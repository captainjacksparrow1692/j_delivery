package uzumtech.j_delivery.controller;

import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uzumtech.j_delivery.dto.request.OrderRequest;
import uzumtech.j_delivery.dto.response.OrderResponse;
import uzumtech.j_delivery.service.OrderService;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/orders") // Добавил версионирование v1 - хороший тон
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class OrderController {

    OrderService orderService;

    @PostMapping
    public ResponseEntity<OrderResponse> create(@Valid @RequestBody OrderRequest request) {
        log.info("REST request to create order: {}", request);
        // Статус 201 Created для новых ресурсов
        return ResponseEntity.status(HttpStatus.CREATED).body(orderService.create(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderResponse> get(@PathVariable Long id) {
        log.info("REST request to get order by id: {}", id);
        return ResponseEntity.ok(orderService.get(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrderResponse> update(@PathVariable Long id, @Valid @RequestBody OrderRequest request) {
        log.info("REST request to update order id: {}", id);
        return ResponseEntity.ok(orderService.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        log.info("REST request to delete order id: {}", id);
        orderService.delete(id);
        return ResponseEntity.noContent().build(); // Возвращаем 204 No Content
    }

    @GetMapping
    public ResponseEntity<Page<OrderResponse>> getPagination(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        log.info("REST request to get orders page: {}, size: {}", page, size);
        return ResponseEntity.ok(orderService.getPagination(page, size));
    }

    // Твой специфичный метод для GCP, если он еще нужен
    @GetMapping("/test-gcp/{id}")
    public ResponseEntity<OrderResponse> testGcp(@PathVariable Long id) {
        return ResponseEntity.ok(orderService.testGcp(id));
    }
}