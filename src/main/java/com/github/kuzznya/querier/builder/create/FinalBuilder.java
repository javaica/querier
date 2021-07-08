package com.github.kuzznya.querier.builder.create;

public class FinalBuilder extends CreateBuilder {

    protected FinalBuilder(CreateBuilder parent) {
        super(parent);
    }

    @Override
    public String build() {
        return super.build();
    }
}
