package com.db.awmd.challenge.service;

import com.db.awmd.challenge.domain.Account;
import com.db.awmd.challenge.domain.Transaction;
import com.db.awmd.challenge.repository.AccountsRepository;
import com.db.awmd.challenge.repository.TransactionRepository;

import lombok.Getter;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;

    @Autowired
    public TransactionService(TransactionRepository accountsRepository) {
        this.transactionRepository = accountsRepository;
    }

    public void createAccount(Transaction transaction) {
        this.transactionRepository.save(transaction);
    }

    public Transaction getAccount(String transactionId) {
        return this.transactionRepository.findOne(transactionId);
    }
    
    public List<Transaction> getTransactions(String accountId) {
        return this.transactionRepository.findByAccountId(accountId);
    }
    
    
}
