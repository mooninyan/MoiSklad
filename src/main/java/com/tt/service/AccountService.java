package com.tt.service;

import com.tt.entity.Account;
import com.tt.repository.AccountRepository;

public class AccountService {
    AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public String resolveCommand(String command) throws IllegalArgumentException {
        String message;

        String[] commArr = command.trim().split(" ");

        Integer accId = Integer.valueOf(commArr[1]);
        Float transfer = 0.f;

        if (commArr.length == 3) {
            transfer = Float.valueOf(commArr[2]);
        }
        try {
            switch (commArr[0]) {
                case (CommandValidator.NEWACCOUNT):
                    if (accountRepository.findById(accId) == null) {
                        Account account = new Account();
                        account.setId(accId);
                        account.setBalance(0.f);
                        accountRepository.save(account);
                        message = "OK";
                    } else {
                        message = "ERROR";
                    }
                    break;

                case (CommandValidator.DEPOSIT):
                    Account accountDB = accountRepository.findById(accId);

                    if (accountDB == null) {
                        Account accountDeposit = new Account();
                        accountDeposit.setId(accId);
                        accountDeposit.setBalance(transfer);
                        accountRepository.save(accountDeposit);
                        message = "OK";
                    }else{
                        accountDB.setBalance(transfer + accountDB.getBalance());
                        accountRepository.save(accountDB);
                        message = "OK";
                    }
                    break;
                case (CommandValidator.BALANCE):
                    if(accountRepository.balance(accId)==null){
                        message = "ERROR";
                        break;
                    }
                    message = accountRepository.balance(accId).toString();
                    break;

                case (CommandValidator.WITHDRAW):
                    Account accountDB1 = accountRepository.findById(accId);
                    if(accountDB1.getBalance() - transfer < 0) {
                        message = "ERROR";
                        break;
                    }

                    if (accountDB1 == null) {
                        message = "ERROR";
                    }else{
                        accountDB1.setBalance(accountDB1.getBalance() - transfer);
                        accountRepository.save(accountDB1);
                        message = "OK";
                    }
                    break;
                default:
                    message = "ERROR";
                    break;
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            message = "ERROR";
        }
        return message;
    }

}

