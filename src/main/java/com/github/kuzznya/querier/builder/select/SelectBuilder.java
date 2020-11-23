package com.github.kuzznya.querier.builder.select;

import com.github.kuzznya.querier.builder.select.model.Join;
import com.github.kuzznya.querier.builder.select.model.OrderType;
import com.github.kuzznya.querier.builder.QueryBuilder;
import com.github.kuzznya.querier.builder.select.model.SelectType;
import com.github.kuzznya.querier.builder.syntax.SyntaxProvider;
import lombok.AccessLevel;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Getter(AccessLevel.PROTECTED)
public abstract class SelectBuilder extends QueryBuilder {

    private List<String> selectColumns = new ArrayList<>();
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

    protected SelectBuilder(SyntaxProvider syntaxProvider) {
        super(syntaxProvider);
    }

    protected SelectBuilder(SelectBuilder parent) {
        super(parent.syntaxProvider);
        selectColumns = parent.selectColumns;
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

    protected void addSelectColumns(String... columns) {
        selectColumns.addAll(Arrays.asList(columns));
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

    protected String createAlias(String value, String alias) {
        return syntaxProvider.alias(value, alias);
    }

    @Override
    protected String build() {
        // TODO: 18.11.2020 add checks
        String query = syntaxProvider.getSelectSyntaxProvider().select(selectType, selectColumns) + syntaxProvider.delimiter() +
                Optional.ofNullable(from)
                        .map(table -> syntaxProvider.getSelectSyntaxProvider().from(table) + syntaxProvider.delimiter())
                        .orElse("") +
                joins.stream()
                        .map(join -> syntaxProvider.getSelectSyntaxProvider().join(join) + syntaxProvider.delimiter())
                        .collect(Collectors.joining()) +
                Optional.ofNullable(where)
                        .map(condition -> syntaxProvider.getSelectSyntaxProvider().where(condition) + syntaxProvider.delimiter())
                        .orElse("") +
                Optional.ofNullable(groupBy)
                        .map(column -> syntaxProvider.getSelectSyntaxProvider().groupBy(column) + syntaxProvider.delimiter())
                        .orElse("") +
                Optional.ofNullable(having)
                        .map(condition -> syntaxProvider.getSelectSyntaxProvider().having(condition) + syntaxProvider.delimiter())
                        .orElse("") +
                Optional.ofNullable(orderBy)
                        .map(value -> syntaxProvider.getSelectSyntaxProvider().orderBy(value, orderType) + syntaxProvider.delimiter())
                        .orElse("") +
                Optional.ofNullable(limit)
                        .map(value -> syntaxProvider.getSelectSyntaxProvider().limit(value) + syntaxProvider.delimiter())
                        .orElse("") +
                Optional.ofNullable(offset)
                        .map(value -> syntaxProvider.getSelectSyntaxProvider().offset(value) + syntaxProvider.delimiter())
                        .orElse("");

        return query.strip();
    }

    public static AfterSelectBuilder select(SyntaxProvider syntaxProvider, String... columns) {
        SelectBuilder parent = new SelectBuilder(syntaxProvider) {};
        parent.addSelectColumns(columns);
        return new AfterSelectBuilder(parent);
    }

    public static AfterSelectBuilder.Aliasable select(SyntaxProvider syntaxProvider, String column) {
        SelectBuilder parent = new SelectBuilder(syntaxProvider) {};
        parent.addSelectColumns(column);
        return new AfterSelectBuilder.Aliasable(parent);
    }
}
