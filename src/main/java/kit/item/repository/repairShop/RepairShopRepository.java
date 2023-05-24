package kit.item.repository.repairShop;

import kit.item.domain.member.RepairShop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepairShopRepository extends JpaRepository<RepairShop, Long> {

    List<RepairShop> findAll();

}
