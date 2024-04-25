package com.cattle.xchange.domain.cattle.cattleAd.dtos;

import com.cattle.xchange.domain.cattle.CattleAdImage;
import com.cattle.xchange.domain.cattle.cattleAd.enums.BreedEnum;
import com.cattle.xchange.domain.cattle.cattleAd.enums.CattleStatusEnum;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;
import java.util.ArrayList;
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
        char sex,
        @NotBlank
        UUID userCod,
        @NotBlank
        LocalDate adDate,
        @NotBlank
        CattleStatusEnum status,
        @NotBlank
        List<CattleAdImageInsertDTO> cattleAdImages
) {
}
