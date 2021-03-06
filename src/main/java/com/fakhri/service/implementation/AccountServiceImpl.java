package com.fakhri.service.implementation;

import com.fakhri.domain.Account;
import com.fakhri.repository.AccountRepository;
import com.fakhri.repository.implementation.AccountRepositoryImpl;
import com.fakhri.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service(value = "accountService")
public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;

    @Override
    public void transferMoney(Long sourceId, Long destinationId, BigDecimal balance) {
        Account sourceAccount = accountRepository.find(sourceId);
        Account destinationAccount = accountRepository.find(destinationId);
        sourceAccount.setBalance(sourceAccount.getBalance().subtract(balance));
        destinationAccount.setBalance(destinationAccount.getBalance().add(balance));

        accountRepository.update(sourceAccount);
        accountRepository.update(destinationAccount);
    }

    @Override
    public Account getAccount(Long id) {

        return accountRepository.find(id);
    }

    public AccountRepository getAccountRepository() {
        return accountRepository;
    }

    // Menggunakan bean Autowired
    @Autowired
    // Untuk mengkualifikasi target autowired
    @Qualifier(value = "accountRepositoryImpl")
    public void setAccountRepository(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }
}
