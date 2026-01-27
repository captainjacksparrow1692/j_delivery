package uzumtech.j_delivery.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import uzumtech.j_delivery.constant.enums.ErrorType;

import static uzumtech.j_delivery.constant.enums.Error.HTTP_SERVICE_ERROR_CODE;

public class HttpServerException extends BussinesException {

    public HttpServerException(String message, HttpStatusCode status) {
        super(HTTP_SERVICE_ERROR_CODE.getCode(), message, HttpStatus.valueOf(status.value()), ErrorType.EXTERNAL);
    }
}
