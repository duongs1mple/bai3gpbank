package com.example.bai3gpbank.repositories;

import com.example.bai3gpbank.entities.UserTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserTransactionRepository extends JpaRepository<UserTransaction, Long> {

    // Ví dụ: Tìm tất cả giao dịch theo customer_id
    @Query(value = "SELECT * FROM transactions WHERE customer_id = :customerId", nativeQuery = true)
    List<UserTransaction> findByCustomerId(String customerId);

    // Ví dụ: Tìm giao dịch theo mã chuyển khoản (transfer_number)
    Optional<UserTransaction> findByTransferNumber(String transferNumber);

    @Query(value = """
        SELECT t.customer_id 
        FROM transactions t
        GROUP BY t.customer_id
        ORDER BY SUM(t.amount) DESC
        LIMIT 1
        """, nativeQuery = true)
    String findTopCustomerByTotalAmount();


}