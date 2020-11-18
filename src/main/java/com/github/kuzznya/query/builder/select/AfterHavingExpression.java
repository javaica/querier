package com.github.kuzznya.query.builder.select;

public class AfterHavingExpression extends BeforeOrderByExpression {

    protected AfterHavingExpression(SelectExpression parent) {
        super(parent);
    }

    public AfterHavingExpression and(String condition) {
        super.andHaving(condition);
        return this;
    }

    public AfterHavingExpression or(String condition) {
        super.orHaving(condition);
        return this;
    }

    public String build() {
        return super.build();
    }
}
