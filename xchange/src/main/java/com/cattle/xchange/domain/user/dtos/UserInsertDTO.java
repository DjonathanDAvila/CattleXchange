package com.cattle.xchange.domain.user.dtos;

import jakarta.validation.constraints.NotBlank;

public record UserInsertDTO(
        @NotBlank
        String document,
        @NotBlank
        String name,
        @NotBlank
        String lastName,
        @NotBlank
        String email,
        @NotBlank
        String password
) {
}
