package kit.item.repository.h2;

import kit.item.domain.h2.RefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {
    boolean existsByEmail(String email);
    Optional<RefreshToken> findByEmail(String email);
}
