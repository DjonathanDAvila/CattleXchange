package com.cattle.xchange.domain.cattle.dtos;

import com.cattle.xchange.domain.cattle.CattleAd;
import com.cattle.xchange.domain.cattle.enums.BreedEnum;
import com.cattle.xchange.domain.cattle.enums.CattleStatusEnum;
import com.cattle.xchange.domain.cattle.enums.SexEnum;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public record CattleAdMinDTO(
        @NotBlank
        String id,
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
        List<CattleAdImageMinDTO> cattleAdImages
) {
        public CattleAdMinDTO(CattleAd user) {
                this(
                        user.getId().toString(),
                        user.getTitle(),
                        user.getDesc(),
                        user.getUnitValue(),
                        user.getQuantity(),
                        user.getBreed(),
                        user.getSex(),
                        user.getUserCod(),
                        user.getCity(),
                        user.getState(),
                        user.getAdDate(),
                        user.getStatus(),
                        user.getCattleAdImages()
                                .stream()
                                .map(cattleAdImage -> new CattleAdImageMinDTO(cattleAdImage))
                                .collect(Collectors.toList())
                );

        }
}
