package com.cattle.xchange.domain.user.dtos;

import com.cattle.xchange.domain.user.User;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.util.UUID;

public record UserMinDTO(
        UUID id,
        String document,
        String name,
        String lastName,
        String email,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
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
