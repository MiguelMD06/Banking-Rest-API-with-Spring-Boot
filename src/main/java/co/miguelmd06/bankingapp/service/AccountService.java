package co.miguelmd06.bankingapp.service;

import co.miguelmd06.bankingapp.dto.AccountDTO;

import java.math.BigDecimal;
import java.util.List;

public interface AccountService {
    AccountDTO saveAccount(AccountDTO accountDTO);
    AccountDTO getAccountById(Long id);
    List<AccountDTO> getAccounts();
    AccountDTO updateAccount(AccountDTO accountDTO);
    void deleteAccount(Long id);
    AccountDTO depositToAccount(Long id, String amount);
    AccountDTO withdrawAccount(Long id, String amount);
    BigDecimal validateAmount(String amount);
}
