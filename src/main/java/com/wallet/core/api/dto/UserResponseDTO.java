package com.wallet.core.api.dto;

import com.wallet.core.domain.entity.User;

import java.math.BigDecimal;

public record UserResponseDTO(
        Long id,
        String email,
        BigDecimal balance
) {
    public static UserResponseDTO fromEntity(User user) {
        return new UserResponseDTO(user.getId(), user.getEmail(), user.getBalance());
    }
}
