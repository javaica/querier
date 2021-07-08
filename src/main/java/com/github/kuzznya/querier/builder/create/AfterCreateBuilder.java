package com.github.kuzznya.querier.builder.create;

import com.github.kuzznya.querier.builder.create.model.CreateType;

public class AfterCreateBuilder extends CreateBuilder {

    protected AfterCreateBuilder(CreateBuilder parent) {
        super(parent);
    }

    public FinalBuilder database(String databaseName) {
        super.setIdentifier(databaseName);
        super.setType(CreateType.DATABASE);
        return new FinalBuilder(this);
    }

    public AfterTableBuilder table(String tableName) {
        super.setIdentifier(tableName);
        super.setType(CreateType.TABLE);
        return new AfterTableBuilder(this);
    }

}
