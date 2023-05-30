package kit.item.repository.it;

import kit.item.domain.it.CategoryBrand;
import kit.item.dto.entity.device.BrandDto;
import kit.item.dto.entity.device.ProductDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CategoryBrandRepository extends JpaRepository<CategoryBrand, Long> {
    @Query("select new kit.item.dto.entity.device.BrandDto (cb.brand.id, cb.brand.name) from CATEGORY_BRAND cb where cb.category.id=:categoryId and cb.category.isPart=false")
    List<BrandDto> findCompletionBrandByCategoryId(@Param(value = "categoryId") Long categoryId);

    @Query("select new kit.item.dto.entity.device.BrandDto (cb.brand.id, cb.brand.name) from CATEGORY_BRAND cb where cb.category.id=:categoryId and cb.category.isPart=true")
    List<BrandDto> findPartBrandByCategoryId(@Param(value = "categoryId") Long categoryId);

    @Query("select new kit.item.dto.entity.device.ProductDto (p.id, p.name) from PRODUCT p " +
            "INNER join fetch CATEGORY_BRAND cb " +
            "where p.categoryBrand.brand.id=:brandId and p.categoryBrand.category.id=:categoryBrandId and p.categoryBrand.id=cb.id " +
            "and p.categoryBrand.category.isPart=false")
    List<ProductDto> findCompletionProductByCategoryIdAndBrandId(@Param(value = "categoryBrandId") Long categoryBrandId, @Param(value = "brandId") Long brandId);

    @Query("select new kit.item.dto.entity.device.ProductDto (p.id, p.name) from PRODUCT p " +
            "INNER join fetch CATEGORY_BRAND cb " +
            "where p.categoryBrand.brand.id=:brandId and p.categoryBrand.category.id=:categoryBrandId and p.categoryBrand.id=cb.id " +
            "and p.categoryBrand.category.isPart=true")
    List<ProductDto> findPartProductByCategoryIdAndBrandId(@Param(value = "categoryBrandId") Long categoryBrandId, @Param(value = "brandId") Long brandId);

    @Query("select new kit.item.dto.entity.device.BrandDto (cb.brand.id, cb.brand.name) from CATEGORY_BRAND cb where cb.category.id=:categoryId and cb.brand.isFinished=false")
    List<BrandDto> findAllBrandByCategoryId(@Param(value = "categoryId") Long categoryId);

    @Query("select new kit.item.dto.entity.device.ProductDto (p.id, p.name) from PRODUCT p " +
            "INNER join fetch CATEGORY_BRAND cb " +
            "where p.categoryBrand.brand.id=:brandId and p.categoryBrand.category.id=:categoryBrandId and p.categoryBrand.id=cb.id " +
            "and cb.brand.isFinished=false")
    List<ProductDto> findAllByCategoryIdAndBrandId(@Param(value = "categoryBrandId") Long categoryBrandId, @Param(value = "brandId") Long brandId);
}
