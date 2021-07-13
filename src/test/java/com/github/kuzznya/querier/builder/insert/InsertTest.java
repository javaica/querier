package com.github.kuzznya.querier.builder.insert;

import com.github.kuzznya.querier.builder.Querier;
import com.github.kuzznya.querier.builder.syntax.SyntaxProvider;
import com.github.kuzznya.querier.builder.syntax.impl.DefaultSyntaxProvider;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InsertTest {

    @Test
    public void defaultInsert() {
        String query = new Querier()
                .insert("Table1")
                .column("Name", "Id")
                .value("man", "13")
                .build();

        assertEquals("INSERT INTO Table1 (Name, Id) " +
                "VALUES (man, 13)", query);
    }


    @Test
    public void insertIntoSpecifiedColumns() {
        String query = new Querier()
                .insert("Table1")
                .column("Name", "Id")
                .value("pal", "17")
                .build();

        assertEquals("INSERT INTO Table1 (Name, Id) " +
                "VALUES (pal, 17)", query);
    }

    @Test
    public void customizedSyntaxProvider() {
        SyntaxProvider syntaxProvider = new DefaultSyntaxProvider() {
            @Override
            public String delimiter() {
                return "\n";
            }
        };
        Querier querier = new Querier(syntaxProvider);

        String query = querier
                .insert("Table1")
                .column("Name, Surname")
                .value("woman", "brown")
                .build();

        assertEquals("INSERT INTO Table1 (Name, Surname)" +
                "\nVALUES (woman, brown)", query);
    }
}
