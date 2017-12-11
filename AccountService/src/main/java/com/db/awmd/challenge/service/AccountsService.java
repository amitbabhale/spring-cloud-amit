package com.db.awmd.challenge.service;

import java.math.BigDecimal;

import javax.transaction.Transactional;

import lombok.Getter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.db.awmd.challenge.domain.Account;
import com.db.awmd.challenge.domain.Transaction;
import com.db.awmd.challenge.domain.enums.TransactionType;
import com.db.awmd.challenge.repository.AccountsRepository;
import com.db.awmd.challenge.repository.TransactionRepository;

@Service
public class AccountsService {

    @Getter
    private final AccountsRepository accountsRepository;

    @Autowired
    private final TransactionRepository transactionRepository;

    @Autowired
    public AccountsService(AccountsRepository accountsRepository, TransactionRepository transactionRepository) {
        this.accountsRepository = accountsRepository;
        this.transactionRepository = transactionRepository;
    }

    public void createAccount(Account account) {
        this.accountsRepository.createAccount(account);
    }

    public Account getAccount(String accountId) {
        return this.accountsRepository.getAccount(accountId);
    }

    @Transactional
    public Transaction performTransaction(final String accountId, final Transaction transaction) throws Exception {
        
        Account account  = getAccount(accountId);
        if(null==account){
        	throw new ResourceNotFoundException(accountId, null);
        }
        transaction.setIsSuccessful(PerformDBtransaction(transaction, account));
        //System.out.println("exit sync block");
        return transactionRepository.save(transaction);

    }

    private synchronized boolean PerformDBtransaction(Transaction transaction, Account acount) {
        boolean Issuccesful = false;        
        /*try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println("Inside sync block");*/
        if(transaction.getTransactionType().equalsIgnoreCase(TransactionType.CREDIT.toString())){            
            acount.setBalance(acount.getBalance().add(transaction.getAmmount()));
            Issuccesful = Boolean.TRUE;
        } else if(transaction.getTransactionType().equalsIgnoreCase(TransactionType.DEBIT.toString())){
            if(acount.getBalance().subtract(transaction.getAmmount()).compareTo(BigDecimal.ZERO) > 0){
            	acount.setBalance(acount.getBalance().subtract(transaction.getAmmount()));
                Issuccesful = Boolean.TRUE;
            }                
        }
        return Issuccesful;
    }
}
