package com.github.kuzznya.querier.builder.syntax.impl;

import com.github.kuzznya.querier.builder.syntax.CreateSyntaxProvider;
import com.github.kuzznya.querier.builder.syntax.InsertSyntaxProvider;
import com.github.kuzznya.querier.builder.syntax.SelectSyntaxProvider;
import com.github.kuzznya.querier.builder.syntax.SyntaxProvider;

public class DefaultSyntaxProvider implements SyntaxProvider {

    SelectSyntaxProvider selectSyntaxProvider = new DefaultSelectSyntaxProvider();
    InsertSyntaxProvider insertSyntaxProvider = new DefaultInsertSyntaxProvider();
    CreateSyntaxProvider createSyntaxProvider = new DefaultCreateSyntaxProvider();

    @Override
    public SelectSyntaxProvider getSelectSyntaxProvider() {
        return selectSyntaxProvider;
    }

    @Override
    public InsertSyntaxProvider getInsertSyntaxProvider() { return insertSyntaxProvider; }

    @Override
    public CreateSyntaxProvider getCreateSyntaxProvider() {
        return createSyntaxProvider;
    }

    @Override
    public String and() {
        return "AND";
    }

    @Override
    public String or() {
        return "OR";
    }

    @Override
    public String alias(String value, String alias) {
        return value + " AS " + alias;
    }

    @Override
    public String delimiter() {
        return " ";
    }
}
