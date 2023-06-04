package kit.item.service.community;

import com.azure.core.annotation.ServiceClient;
import kit.item.domain.it.Product;
import kit.item.domain.member.Member;
import kit.item.domain.post.*;
import kit.item.dto.entity.community.CommentDto;
import kit.item.dto.entity.community.PostDataDto;
import kit.item.dto.entity.community.PostDto;
import kit.item.dto.request.community.RequestCreateCommentDto;
import kit.item.dto.request.community.RequestCreatePostDto;
import kit.item.dto.request.community.RequestReportDto;
import kit.item.dto.response.community.*;
import kit.item.repository.community.*;
import kit.item.repository.it.ProductRepository;
import kit.item.repository.member.MemberRepository;
import kit.item.util.http.HttpUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
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
    private final ProductRepository productRepository;
    private final PostImageRepository postImageRepository;

    private final MemberRepository memberRepository;

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

    private Post getPostById(Long postId) {
        return postRepository.findById(postId).orElse(null);
    }
    public ResponsePostDto getPostContentById(Long postId) {
        Post post = postRepository.findById(postId).orElse(null);
        ResponsePostDto responsePostDtO = ResponsePostDto.fromPost(post);
        return responsePostDtO;
    }

    public Boolean createPost(RequestCreatePostDto requestCreatePostDTO, Long memberId) {
        System.out.println("requestCreatePostDTO.getTitle() = " + requestCreatePostDTO.getTitle());
        String title = requestCreatePostDTO.getTitle();
        String content = requestCreatePostDTO.getContent();
        Long productId = requestCreatePostDTO.getProductId();
        List<String> images = requestCreatePostDTO.getImages();
        if (isDupliPost(title, memberId)) {
            return false;
        }
        Post post = Post.builder()
                .title(title)
                .content(content)
                .date(LocalDateTime.now())
                .report(0L)
                .member(
                        Member.builder()
                                .id(memberId)
                                .build()
                )
                .product(
                        productRepository.findById(productId).orElse(null)
                )
                .build();
        postRepository.save(post);
        if(images != null) {
            List<PostImage> postImages = new ArrayList<>();
            for (String image : images) {
                System.out.println("image = " + image);
                PostImage postImage = PostImage.builder()
                        .url(image)
                        .build();
                postImage.setPost(post);
                postImages.add(postImage);
            }
            postImageRepository.saveAll(postImages);

            post.setPostImages(postImages);

            postRepository.save(post);
        }
        return true;
    }
    private boolean isDupliPost(String title, Long memberId) {
        return postRepository.existsByTitleAndMemberId(title, memberId);
    }

    public Boolean updatePost(Long postId, RequestCreatePostDto requestCreatePostDTO, Long memberId) {
        Post origin = getPostById(postId);
        if (origin == null) {
            return false;
        }
        if (origin.getMember().getId() != memberId) {
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
                .product(
                        productRepository.findById(requestCreatePostDTO.getProductId()).orElse(null)
                )
                .date(origin.getDate())
                .report(origin.getReport())
                .postReports(origin.getPostReports())
                .comments(origin.getComments())
                .build();
        postRepository.save(post);

        List<PostImage> existingImages = postImageRepository.findAllByPostId(postId);
        postImageRepository.deleteAll(existingImages);

        if(requestCreatePostDTO.getImages()!= null) {
            List<PostImage> postImages = new ArrayList<>();
            for (String image : requestCreatePostDTO.getImages()) {
                System.out.println("image = " + image);
                PostImage postImage = PostImage.builder()
                        .url(image)
                        .build();
                postImage.setPost(post);
                postImages.add(postImage);
            }
            postImageRepository.saveAll(postImages);

            post.setPostImages(postImages);

            postRepository.save(post);
        }

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
        List<Comment> comments = post.getComments();
        if (comments != null) {
            for (Comment comment : comments) {
                List<Comment> childComments = comment.getChildrenComment();
                if (childComments != null) {
                    commentRepository.deleteAll(childComments);
                }
            }
            commentRepository.deleteAll(comments);
        }
        List<PostImage> postImages = post.getPostImages();
        if (postImages != null) {
            postImageRepository.deleteAll(postImages);
        }
        List<PostReport> postReports = post.getPostReports();
        if (postReports != null) {
            postReportRepository.deleteAll(postReports);
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
                .report(0L)
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
                .report(0L)
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

        boolean hasMore = posts.hasNext();

        List<PostDto> postDtos = posts.stream()
                .map(PostDto::fromPost)
                .collect(Collectors.toList());
        return ResponsePostListDto.builder()
                .posts(postDtos)
                .hasMore(hasMore)
                .build();
    }

    public ResponsePostListDto getPostsCommentedByMe(Long memberId,int page) {
        Page<PostDataDto> posts = postRepository.findByCommentsMemberId(memberId, PageRequest.of(0, 10, Sort.by("id").descending()));
        boolean hasMore = posts.hasNext();

        List<Post> postList = new ArrayList<>();
        for(PostDataDto postDataDto : posts.getContent()){
            postList.add(getPostById(postDataDto.getId()));
        }
        List<PostDto> postDtos = postList.stream()
                .map(PostDto::fromPost)
                .collect(Collectors.toList());

        return ResponsePostListDto.builder()
                .posts(postDtos)
                .hasMore(hasMore)
                .build();
    }

    public String getCommentByPostId(Long postId, Long commentId) {
        Post post = getPostById(postId);
        if (post == null) {
            return null;
        }
        Comment comment = getCommentById(commentId);
        if (comment == null) {
            return null;
        }
        return comment.getContent();
    }

    public List<PostDto> getLatestPostsList() {
        List<Post> posts = postRepository.findAll(PageRequest.of(0, 5, Sort.by("id").descending())).getContent();
        return posts.stream()
                .map(PostDto::fromPost)
                .collect(Collectors.toList());
    }

    public Object getMyInfo(Long memberId) {

        Member member = memberRepository.findById(memberId).orElse(null);
        if (member == null) {
            return null;
        }
        return ResponseMyInfoDto.builder()
                .nickname(member.getName())
                .postCount(postRepository.countAllByMemberId(member.getId()))
                .commentCount(commentRepository.countAllByMemberId(member.getId()))
                .build();
    }
}
