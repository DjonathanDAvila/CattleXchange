package com.cattle.xchange.domain.user.auth;

import jakarta.validation.constraints.NotBlank;

public record AuthenticationRequest(
        @NotBlank String email,
        @NotBlank String password
) {
}
