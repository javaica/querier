package com.github.kuzznya.querier.builder.syntax;

public interface SyntaxProvider {
    SelectSyntaxProvider getSelectSyntaxProvider();
    String and();
    String or();
    String alias(String value, String alias);
    String delimiter();
}
