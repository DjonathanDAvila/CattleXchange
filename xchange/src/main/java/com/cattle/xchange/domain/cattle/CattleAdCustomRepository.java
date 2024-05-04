package com.cattle.xchange.domain.cattle;

import com.cattle.xchange.domain.cattle.enums.BreedEnum;

import java.util.List;

interface CattleAdCustomRepository {

    List<CattleAd> findByCriteria(String city, String state, Double maxPrice, BreedEnum breed);
}
