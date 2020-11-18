package com.github.kuzznya.query.builder;

import com.github.kuzznya.query.builder.select.AfterSelectExpression;
import com.github.kuzznya.query.builder.select.SelectExpression;
import com.github.kuzznya.query.builder.syntax.DefaultSyntaxProvider;
import com.github.kuzznya.query.builder.syntax.SyntaxProvider;

public class QueryBuilder {

    private final SyntaxProvider syntaxProvider;

    public QueryBuilder() {
        this(new DefaultSyntaxProvider());
    }

    public QueryBuilder(SyntaxProvider syntaxProvider) {
        this.syntaxProvider = syntaxProvider;
    }

    public AfterSelectExpression select(String... columns) {
        return SelectExpression.select(syntaxProvider, columns);
    }

    public AfterSelectExpression.Aliasable select(String column) {
        return SelectExpression.select(syntaxProvider, column);
    }

}
