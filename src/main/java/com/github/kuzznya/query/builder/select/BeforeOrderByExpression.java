package com.github.kuzznya.query.builder.select;

import com.github.kuzznya.query.builder.select.model.OrderType;

public abstract class BeforeOrderByExpression extends BeforeLimitExpression {

    protected BeforeOrderByExpression(SelectExpression parent) {
        super(parent);
    }

    public AfterOrderByExpression orderBy(String... columns) {
        super.setOrderBy(columns);
        return new AfterOrderByExpression(this);
    }

    public AfterOrderByExpression orderBy(OrderType orderType, String... columns) {
        super.setOrderBy(columns);
        super.setOrderType(orderType);
        return new AfterOrderByExpression(this);
    }

    public AfterOrderByExpression orderByAsc(String... columns) {
        super.setOrderBy(columns);
        super.setOrderType(OrderType.ASCENDING);
        return new AfterOrderByExpression(this);
    }

    public AfterOrderByExpression orderByDesc(String... columns) {
        super.setOrderBy(columns);
        super.setOrderType(OrderType.DESCENDING);
        return new AfterOrderByExpression(this);
    }
}
