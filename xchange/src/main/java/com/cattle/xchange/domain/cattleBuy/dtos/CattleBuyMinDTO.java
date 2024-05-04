package com.cattle.xchange.domain.cattleBuy.dtos;

import com.cattle.xchange.domain.cattleAd.dtos.CattleAdMinDTO;
import com.cattle.xchange.domain.user.dtos.UserMinDTO;
import jakarta.validation.constraints.NotBlank;

import java.util.Date;
import java.util.UUID;

public record CattleBuyMinDTO(
        @NotBlank
        UUID codBuy,
        @NotBlank
        Date dateBuy,
        @NotBlank
        double totalValue,
        @NotBlank
        UserMinDTO user,
        @NotBlank
        CattleAdMinDTO cattleAd
) {
}