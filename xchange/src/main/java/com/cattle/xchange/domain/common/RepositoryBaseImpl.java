package com.cattle.xchange.domain.common;

import com.querydsl.core.Tuple;
import com.querydsl.core.types.Expression;
import com.querydsl.jpa.impl.JPAQuery;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public class RepositoryBaseImpl {

    @PersistenceContext
    private EntityManager ctx;

    public <U> JPAQuery<U> select(Expression<U> expression) {
        return new JPAQuery<>(ctx).select(expression);
    }

    public JPAQuery<Tuple> select(Expression<?>... expressions) {
        return new JPAQuery<>(ctx).select(expressions);
    }
}
