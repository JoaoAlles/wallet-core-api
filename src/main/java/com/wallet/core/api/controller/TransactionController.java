package com.wallet.core.api.controller;

import com.wallet.core.api.dto.TransactionRequestDTO;
import com.wallet.core.domain.service.TransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody TransactionRequestDTO data) {
        transactionService.createTransaction(data);
        return ResponseEntity.ok("Transaction created successfully!");
    }
}
