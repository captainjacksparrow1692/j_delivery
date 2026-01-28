package uzumtech.j_delivery.service;

import org.springframework.data.domain.Page;
import uzumtech.j_delivery.dto.request.OrderRequest;
import uzumtech.j_delivery.dto.response.OrderResponse;

public interface OrderService {

    // Создание нового заказа
    OrderResponse create(OrderRequest orderRequest);

    // Получение одного заказа
    OrderResponse get(Long orderId);

    // Обновление (теперь возвращает Response)
    OrderResponse update(Long orderId, OrderRequest orderRequest);

    // Удаление
    void delete(Long orderId);

    // Пагинация (принимаем page и size напрямую для удобства контроллера)
    Page<OrderResponse> getPagination(int page, int size);

    // Метод для тестов GCP (если он нужен в реализации)
    OrderResponse testGcp(Long orderId);
}