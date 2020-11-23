package com.github.kuzznya.querier.builder.select;

public class AfterHavingBuilder extends BeforeOrderByBuilder {

    protected AfterHavingBuilder(SelectBuilder parent) {
        super(parent);
    }

    public AfterHavingBuilder and(String condition) {
        super.andHaving(condition);
        return this;
    }

    public AfterHavingBuilder or(String condition) {
        super.orHaving(condition);
        return this;
    }

    public String build() {
        return super.build();
    }
}
