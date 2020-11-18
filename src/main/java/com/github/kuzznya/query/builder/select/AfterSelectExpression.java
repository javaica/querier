package com.github.kuzznya.query.builder.select;

public class AfterSelectExpression extends SelectExpression {

    protected AfterSelectExpression(SelectExpression parent) {
        super(parent);
    }

    public AfterSelectExpression distinct() {
        super.setSelectType(SelectType.DISTINCT);
        return this;
    }

    public AfterSelectExpression all() {
        super.setSelectType(SelectType.ALL);
        return this;
    }

    public AfterFromExpression from(String... tables) {
        super.setFrom(tables);
        return new AfterFromExpression(this);
    }
}
