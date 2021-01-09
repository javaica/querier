package com.github.kuzznya.querier.builder.syntax;

import java.util.List;

public interface InsertSyntaxProvider {
    String insertInto(String tableName);
    String column(String column);
    String value(String value);
    String columns(List<String> columns);
    String values(List<String> values);
    String encloseInBrackets(String list);
}
