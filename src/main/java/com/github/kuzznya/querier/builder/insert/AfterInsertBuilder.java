package com.github.kuzznya.querier.builder.insert;

public class AfterInsertBuilder extends InsertBuilder {

    protected AfterInsertBuilder(InsertBuilder parent) {
        super(parent);
    }

    public AfterValueBuilder value(String ... value) {
        super.addInsertValues(value);
        return new AfterValueBuilder(this);
    }

    public AfterColumnBuilder column(String ... column) {
        super.addInsertColumns(column);
        return new AfterColumnBuilder(this);
    }
}
