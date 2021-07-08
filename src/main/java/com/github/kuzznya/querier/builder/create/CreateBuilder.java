package com.github.kuzznya.querier.builder.create;

import com.github.kuzznya.querier.builder.QueryBuilder;
import com.github.kuzznya.querier.builder.create.columns.Column;
import com.github.kuzznya.querier.builder.create.model.CreateType;
import com.github.kuzznya.querier.builder.syntax.SyntaxProvider;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
public abstract class CreateBuilder extends QueryBuilder {

    private String identifier;
    private CreateType type;
    private List<Column> columns = new ArrayList<>();

    protected CreateBuilder(SyntaxProvider syntaxProvider) {
        super(syntaxProvider);
    }

    protected CreateBuilder(CreateBuilder parent) {
        super(parent.syntaxProvider);
        identifier = parent.identifier;
        type = parent.type;
        columns = parent.columns;
    }

    @Override
    protected String build() {
        String query = "";
        query += syntaxProvider.getCreateSyntaxProvider().create();
        switch (type) {
            case DATABASE -> query += syntaxProvider.getCreateSyntaxProvider().database(identifier);
            case TABLE -> query += syntaxProvider.getCreateSyntaxProvider().table(identifier, columns);
        }

        return query;
    }

    public static AfterCreateBuilder create(SyntaxProvider syntaxProvider) {
        CreateBuilder parent = new CreateBuilder(syntaxProvider) {};
        return new AfterCreateBuilder(parent);
    }

    protected void addColumn(Column column) {
        columns.add(column);
    }
}
