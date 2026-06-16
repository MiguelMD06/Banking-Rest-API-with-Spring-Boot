package co.miguelmd06.bankingapp.exception;

import java.time.LocalDateTime;

public record ErrorDetails(
        LocalDateTime timestamp,
        String errorMessage,
        String errorDetails,
        String httpCode
) {
}
