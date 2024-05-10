package com.cattle.xchange.domain.cattleAd;

import com.cattle.xchange.domain.cattleAd.enums.BreedEnum;
import com.cattle.xchange.domain.cattleAd.enums.CattleStatusEnum;
import com.cattle.xchange.domain.cattleAd.enums.SexEnum;
import com.cattle.xchange.domain.common.RepositoryBaseImpl;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.JPQLQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.support.PageableExecutionUtils;

import java.util.UUID;

class CattleAdRepositoryImpl extends RepositoryBaseImpl implements CattleAdCustomRepository {

    @Override
    public Page<CattleAd> findByCriteria(SexEnum sex, String city, String state, Double maxPrice, BreedEnum breed, Pageable pageable) {
        QCattleAd qCattleAd = QCattleAd.cattleAd;
        BooleanBuilder whereClause = new BooleanBuilder(qCattleAd.status.eq(CattleStatusEnum.ACTIVE));

        // Optional filters based on provided parameters
        if (sex != null) whereClause.and(qCattleAd.sex.eq(sex));
        if (city != null) whereClause.and(qCattleAd.city.eq(city));
        if (state != null) whereClause.and(qCattleAd.state.eq(state));
        if (maxPrice != null) whereClause.and(qCattleAd.unitValue.loe(maxPrice));
        if (breed != null) whereClause.and(qCattleAd.breed.eq(breed));

        JPQLQuery<CattleAd> query = select(qCattleAd)
                .from(qCattleAd)
                .where(whereClause);

        query = getQuerydsl().applyPagination(pageable, query);

        return PageableExecutionUtils.getPage(query.fetch(), pageable, query::fetchCount);
    }

    @Override
    public Page<CattleAd> findByUser(UUID userId, Pageable pageable) {
        QCattleAd qCattleAd = QCattleAd.cattleAd;
        BooleanBuilder whereClause = new BooleanBuilder(qCattleAd.userCod.eq(userId));

        JPQLQuery<CattleAd> query = select(qCattleAd)
                .from(qCattleAd)
                .where(whereClause);

        query = getQuerydsl().applyPagination(pageable, query);

        return PageableExecutionUtils.getPage(query.fetch(), pageable, query::fetchCount);
    }

}
