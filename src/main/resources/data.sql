CREATE DATABASE IF NOT EXISTS banking;
USE banking;
CREATE TABLE IF NOT EXISTS transactions (
                                            transaction_id BIGINT PRIMARY KEY AUTO_INCREMENT,
                                            customer_id VARCHAR(50),
    transfer_number VARCHAR(50),
    transaction_date DATE,
    amount DOUBLE
    );
