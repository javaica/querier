package com.github.kuzznya.query.builder.select;

import com.github.kuzznya.query.builder.QueryExpression;
import com.github.kuzznya.query.builder.select.model.*;
import com.github.kuzznya.query.builder.syntax.SyntaxProvider;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public abstract class SelectExpression extends QueryExpression {

    private String[] selectColumns;
    private ColumnAlias[] selectAliases;
    private SelectType selectType = SelectType.DEFAULT;
    private String from;
    private List<Join> joins = new ArrayList<>();
    private String where;
    private String groupBy;
    private String having;
    private String orderBy;
    private OrderType orderType = OrderType.DEFAULT;
    private Integer limit;
    private Integer offset;

    protected SelectExpression(SyntaxProvider syntaxProvider) {
        super(syntaxProvider);
    }

    protected SelectExpression(SelectExpression parent) {
        super(parent.syntaxProvider);
        selectColumns = parent.selectColumns;
        selectAliases = parent.selectAliases;
        selectType = parent.selectType;
        from = parent.from;
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
        selectColumns = columns;
        selectAliases = null;
    }

    protected void setSelect(ColumnAlias... aliases) {
        selectAliases = aliases;
        selectColumns = null;
    }

    protected void setSelectType(SelectType type) {
        selectType = type;
    }

    protected void setFrom(String table) {
        from = table;
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
            where += " " + syntaxProvider.and() + " " + condition;
    }

    protected void orWhere(String condition) {
        if (where == null)
            where = condition;
        else
            where += " " + syntaxProvider.or() + " " + condition;
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

    @Override
    protected String build() {
        // TODO: 18.11.2020 add checks
        return Optional.ofNullable(selectColumns)
                .map(columns -> syntaxProvider.select(selectType, selectColumns))
                .orElseGet(() -> syntaxProvider.select(selectType, selectAliases)) + syntaxProvider.delimiter() +
                Optional.ofNullable(from)
                        .map(table -> syntaxProvider.from(table) + syntaxProvider.delimiter())
                        .orElse("") +
                joins.stream()
                        .map(join -> syntaxProvider.join(join) + syntaxProvider.delimiter())
                        .collect(Collectors.joining()) +
                Optional.ofNullable(where)
                        .map(condition -> syntaxProvider.where(condition) + syntaxProvider.delimiter())
                        .orElse("") +
                Optional.ofNullable(groupBy)
                        .map(column -> syntaxProvider.groupBy(column) + syntaxProvider.delimiter())
                        .orElse("") +
                Optional.ofNullable(having)
                        .map(condition -> syntaxProvider.having(condition) + syntaxProvider.delimiter())
                        .orElse("") +
                Optional.ofNullable(orderBy)
                        .map(value -> syntaxProvider.orderBy(value, orderType) + syntaxProvider.delimiter())
                        .orElse("") +
                Optional.ofNullable(limit)
                        .map(value -> syntaxProvider.limit(value) + syntaxProvider.delimiter())
                        .orElse("") +
                Optional.ofNullable(offset)
                        .map(value -> syntaxProvider.offset(value) + syntaxProvider.delimiter())
                        .orElse("");

    }

    public static AfterSelectExpression select(SyntaxProvider syntaxProvider, String... columns) {
        SelectExpression parent = new SelectExpression(syntaxProvider) {};
        parent.setSelect(columns);
        return new AfterSelectExpression(parent);
    }

    public static AfterSelectExpression select(SyntaxProvider syntaxProvider, ColumnAlias... aliases) {
        SelectExpression parent = new SelectExpression(syntaxProvider) {};
        parent.setSelect(aliases);
        return new AfterSelectExpression(parent);
    }
}
