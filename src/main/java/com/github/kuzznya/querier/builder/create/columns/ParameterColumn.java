package com.github.kuzznya.querier.builder.create.columns;

import com.github.kuzznya.querier.builder.create.model.DataType;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class ParameterColumn extends Column  {

    private List<Integer> params;

    public ParameterColumn(String name, DataType type, Integer ... params) {
        super(name, type);
        this.params = Arrays.asList(params);
    }

    @Override
    public String toString() {
        return super.toString() +
                "(" + params.stream().map(String::valueOf).collect(Collectors.joining(", ")) + ")";
    }
}
