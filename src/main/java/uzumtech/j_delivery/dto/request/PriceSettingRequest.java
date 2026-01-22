package uzumtech.j_delivery.dto.request;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder
public record PriceSettingRequest(
        @NotNull(message = "Базовая ставка не может быть пустой")
        @DecimalMin(value = "0.0", message = "Базовая ставка не может быть отрицательной")
        Double baseFee,

        @NotNull(message = "Тариф за кг не может быть пустым")
        @DecimalMin(value = "0.0", message = "Тариф за кг должен быть положительным")
        Double perKgRate,

        @NotNull(message = "Тариф за км не может быть пустым")
        @DecimalMin(value = "0.0", message = "Тариф за км должен быть положительным")
        Double perKmRate,

        @NotNull(message = "Бесплатное расстояние должно быть указано")
        @DecimalMin(value = "0.0", message = "Расстояние не может быть отрицательным")
        Double freeDistance,

        @NotNull(message = "Комиссия за срочность обязательна")
        @DecimalMin(value = "0.0", message = "Комиссия не может быть отрицательной")
        Double urgentFee,

        @NotNull(message = "Комиссия за хрупкость обязательна")
        @DecimalMin(value = "0.0", message = "Комиссия не может быть отрицательной")
        Double fragileFee
) {
}
