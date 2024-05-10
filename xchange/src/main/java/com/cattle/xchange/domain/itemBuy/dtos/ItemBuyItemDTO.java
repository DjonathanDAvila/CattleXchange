package com.cattle.xchange.domain.itemBuy.dtos;

import com.cattle.xchange.domain.cattleAd.dtos.CattleAdForBuyMinDTO;
import com.cattle.xchange.domain.itemBuy.CattleItemBuy;

public record ItemBuyItemDTO(
        CattleAdForBuyMinDTO cattleAdForBuyMinDTO
) {
    public ItemBuyItemDTO(CattleItemBuy cattleItemBuy) {
        this(new CattleAdForBuyMinDTO(cattleItemBuy.getCattleAd()));
    }
}
