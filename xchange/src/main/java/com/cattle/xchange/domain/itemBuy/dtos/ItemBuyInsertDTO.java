package com.cattle.xchange.domain.itemBuy.dtos;

import com.cattle.xchange.domain.cattle.CattleAd;
import com.cattle.xchange.domain.cattleBuy.CattleBuy;

public record ItemBuyInsertDTO(
        CattleBuy cattleBuy,
        CattleAd cattleAd,
        double valueAd
) {
}
