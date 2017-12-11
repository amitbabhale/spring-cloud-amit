package com.db.awmd.challenge.domain;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.Data;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.db.awmd.challenge.domain.validation.ValidateString;

@Data
@EntityListeners(AuditingEntityListener.class)
@Entity
public class Transaction {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String transactionId;

    private String accountId;

    @CreatedDate
    private Date createdDateTime;


    @NotNull
    @ValidateString(acceptedValues={"DEBIT", "CREDIT" }, message="Invalid dataType")
    private String transactionType;

    @NotNull
    @Min(value = 1 , message = "mimimum ammount to credit or withdraw must be positive.")
    private BigDecimal ammount;
    
    private Boolean isSuccessful;
}
