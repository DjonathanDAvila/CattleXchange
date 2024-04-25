package com.cattle.xchange.domain.user.dtos;

import com.cattle.xchange.domain.user.User;

import java.time.LocalDate;
import java.util.UUID;

public record UserMinDTO(
        UUID id,
        String document,
        String name,
        String lastName,
        String email,
        LocalDate creationDate
) {

    public UserMinDTO(User user) {
        this(
                user.getId(),
                user.getDocument(),
                user.getName(),
                user.getLastName(),
                user.getEmail(),
                user.getCreationDate()
        );

    }
}
