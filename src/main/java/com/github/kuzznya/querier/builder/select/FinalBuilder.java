package com.github.kuzznya.querier.builder.select;

public class FinalBuilder extends SelectBuilder {

    protected FinalBuilder(SelectBuilder parent) {
        super(parent);
    }

    public String build() {
        return super.build();
    }
}
