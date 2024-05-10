package com.cattle.xchange.domain.itemBuy.dtos;

import com.cattle.xchange.domain.cattle.cattleAd.CattleAd;
import com.cattle.xchange.domain.cattle.cattleAd.dtos.CattleAdForBuyMinDTO;

public record ItemBuyItemDTO(
        CattleAdForBuyMinDTO cattleAdForBuyMinDTO
) {
    public ItemBuyItemDTO(CattleAd cattleAd) {
        this(new CattleAdForBuyMinDTO(cattleAd));
    }
}
