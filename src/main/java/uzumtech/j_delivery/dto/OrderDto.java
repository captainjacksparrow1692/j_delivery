package uzumtech.j_delivery.dto;

public record OrderDto(
        String key,
        String correlationId,
        String message
) {
}
