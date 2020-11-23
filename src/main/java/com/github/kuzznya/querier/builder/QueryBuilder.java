package com.github.kuzznya.querier.builder;

import com.github.kuzznya.querier.builder.syntax.SyntaxProvider;

public abstract class QueryBuilder {

    protected final SyntaxProvider syntaxProvider;

    protected QueryBuilder(SyntaxProvider syntaxProvider) {
        this.syntaxProvider = syntaxProvider;
    }

    protected abstract String build();
}
