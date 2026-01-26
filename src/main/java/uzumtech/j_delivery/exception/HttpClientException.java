package uzumtech.j_delivery.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import uzumtech.j_delivery.constant.enums.ErrorType;

import static uzumtech.j_delivery.constant.enums.Error.HTTP_CLIENT_ERROR_CODE;
public class HttpClientException extends BussinesException {

    public HttpClientException(String message, HttpStatusCode status) {
        super(HTTP_CLIENT_ERROR_CODE.getCode(), message, HttpStatus.valueOf(status.value()), ErrorType.EXTERNAL);
    }
}