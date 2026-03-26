package com.wallet.core.domain.service;

import com.wallet.core.api.dto.TransactionRequestDTO;
import com.wallet.core.domain.repository.TransactionRepository;
import com.wallet.core.domain.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;
    private final UserRepository userRepository;

    public TransactionService(TransactionRepository transactionRepository, UserRepository userRepository) {
        this.transactionRepository = transactionRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    public void createTransaction(TransactionRequestDTO data) {

    }
}
