package com.github.kuzznya.querier.builder.select;

public class AfterLimitBuilder extends SelectBuilder {

    protected AfterLimitBuilder(SelectBuilder parent) {
        super(parent);
    }

    public FinalBuilder offset(int offset) {
        super.setOffset(offset);
        return new FinalBuilder(this);
    }

    public String build() {
        return super.build();
    }
}
