package com.cattle.xchange.domain.cattleBuy;

import com.cattle.xchange.domain.cattleAd.CattleAd;
import com.cattle.xchange.domain.cattleAd.CattleAdService;
import com.cattle.xchange.domain.cattleBuy.dtos.CattleBuyInsertDTO;
import com.cattle.xchange.domain.itemBuy.CattleItemBuy;
import com.cattle.xchange.domain.itemBuy.CattleItemBuyService;
import com.cattle.xchange.domain.itemBuy.dtos.ItemBuyInsertDTO;
import com.cattle.xchange.domain.user.User;
import com.cattle.xchange.domain.user.UserService;
import com.cattle.xchange.infra.exception.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CattleBuyService {

    @Autowired
    private CattleBuyRepository cattleBuyRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private CattleAdService cattleAdService;
    @Autowired
    private CattleItemBuyService cattleItemBuyService;

    public List<CattleBuy> findAll() {
        return cattleBuyRepository.findAll();
    }

    public CattleBuy findById(UUID id) {
        return cattleBuyRepository.findById(id).orElseThrow();
    }

    public CattleBuy create(CattleBuyInsertDTO cattleBuyInsertDTO) {
        // Verifica se o código do usuário é fornecido
        if (cattleBuyInsertDTO.codUser() == null) {
            throw new BadRequestException("O código do usuário é obrigatório.");
        }

        // Verifica se a data de compra é fornecida
        if (cattleBuyInsertDTO.dataBuy() == null) {
            throw new BadRequestException("A data de compra é obrigatória.");
        }
        User user = userService.findUserById(cattleBuyInsertDTO.codUser());


        CattleBuy newCattleBuy = new CattleBuy(
                user,
                cattleBuyInsertDTO.dataBuy(),
                0    // totalValue
        );


        List<CattleItemBuy> cattleItemBuys = getCattleItemBuyListByUUIDs(cattleBuyInsertDTO.listCodAds()
                                                                        , newCattleBuy);

        double totalValue = getTotalValueByCattleBuyList(cattleItemBuys);

        newCattleBuy.setTotalValue(totalValue);
        newCattleBuy.setCattleItemBuyList(cattleItemBuys);


        cattleBuyRepository.save(newCattleBuy);

        return newCattleBuy;
    }

    public Page<CattleBuy> findByUserId(UUID userId, Pageable pageable){
        return cattleBuyRepository.findByUserId(userId, pageable);
    }

    private List<CattleItemBuy> getCattleItemBuyListByUUIDs(List<UUID> cattleAdList, CattleBuy cattleBuy){
        List<CattleItemBuy> cattleItemBuysList = new ArrayList<>();


        for (UUID codAd : cattleAdList) {
            CattleAd cattleAd = cattleAdService.findCattleAdById(codAd).get();

            if (cattleAd != null){
                CattleItemBuy newItemBuy = new CattleItemBuy(
                        cattleBuy,
                        cattleAd,
                        cattleAd.getUnitValue() * cattleAd.getQuantity()
                );

                cattleItemBuysList.add(newItemBuy);
            }
        }

        return cattleItemBuysList;
    }

    private double getTotalValueByCattleBuyList(List<CattleItemBuy> cattleItemBuys){
        double totalValueReturn = 0;

        for (var cattleItemBuy : cattleItemBuys) {
            totalValueReturn += cattleItemBuy.getValueAd();
        }

        return totalValueReturn;
    }
}
