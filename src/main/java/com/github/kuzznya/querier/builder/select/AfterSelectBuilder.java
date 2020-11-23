package com.github.kuzznya.querier.builder.select;

import com.github.kuzznya.querier.builder.select.model.SelectType;

public class AfterSelectBuilder extends SelectBuilder {

    protected AfterSelectBuilder(SelectBuilder parent) {
        super(parent);
    }

    public AfterSelectBuilder.Aliasable select(String column) {
        super.addSelectColumns(column);
        return new AfterSelectBuilder.Aliasable(this);
    }

    public AfterSelectBuilder distinct() {
        super.setSelectType(SelectType.DISTINCT);
        return this;
    }

    public AfterSelectBuilder all() {
        super.setSelectType(SelectType.ALL);
        return this;
    }

    public AfterFromBuilder.Aliasable from(String table) {
        super.setFrom(table);
        return new AfterFromBuilder.Aliasable(this);
    }

    public static class Aliasable extends AfterSelectBuilder {

        protected Aliasable(SelectBuilder parent) {
            super(parent);
        }

        public AfterSelectBuilder as(String alias) {
            int lastIndex = super.getSelectColumns().size() - 1;
            String aliased = syntaxProvider.alias(super.getSelectColumns().get(lastIndex), alias);
            super.getSelectColumns().set(lastIndex, aliased);
            return new AfterSelectBuilder(this);
        }
    }
}
