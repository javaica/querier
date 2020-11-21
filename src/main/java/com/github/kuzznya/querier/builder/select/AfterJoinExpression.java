package com.github.kuzznya.querier.builder.select;

import com.github.kuzznya.querier.builder.select.model.Join;
import com.github.kuzznya.querier.builder.select.model.JoinType;

public class AfterJoinExpression extends SelectExpression {

    protected final JoinType joinType;
    protected final String join;

    protected AfterJoinExpression(SelectExpression parent, JoinType joinType, String join) {
        super(parent);
        this.joinType = joinType;
        this.join = join;
    }

    public AfterFromExpression on(String on) {
        super.addJoin(new Join(joinType, join, on));
        return new AfterFromExpression(this);
    }

    public static class Aliasable extends AfterJoinExpression {

        protected Aliasable(SelectExpression parent, JoinType joinType, String join) {
            super(parent, joinType, join);
        }

        public AfterJoinExpression as(String alias) {
            return new AfterJoinExpression(this, super.joinType, syntaxProvider.alias(super.join, alias));
        }
    }
}
