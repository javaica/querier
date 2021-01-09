package com.github.kuzznya.querier.builder.insert;

import java.util.Arrays;

public abstract class BeforeColumnBuilder extends BeforeValueBuilder {

    protected BeforeColumnBuilder(InsertBuilder parent) {
        super(parent);
    }

    public void columns(String ... columns) {
        super.setColumns(Arrays.asList(columns));
    }
}
