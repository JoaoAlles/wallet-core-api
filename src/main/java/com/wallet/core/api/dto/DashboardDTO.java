package com.wallet.core.api.dto;

import java.math.BigDecimal;

public record DashboardDTO(
        BigDecimal currentBalance,
        BigDecimal totalIncome,
        BigDecimal totalExpense
) {}