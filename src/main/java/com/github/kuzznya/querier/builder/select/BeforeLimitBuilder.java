package com.github.kuzznya.querier.builder.select;

public abstract class BeforeLimitBuilder extends SelectBuilder {

    protected BeforeLimitBuilder(SelectBuilder parent) {
        super(parent);
    }

    public AfterLimitBuilder limit(int count) {
        super.setLimit(count);
        return new AfterLimitBuilder(this);
    }
}
