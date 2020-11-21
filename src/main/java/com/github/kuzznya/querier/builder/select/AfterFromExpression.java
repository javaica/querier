package com.github.kuzznya.querier.builder.select;

public class AfterFromExpression extends BeforeJoinExpression {

    protected AfterFromExpression(SelectExpression parent) {
        super(parent);
    }

    public String build() {
        return super.build();
    }

    public static class Aliasable extends AfterFromExpression {

        protected Aliasable(SelectExpression parent) {
            super(parent);
        }

        public AfterFromExpression as(String alias) {
            super.setFrom(syntaxProvider.alias(super.getFrom(), alias));
            return new AfterFromExpression(this);
        }
    }
}
