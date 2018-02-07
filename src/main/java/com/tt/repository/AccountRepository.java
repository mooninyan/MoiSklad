package com.tt.repository;

import com.tt.entity.Account;

public interface AccountRepository {
    void save(Account account);
    Float balance(Integer id);
    Account findById(Integer id);
}
