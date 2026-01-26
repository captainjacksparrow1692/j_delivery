package uzumtech.j_delivery.exception;

import lombok.Getter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import uzumtech.j_delivery.constant.enums.ErrorType;

@Getter
@ToString
@FieldDefaults(level = lombok.AccessLevel.PRIVATE, makeFinal = true)
public class BussinesException extends RuntimeException {
    int code;
    String message;
    HttpStatus httpStatus;
    ErrorType errorType;

    public BussinesException(int code, String message, HttpStatus httpStatus, ErrorType errorType) {
        this.code = code;
        this.message = message;
        this.httpStatus = httpStatus;
        this.errorType = errorType;
    }

}
