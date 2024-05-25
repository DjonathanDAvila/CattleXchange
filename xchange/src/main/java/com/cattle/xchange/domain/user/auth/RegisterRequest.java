package com.cattle.xchange.domain.user.auth;

import jakarta.validation.constraints.NotBlank;

public record RegisterRequest(
        @NotBlank String document,
        @NotBlank String firstName,
        String lastName,
        @NotBlank String email,
        @NotBlank String password
) {
}
