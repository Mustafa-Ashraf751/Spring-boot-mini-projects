package com.project2.bankrestapi.Service;


import com.project2.bankrestapi.entity.Account;

public interface AccountService {
  Account createAccount(Account account);

  Account getAccount(Long id);

  Account deposite(Long id,double amount );

  Account WithDraw(Long id,double amount);


}
