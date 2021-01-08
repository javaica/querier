package com.github.kuzznya.querier.builder.insert;

import java.util.Arrays;

public abstract class BeforeValueBuilder extends InsertBuilder {

    protected BeforeValueBuilder(InsertBuilder parent) {
        super(parent);
    }

    public AfterValueBuilder value(String ... values) {
        super.setValues(Arrays.asList(values));
        return new AfterValueBuilder(this);
    }
}
