package kit.item.repository.community;

import kit.item.domain.post.PostImage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostImageRepository extends JpaRepository<PostImage,Long> {
    List<PostImage> findAllByPostId(Long id);
}
