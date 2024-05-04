package com.cattle.xchange.domain.cattle;

import com.cattle.xchange.domain.cattle.enums.BreedEnum;
import com.cattle.xchange.domain.cattle.enums.CattleStatusEnum;
import com.cattle.xchange.domain.common.RepositoryBaseImpl;
import com.querydsl.core.BooleanBuilder;

import java.util.List;

class CattleAdRepositoryImpl extends RepositoryBaseImpl implements CattleAdCustomRepository {

    @Override
    public List<CattleAd> findByCriteria(String city, String state, Double maxPrice, BreedEnum breed) {
        QCattleAd qCattleAd = QCattleAd.cattleAd;
        BooleanBuilder whereClause = new BooleanBuilder();

        // Always filter by active CattleAds
        whereClause.and(qCattleAd.status.eq(CattleStatusEnum.ACTIVE));

        // Optional filters based on provided parameters
        if (city != null) {
            whereClause.and(qCattleAd.city.eq(city));
        }

        if (state != null) {
            whereClause.and(qCattleAd.state.eq(state));
        }

        if (maxPrice != null) {
            whereClause.and(qCattleAd.unitValue.loe(maxPrice));
        }

        if (breed != null) {
            whereClause.and(qCattleAd.breed.eq(breed));
        }

        return select(qCattleAd)
                .from(qCattleAd)
                .where(whereClause)
                .fetch();
    }

}
