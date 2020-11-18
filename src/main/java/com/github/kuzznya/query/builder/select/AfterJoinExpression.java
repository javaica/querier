package com.github.kuzznya.query.builder.select;

import com.github.kuzznya.query.builder.select.model.Join;
import com.github.kuzznya.query.builder.select.model.JoinType;

public class AfterJoinExpression extends SelectExpression {

    private final JoinType joinType;
    private final String join;

    protected AfterJoinExpression(SelectExpression parent, JoinType joinType, String join) {
        super(parent);
        this.joinType = joinType;
        this.join = join;
    }

    public AfterFromExpression on(String on) {
        super.addJoin(new Join(joinType, join, on));
        return new AfterFromExpression(this);
    }
}
