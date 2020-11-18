package com.github.kuzznya.query.builder.select.model;

import lombok.Value;

@Value
public class ColumnAlias {
    String column;
    String alias;
}
