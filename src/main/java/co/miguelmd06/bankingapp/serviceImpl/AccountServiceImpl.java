package co.miguelmd06.bankingapp.serviceImpl;

import co.miguelmd06.bankingapp.dto.AccountDTO;
import co.miguelmd06.bankingapp.entity.Account;
import co.miguelmd06.bankingapp.exception.ResourceNotFoundException;
import co.miguelmd06.bankingapp.mapper.AccountMapper;
import co.miguelmd06.bankingapp.repository.AccountRepository;
import co.miguelmd06.bankingapp.service.AccountService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
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
                                () -> new ResourceNotFoundException("Account with id "+ id + " does not exist.")
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
        getAccountById(accountDTO.id());
        Account updatedAccount = accountRepository.save(
                AccountMapper.toEntity(accountDTO)
        );
        return AccountMapper.toDTO(updatedAccount);
    }

    @Override
    public void deleteAccount(Long id) {
        getAccountById(id);
        accountRepository.deleteById(id);
    }

    @Override
    public AccountDTO depositToAccount(Long id, BigDecimal amount) {
        Account account = AccountMapper.toEntity(getAccountById(id));
        BigDecimal totalBalance = account.getBalance().add(amount);
        account.setBalance(totalBalance);
        return AccountMapper.toDTO(
                accountRepository.save(account)
        );
    }

    @Override
    public AccountDTO withdrawAccount(Long id, BigDecimal amount) {
        Account account = AccountMapper.toEntity(getAccountById(id));
        BigDecimal totalBalance = account.getBalance().subtract(amount);
        account.setBalance(totalBalance);
        return AccountMapper.toDTO(
                accountRepository.save(account)
        );
    }
}
