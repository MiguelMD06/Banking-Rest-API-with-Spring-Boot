package co.miguelmd06.bankingapp.controller;

import co.miguelmd06.bankingapp.dto.AccountDTO;
import co.miguelmd06.bankingapp.service.AccountService;
import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        AccountDTO updatedAccount = accountService.saveAccount(accountDTO);
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
}
