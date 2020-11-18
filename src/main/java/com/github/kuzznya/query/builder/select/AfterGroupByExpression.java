package com.github.kuzznya.query.builder.select;

public class AfterGroupByExpression extends BeforeOrderByExpression {

    protected AfterGroupByExpression(SelectExpression parent) {
        super(parent);
    }

    public AfterHavingExpression having(String condition) {
        super.setHaving(condition);
        return new AfterHavingExpression(this);
    }

    public String build() {
        return super.build();
    }
}
