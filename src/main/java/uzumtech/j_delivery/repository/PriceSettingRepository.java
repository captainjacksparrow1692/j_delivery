package uzumtech.j_delivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uzumtech.j_delivery.entity.PriceSetting;

import java.util.Optional;

public interface PriceSettingRepository extends JpaRepository<PriceSetting, Long> {
    Optional<PriceSetting> findFirstByOrderByUpdatedAtDesc();
}
