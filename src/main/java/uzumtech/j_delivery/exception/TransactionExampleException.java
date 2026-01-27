package uzumtech.j_delivery.exception;

import org.springframework.http.HttpStatus;
import uzumtech.j_delivery.constant.enums.ErrorType;

public class TransactionExampleException extends BussinesException {

    public TransactionExampleException(String message) {
        super(10011, message, HttpStatus.NOT_FOUND, ErrorType.INTERNAL);
    }
}