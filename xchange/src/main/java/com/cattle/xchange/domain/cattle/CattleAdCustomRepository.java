package com.cattle.xchange.domain.cattle;

import java.util.List;

interface CattleAdCustomRepository {

    List<CattleAd> findByCriteria(String city, String state, Double maxPrice);
}
