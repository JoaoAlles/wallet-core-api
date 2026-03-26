package com.wallet.core.api.dto;

import java.math.BigDecimal;

public record TransactionRequestDTO(
        BigDecimal amount,
        String type,
        Long categoryId,
        Long userId
) {}
