package com.github.kuzznya.querier.builder.syntax.impl;

import com.github.kuzznya.querier.builder.create.columns.Column;
import com.github.kuzznya.querier.builder.create.columns.ParameterColumn;
import com.github.kuzznya.querier.builder.create.model.CreateType;
import com.github.kuzznya.querier.builder.syntax.CreateSyntaxProvider;

import java.util.List;

public class DefaultCreateSyntaxProvider implements CreateSyntaxProvider {

    @Override
    public String create() {
        return "CREATE ";
    }

    @Override
    public String database(String identifier) {
        return CreateType.DATABASE.name() + " " + identifier;
    }

    @Override
    public String table(String identifier, List<Column> values) {
        StringBuilder res = new StringBuilder(CreateType.TABLE.name() + " " + identifier + " (");
        String prefix = "";
        for(Column value : values) {
            res.append(prefix);
            prefix = ", ";
            res.append(value.getName());
            res.append(" ");
            res.append(value.getType().name());
            if(value instanceof ParameterColumn) { // FIXME: There should be a better approach...
                res.append("(");
                prefix = "";
                for (Integer i : ((ParameterColumn) value).getParams()) {
                    res.append(prefix);
                    prefix = ", ";
                    res.append(i);
                }
                res.append(")");
            }
        }

        res.append(")");

        return res.toString();
    }
}
