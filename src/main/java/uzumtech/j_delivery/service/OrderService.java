package uzumtech.j_delivery.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import uzumtech.j_delivery.dto.request.OrderRequest;
import uzumtech.j_delivery.dto.response.OrderResponse;

import java.sql.SQLDataException;

public interface OrderService {
    OrderResponse createOrder(OrderRequest orderRequest);

    void delete(Long orderId);
    OrderResponse get(Long orderId);
    void update(Long orderId, OrderRequest orderRequest) throws SQLDataException;

    Page<OrderResponse> findAll(Pageable pageable);
}
