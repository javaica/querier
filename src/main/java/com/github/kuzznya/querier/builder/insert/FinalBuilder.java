package com.github.kuzznya.querier.builder.insert;

public class FinalBuilder extends InsertBuilder {

    protected FinalBuilder(InsertBuilder parent) {
        super(parent);
    }

    public String build() {
        return super.build();
    }
}
