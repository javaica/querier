package com.github.kuzznya.querier.builder.select;

public class FinalExpression extends SelectExpression {

    protected FinalExpression(SelectExpression parent) {
        super(parent);
    }

    public String build() {
        return super.build();
    }
}
