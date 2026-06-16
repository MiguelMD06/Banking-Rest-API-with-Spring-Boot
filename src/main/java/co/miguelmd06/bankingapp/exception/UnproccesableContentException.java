package co.miguelmd06.bankingapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNPROCESSABLE_CONTENT)
public class UnproccesableContentException extends RuntimeException {
    public UnproccesableContentException(String message) {
        super(message);
    }
}
