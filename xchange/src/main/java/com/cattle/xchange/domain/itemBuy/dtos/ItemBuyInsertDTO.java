package com.cattle.xchange.domain.itemBuy.dtos;

import com.cattle.xchange.domain.cattle.cattleAd.CattleAd;
import com.cattle.xchange.domain.cattleBuy.CattleBuy;

import java.util.UUID;

public record ItemBuyInsertDTO(
        CattleBuy cattleBuy,
        CattleAd cattleAd,
        double valueAd
) {
}
