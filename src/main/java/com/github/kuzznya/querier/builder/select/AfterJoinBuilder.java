package com.github.kuzznya.querier.builder.select;

import com.github.kuzznya.querier.builder.select.model.Join;
import com.github.kuzznya.querier.builder.select.model.JoinType;

public class AfterJoinBuilder extends SelectBuilder {

    protected final JoinType joinType;
    protected final String join;

    protected AfterJoinBuilder(SelectBuilder parent, JoinType joinType, String join) {
        super(parent);
        this.joinType = joinType;
        this.join = join;
    }

    public AfterFromBuilder on(String on) {
        super.addJoin(new Join(joinType, join, on));
        return new AfterFromBuilder(this);
    }

    public static class Aliasable extends AfterJoinBuilder {

        protected Aliasable(SelectBuilder parent, JoinType joinType, String join) {
            super(parent, joinType, join);
        }

        public AfterJoinBuilder as(String alias) {
            return new AfterJoinBuilder(this, super.joinType, syntaxProvider.alias(super.join, alias));
        }
    }
}
