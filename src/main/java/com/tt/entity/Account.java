package com.tt.entity;

import javax.persistence.*;

@Entity
@Table
public class Account {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;

    @Column(name="balance")
    Float balance;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Float getBalance() {
        return balance;
    }

    public void setBalance(Float balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", balance=" + balance +
                '}';
    }
}
