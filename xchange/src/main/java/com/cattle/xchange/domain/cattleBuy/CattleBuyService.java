package com.cattle.xchange.domain.cattleBuy;

import com.cattle.xchange.domain.cattle.CattleAd;
import com.cattle.xchange.domain.cattle.CattleAdService;
import com.cattle.xchange.domain.cattleBuy.dtos.CattleBuyInsertDTO;
import com.cattle.xchange.domain.itemBuy.CattleItemBuyService;
import com.cattle.xchange.domain.itemBuy.dtos.ItemBuyInsertDTO;
import com.cattle.xchange.domain.user.User;
import com.cattle.xchange.domain.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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
        User user = userService.findUserById(cattleBuyInsertDTO.codUser());

        double totalValue = 0;
        CattleBuy newCattleBuy = new CattleBuy(
                user,
                cattleBuyInsertDTO.dataBuy(),
                totalValue
        );
        CattleBuy savedCattleBuy = cattleBuyRepository.save(newCattleBuy);


        List<UUID> listCodAds = cattleBuyInsertDTO.listCodAds();
        List<ItemBuyInsertDTO> itemBuyInsertDTOList = new ArrayList<>();

        for (UUID codAd : listCodAds) {
            Optional<CattleAd> optionalCattleAd = cattleAdService.findCattleAdById(codAd);

            optionalCattleAd.ifPresent(cattleAd -> {
                ItemBuyInsertDTO newItemInsertDTO = new ItemBuyInsertDTO(
                        newCattleBuy,
                        cattleAd,
                        cattleAd.getUnitValue()
                );

                itemBuyInsertDTOList.add(newItemInsertDTO);
            });
        }

        savedCattleBuy.setTotalValue(cattleItemBuyService.createCattleItemBuy(itemBuyInsertDTOList));
        cattleBuyRepository.save(savedCattleBuy);
        return savedCattleBuy;
    }
}
