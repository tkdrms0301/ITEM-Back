package kit.item.repository.it;

import kit.item.domain.it.CategoryBrand;
import kit.item.dto.entity.device.BrandDto;
import kit.item.dto.entity.device.CategoryBrandDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CategoryBrandRepository extends JpaRepository<CategoryBrand, Long> {
    @Query("select new kit.item.dto.entity.device.BrandDto (cb.brand.id, cb.brand.name) from CATEGORY_BRAND cb where cb.category.id=:categoryId")
    List<BrandDto> findBrandByCategoryId(@Param(value = "categoryId") Long categoryId);

    @Query("select new kit.item.dto.entity.device.CategoryBrandDto (cb.id, cb.category.id, cb.brand.id) from CATEGORY_BRAND cb where cb.category.id=:categoryId and cb.brand.id=:brandId")
    CategoryBrandDto findCategoryBrandByCategoryIdAndBrandId(@Param(value = "categoryId") Long categoryId, @Param(value = "brandId") Long brandId);

    List<CategoryBrand> findByCategoryIdAndBrandId(Long categoryId, Long brandId);
}
