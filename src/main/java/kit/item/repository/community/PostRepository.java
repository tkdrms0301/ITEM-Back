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

import java.time.LocalDateTime;
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

    @Query("SELECT new kit.item.dto.entity.community.PostDataDto(p.id, p.title) FROM POST p JOIN p.comments c WHERE c.member.id = :memberId")
    Page<PostDataDto> findByCommentsMemberId(@Param("memberId") Long memberId,Pageable pageable);

    Long countAllByMemberId(Long memberId);
}

