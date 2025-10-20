package com.example.bai3gpbank.services;

import com.example.bai3gpbank.entities.UserTransaction;
import com.example.bai3gpbank.utils.CsvGeneratorUtil;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

@Service
@AllArgsConstructor
public class FileGeneratorService {
    private UserTransactionService userTransactionService;
    private CsvGeneratorUtil csvGeneratorUtil;
    public byte[] generateUserWithHighestAmountCsvFile(){
        List<UserTransaction> userTransactionList = userTransactionService.getAllTransactionsOfUserHasHighestAmount();
//        byte[] csvBytes = csvGeneratorUtil.generateCsv(userTransactionList).getBytes();
//        return csvBytes;

        //generate CSV content as String
        String csvContent = csvGeneratorUtil.generateCsv(userTransactionList);

        //Generate CSV file to a path
        saveCsvToFile(csvContent, "exports/highest_user_transactions.csv");

        //return the bytes for API
        return csvContent.getBytes();
    }
    private void saveCsvToFile(String csvContent, String filePath) {
        try {
            File file = new File(filePath);
            file.getParentFile().mkdirs(); // Create destination path if not already exists

            try (FileWriter writer = new FileWriter(file)) {
                writer.write(csvContent);
            }

            System.out.println("File CSV generated and saved at: " + file.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Error: " + e.getMessage());
        }
    }
}
