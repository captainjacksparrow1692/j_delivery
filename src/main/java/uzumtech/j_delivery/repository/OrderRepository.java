package uzumtech.j_delivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uzumtech.j_delivery.entity.OrderEntity;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
}
