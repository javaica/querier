package com.github.kuzznya.querier.builder.syntax.impl;

import com.github.kuzznya.querier.builder.syntax.InsertSyntaxProvider;

import java.util.List;

public class DefaultInsertSyntaxProvider implements InsertSyntaxProvider {

    @Override
    public String insertInto(String tableName) {
        return "INSERT INTO " + tableName;
    }

    @Override
    public String columns(List<String> columns) {
        return encloseInBrackets(String.join(", ", columns));
    }

    @Override
    public String column(String column) {
        return column + ",";
    }

    @Override
    public String value(String value) {
        return value + ", ";
    }

    @Override
    public String values(List<String> values) {
        return "\nVALUE " + encloseInBrackets(String.join(", ", values));
    }

    @Override
    public String encloseInBrackets(String list) {
        StringBuilder sb = new StringBuilder(list);
        sb.insert(0, "(");
        sb.insert(list.length() + 1, ")");
        return sb.toString();
    }
}
