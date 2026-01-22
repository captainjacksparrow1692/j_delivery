package uzumtech.j_delivery.dto.response;

public record PriceSettingResponse(
        Long id,
        Integer freeDistance,
        Integer baseFee,
        Integer perKgRate,
        Integer perKmRate,
        Integer urgentFee,
        Integer fragileFee
) {
}
