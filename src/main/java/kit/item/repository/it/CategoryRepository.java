package kit.item.repository.it;

import kit.item.domain.it.Category;
import kit.item.dto.entity.device.BrandDto;
import kit.item.dto.entity.device.CategoryDto;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    @Query("select new kit.item.dto.entity.device.CategoryDto(c.id, c.imageUrl, c.name) from CATEGORY c where c.isPart = false")
    List<CategoryDto> findCompletionAllCategory();

    @Query("select new kit.item.dto.entity.device.CategoryDto(c.id, c.imageUrl, c.name) from CATEGORY c where c.isPart = true")
    List<CategoryDto> findPartAllCategory();

    @Query("select new kit.item.dto.entity.device.CategoryDto(c.id, c.imageUrl, c.name) from CATEGORY c")
    List<CategoryDto> findAllCategory();
}
