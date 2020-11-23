package com.github.kuzznya.querier.builder.select;

public class AfterWhereBuilder extends BeforeGroupByBuilder {

    protected AfterWhereBuilder(SelectBuilder parent) {
        super(parent);
    }

    public AfterWhereBuilder and(String condition) {
        super.andWhere(condition);
        return this;
    }

    public AfterWhereBuilder or(String condition) {
        super.orWhere(condition);
        return this;
    }

    public String build() {
        return super.build();
    }
}
