package com.github.kuzznya.querier.builder;

import com.github.kuzznya.querier.builder.syntax.SyntaxProvider;

public abstract class QueryExpression {

    protected final SyntaxProvider syntaxProvider;

    protected QueryExpression(SyntaxProvider syntaxProvider) {
        this.syntaxProvider = syntaxProvider;
    }

    protected abstract String build();
}
