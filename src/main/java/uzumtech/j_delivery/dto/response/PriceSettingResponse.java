package uzumtech.j_delivery.dto.response;

public record PriceSettingResponse(
        Long id,
        Double freeDistance,
        Double baseFee,
        Double perKgRate,
        Double perKmRate,
        Double urgentFee,
        Double fragileFee
) {
}
