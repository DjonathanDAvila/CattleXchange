package com.cattle.xchange.domain.cattleBuy;

import com.cattle.xchange.domain.common.RepositoryBaseImpl;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.JPQLQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.support.PageableExecutionUtils;

import java.util.UUID;

public class CattleBuyRepositoryImpl extends RepositoryBaseImpl implements CattleBuyCustomRepository {
    @Override
    public Page<CattleBuy> findByUserId(UUID userId, Pageable pageable){
        QCattleBuy qCattleBuy = QCattleBuy.cattleBuy;
        BooleanBuilder whereClause = new BooleanBuilder(qCattleBuy.user.id.eq(userId));

        JPQLQuery<CattleBuy> query = select(qCattleBuy)
                .from(qCattleBuy)
                .where(whereClause);


        query = getQuerydsl().applyPagination(pageable, query);

        return PageableExecutionUtils.getPage(query.fetch(), pageable, query::fetchCount);
    }
}
