package com.wallet.core.api.dto;

public record AuthenticationDTO(
        String email,
        String password
) {}

