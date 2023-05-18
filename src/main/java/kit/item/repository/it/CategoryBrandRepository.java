package kit.item.repository.it;

import kit.item.domain.it.CategoryBrand;
import kit.item.dto.entity.device.BrandDto;
import kit.item.dto.entity.device.ProductDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CategoryBrandRepository extends JpaRepository<CategoryBrand, Long> {
    @Query("select new kit.item.dto.entity.device.BrandDto (cb.brand.id, cb.brand.name) from CATEGORY_BRAND cb where cb.category.id=:categoryId")
    List<BrandDto> findBrandByCategoryId(@Param(value = "categoryId") Long categoryId);

    @Query("select new kit.item.dto.entity.device.ProductDto (p.id, p.name) from PRODUCT p " +
            "INNER join fetch CATEGORY_BRAND cb " +
            "where p.categoryBrand.brand.id=:brandId and p.categoryBrand.category.id=:categoryBrandId and p.categoryBrand.id=cb.id")
    List<ProductDto> findProductByCategoryIdAndBrandId(@Param(value = "categoryBrandId") Long categoryBrandId, @Param(value = "brandId") Long brandId);
}
