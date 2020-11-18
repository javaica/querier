package com.github.kuzznya.query.builder.select;

import com.github.kuzznya.query.builder.select.model.SelectType;

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

    public AfterFromExpression from(String table) {
        super.setFrom(table);
        return new AfterFromExpression(this);
    }
}
