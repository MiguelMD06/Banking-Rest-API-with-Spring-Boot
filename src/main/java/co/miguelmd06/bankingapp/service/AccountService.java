package co.miguelmd06.bankingapp.service;

import co.miguelmd06.bankingapp.dto.AccountDTO;

import java.util.List;

public interface AccountService {
    AccountDTO saveAccount(AccountDTO accountDTO);
    AccountDTO getAccountById(Long id);
    List<AccountDTO> getAccounts();
    AccountDTO updateAccount(AccountDTO accountDTO);
    void deleteAccount(Long id);
}
