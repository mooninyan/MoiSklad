package com.tt.repository;

import com.tt.entity.Account;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Transactional
public class AccountRepositoryImpl implements AccountRepository {
    @PersistenceContext()
    private EntityManager em;

    public void save(Account account) {

        if (em.find(Account.class, account.getId())==null) {
            this.em.persist(account);
        } else {
            this.em.merge(account);
        }
        em.flush();
    }

    public Float balance(Integer id) {
        Account account = em.find(Account.class, id);
        if(account==null){
            return null;
        }
        return account.getBalance();
    }

    public Account findById(Integer id) {
        return em.find(Account.class, id);
    }
}
