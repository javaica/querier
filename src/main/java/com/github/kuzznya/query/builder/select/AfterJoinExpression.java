package com.github.kuzznya.query.builder.select;

public class AfterJoinExpression extends SelectExpression {

    private final SelectExpression.JoinType joinType;
    private final String join;

    protected AfterJoinExpression(SelectExpression parent, SelectExpression.JoinType joinType, String join) {
        super(parent);
        this.joinType = joinType;
        this.join = join;
    }

    public AfterFromExpression on(String on) {
        super.addJoin(new SelectExpression.Join(joinType, join, on));
        return new AfterFromExpression(this);
    }
}
