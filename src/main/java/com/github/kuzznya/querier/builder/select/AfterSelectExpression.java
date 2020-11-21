package com.github.kuzznya.querier.builder.select;

import com.github.kuzznya.querier.builder.select.model.SelectType;

public class AfterSelectExpression extends SelectExpression {

    protected AfterSelectExpression(SelectExpression parent) {
        super(parent);
    }

    public AfterSelectExpression.Aliasable select(String column) {
        super.addSelectColumns(column);
        return new AfterSelectExpression.Aliasable(this);
    }

    public AfterSelectExpression distinct() {
        super.setSelectType(SelectType.DISTINCT);
        return this;
    }

    public AfterSelectExpression all() {
        super.setSelectType(SelectType.ALL);
        return this;
    }

    public AfterFromExpression.Aliasable from(String table) {
        super.setFrom(table);
        return new AfterFromExpression.Aliasable(this);
    }

    public static class Aliasable extends AfterSelectExpression {

        protected Aliasable(SelectExpression parent) {
            super(parent);
        }

        public AfterSelectExpression as(String alias) {
            int lastIndex = super.getSelectColumns().size() - 1;
            String aliased = syntaxProvider.alias(super.getSelectColumns().get(lastIndex), alias);
            super.getSelectColumns().set(lastIndex, aliased);
            return new AfterSelectExpression(this);
        }
    }
}
