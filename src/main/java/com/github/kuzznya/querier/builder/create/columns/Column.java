package com.github.kuzznya.querier.builder.create.columns;

import com.github.kuzznya.querier.builder.create.model.DataType;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Column {
    protected String name;
    protected DataType type;
}
