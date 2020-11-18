package com.github.kuzznya.query.builder.select;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public abstract class SelectExpression {

    public static AfterSelectExpression select(String... columns) {
        AfterSelectExpression expression = new AfterSelectExpression(null);
        expression.setSelect(columns);
        return expression;
    }


    private String select;
    private SelectType selectType;
    private String from;
    private JoinType joinType;
    private List<Join> joins = new ArrayList<>();
    private String where;
    private String groupBy;
    private String having;
    private String orderBy;
    private OrderType orderType;
    private Integer limit;
    private Integer offset;

    protected SelectExpression(SelectExpression parent) {
        if (parent == null)
            return;
        select = parent.select;
        selectType = parent.selectType;
        from = parent.from;
        joinType = parent.joinType;
        joins = parent.joins;
        where = parent.where;
        groupBy = parent.groupBy;
        having = parent.having;
        orderBy = parent.orderBy;
        orderType = parent.orderType;
        limit = parent.limit;
        offset = parent.offset;
    }

    protected void setSelect(String... columns) {
        select = String.join(",", columns);
    }

    protected void setSelectType(SelectType type) {
        selectType = type;
    }

    protected void setFrom(String... tables) {
        from = String.join(",", tables);
    }

    protected void addJoin(Join join) {
        joins.add(join);
    }

    protected void setWhere(String condition) {
        where = condition;
    }

    protected void andWhere(String condition) {
        if (where == null)
            where = condition;
        else
            where += " AND " + condition;
    }

    protected void orWhere(String condition) {
        if (where == null)
            where = condition;
        else
            where += " OR " + condition;
    }

    protected void setGroupBy(String... columns) {
        groupBy = String.join(",", columns);
    }

    protected void setHaving(String condition) {
        having = condition;
    }

    protected void andHaving(String condition) {
        if (having == null)
            having = condition;
        else
            having += " AND " + condition;
    }

    protected void orHaving(String condition) {
        if (having == null)
            having = condition;
        else
            having += " OR " + condition;
    }

    protected void setOrderBy(String... columns) {
        orderBy = String.join(",", columns);
    }

    protected void setOrderType(OrderType type) {
        orderType = type;
    }

    protected void setLimit(int limit) {
        this.limit = limit;
    }

    protected void setOffset(int offset) {
        this.offset = offset;
    }


    private String emptyIfNull(String param) {
        return param == null ? "" : param;
    }

    private String emptyIfNull(Object obj) {
        return obj == null ? "" : obj.toString();
    }

    private String emptyIfNull(String expr, String param) {
        return expr == null || param == null ? "" : expr + param;
    }

    private String emptyIfNull(String expr, Object param) {
        return expr == null || param == null ? "" : expr + param;
    }

    private String emptyIfNull(Object first, Object second) {
        return first == null || second == null ? "" : first.toString() + second.toString();
    }

    protected String build() {
        // TODO: 18.11.2020 add checks
        return "SELECT " + emptyIfNull(selectType, " ") + select +
                emptyIfNull(" FROM ", from) +
                joins.stream()
                        .map(join -> emptyIfNull(" ", join.type) + " JOIN " + join.join + " ON " + join.on)
                        .collect(Collectors.joining()) +
                emptyIfNull(" WHERE ", where) +
                emptyIfNull(" GROUP BY ", groupBy) +
                emptyIfNull(" HAVING ", having) +
                emptyIfNull(" ORDER BY ", orderBy) +
                emptyIfNull(" ", orderType) +
                emptyIfNull(" LIMIT ", limit) +
                emptyIfNull(" OFFSET ", offset);

    }


    protected enum SelectType {
        ALL,
        DISTINCT
    }

    protected enum JoinType {
        LEFT,
        RIGHT,
        INNER
    }

    @AllArgsConstructor
    @Getter
    protected static class Join {
        private final JoinType type;
        private final String join;
        private final String on;
    }

    protected enum OrderType {
        ASC,
        DESC
    }
}
