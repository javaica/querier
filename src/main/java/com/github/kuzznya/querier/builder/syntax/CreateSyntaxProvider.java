package com.github.kuzznya.querier.builder.syntax;

import com.github.kuzznya.querier.builder.create.columns.Column;

import java.util.List;

public interface CreateSyntaxProvider {
    String create();
    String database(String identifier);
    String table(String identifier, List<Column> values);
}
