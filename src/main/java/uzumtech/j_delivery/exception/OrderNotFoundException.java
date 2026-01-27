package uzumtech.j_delivery.exception;

import org.springframework.http.HttpStatus;
import uzumtech.j_delivery.constant.enums.ErrorType;

public class OrderNotFoundException extends BussinesException {

    public OrderNotFoundException(String message) {
        super(10011, message, HttpStatus.CONFLICT, ErrorType.INTERNAL);
    }
}
