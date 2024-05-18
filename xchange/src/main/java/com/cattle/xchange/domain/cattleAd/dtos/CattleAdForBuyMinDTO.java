package com.cattle.xchange.domain.cattleAd.dtos;

import com.cattle.xchange.controllers.CattleAdController;
import com.cattle.xchange.domain.cattleAd.CattleAd;
import jakarta.validation.constraints.NotBlank;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;

import java.util.UUID;

public record CattleAdForBuyMinDTO
        (@NotBlank
         String title,
         @NotBlank
         double unitValue,
         @NotBlank
         int quantity,
         @NotBlank
         UUID ownerCod,

         @NotBlank
         Link cattleAdLink
        ) {
    public CattleAdForBuyMinDTO(CattleAd cattleAd) {
        this(
                cattleAd.getTitle(),
                cattleAd.getUnitValue(),
                cattleAd.getQuantity(),
                cattleAd.getUserCod(),
                WebMvcLinkBuilder.linkTo(
                                WebMvcLinkBuilder.methodOn(CattleAdController.class).findCattleAdById(cattleAd.getId()))
                        .withSelfRel()
        );
    }
}
