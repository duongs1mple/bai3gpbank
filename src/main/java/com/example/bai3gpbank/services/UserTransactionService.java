package com.example.bai3gpbank.services;

import com.example.bai3gpbank.entities.UserTransaction;
import com.example.bai3gpbank.repositories.UserTransactionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserTransactionService {
    private UserTransactionRepository userTransactionRepository;

    public List<UserTransaction> getAllTransactionsOfUserHasHighestAmount(){
        String highestAmountCustomerId = userTransactionRepository.findTopCustomerByTotalAmount();
        return userTransactionRepository.findByCustomerId(highestAmountCustomerId);
    }
}
