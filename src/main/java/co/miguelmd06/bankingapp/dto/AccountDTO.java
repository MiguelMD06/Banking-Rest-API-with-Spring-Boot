package co.miguelmd06.bankingapp.dto;

import java.math.BigDecimal;

public record AccountDTO(Long id, String accountHolderName, BigDecimal balance) {
}
