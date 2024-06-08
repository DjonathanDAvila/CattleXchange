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

import java.util.List;
import java.util.UUID;

class CattleAdRepositoryImpl extends RepositoryBaseImpl implements CattleAdCustomRepository {

    @Override
    public Page<CattleAd> findByCriteria(List<SexEnum> sex, List<String> cities, List<String> states, Double maxPrice, BreedEnum breed, Pageable pageable) {
        QCattleAd qCattleAd = QCattleAd.cattleAd;
        BooleanBuilder whereClause = new BooleanBuilder(qCattleAd.status.eq(CattleStatusEnum.ACTIVE));

        // Optional filters based on provided parameters
        if (sex != null && !sex.isEmpty()) whereClause.and(qCattleAd.sex.in(sex));
        if (cities != null && !cities.isEmpty()) whereClause.and(qCattleAd.city.in(cities));
        if (states != null && !states.isEmpty()) whereClause.and(qCattleAd.state.in(states));
        if (maxPrice != null && maxPrice > 0) whereClause.and(qCattleAd.unitValue.loe(maxPrice));
        if (breed != null && !breed.name().isEmpty()) whereClause.and(qCattleAd.breed.eq(breed));

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
