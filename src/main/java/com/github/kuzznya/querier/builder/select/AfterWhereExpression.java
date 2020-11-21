package com.github.kuzznya.querier.builder.select;

public class AfterWhereExpression extends BeforeGroupByExpression {

    protected AfterWhereExpression(SelectExpression parent) {
        super(parent);
    }

    public AfterWhereExpression and(String condition) {
        super.andWhere(condition);
        return this;
    }

    public AfterWhereExpression or(String condition) {
        super.orWhere(condition);
        return this;
    }

    public String build() {
        return super.build();
    }
}
