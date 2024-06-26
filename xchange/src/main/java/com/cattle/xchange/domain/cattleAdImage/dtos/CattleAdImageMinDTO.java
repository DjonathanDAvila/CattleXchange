package com.cattle.xchange.domain.cattleAdImage.dtos;

import com.cattle.xchange.domain.cattleAdImage.CattleAdImage;
import jakarta.validation.constraints.NotBlank;

import java.util.UUID;

public record CattleAdImageMinDTO(
        @NotBlank
        UUID id,
//        @NotBlank
//        UUID cattleAdId,
        @NotBlank
        int sequence,
        @NotBlank
        String url
) {
    public CattleAdImageMinDTO(CattleAdImage image){
        this(
            image.getId(),
//            image.getCattleAdId(),
            image.getSequence(),
            image.getUrl()
        );
    }
}
