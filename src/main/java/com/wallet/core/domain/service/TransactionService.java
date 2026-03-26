package com.wallet.core.domain.service;

import com.wallet.core.api.dto.TransactionRequestDTO;
import com.wallet.core.domain.entity.Category;
import com.wallet.core.domain.entity.Transaction;
import com.wallet.core.domain.entity.User;
import com.wallet.core.domain.repository.CategoryRepository;
import com.wallet.core.domain.repository.TransactionRepository;
import com.wallet.core.domain.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;
    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;

    public TransactionService(
            TransactionRepository transactionRepository,
            UserRepository userRepository,
            CategoryRepository categoryRepository)
    {
        this.transactionRepository = transactionRepository;
        this.userRepository = userRepository;
        this.categoryRepository = categoryRepository;
    }

    @Transactional
    public void createTransaction(TransactionRequestDTO data) {
        User user = userRepository.findById(data.userId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Category category = categoryRepository.findById(data.categoryId())
                .orElseThrow(() -> new RuntimeException("Category not found"));

        BigDecimal amount = data.amount();
        BigDecimal newBalance = getBigDecimal(data, user, amount);

        user.setBalance(newBalance);
        userRepository.save(user);

        Transaction transaction = new Transaction();
        transaction.setAmount(amount);
        transaction.setType(data.type());
        transaction.setCategory(category);
        transaction.setUser(user);
        transaction.setTimestamp(LocalDateTime.now());

        transactionRepository.save(transaction);
    }

    private static BigDecimal getBigDecimal(TransactionRequestDTO data, User user, BigDecimal amount) {
        BigDecimal newBalance;

        if ("EXPENSE".equals(data.type())) {
            if (user.getBalance().compareTo(amount) < 0) {
                throw new RuntimeException("Insufficient balance for this expense");
            }
            newBalance = user.getBalance().subtract(amount);
        } else if ("INCOME".equals(data.type())) {
            newBalance = user.getBalance().add(amount);
        } else {
            throw new RuntimeException("Invalid transaction type");
        }
        return newBalance;
    }

}
