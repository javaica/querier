package com.github.kuzznya.query.builder.syntax;

import com.github.kuzznya.query.builder.select.model.Join;
import com.github.kuzznya.query.builder.select.model.OrderType;
import com.github.kuzznya.query.builder.select.model.SelectType;

import java.util.List;

public interface SyntaxProvider {
    String select(SelectType type, List<String> columns);
    String from(String table);
    String join(Join join);
    String where(String condition);
    String groupBy(String column);
    String having(String condition);
    String orderBy(String column, OrderType orderType);
    String limit(int value);
    String offset(int value);
    String and();
    String or();
    String alias(String value, String alias);
    String delimiter();
}
