package com.cattle.xchange.domain.cattleAd.dtos;

import com.cattle.xchange.domain.cattleAd.enums.BreedEnum;
import com.cattle.xchange.domain.cattleAd.enums.CattleStatusEnum;
import com.cattle.xchange.domain.cattleAd.enums.SexEnum;
import com.cattle.xchange.domain.cattleAdImage.dtos.CattleAdImageInsertDTO;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public record CattleAdInsertDTO(
        @NotBlank
        String title,
        @NotBlank
        String desc,
        @NotBlank
        double unitValue,
        @NotBlank
        int quantity,
        @NotBlank
        BreedEnum breed,
        @NotBlank
        SexEnum sex,
        @NotBlank
        UUID userCod,
        @NotBlank
        String city,
        @NotBlank
        String state,
        @NotBlank
        LocalDate adDate,
        @NotBlank
        CattleStatusEnum status,
        @NotBlank
        List<CattleAdImageInsertDTO> cattleAdImages
) {
}
