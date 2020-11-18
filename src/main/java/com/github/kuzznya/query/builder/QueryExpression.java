package com.github.kuzznya.query.builder;

import com.github.kuzznya.query.builder.syntax.SyntaxProvider;

public abstract class QueryExpression {

    protected final SyntaxProvider syntaxProvider;

    protected QueryExpression(SyntaxProvider syntaxProvider) {
        this.syntaxProvider = syntaxProvider;
    }

    protected abstract String build();
}
