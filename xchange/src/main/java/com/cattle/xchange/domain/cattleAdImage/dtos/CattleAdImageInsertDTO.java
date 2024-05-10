package com.cattle.xchange.domain.cattleAdImage.dtos;

import com.cattle.xchange.domain.cattleAdImage.CattleAdImage;
import jakarta.validation.constraints.NotBlank;

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
