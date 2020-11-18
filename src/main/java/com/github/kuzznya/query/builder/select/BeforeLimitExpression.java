package com.github.kuzznya.query.builder.select;

public abstract class BeforeLimitExpression extends SelectExpression {

    protected BeforeLimitExpression(SelectExpression parent) {
        super(parent);
    }

    public AfterLimitExpression limit(int count) {
        super.setLimit(count);
        return new AfterLimitExpression(this);
    }
}
