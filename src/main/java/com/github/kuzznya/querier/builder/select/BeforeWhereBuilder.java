package com.github.kuzznya.querier.builder.select;

public abstract class BeforeWhereBuilder extends BeforeGroupByBuilder {

    protected BeforeWhereBuilder(SelectBuilder parent) {
        super(parent);
    }

    public AfterWhereBuilder where(String condition) {
        super.setWhere(condition);
        return new AfterWhereBuilder(this);
    }
}
