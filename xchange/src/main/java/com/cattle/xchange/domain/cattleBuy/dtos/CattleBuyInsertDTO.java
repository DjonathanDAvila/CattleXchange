package com.cattle.xchange.domain.cattleBuy.dtos;

import jakarta.validation.constraints.NotBlank;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public record CattleBuyInsertDTO(
        UUID codUser,
        List<UUID> listCodAds,
        Date dataBuy
) {
}
