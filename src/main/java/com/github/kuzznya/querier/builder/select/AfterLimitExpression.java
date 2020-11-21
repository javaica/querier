package com.github.kuzznya.querier.builder.select;

public class AfterLimitExpression extends SelectExpression {

    protected AfterLimitExpression(SelectExpression parent) {
        super(parent);
    }

    public FinalExpression offset(int offset) {
        super.setOffset(offset);
        return new FinalExpression(this);
    }

    public String build() {
        return super.build();
    }
}
