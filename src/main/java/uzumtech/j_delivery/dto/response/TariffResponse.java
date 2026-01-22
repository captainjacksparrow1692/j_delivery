package uzumtech.j_delivery.dto.response;

import lombok.Builder;

@Builder
public record TariffResponse(
        Long id,
        String name,
        Double maxWeight,
        Double maxLength,
        Double maxWidth,
        Double maxHeight,
        String description
) {
}
