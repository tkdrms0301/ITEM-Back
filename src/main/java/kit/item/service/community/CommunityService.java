package kit.item.service.community;

import kit.item.domain.member.Member;
import kit.item.domain.post.Comment;
import kit.item.domain.post.CommentReport;
import kit.item.domain.post.Post;
import kit.item.domain.post.PostReport;
import kit.item.dto.entity.community.CommentDto;
import kit.item.dto.entity.community.PostDataDto;
import kit.item.dto.entity.community.PostDto;
import kit.item.dto.request.community.RequestCreateCommentDto;
import kit.item.dto.request.community.RequestCreatePostDto;
import kit.item.dto.request.community.RequestReportDto;
import kit.item.dto.response.community.ResponseCommentListDto;
import kit.item.dto.response.community.ResponsePostDataListDto;
import kit.item.dto.response.community.ResponsePostListDto;
import kit.item.repository.community.CommentReportRepository;
import kit.item.repository.community.CommentRepository;
import kit.item.repository.community.PostReportRepository;
import kit.item.repository.community.PostRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class CommunityService {
    private static final int PAGE_SIZE = 20;
    private final PostRepository postRepository;
    private final CommentRepository commentRepository;
    private final PostReportRepository postReportRepository;
    private final CommentReportRepository commentReportRepository;

    public ResponsePostListDto getPostsList(int page) {
        List<PostDto> posts = getPosts(page, PAGE_SIZE);
        boolean hasMore = hasMorePosts(page, PAGE_SIZE);

        return ResponsePostListDto.builder()
                .posts(posts)
                .hasMore(hasMore)
                .build();
    }
    private List<PostDto> getPosts(int page, int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize, Sort.by("id").descending());
        Page<Post> postPage = postRepository.findAll(pageable);
        return postPage.stream()
                .map(PostDto::fromPost)
                .collect(Collectors.toList());
    }
    private boolean hasMorePosts(int page, int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        Page<Post> postPage = postRepository.findAll(pageable);
        return postPage.hasNext();
    }

    public ResponsePostListDto getPostsList(int page, String keyword) {
        List<PostDto> posts = getPosts(page, PAGE_SIZE, keyword);
        boolean hasMore = hasMorePosts(page, PAGE_SIZE, keyword);

        return ResponsePostListDto.builder()
                .posts(posts)
                .hasMore(hasMore)
                .build();
    }
    private List<PostDto> getPosts(int page, int pageSize, String keyword) {
        Pageable pageable = PageRequest.of(page, pageSize, Sort.by("id").descending());
        Page<Post> postPage = postRepository.findAllByTitleContaining(keyword, pageable);
        return postPage.stream()
                .map(PostDto::fromPost)
                .collect(Collectors.toList());
    }
    private boolean hasMorePosts(int page, int pageSize, String keyword) {
        Pageable pageable = PageRequest.of(page, pageSize);
        Page<Post> postPage = postRepository.findAllByTitleContaining(keyword, pageable);
        return postPage.hasNext();
    }

    public Post getPostById(Long postId) {
        return postRepository.findById(postId).orElse(null);
    }

    public Boolean createPost(RequestCreatePostDto requestCreatePostDTO, Long memberId) {
        String title = requestCreatePostDTO.getTitle();
        String content = requestCreatePostDTO.getContent();
        if (isDupliPost(title, memberId)) {
            return false;
        }
        Post post = Post.builder()
                .title(title)
                .content(content)
                .member(
                        Member.builder()
                                .id(memberId)
                                .build()
                )
                .build();
        postRepository.save(post);
        return true;
    }
    private boolean isDupliPost(String title, Long memberId) {
        return postRepository.existsByTitleAndMemberId(title, memberId);
    }

    public Boolean updatePost(Long postId, RequestCreatePostDto requestCreatePostDTO, Long memberId) {
        if (getPostById(postId) == null) {
            return false;
        }
        if (getPostById(postId).getMember().getId() != memberId) {
            return false;
        }
        Post post = Post.builder()
                .id(postId)
                .title(requestCreatePostDTO.getTitle())
                .content(requestCreatePostDTO.getContent())
                .member(
                        Member.builder()
                                .id(memberId)
                                .build())
                .build();
        postRepository.save(post);
        return true;
    }

    public Boolean deletePost(Long postId, Long memberId) {
        Post post = getPostById(postId);
        if (post == null) {
            return false;
        }
        if (getPostById(postId).getMember().getId() != memberId) {
            return false;
        }
        postRepository.delete(post);
        return true;
    }

    public ResponseCommentListDto getCommentsByPostId(Long postId) {
        Post post = getPostById(postId);
        if (post == null) {
            return null;
        }
        List<CommentDto> comments = post.getComments().stream()
                .map(CommentDto::fromComment)
                .collect(Collectors.toList());

        return ResponseCommentListDto.builder()
                .comments(comments)
                .build();
    }

    private Comment getCommentById(Long commentId) {
        return commentRepository.findById(commentId).orElse(null);
    }

    public boolean createComment(Long postId, RequestCreateCommentDto requestCreateCommentDTO, Long memberId) {
        Post post = getPostById(postId);
        if (post == null) {
            return false;
        }
        Comment comment = Comment.builder()
                .date(LocalDateTime.now())
                .content(requestCreateCommentDTO.getContent())
                .member(
                        Member.builder()
                                .id(memberId)
                                .build())
                .post(post)
                .build();


        commentRepository.save(comment);


        return true;
    }

    public Boolean createComment(Long postId, Long commentId, RequestCreatePostDto requestCreatePostDTO, Long memberId) {
        Post post = getPostById(postId);
        if (post == null) {
            return false;
        }
        Comment comment = getCommentById(commentId);
        if (comment == null) {
            return false;
        }
        if (comment.getParentComment() != null) {
            return false;
        }
        Comment replyComment = Comment.builder()
                .date(LocalDateTime.now())
                .content(requestCreatePostDTO.getContent())
                .member(
                        Member.builder()
                                .id(memberId)
                                .build())
                .parentComment(comment)
                .build();
        commentRepository.save(replyComment);
        return true;
    }



    public Boolean updateComment(Long postId, Long commentId, RequestCreatePostDto requestCreatePostDTO, Long memberId) {
        Post post = getPostById(postId);
        if (post == null) {
            return false;
        }
        Comment comment = getCommentById(commentId);
        if (comment == null) {
            return false;
        }
        if (comment.getMember().getId() != memberId) {
            return false;
        }
        comment.setContent(requestCreatePostDTO.getContent());
        commentRepository.save(comment);
        return true;
    }


    public Boolean deleteComment(Long postId, Long commentId, Long memberId) {
        Post post = getPostById(postId);
        if (post == null) {
            return false;
        }
        Comment comment = getCommentById(commentId);
        if (comment == null) {
            return false;
        }
        if (comment.getMember().getId() != memberId) {
            return false;
        }
        if (comment.getParentComment() == null) {
            List<Comment> replyComments = comment.getChildrenComment();
            commentRepository.deleteAll(replyComments);
        }
        commentRepository.delete(comment);
        return true;
    }

    public Boolean reportPost(Long postId, RequestReportDto requestReportDto, Long memberId) {
        Post post = getPostById(postId);
        if (post == null) {
            return false;
        }
        PostReport postReport = PostReport.builder()
                .reason(requestReportDto.getReason())
                .reportType(requestReportDto.getReportType())
                .member(
                        Member.builder()
                                .id(memberId)
                                .build())
                .post(post)
                .build();
        postReportRepository.save(postReport);
        return true;
    }

    public Boolean reportComment(Long commentId, RequestReportDto requestReportDto, Long memberId) {
        Comment comment = getCommentById(commentId);
        if (comment == null) {
            return false;
        }
        CommentReport commentReport = CommentReport.builder()
                .reason(requestReportDto.getReason())
                .reportType(requestReportDto.getReportType())
                .member(
                        Member.builder()
                                .id(memberId)
                                .build())
                .comment(comment)
                .build();
        commentReportRepository.save(commentReport);
        return true;
    }

    public ResponsePostListDto getMyPosts(Long memberId,int page) {
        Page<Post> posts = postRepository.findAllByMemberId(memberId, PageRequest.of(page, 10, Sort.by("id").descending()));
        List<PostDto> postDtos = posts.stream()
                .map(PostDto::fromPost)
                .collect(Collectors.toList());
        return ResponsePostListDto.builder()
                .posts(postDtos)
                .build();
    }

    //find all post what i commented

    public ResponsePostDataListDto getPostsCommentedByMe(Long memberId,int page) {
        Page<PostDataDto> posts = postRepository.findByCommentsMemberId(memberId, PageRequest.of(0, 10, Sort.by("id").descending()));
        return ResponsePostDataListDto.builder()
                .posts(posts.getContent())
                .build();
    }
}
