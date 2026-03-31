package com.wallet.core.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import java.math.BigDecimal;

public record TransactionRequestDTO(
        @NotNull(message = "Amount is required")
        @Positive(message = "Amount must be greater than zero")
        BigDecimal amount,

        @NotBlank(message = "Type is required")
        String type,

        @NotNull(message = "Category ID is required")
        Long categoryId,

        @NotNull(message = "User ID is required")
        Long userId
) {}
