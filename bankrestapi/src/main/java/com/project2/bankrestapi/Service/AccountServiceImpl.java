package com.project2.bankrestapi.Service;

import com.project2.bankrestapi.entity.Account;
import com.project2.bankrestapi.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

  private final AccountRepository accountRepository;

  @Autowired
  public AccountServiceImpl(AccountRepository accountRepository) {
    this.accountRepository = accountRepository;
  }

  @Override
  public Account createAccount(Account account) {
    return accountRepository.save(account);

  }

  @Override
  public Account getAccount(Long id) {
    Account account = accountRepository.findById(id).orElseThrow(() -> new RuntimeException("The required account is " +
            "not exist"));
    return account;
  }

  @Override
  public Account deposite(Long id, double amount) {
    Account account = accountRepository.findById(id).orElseThrow(() -> new RuntimeException("The required account is " +
            "not exist"));
    account.setBalance(account.getBalance() + amount);
    accountRepository.save(account);
    return account;
  }

  @Override
  public Account WithDraw(Long id, double amount) {
    Account account = accountRepository.findById(id).orElseThrow(() -> new RuntimeException("The required account is " +
            "not exist"));
    if(account.getBalance() < amount) {
       throw new RuntimeException("Insufficient funds");
    }
    account.setBalance(account.getBalance() - amount);
    accountRepository.save(account);
    return account;
  }
}
