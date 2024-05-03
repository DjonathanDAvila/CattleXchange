package com.cattle.xchange.domain.cattle.dtos;

import com.cattle.xchange.domain.cattle.CattleAdImage;
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
