package uzumtech.j_delivery.dto;

import lombok.Builder;

@Builder
public record TariffDto(
        Long id,
        String name,
        Double length,
        Double weight,
        Double height,
        Double width
) {
}
