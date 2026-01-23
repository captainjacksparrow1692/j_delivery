package uzumtech.j_delivery.dto.response;

import uzumtech.j_delivery.constant.enums.Status;

import java.time.LocalDateTime;

public record OrderResponse(
        Long id,
        Long tariffId,
        Double totalPrice,
        Status status,
        String trackingNumber,
        LocalDateTime createdAt
) {
}
