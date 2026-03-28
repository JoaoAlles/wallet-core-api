package com.wallet.core.api.controller;

import com.wallet.core.api.dto.TransactionRequestDTO;
import com.wallet.core.domain.entity.Transaction;
import com.wallet.core.domain.repository.TransactionRepository;
import com.wallet.core.domain.service.TransactionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    private final TransactionService transactionService;
    private final TransactionRepository transactionRepository;

    public TransactionController(TransactionService transactionService, TransactionRepository transactionRepository) {
        this.transactionService = transactionService;
        this.transactionRepository = transactionRepository;
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody TransactionRequestDTO data) {
        transactionService.createTransaction(data);
        return ResponseEntity.ok("Transaction created successfully!");
    }

    @GetMapping
    public ResponseEntity<Page<Transaction>> findAll(
            @PageableDefault(size = 10, sort = "timestamp", direction = Sort.Direction.DESC) Pageable pageable) {
        return ResponseEntity.ok(transactionRepository.findAll(pageable));
    }

}
