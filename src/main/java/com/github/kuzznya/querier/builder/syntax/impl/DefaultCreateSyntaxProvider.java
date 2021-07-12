package com.github.kuzznya.querier.builder.syntax.impl;

import com.github.kuzznya.querier.builder.create.columns.Column;
import com.github.kuzznya.querier.builder.create.columns.ParameterColumn;
import com.github.kuzznya.querier.builder.create.model.CreateType;
import com.github.kuzznya.querier.builder.syntax.CreateSyntaxProvider;

import java.util.List;
import java.util.stream.Collectors;

public class DefaultCreateSyntaxProvider implements CreateSyntaxProvider {

    @Override
    public String create() {
        return "CREATE ";
    }

    @Override
    public String database(String identifier) {
        return CreateType.DATABASE.name() + " " + identifier;
    }

    @Override
    public String table(String identifier, List<Column> values) {
        String query = "";
        query += CreateType.TABLE.name() + " " + identifier +
                " (" + values.stream().map(String::valueOf).collect(Collectors.joining(", ")) + ")";
        return query;
    }
}
