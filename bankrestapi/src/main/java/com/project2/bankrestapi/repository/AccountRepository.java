package com.project2.bankrestapi.repository;

import com.project2.bankrestapi.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,Long> {
}
