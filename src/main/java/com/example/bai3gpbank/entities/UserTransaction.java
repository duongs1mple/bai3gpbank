package com.example.bai3gpbank.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "transactions")
public class UserTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_id")
    //private Long transactionId;
    private Long id;

    @Column(name = "customer_id", nullable = false)
    private String customerId;

    @Column(name = "transfer_number", length = 50, nullable = false)
    private String transferNumber;

    @Column(name = "transaction_date")
    private LocalDate transactionDate;

    @Column(name = "amount", precision = 15, scale = 2)
    private BigDecimal amount;

//    public static UserTransaction fromCsv(String[] fields) {
//        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("d/M/yyyy");
//        return new UserTransaction(
//                Long.parseLong(fields[0]),
//                fields[1],
//                fields[2],
//                LocalDate.parse(fields[3], fmt),
//                new BigDecimal(fields[4])
//        );
//    }

}
