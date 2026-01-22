package uzumtech.j_delivery.dto;

public record TariffDto(
        Long length,
        Long weight,
        Long height,
        Long width
) {
}
