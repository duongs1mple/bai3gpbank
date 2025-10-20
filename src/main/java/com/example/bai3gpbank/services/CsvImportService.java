package com.example.bai3gpbank.services;

import com.example.bai3gpbank.entities.UserTransaction;
import com.example.bai3gpbank.repositories.UserTransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CsvImportService {

    private final UserTransactionRepository userTransactionRepository;

//    // Dùng cho file có sẵn trong resources
//    public void importCsvData() {
//        try (BufferedReader reader = new BufferedReader(
//                new InputStreamReader(getClass().getResourceAsStream("/data/transactions.csv"), StandardCharsets.UTF_8))) {
//
//            List<UserTransaction> transactions = parseCsv(reader);
//            userTransactionRepository.saveAll(transactions);
//            System.out.println("Imported " + transactions.size() + " transactions from CSV file");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    // file import via API
    public int importCsvFile(MultipartFile file) throws Exception {
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(file.getInputStream(), StandardCharsets.UTF_8))) {

            List<UserTransaction> transactions = parseCsv(reader);
            userTransactionRepository.saveAll(transactions);
            return transactions.size();
        }
    }

    // Hàm xử lý parse CSV chung
    private List<UserTransaction> parseCsv(BufferedReader reader) throws Exception {
        List<UserTransaction> transactions = new ArrayList<>();
        String line;
        boolean firstLine = true;
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("d/M/yyyy");

        while ((line = reader.readLine()) != null) {
            if (firstLine) {
                firstLine = false;
                continue; // bỏ  header
            }

            String[] f = line.split(",");
            UserTransaction t = new UserTransaction();
            t.setCustomerId(f[1]);
            t.setTransferNumber(f[2]);
            t.setTransactionDate(LocalDate.parse(f[3], fmt));
            t.setAmount(new BigDecimal(f[4]));
            transactions.add(t);

        }
        return transactions;
    }
}
