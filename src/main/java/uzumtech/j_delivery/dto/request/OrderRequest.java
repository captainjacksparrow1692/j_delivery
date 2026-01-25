package uzumtech.j_delivery.dto.request;

import lombok.Builder;

@Builder
public record OrderRequest(
        Long merchantId, // Добавь эту строку
        Double weight,
        Double length,
        Double width,
        Double height,
        Double distance,
        boolean isUrgent,
        boolean isFragile,
        String senderAddress,
        String receiverAddress
) {
}
