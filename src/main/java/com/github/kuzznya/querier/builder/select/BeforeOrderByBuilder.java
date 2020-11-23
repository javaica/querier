package com.github.kuzznya.querier.builder.select;

import com.github.kuzznya.querier.builder.select.model.OrderType;

public abstract class BeforeOrderByBuilder extends BeforeLimitBuilder {

    protected BeforeOrderByBuilder(SelectBuilder parent) {
        super(parent);
    }

    public AfterOrderByBuilder orderBy(String... columns) {
        super.setOrderBy(columns);
        return new AfterOrderByBuilder(this);
    }

    public AfterOrderByBuilder orderBy(OrderType orderType, String... columns) {
        super.setOrderBy(columns);
        super.setOrderType(orderType);
        return new AfterOrderByBuilder(this);
    }

    public AfterOrderByBuilder orderByAsc(String... columns) {
        super.setOrderBy(columns);
        super.setOrderType(OrderType.ASCENDING);
        return new AfterOrderByBuilder(this);
    }

    public AfterOrderByBuilder orderByDesc(String... columns) {
        super.setOrderBy(columns);
        super.setOrderType(OrderType.DESCENDING);
        return new AfterOrderByBuilder(this);
    }
}
