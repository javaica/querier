package com.github.kuzznya.query.builder.select;

import com.github.kuzznya.query.builder.select.model.JoinType;

public abstract class BeforeJoinExpression extends BeforeWhereExpression {

    protected BeforeJoinExpression(SelectExpression parent) {
        super(parent);
    }

    public AfterJoinExpression join(String table) {
        return new AfterJoinExpression(this, JoinType.DEFAULT, table);
    }

    public AfterJoinExpression leftJoin(String table) {
        return new AfterJoinExpression(this, JoinType.LEFT, table);
    }

    public AfterJoinExpression rightJoin(String table) {
        return new AfterJoinExpression(this, JoinType.RIGHT, table);
    }

    public AfterJoinExpression innerJoin(String table) {
        return new AfterJoinExpression(this, JoinType.INNER, table);
    }

}
