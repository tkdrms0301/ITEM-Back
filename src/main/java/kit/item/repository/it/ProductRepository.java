package kit.item.repository.it;

import kit.item.domain.it.Product;
import kit.item.dto.entity.device.ProductDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
//    @Query("select new kit.item.dto.entity.device.ProductDto(p.id, p.name, p.productType, p.kind.name) " +
//            "from PRODUCT p " +
//            "INNER JOIN FETCH BRAND_PRODUCT bp on p.id=bp.product.id " +
//            "INNER JOIN FETCH BRAND b on b.id=bp.brand.id " +
//            "INNER JOIN FETCH CATEGORY_BRAND cb on cb.brand.id=bp.brand.id and  " +
//            "where bp.brand.id=:brandId and cb.category.id=:categoryId and p.productType = 'COMPLETE_PRODUCT'")
//    List<ProductDto> findProductByBrandId(@Param(value = "categoryId") Long categoryId, @Param(value = "brandId") Long brandId);
}
