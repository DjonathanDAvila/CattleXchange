package com.cattle.xchange.domain.cattle.dtos;

import com.cattle.xchange.domain.cattle.enums.BreedEnum;
import com.cattle.xchange.domain.cattle.enums.CattleStatusEnum;
import com.cattle.xchange.domain.cattle.enums.SexEnum;
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
