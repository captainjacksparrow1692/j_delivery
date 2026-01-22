package uzumtech.j_delivery.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Builder;

@Builder
public record TariffRequest(
        @NotBlank(message = "Название тарифа не может быть пустым")
        String name,

        @Positive(message = "Максимальный вес должен быть больше 0")
        Double maxWeight,

        @Positive(message = "Максимальная длина должна быть больше 0")
        Double maxLength,

        @Positive(message = "Максимальная ширина должна быть больше 0")
        Double maxWidth,

        @Positive(message = "Максимальная высота должна быть больше 0")
        Double maxHeight
) {
}
