package com.cattle.xchange.domain.itemBuy;

import com.cattle.xchange.domain.cattleAd.CattleAdService;
import com.cattle.xchange.domain.cattleAd.enums.CattleStatusEnum;
import com.cattle.xchange.domain.itemBuy.dtos.ItemBuyInsertDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CattleItemBuyService {

    @Autowired
    private CattleItemBuyRepository cattleItemBuyRepository;
    @Autowired
    private CattleAdService cattleAdService;

    public Double createCattleItemBuy(List<ItemBuyInsertDTO> itemBuyInsertDTOList) {
        double totalBuy = 0;
        List<CattleItemBuy> cattleItemBuyList = new ArrayList<>();
        for (ItemBuyInsertDTO item : itemBuyInsertDTOList) {
            CattleItemBuy cattleItemBuy = new CattleItemBuy(
                    item.cattleBuy(),
                    item.cattleAd(),
                    item.valueAd()
            );
            totalBuy += item.cattleAd().getUnitValue();
            cattleItemBuyList.add(cattleItemBuy);
            cattleAdService.updateStatus(item.cattleAd().getId(), CattleStatusEnum.SOLDED);
        }

        cattleItemBuyRepository.saveAll(cattleItemBuyList);
        return totalBuy;
    }
}
