package uzumtech.j_delivery.service.impl;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uzumtech.j_delivery.constant.enums.Error;
import uzumtech.j_delivery.constant.enums.ErrorType;
import uzumtech.j_delivery.dto.request.OrderRequest;
import uzumtech.j_delivery.dto.response.OrderResponse;
import uzumtech.j_delivery.dto.response.PriceSettingResponse;
import uzumtech.j_delivery.entity.OrderEntity;
import uzumtech.j_delivery.exception.BussinesException;
import uzumtech.j_delivery.mapper.OrderMapper;
import uzumtech.j_delivery.repository.OrderRepository;
import uzumtech.j_delivery.service.OrderService;
import uzumtech.j_delivery.service.PriceSettingService;

@Slf4j
@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class OrderServiceImpl implements OrderService {

    OrderRepository orderRepository;
    OrderMapper orderMapper;
    PriceSettingService priceSettingService;

    @Override
    @Transactional
    public OrderResponse create(OrderRequest orderRequest) {
        PriceSettingResponse settings = priceSettingService.getCurrent();

        if (settings == null) {
            // Обращаемся напрямую: Класс.Константа
            throw new BussinesException(
                    Error.PRICE_SETTING_NOT_FOUND.getCode(),
                    Error.PRICE_SETTING_NOT_FOUND.getMessage(),
                    Error.PRICE_SETTING_NOT_FOUND.getHttpStatus(),
                    ErrorType.SYSTEM
            );
        }

        OrderEntity entity = orderMapper.toEntity(orderRequest);
        entity.setTotalPrice(calculatePrice(orderRequest, settings));

        return orderMapper.toResponse(orderRepository.save(entity));
    }

    @Override
    public OrderResponse get(Long orderId) {
        return orderRepository.findById(orderId)
                .map(orderMapper::toResponse)
                .orElseThrow(() -> new BussinesException(
                        Error.ORDER_NOT_FOUND.getCode(),
                        Error.ORDER_NOT_FOUND.getMessage(),
                        Error.ORDER_NOT_FOUND.getHttpStatus(),
                        ErrorType.BUSINESS
                ));
    }

    @Override
    @Transactional
    public OrderResponse update(Long orderId, OrderRequest orderRequest) {
        OrderEntity entity = orderRepository.findById(orderId)
                .orElseThrow(() -> new BussinesException(
                        Error.ORDER_NOT_FOUND.getCode(),
                        Error.ORDER_NOT_FOUND.getMessage(),
                        Error.ORDER_NOT_FOUND.getHttpStatus(),
                        ErrorType.BUSINESS
                ));

        orderMapper.updateEntityFromDto(orderRequest, entity);

        PriceSettingResponse settings = priceSettingService.getCurrent();
        if (settings != null) {
            entity.setTotalPrice(calculatePrice(orderRequest, settings));
        }

        return orderMapper.toResponse(orderRepository.save(entity));
    }

    @Override
    @Transactional
    public void delete(Long orderId) {
        if (!orderRepository.existsById(orderId)) {
            throw new BussinesException(
                    Error.ORDER_NOT_FOUND.getCode(),
                    Error.ORDER_NOT_FOUND.getMessage(),
                    Error.ORDER_NOT_FOUND.getHttpStatus(),
                    ErrorType.BUSINESS
            );
        }
        orderRepository.deleteById(orderId);
    }

    @Override
    public Page<OrderResponse> getPagination(int page, int size) {
        return orderRepository.findAll(PageRequest.of(page, size))
                .map(orderMapper::toResponse);
    }

    @Override
    public OrderResponse testGcp(Long orderId) {
        return get(orderId);
    }

    private Double calculatePrice(OrderRequest req, PriceSettingResponse s) {
        double weight = req.weight() != null ? req.weight() : 0.0;
        return s.baseFee() + (weight * s.perKgRate());
    }
}