package com.github.kuzznya.querier.builder.select;

public class AfterGroupByBuilder extends BeforeOrderByBuilder {

    protected AfterGroupByBuilder(SelectBuilder parent) {
        super(parent);
    }

    public AfterHavingBuilder having(String condition) {
        super.setHaving(condition);
        return new AfterHavingBuilder(this);
    }

    public String build() {
        return super.build();
    }
}
