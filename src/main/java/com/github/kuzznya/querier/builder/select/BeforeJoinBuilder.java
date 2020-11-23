package com.github.kuzznya.querier.builder.select;

import com.github.kuzznya.querier.builder.select.model.JoinType;

public abstract class BeforeJoinBuilder extends BeforeWhereBuilder {

    protected BeforeJoinBuilder(SelectBuilder parent) {
        super(parent);
    }

    public AfterJoinBuilder.Aliasable join(String table) {
        return new AfterJoinBuilder.Aliasable(this, JoinType.DEFAULT, table);
    }

    public AfterJoinBuilder.Aliasable leftJoin(String table) {
        return new AfterJoinBuilder.Aliasable(this, JoinType.LEFT, table);
    }

    public AfterJoinBuilder.Aliasable rightJoin(String table) {
        return new AfterJoinBuilder.Aliasable(this, JoinType.RIGHT, table);
    }

    public AfterJoinBuilder.Aliasable innerJoin(String table) {
        return new AfterJoinBuilder.Aliasable(this, JoinType.INNER, table);
    }

}
