package com.github.kuzznya.query.builder.select;

public abstract class BeforeOrderByExpression extends BeforeLimitExpression {

    protected BeforeOrderByExpression(SelectExpression parent) {
        super(parent);
    }

    public AfterOrderByExpression orderBy(String... columns) {
        super.setOrderBy(columns);
        return new AfterOrderByExpression(this);
    }

    public AfterOrderByExpression orderByAsc(String... columns) {
        super.setOrderBy(columns);
        super.setOrderType(OrderType.ASC);
        return new AfterOrderByExpression(this);
    }

    public AfterOrderByExpression orderByDesc(String... columns) {
        super.setOrderBy(columns);
        super.setOrderType(OrderType.DESC);
        return new AfterOrderByExpression(this);
    }
}
