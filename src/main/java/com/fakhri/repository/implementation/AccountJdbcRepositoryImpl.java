package com.fakhri.repository.implementation;

import com.fakhri.domain.Account;
import com.fakhri.repository.AccountRepository;
import org.springframework.stereotype.Repository;


@Repository
public class AccountJdbcRepositoryImpl implements AccountRepository {
    @Override
    public void update(Account account) {

    }

    @Override
    public Account find(Long id) {
        return null;
    }
}
