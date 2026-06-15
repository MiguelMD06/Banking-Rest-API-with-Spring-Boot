package co.miguelmd06.bankingapp.serviceImpl;

import co.miguelmd06.bankingapp.dto.AccountDTO;
import co.miguelmd06.bankingapp.entity.Account;
import co.miguelmd06.bankingapp.mapper.AccountMapper;
import co.miguelmd06.bankingapp.repository.AccountRepository;
import co.miguelmd06.bankingapp.service.AccountService;

import java.util.List;

public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    //Dependency injection by constructor
    public AccountServiceImpl(AccountRepository accountRepository){
        this.accountRepository = accountRepository;
    }

    @Override
    public AccountDTO saveAccount(AccountDTO accountDTO) {
        Account savedAccount = accountRepository.save(
                AccountMapper.toEntity(accountDTO)
        );
        return AccountMapper.toDTO(savedAccount);
    }

    @Override
    public AccountDTO getAccountById(Long id) {
        return AccountMapper.toDTO(
                accountRepository.findById(id)
                        .orElseThrow(
                                () -> new RuntimeException("Account with id "+ id + "does not exist.")
                        )
        );
    }

    @Override
    public List<AccountDTO> getAccounts() {
        return accountRepository.findAll()
                .stream().map(AccountMapper :: toDTO).toList();
    }

    @Override
    public AccountDTO updateAccount(AccountDTO accountDTO) {
        Account updatedAccount = accountRepository.save(
                AccountMapper.toEntity(accountDTO)
        );
        return AccountMapper.toDTO(updatedAccount);
    }
}
