package kit.item.repository.it;

import kit.item.domain.it.BrandProduct;
import kit.item.dto.entity.device.ProductDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BrandProductRepository extends JpaRepository<BrandProduct, Long> {
    @Query("select new kit.item.dto.entity.device.ProductDto (bp.product.id, bp.product.name) " +
            "from BRAND_PRODUCT bp " +
            "LEFT JOIN fetch CATEGORY_BRAND cb " +
            "where bp.brand.id=cb.brand.id and bp.brand.id=:brandId and cb.category.id=:categoryId")
    List<ProductDto> findProductByCategoryIdAndBrandId(@Param(value = "categoryId") Long categoryId,@Param(value = "brandId") Long brandId);

    List<BrandProduct> findByBrandId(Long brandId);
}
