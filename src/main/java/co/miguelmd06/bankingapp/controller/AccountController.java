package co.miguelmd06.bankingapp.controller;

import co.miguelmd06.bankingapp.dto.AccountDTO;
import co.miguelmd06.bankingapp.service.AccountService;
import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    private final AccountService accountService;

    //Dependency injection by Constructor
    public AccountController(AccountService accountService){
        this.accountService = accountService;
    }

    @PostMapping
    public ResponseEntity<AccountDTO> saveAccount(@RequestBody AccountDTO accountDTO){
        AccountDTO savedAccount = accountService.saveAccount(accountDTO);
        return new ResponseEntity<>(savedAccount, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountDTO> getAccountById(@PathVariable Long id){
        return ResponseEntity.ok(accountService.getAccountById(id));
    }

    @GetMapping
    public ResponseEntity<List<AccountDTO>> getAccounts(){
        return ResponseEntity.ok(accountService.getAccounts());
    }

    @PutMapping
    public ResponseEntity<AccountDTO> updateAccount(@RequestBody AccountDTO accountDTO){
        AccountDTO updatedAccount = accountService.updateAccount(accountDTO);
        return ResponseEntity.ok(updatedAccount);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAccount(@PathVariable Long id){
        accountService.deleteAccount(id);
        return new ResponseEntity<>(
                "Account with id " + id + " has been deleted succesfully",
                HttpStatus.OK
                );
    }

    //Deposit Method
    @PutMapping("/{id}/deposit")
    public ResponseEntity<AccountDTO> depositToAccount(@PathVariable Long id,@RequestBody Map<String,String> request){
        BigDecimal amount = new BigDecimal(request.get("amount"));
        AccountDTO accountDTO = accountService.depositToAccount(id,amount);
        return ResponseEntity.ok(accountDTO);
    }
}
