package com.github.kuzznya.query.builder.select;

public abstract class BeforeGroupByExpression extends BeforeOrderByExpression {

    protected BeforeGroupByExpression(SelectExpression parent) {
        super(parent);
    }

    public AfterGroupByExpression groupBy(String column) {
        super.setGroupBy(column);
        return new AfterGroupByExpression(this);
    }
}
