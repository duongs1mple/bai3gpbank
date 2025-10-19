package com.example.bai3gpbank.controllers;

import com.example.bai3gpbank.services.FileGeneratorService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/transactions")
@AllArgsConstructor

public class UserTransactionController {
    private FileGeneratorService fileGeneratorService;

    @GetMapping("/test")
    ResponseEntity<String> test(){
        return ResponseEntity.ok("test");
    }
    @GetMapping("/highest_amount")
    ResponseEntity<byte[]> getHighestUserAmount(){
        return ResponseEntity.ok(fileGeneratorService.generateUserWithHighestAmountCsvFile());
    }
}
