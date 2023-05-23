package kit.item.repository.community;

import kit.item.domain.post.Post;
import kit.item.domain.post.Comment;
import kit.item.dto.entity.community.PostDataDto;
import kit.item.dto.entity.community.PostDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;



public interface PostRepository extends PagingAndSortingRepository<Post, Long>{
    Page<Post> findAll(Pageable pageable);

    Optional<Post> findById(Long postId);

    boolean existsByTitleAndMemberId(String title, Long memberId);

    void save(Post post);

    void delete(Post post);


    Page<Post> findAllByTitleContaining(String keyword, Pageable pageable);

    Page<Post> findAllByMemberId(Long memberId, Pageable pageable);

//    SELECT p.post_id, p.title
//    FROM post p
//    JOIN comment c ON p.post_id = c.post_id
//    WHERE c.member_id = 'your_memberId'
    // 위에꺼가 내가 원하는 쿼리문인데 이걸 어떻게 jpa로 바꿀지 모르겠다.
    // 한다고 한게 밑에꺼인데
    // 작동을 안해
    
    // 모든 글에서 멤버아이디가 댓글 쓴 글
//    @Query("select new kit.item.dto.entity.community.PostDataDto(p.id,p.title) from POST p join fetch COMMENT c on p.id = c.post.id where c.member.id = :memberId")
//    Page<PostDataDto> findByCommentsMemberId(@Param("memberId")Long memberId, Pageable pageable);

    @Query("SELECT new kit.item.dto.entity.community.PostDataDto(p.id, p.title) FROM POST p JOIN p.comments c WHERE c.member.id = :memberId")
    Page<PostDataDto> findByCommentsMemberId(@Param("memberId") Long memberId,Pageable pageable);
}

