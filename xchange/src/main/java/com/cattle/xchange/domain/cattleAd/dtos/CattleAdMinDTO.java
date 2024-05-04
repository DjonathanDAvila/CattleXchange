package com.cattle.xchange.domain.cattleAd.dtos;

import com.cattle.xchange.domain.cattleAd.CattleAd;
import com.cattle.xchange.domain.cattleAd.enums.BreedEnum;
import com.cattle.xchange.domain.cattleAd.enums.CattleStatusEnum;
import com.cattle.xchange.domain.cattleAd.enums.SexEnum;
import com.cattle.xchange.domain.cattleAdImage.dtos.CattleAdImageMinDTO;
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
