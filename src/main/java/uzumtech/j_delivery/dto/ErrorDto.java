package uzumtech.j_delivery.dto;

import lombok.Builder;
import uzumtech.j_delivery.constant.enums.ErrorType;

import java.util.List;

@Builder
public record ErrorDto(
        int code,
        String message,
        ErrorType errorType,
        List<String> validationErrors
) {
}
