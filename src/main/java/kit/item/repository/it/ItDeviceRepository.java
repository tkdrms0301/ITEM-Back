package kit.item.repository.it;

import kit.item.domain.it.ItDevice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItDeviceRepository extends JpaRepository<ItDevice, Long> {
}
