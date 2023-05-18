package kit.item.repository.it;

import kit.item.domain.it.Product;
import kit.item.dto.entity.device.ProductDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("select new kit.item.dto.entity.device.ProductDto(p.id, p.name, p.isComponent, p.kind.name) " +
            "from PRODUCT p INNER JOIN FETCH BRAND_PRODUCT bp " +
            "where bp.product.id = p.id and bp.brand.id = :brandId and p.isComponent = true"
            )
    List<ProductDto> findProductByBrandId(@Param(value = "brandId") Long brandId);
}
