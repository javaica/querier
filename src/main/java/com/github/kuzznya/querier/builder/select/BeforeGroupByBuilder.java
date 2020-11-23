package com.github.kuzznya.querier.builder.select;

public abstract class BeforeGroupByBuilder extends BeforeOrderByBuilder {

    protected BeforeGroupByBuilder(SelectBuilder parent) {
        super(parent);
    }

    public AfterGroupByBuilder groupBy(String column) {
        super.setGroupBy(column);
        return new AfterGroupByBuilder(this);
    }
}
