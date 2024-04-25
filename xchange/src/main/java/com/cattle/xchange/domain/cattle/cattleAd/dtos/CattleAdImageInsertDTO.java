package com.cattle.xchange.domain.cattle.cattleAd.dtos;

import com.cattle.xchange.domain.cattle.CattleAdImage;
import jakarta.validation.constraints.NotBlank;

import java.util.UUID;

public record CattleAdImageInsertDTO(
        @NotBlank
        int sequence,
        @NotBlank
        String url
) {
    public CattleAdImageInsertDTO(CattleAdImage image){
        this(
                image.getSequence(),
                image.getUrl()
        );
    }
}
