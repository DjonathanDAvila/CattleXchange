package com.cattle.xchange.domain.common;

import com.cattle.xchange.domain.cattle.CattleAd;
import com.querydsl.core.Tuple;
import com.querydsl.core.types.Expression;
import com.querydsl.jpa.impl.JPAQuery;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

public class RepositoryBaseImpl extends QuerydslRepositorySupport {

    @PersistenceContext
    private EntityManager ctx;

    public RepositoryBaseImpl() {
        super(CattleAd.class);
    }

    public <U> JPAQuery<U> select(Expression<U> expression) {
        return new JPAQuery<>(ctx).select(expression);
    }

    public JPAQuery<Tuple> select(Expression<?>... expressions) {
        return new JPAQuery<>(ctx).select(expressions);
    }
}
