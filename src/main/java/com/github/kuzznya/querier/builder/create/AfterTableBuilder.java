package com.github.kuzznya.querier.builder.create;

import com.github.kuzznya.querier.builder.create.columns.Column;
import com.github.kuzznya.querier.builder.create.columns.ParameterColumn;
import com.github.kuzznya.querier.builder.create.model.DataType;

public class AfterTableBuilder extends CreateBuilder {

    protected AfterTableBuilder(CreateBuilder parent) {
        super(parent);
    }

    public AfterTableBuilder INT(String name) {
        super.addColumn(new Column(name, DataType.INT));
        return new AfterTableBuilder(this);
    }

    public AfterTableBuilder INT(String name, int size) {
        super.addColumn(new ParameterColumn(name, DataType.INT, size));
        return new AfterTableBuilder(this);
    }

    public AfterTableBuilder VARCHAR(String name, int size) {
        super.addColumn(new ParameterColumn(name, DataType.VARCHAR, size));
        return new AfterTableBuilder(this);
    }

    public AfterTableBuilder TEXT(String name, int size) {
        super.addColumn(new ParameterColumn(name, DataType.TEXT, size));
        return new AfterTableBuilder(this);
    }

    public AfterTableBuilder DOUBLE(String name) {
        super.addColumn(new Column(name, DataType.DOUBLE));
        return new AfterTableBuilder(this);
    }

    public AfterTableBuilder DECIMAL(String name, int M, int D) {
        super.addColumn(new ParameterColumn(name, DataType.DECIMAL, M, D));
        return new AfterTableBuilder(this);
    }

    public AfterTableBuilder DATE(String name) {
        super.addColumn(new Column(name, DataType.DATE));
        return new AfterTableBuilder(this);
    }

    public String build() {
        return super.build();
    }
}
