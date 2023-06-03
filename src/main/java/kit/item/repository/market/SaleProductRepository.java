package kit.item.repository.market;


import kit.item.domain.market.SaleProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SaleProductRepository extends JpaRepository<SaleProduct, Long> {

    List<SaleProduct> findByProduct_CategoryBrand_Category_Id(Long categoryId);

    List<SaleProduct> findByNameContaining(String keyword);
}