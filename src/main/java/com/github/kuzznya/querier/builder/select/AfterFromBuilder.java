package com.github.kuzznya.querier.builder.select;

public class AfterFromBuilder extends BeforeJoinBuilder {

    protected AfterFromBuilder(SelectBuilder parent) {
        super(parent);
    }

    public String build() {
        return super.build();
    }

    public static class Aliasable extends AfterFromBuilder {

        protected Aliasable(SelectBuilder parent) {
            super(parent);
        }

        public AfterFromBuilder as(String alias) {
            super.setFrom(syntaxProvider.alias(super.getFrom(), alias));
            return new AfterFromBuilder(this);
        }
    }
}
