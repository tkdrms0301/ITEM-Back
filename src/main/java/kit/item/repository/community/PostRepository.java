package kit.item.repository.community;

import kit.item.domain.post.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;


public interface PostRepository extends PagingAndSortingRepository<Post, Long>{
    Page<Post> findAll(Pageable pageable);

    Optional<Post> findById(Long postId);

    boolean existsByTitleAndMemberId(String title, Long memberId);

    void save(Post post);

    void delete(Post post);


    Page<Post> findAllByTitleContaining(String keyword, Pageable pageable);
}

