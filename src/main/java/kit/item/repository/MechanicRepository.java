package kit.item.repository;

import kit.item.domain.member.RepairShop;
import kit.item.dto.entity.member.MechanicInfoDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MechanicRepository extends JpaRepository<RepairShop, Long> {
}
