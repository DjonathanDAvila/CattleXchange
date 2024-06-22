package com.cattle.xchange.domain.cattleBuy.dtos;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public record CattleBuyInsertDTO(
        String codUser,
        List<UUID> listCodAds,
        Date dataBuy
) {
}
