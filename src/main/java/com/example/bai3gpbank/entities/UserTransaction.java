package com.example.bai3gpbank.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "user_transaction")
public class UserTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_id")
    private Long transactionId;

    @Column(name = "customer_id", nullable = false)
    private String customerId;

    @Column(name = "transfer_number", length = 50, nullable = false)
    private String transferNumber;

    @Column(name = "transaction_date")
    private LocalDateTime transactionDate;

    @Column(name = "amount", precision = 15, scale = 2)
    private BigDecimal amount;



}
