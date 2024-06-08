package com.cattle.xchange.domain.cattleAd;

import com.cattle.xchange.domain.cattleAd.enums.BreedEnum;
import com.cattle.xchange.domain.cattleAd.enums.SexEnum;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

interface CattleAdCustomRepository {

    Page<CattleAd> findByCriteria(List<SexEnum> sex, List<String> city, List<String> state, Double maxPrice, BreedEnum breed, Pageable pageable);
    Page<CattleAd> findByUser(UUID userId, Pageable pageable);
}
