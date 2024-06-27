package com.cattle.xchange.domain.cattleAd.dtos;

import com.cattle.xchange.controllers.CattleAdController;
import com.cattle.xchange.domain.cattleAd.CattleAd;
import com.cattle.xchange.domain.cattleAd.enums.BreedEnum;
import com.cattle.xchange.domain.cattleAd.enums.CattleStatusEnum;
import com.cattle.xchange.domain.cattleAd.enums.SexEnum;
import com.cattle.xchange.domain.cattleAdImage.dtos.CattleAdImageMinDTO;
import com.cattle.xchange.domain.user.User;
import com.cattle.xchange.domain.user.dtos.UserMinDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public record CattleAdMinDTO(
        @NotBlank
        String id,
        @NotBlank
        String title,
        @NotBlank
        String desc,
        @NotBlank
        double unitValue,
        @NotBlank
        int quantity,
        @NotBlank
        BreedEnum breed,

        @NotBlank
        SexEnum sex,
        @NotBlank
        UserMinDTO announcer,
        @NotBlank
        String city,
        @NotBlank
        String state,
        @NotBlank
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
        LocalDate adDate,
        @NotBlank
        CattleStatusEnum status,
        @NotBlank
        List<CattleAdImageMinDTO> cattleAdImages,
        @NotBlank
        Link cattleAdLink
) {
        public CattleAdMinDTO(CattleAd cattleAd, User user) {
                this(
                        cattleAd.getId().toString(),
                        cattleAd.getTitle(),
                        cattleAd.getDesc(),
                        cattleAd.getUnitValue(),
                        cattleAd.getQuantity(),
                        cattleAd.getBreed(),
                        cattleAd.getSex(),
                        new UserMinDTO(user),
                        cattleAd.getCity(),
                        cattleAd.getState(),
                        cattleAd.getAdDate(),
                        cattleAd.getStatus(),
                        cattleAd.getCattleAdImages()
                                .stream()
                                .map(CattleAdImageMinDTO::new)
                                .collect(Collectors.toList()),
                        WebMvcLinkBuilder.linkTo(
                                        WebMvcLinkBuilder.methodOn(CattleAdController.class).findCattleAdById(cattleAd.getId()))
                                .withSelfRel()
                );

        }
}
