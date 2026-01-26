package uzumtech.j_delivery.constant.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum Error {

    // --- 1000: SYSTEM ERRORS (Критические сбои) ---
    INTERNAL_SERVER_ERROR(1000, "Internal server error occurred", HttpStatus.INTERNAL_SERVER_ERROR),
    DATABASE_ERROR(1001, "Database connection or integrity error", HttpStatus.SERVICE_UNAVAILABLE),
    KAFKA_ERROR(1002, "Message broker communication failed", HttpStatus.SERVICE_UNAVAILABLE),
    EXTERNAL_SERVICE_ERROR(1003, "External API is not responding", HttpStatus.BAD_GATEWAY),
    HTTP_CLIENT_ERROR_CODE(1004, "Client request to external service failed", HttpStatus.BAD_REQUEST),

    // --- 2000: SECURITY & AUTH (Доступ) ---
    UNAUTHORIZED(2000, "User is not authenticated", HttpStatus.UNAUTHORIZED),
    FORBIDDEN(2001, "Access denied for this resource", HttpStatus.FORBIDDEN),
    MERCHANT_ACCESS_DENIED(2002, "You can only access your own orders", HttpStatus.FORBIDDEN),
    INVALID_TOKEN(2003, "Authentication token is invalid or expired", HttpStatus.UNAUTHORIZED),

    // --- 3000: VALIDATION ERRORS (Входящие данные) ---
    VALIDATION_FAILED(3000, "Input data validation failed", HttpStatus.BAD_REQUEST),
    INVALID_DIMENSIONS(3001, "Package dimensions exceed allowed limits", HttpStatus.BAD_REQUEST),
    WEIGHT_LIMIT_EXCEEDED(3002, "Package weight exceeds maximum limit", HttpStatus.BAD_REQUEST),
    INVALID_PHONE_NUMBER(3003, "Phone number format is incorrect", HttpStatus.BAD_REQUEST),
    MANDATORY_FIELD_MISSING(3004, "Required field is empty", HttpStatus.BAD_REQUEST),

    // --- 4000: ORDER BUSINESS LOGIC (Жизненный цикл заказа) ---
    ORDER_NOT_FOUND(4000, "Order with specified ID does not exist", HttpStatus.NOT_FOUND),
    ORDER_ALREADY_EXISTS(4001, "Order with this tracking number already exists", HttpStatus.CONFLICT),
    INVALID_STATUS_TRANSITION(4002, "Cannot change status to requested state", HttpStatus.BAD_REQUEST),
    ORDER_LOCKED(4003, "Order is currently being processed by another system", HttpStatus.LOCKED),
    ORDER_ALREADY_CANCELLED(4004, "Cannot modify an already cancelled order", HttpStatus.BAD_REQUEST),
    ORDER_ALREADY_DELIVERED(4005, "Cannot modify an already delivered order", HttpStatus.BAD_REQUEST),

    // --- 5000: LOGISTICS & PRICING (География и деньги) ---
    PRICE_SETTING_NOT_FOUND(5000, "Active price settings not found", HttpStatus.INTERNAL_SERVER_ERROR),
    PRICE_CALCULATION_FAILED(5001, "Could not calculate delivery price", HttpStatus.UNPROCESSABLE_ENTITY),
    OUT_OF_SERVICE_AREA(5002, "Delivery address is outside the service zone", HttpStatus.BAD_REQUEST),
    COURIER_NOT_AVAILABLE(5003, "No couriers available for this route", HttpStatus.SERVICE_UNAVAILABLE),
    DISTANCE_TOO_LONG(5004, "Delivery distance exceeds maximum allowed", HttpStatus.BAD_REQUEST),
    INSUFFICIENT_MERCHANT_FUNDS(5005, "Merchant has insufficient balance", HttpStatus.PAYMENT_REQUIRED),

    // --- 6000: INTEGRATION SPECIFIC (Uzum Ecosystem) ---
    MERCHANT_NOT_FOUND(6000, "Merchant account not found in Uzum system", HttpStatus.NOT_FOUND),
    TARIFF_NOT_FOUND(6001, "Selected delivery tariff is inactive", HttpStatus.NOT_FOUND),
    INTEGRATION_SYNC_ERROR(6002, "Failed to sync order data with external warehouse", HttpStatus.INTERNAL_SERVER_ERROR);

    private final int code;
    private final String message;
    private final HttpStatus httpStatus;
}