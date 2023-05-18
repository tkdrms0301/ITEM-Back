package kit.item.repository.it;

import kit.item.domain.it.BrandProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandProductRepository extends JpaRepository<BrandProduct, Long> {
}
