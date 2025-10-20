package com.example.bai3gpbank.utils;

import com.example.bai3gpbank.entities.UserTransaction;
import org.springframework.stereotype.Component;

import java.io.StringWriter;
import java.util.List;

@Component
public class CsvGeneratorUtil {
//    private static final String CSV_HEADER = "transaction_id,customer_id,transfer_number,transaction_date,amount\n";
//
//    public String generateCsv(List<UserTransaction> transactionList) {
//        StringBuilder csvContent = new StringBuilder();
//        csvContent.append(CSV_HEADER);
//
//        for (UserTransaction transaction : transactionList) {
//            csvContent.append(transaction.getId()).append(",")
//                    .append(transaction.getCustomerId()).append(",")
//                    .append(transaction.getTransferNumber()).append(",")
//                    .append(transaction.getTransactionDate()).append(",")
//                    .append(transaction.getAmount()).append("\n");
//        }
//
//        return csvContent.toString();
//    }

    //Code moi
    public String generateCsv(List<UserTransaction> transactions) {
        StringWriter writer = new StringWriter();
        writer.append("Transaction ID,Customer ID,Transfer Number,Transaction Date,Amount\n");

        for (UserTransaction tx : transactions) {
            writer.append(String.valueOf(tx.getId())).append(",")
                    .append(tx.getCustomerId()).append(",")
                    .append(tx.getTransferNumber()).append(",")
                    .append(String.valueOf(tx.getTransactionDate())).append(",")
                    .append(String.valueOf(tx.getAmount())).append("\n");
        }

        return writer.toString();
    }
}