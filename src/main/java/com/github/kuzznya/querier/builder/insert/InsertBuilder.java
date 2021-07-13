package com.github.kuzznya.querier.builder.insert;

import com.github.kuzznya.querier.builder.QueryBuilder;
import com.github.kuzznya.querier.builder.syntax.SyntaxProvider;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

//TODO: add select after insert
@Getter
@Setter
public abstract class InsertBuilder extends QueryBuilder {

    private List<String> columns = new ArrayList<>();
    private List<String> values = new ArrayList<>();
    private String table;

    protected InsertBuilder(SyntaxProvider syntaxProvider) {
        super(syntaxProvider);
    }

    protected InsertBuilder(InsertBuilder parent) {
        super(parent.syntaxProvider);
        columns = parent.columns;
        values = parent.values;
        table = parent.table;
    }

    protected void addInsertColumns(String ... columns) {
        this.columns.addAll(Arrays.asList(columns));
    }

    protected void addInsertValues(String ... values) {
        this.values.addAll(Arrays.asList(values));
    }

    @Override
    protected String build() {
        String query = "";
        query += Optional.ofNullable(table)
                .map(table -> syntaxProvider.getInsertSyntaxProvider().insertInto(table) + " ")
                .orElse("");
        if(!columns.isEmpty())
            query += syntaxProvider.getInsertSyntaxProvider().columns(columns) + syntaxProvider.delimiter();
        if(!values.isEmpty())
            query += syntaxProvider.getInsertSyntaxProvider().values(values);
        return query.strip();
    }

    public static AfterInsertBuilder insert(SyntaxProvider syntaxProvider, String tableName) {
        InsertBuilder parent = new InsertBuilder(syntaxProvider) {};
        parent.setTable(tableName);
        return new AfterInsertBuilder(parent);
    }
}
