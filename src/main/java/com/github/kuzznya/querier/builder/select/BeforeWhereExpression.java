package com.github.kuzznya.querier.builder.select;

public abstract class BeforeWhereExpression extends BeforeGroupByExpression {

    protected BeforeWhereExpression(SelectExpression parent) {
        super(parent);
    }

    public AfterWhereExpression where(String condition) {
        super.setWhere(condition);
        return new AfterWhereExpression(this);
    }
}
