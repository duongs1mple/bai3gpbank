package com.example.bai3gpbank.controllers;

import com.example.bai3gpbank.services.CsvImportService;
import com.example.bai3gpbank.services.FileGeneratorService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/transactions")
@AllArgsConstructor

public class UserTransactionController {
    private FileGeneratorService fileGeneratorService;
    private CsvImportService csvImportService;

    @GetMapping("/test")
    ResponseEntity<String> test(){
        return ResponseEntity.ok("test");
    }
    @GetMapping("/highest_amount")
    ResponseEntity<byte[]> getHighestUserAmount(){
        return ResponseEntity.ok(fileGeneratorService.generateUserWithHighestAmountCsvFile());
    }
    @PostMapping("/import")
    public ResponseEntity<String> uploadCsv(@RequestParam("file") MultipartFile file) {
        try {
            int count = csvImportService.importCsvFile(file);
            return ResponseEntity.ok("Imported " + count + " transactions from CSV file.");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body("Failed to import file: " + e.getMessage());
        }
    }
}
