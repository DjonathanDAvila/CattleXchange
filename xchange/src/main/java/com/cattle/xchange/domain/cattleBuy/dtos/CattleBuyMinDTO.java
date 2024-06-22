package com.cattle.xchange.domain.cattleBuy.dtos;

import com.cattle.xchange.domain.cattleAd.dtos.CattleAdForBuyMinDTO;
import com.cattle.xchange.domain.cattleBuy.CattleBuy;
import com.cattle.xchange.domain.cattleBuy.enums.CattleBuyStatus;
import com.cattle.xchange.domain.itemBuy.dtos.ItemBuyItemDTO;
import com.cattle.xchange.domain.user.dtos.UserMinDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


public record CattleBuyMinDTO(
        @NotBlank
        UUID codBuy,
        @NotBlank
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
        Date dateBuy,
        @NotBlank
        double totalValue,
        @NotBlank
        UserMinDTO buyer,
        @NotBlank
        CattleBuyStatus status,
        @NotBlank
        List<ItemBuyItemDTO> itemsBuy
) {
        public CattleBuyMinDTO(CattleBuy cattleBuy) {
                this(
                        cattleBuy.getCodBuy(),
                        cattleBuy.getDateBuy(),
                        cattleBuy.getTotalValue(),
                        new UserMinDTO(cattleBuy.getUser()),
                        cattleBuy.getStatus(),
                        cattleBuy.getCattleItemBuyList()
                                .stream()
                                .map(cattleItemBuy -> new ItemBuyItemDTO(cattleItemBuy))
                                .collect(Collectors.toList())
                );
        }
}