package com.example.bai3gpbank.services;

import com.example.bai3gpbank.entities.UserTransaction;
import com.example.bai3gpbank.utils.CsvGeneratorUtil;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class FileGeneratorService {
    private UserTransactionService userTransactionService;
    private CsvGeneratorUtil csvGeneratorUtil;
    public byte[] generateUserWithHighestAmountCsvFile(){
        List<UserTransaction> userTransactionList = userTransactionService.getAllTransactionsOfUserHasHighestAmount();
        byte[] csvBytes = csvGeneratorUtil.generateCsv(userTransactionList).getBytes();
        return csvBytes;
    }
}
