package uzumtech.j_delivery.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Builder;

@Builder
public record OrderRequest(
        @NotNull(message = "Вес обязателен для расчета")
        @Positive(message = "Вес должен быть больше нуля")
        Double weight,

        @NotNull(message = "Длина обязательна")
        @Min(value = 1, message = "Минимальная длина — 1 см")
        Double length,

        @NotNull(message = "Ширина обязательна")
        @Min(value = 1, message = "Минимальная ширина — 1 см")
        Double width,

        @NotNull(message = "Высота обязательна")
        @Min(value = 1, message = "Минимальная высота — 1 см")
        Double height,

        @NotNull(message = "Расстояние доставки обязательно")
        @Positive(message = "Расстояние должно быть положительным числом")
        Double distance,

        // Опции (по умолчанию false, если не переданы)
        boolean isUrgent,
        boolean isFragile,

        // Информация о точках (опционально, но полезно для трекинга)
        String senderAddress,
        String receiverAddress
) {
}
