package com.db.awmd.challenge.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.db.awmd.challenge.domain.Transaction;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction, String>{

    List<Transaction> findByAccountId(String accountId);

}
