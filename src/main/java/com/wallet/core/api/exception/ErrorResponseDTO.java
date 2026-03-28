package com.wallet.core.api.exception;

import java.time.LocalDateTime;

public record ErrorResponseDTO(
        String message,
        int status,
        LocalDateTime timestamp
) {}
