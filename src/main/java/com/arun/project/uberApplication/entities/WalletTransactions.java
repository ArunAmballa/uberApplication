package com.arun.project.uberApplication.entities;

import com.arun.project.uberApplication.entities.enums.TransactionMethod;
import com.arun.project.uberApplication.entities.enums.TransactionType;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
public class WalletTransactions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double amount;

    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;

    @Enumerated(EnumType.STRING)
    private TransactionMethod transactionMethod;

    @OneToOne(fetch = FetchType.EAGER)
    private Ride ride;

    private String transactionId;

    @CreationTimestamp
    private LocalDateTime timeStamp;

    @ManyToOne
    private Wallet wallet;

}
