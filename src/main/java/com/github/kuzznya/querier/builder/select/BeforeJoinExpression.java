package com.github.kuzznya.querier.builder.select;

import com.github.kuzznya.querier.builder.select.model.JoinType;

public abstract class BeforeJoinExpression extends BeforeWhereExpression {

    protected BeforeJoinExpression(SelectExpression parent) {
        super(parent);
    }

    public AfterJoinExpression.Aliasable join(String table) {
        return new AfterJoinExpression.Aliasable(this, JoinType.DEFAULT, table);
    }

    public AfterJoinExpression.Aliasable leftJoin(String table) {
        return new AfterJoinExpression.Aliasable(this, JoinType.LEFT, table);
    }

    public AfterJoinExpression.Aliasable rightJoin(String table) {
        return new AfterJoinExpression.Aliasable(this, JoinType.RIGHT, table);
    }

    public AfterJoinExpression.Aliasable innerJoin(String table) {
        return new AfterJoinExpression.Aliasable(this, JoinType.INNER, table);
    }

}
