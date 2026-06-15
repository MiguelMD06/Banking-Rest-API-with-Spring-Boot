package co.miguelmd06.bankingapp.mapper;

import co.miguelmd06.bankingapp.dto.AccountDTO;
import co.miguelmd06.bankingapp.entity.Account;

public class AccountMapper {

    public static AccountDTO toDTO(Account account){
        return new AccountDTO(
                account.getId(),
                account.getAccountHolderName(),
                account.getBalance()
        );
    }

    public static Account toEntity(AccountDTO accountDTO){
        return new Account(
                accountDTO.id(),
                accountDTO.accountHolderName(),
                accountDTO.balance()
                );
    }
}
