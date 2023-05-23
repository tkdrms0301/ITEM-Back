package kit.item.controller;

import kit.item.domain.post.Post;
import kit.item.dto.common.MsgDto;
import kit.item.dto.entity.community.PostDto;
import kit.item.dto.request.community.RequestCreateCommentDto;
import kit.item.dto.request.community.RequestCreatePostDto;
import kit.item.dto.request.community.RequestReportDto;
import kit.item.service.community.CommunityService;
import kit.item.util.jwt.TokenProvider;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/community")
public class CommunityController {

    private final CommunityService communityService;
    private final TokenProvider tokenProvider;


    @GetMapping("/posts")
    public ResponseEntity<MsgDto> getPostsList(@RequestParam(defaultValue = "0") int page) {
        return new ResponseEntity<>(new MsgDto(true, "",
                communityService.getPostsList(page)
                ), HttpStatus.OK);
    }

    @GetMapping("/posts/search")
    public ResponseEntity<MsgDto> getPostsList(@RequestParam(defaultValue = "0") int page,
                                               @RequestParam(defaultValue = "") String keyword) {
        return new ResponseEntity<>(new MsgDto(true, "",
                communityService.getPostsList(page, keyword)
        ), HttpStatus.OK);
    }

    @GetMapping("/post/{postId}")
    public ResponseEntity<MsgDto> getPost(@PathVariable("postId") Long postId) {
        Post post = communityService.getPostById(postId);
        if (post == null) {
            return ResponseEntity.notFound().build();
        }
        PostDto postDto = PostDto.fromPost(post);

        return ResponseEntity.ok(new MsgDto(true, "", postDto));
    }

    @PostMapping("/post/create")
    public ResponseEntity<MsgDto> createPost(@RequestBody RequestCreatePostDto requestCreatePostDTO, @RequestHeader(value = "X-AUTH-TOKEN") String accessToken) {
        Long memberId = tokenProvider.getId(tokenProvider.resolveToken(accessToken));
        log.info("memberId : {}", memberId);
        return ResponseEntity.ok(new MsgDto(true, "게시글 작성 성공", communityService.createPost(requestCreatePostDTO,memberId)));
    }

    @PutMapping("/post/{postId}/update")
    public ResponseEntity<MsgDto> updatePost(@PathVariable("postId") Long postId,
                                             @RequestBody RequestCreatePostDto requestCreatePostDTO,
                                             @RequestHeader(value = "X-AUTH-TOKEN") String accessToken) {
        Long memberId = tokenProvider.getId(tokenProvider.resolveToken(accessToken));
        return ResponseEntity.ok(new MsgDto(true, "", communityService.updatePost(postId, requestCreatePostDTO, memberId)));
    }

    @DeleteMapping("/post/{postId}/delete")
    public ResponseEntity<MsgDto> deletePost(@PathVariable("postId") Long postId, @RequestHeader(value = "X-AUTH-TOKEN") String accessToken) {
        Long memberId = tokenProvider.getId(tokenProvider.resolveToken(accessToken));
        return ResponseEntity.ok(new MsgDto(true, "", communityService.deletePost(postId, memberId)));
    }

    @GetMapping("/post/{postId}/comments")
    public ResponseEntity<MsgDto> getCommentsByPostId(@PathVariable("postId") Long postId) {
        return ResponseEntity.ok(new MsgDto(true, "", communityService.getCommentsByPostId(postId)));
    }

    @PostMapping("/post/{postId}/comment/create")
    public ResponseEntity<MsgDto> createComment(@PathVariable("postId") Long postId,
                                                @RequestBody RequestCreateCommentDto requestCreateCommentDTO,
                                                @RequestHeader(value = "X-AUTH-TOKEN") String accessToken) {
        Long memberId = tokenProvider.getId(tokenProvider.resolveToken(accessToken));
        return ResponseEntity.ok(new MsgDto(true, "", communityService.createComment(postId, requestCreateCommentDTO,memberId)));
    }

    @PostMapping("/post/{postId}/comment/{commentId}/create")
    public ResponseEntity<MsgDto> createComment(@PathVariable("postId") Long postId,
                                                @PathVariable("commentId") Long commentId,
                                                @RequestBody RequestCreatePostDto requestCreatePostDTO,
                                                @RequestHeader(value = "X-AUTH-TOKEN") String accessToken) {
        Long memberId = tokenProvider.getId(tokenProvider.resolveToken(accessToken));
        return ResponseEntity.ok(new MsgDto(true, "", communityService.createComment(postId, commentId, requestCreatePostDTO,memberId)));
    }

    @PutMapping("/post/{postId}/comment/{commentId}/update")
    public ResponseEntity<MsgDto> updateComment(@PathVariable("postId") Long postId,
                                                @PathVariable("commentId") Long commentId,
                                                @RequestBody RequestCreatePostDto requestCreatePostDTO,
                                                @RequestHeader(value = "X-AUTH-TOKEN") String accessToken) {
        Long memberId = tokenProvider.getId(tokenProvider.resolveToken(accessToken));
        return ResponseEntity.ok(new MsgDto(true, "", communityService.updateComment(postId, commentId, requestCreatePostDTO, memberId)));
    }

    @DeleteMapping("/post/{postId}/comment/{commentId}/delete")
    public ResponseEntity<MsgDto> deleteComment(@PathVariable("postId") Long postId,
                                                @PathVariable("commentId") Long commentId,
                                                @RequestHeader(value = "X-AUTH-TOKEN") String accessToken) {
        Long memberId = tokenProvider.getId(tokenProvider.resolveToken(accessToken));
        return ResponseEntity.ok(new MsgDto(true, "", communityService.deleteComment(postId, commentId, memberId)));
    }
    // post report
    @PostMapping("/post/{postId}/report")
    public ResponseEntity<MsgDto> reportPost(@PathVariable("postId") Long postId,
                                             @RequestBody RequestReportDto requestReportDto,
                                             @RequestHeader(value = "X-AUTH-TOKEN") String accessToken) {
        Long memberId = tokenProvider.getId(tokenProvider.resolveToken(accessToken));
        return ResponseEntity.ok(new MsgDto(true, "", communityService.reportPost(postId, requestReportDto, memberId)));
    }
    // comment report
    @PostMapping("/post/{postId}/comment/{commentId}/report")
    public ResponseEntity<MsgDto> reportComment(@PathVariable("postId") Long postId,
                                                @PathVariable("commentId") Long commentId,
                                                @RequestBody RequestReportDto requestReportDto,
                                                @RequestHeader(value = "X-AUTH-TOKEN") String accessToken) {
        Long memberId = tokenProvider.getId(tokenProvider.resolveToken(accessToken));
        return ResponseEntity.ok(new MsgDto(true, "", communityService.reportComment(commentId, requestReportDto, memberId)));
    }

    @GetMapping("/user/posts")
    public ResponseEntity<MsgDto> getMyPosts(@RequestHeader(value = "X-AUTH-TOKEN") String accessToken,
                                             @RequestParam(defaultValue = "0") int page) {
        Long memberId = tokenProvider.getId(tokenProvider.resolveToken(accessToken));
        return ResponseEntity.ok(new MsgDto(true, "", communityService.getMyPosts(memberId, page)));
    }

    @GetMapping("/user/comments")
    public ResponseEntity<MsgDto> getPostsCommentedByMe(@RequestHeader(value = "X-AUTH-TOKEN") String accessToken,
                                                        @RequestParam(defaultValue = "0") int page) {
        Long memberId = tokenProvider.getId(tokenProvider.resolveToken(accessToken));
        return ResponseEntity.ok(new MsgDto(true, "", communityService.getPostsCommentedByMe(memberId, page)));
    }











}
