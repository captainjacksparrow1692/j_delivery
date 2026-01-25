package uzumtech.j_delivery.service.impl;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uzumtech.j_delivery.dto.request.OrderRequest;
import uzumtech.j_delivery.dto.response.OrderResponse;
import uzumtech.j_delivery.dto.response.PriceSettingResponse;
import uzumtech.j_delivery.entity.OrderEntity;
import uzumtech.j_delivery.mapper.OrderMapper;
import uzumtech.j_delivery.repository.OrderRepository;
import uzumtech.j_delivery.service.OrderService;
import uzumtech.j_delivery.service.PriceSettingService;

import java.sql.SQLDataException;

@Slf4j
@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;
    private final PriceSettingService priceSettingService;

    @Override
    @Transactional
    public OrderResponse createOrder(OrderRequest orderRequest) {
        PriceSettingResponse settings = priceSettingService.getCurrent();
        OrderEntity entity = orderMapper.toEntity(orderRequest);

        // Теперь calculatePrice будет виден
        entity.setTotalPrice(calculatePrice(orderRequest, settings));

        return orderMapper.toResponse(orderRepository.save(entity));
    }

    @Override
    public OrderResponse get(Long orderId) {
        return orderRepository.findById(orderId)
                .map(orderMapper::toResponse)
                .orElseThrow();
    }

    @Override
    @Transactional
    public void update(Long orderId, OrderRequest orderRequest) throws SQLDataException {
        OrderEntity entity = orderRepository.findById(orderId).orElseThrow();
        orderMapper.updateEntityFromDto(orderRequest, entity);
        orderRepository.save(entity);
    }

    @Override
    @Transactional
    public void delete(Long orderId) { // Исправлено имя параметра
        orderRepository.deleteById(orderId);
    }

    @Override
    public Page<OrderResponse> findAll(Pageable pageable) {
        return orderRepository.findAll(pageable).map(orderMapper::toResponse);
    }

    // Тот самый метод, который "не резолвился"
    private Double calculatePrice(OrderRequest req, PriceSettingResponse s) {
        return s.baseFee() + (req.weight() * s.perKgRate());
    }
}