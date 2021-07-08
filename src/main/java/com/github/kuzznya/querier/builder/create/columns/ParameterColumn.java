package com.github.kuzznya.querier.builder.create.columns;

import com.github.kuzznya.querier.builder.create.model.DataType;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;

@Getter
public class ParameterColumn extends Column  {

    private List<Integer> params;

    public ParameterColumn(String name, DataType type, Integer ... params) {
        super(name, type);
        this.params = Arrays.asList(params);
    }

}
