package uzumtech.j_delivery.constant.enums;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum Error {
    // Твои существующие коды
    INTERNAL_SERVICE_ERROR_CODE(10001, "System not available", HttpStatus.INTERNAL_SERVER_ERROR),
    EXTERNAL_SERVICE_FAILED_ERROR_CODE(10002, "External service not available", HttpStatus.BAD_GATEWAY),
    HANDLER_NOT_FOUND_ERROR_CODE(10003, "Handler not found", HttpStatus.NOT_FOUND),
    JSON_NOT_VALID_ERROR_CODE(10004, "Json not valid", HttpStatus.BAD_REQUEST),
    VALIDATION_ERROR_CODE(10005, "Validation error", HttpStatus.BAD_REQUEST),
    INVALID_REQUEST_PARAM_ERROR_CODE(10006, "Invalid request param", HttpStatus.BAD_REQUEST),
    INTERNAL_TIMEOUT_ERROR_CODE(10007, "Internal timeout", HttpStatus.REQUEST_TIMEOUT),
    METHOD_NOT_SUPPORTED_ERROR_CODE(10008, "Method not supported", HttpStatus.METHOD_NOT_ALLOWED),
    MISSING_REQUEST_HEADER_ERROR_CODE(10009, "Missing request header", HttpStatus.BAD_REQUEST),
    HTTP_SERVICE_ERROR_CODE(10010, "Service error code", HttpStatus.INTERNAL_SERVER_ERROR),
    HTTP_CLIENT_ERROR_CODE(10011, "Client error code", HttpStatus.BAD_REQUEST),

    // НОВЫЕ коды, которых не хватало в OrderServiceImpl
    ORDER_NOT_FOUND(40001, "Order with specified ID not found", HttpStatus.NOT_FOUND),
    PRICE_SETTING_NOT_FOUND(50001, "Active price settings not found", HttpStatus.INTERNAL_SERVER_ERROR);

    final int code;
    final String message;
    final HttpStatus httpStatus; // Добавили поле

    Error(int code, String message, HttpStatus httpStatus) {
        this.code = code;
        this.message = message;
        this.httpStatus = httpStatus;
    }
}