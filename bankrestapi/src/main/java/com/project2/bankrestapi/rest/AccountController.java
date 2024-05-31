package com.project2.bankrestapi.rest;

import com.project2.bankrestapi.Service.AccountService;
import com.project2.bankrestapi.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {
  private final AccountService accountService;

  @Autowired
  public AccountController(AccountService accountService) {
    this.accountService = accountService;
  }

  @PostMapping
  public Account addAcccount(@RequestBody Account account){
    return accountService.createAccount(account);
  }

  @GetMapping("/{id}")
  public Account getAccount(@PathVariable Long id){
    return accountService.getAccount(id);
  }

  @PostMapping("/{id}/deposit")
  public Account depoisteAccount(@PathVariable Long id , @RequestBody Map<String,Double> request){
    Double amount = request.get("amount");
    return accountService.deposite(id,amount);

  }

  @PostMapping("/{id}/withdraw")
  public Account withDraw(@PathVariable Long id,@RequestBody Map<String,Double> request){
    Double amount = request.get("amount");
    return accountService.WithDraw(id,amount);
  }

}
