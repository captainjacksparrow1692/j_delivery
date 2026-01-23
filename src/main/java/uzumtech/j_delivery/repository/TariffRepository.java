package uzumtech.j_delivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uzumtech.j_delivery.entity.TariffEntity;

public interface TariffRepository extends JpaRepository<TariffEntity, Long> {
}
