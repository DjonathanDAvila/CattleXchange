package com.cattle.xchange.domain.cattleAd;

import com.cattle.xchange.domain.cattleAd.enums.BreedEnum;
import com.cattle.xchange.domain.cattleAd.enums.SexEnum;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

interface CattleAdCustomRepository {

    Page<CattleAd> findByCriteria(SexEnum sex, String city, String state, Double maxPrice, BreedEnum breed, Pageable pageable);
}
