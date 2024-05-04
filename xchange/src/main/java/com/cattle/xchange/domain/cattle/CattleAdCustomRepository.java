package com.cattle.xchange.domain.cattle;

import com.cattle.xchange.domain.cattle.enums.BreedEnum;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

interface CattleAdCustomRepository {

    Page<CattleAd> findByCriteria(String city, String state, Double maxPrice, BreedEnum breed, Pageable pageable);
}
