package com.github.kuzznya.querier.builder;

import com.github.kuzznya.querier.builder.syntax.impl.DefaultSyntaxProvider;
import com.github.kuzznya.querier.builder.syntax.SyntaxProvider;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class QuerierTest {

    @Test
    public void simpleSelect() {
        String query = new Querier()
                .select("col1", "col2")
                .from("Table1")
                .build();

        assertEquals("SELECT col1, col2 FROM Table1", query);
    }

    @Test
    public void multipleSelectValues() {
        String query = new Querier()
                .select()
                .select("col1")
                .select("col2")
                .from("Table1")
                .build();

        assertEquals("SELECT col1, col2 FROM Table1", query);
    }

    @Test
    public void selectWithAliases() {
        String query = new Querier()
                .select("column1").as("first")
                .select("column2").as("second")
                .from("Table1")
                .build();

        assertEquals("SELECT column1 AS first, column2 AS second FROM Table1", query);
    }

    @Test
    public void selectWithJoins() {
        String query = new Querier()
                .select("t1.col1", "t2.col2", "t3.col3")
                .from("Table1").as("t1")
                .leftJoin("Table2").as("t2")
                .on("t2.col2 = t1.col1")
                .join("Table3").as("t3")
                .on("t3.col3 > t1.col1")
                .build();

        assertEquals("SELECT t1.col1, t2.col2, t3.col3" +
                " FROM Table1 AS t1" +
                " LEFT JOIN Table2 AS t2 ON t2.col2 = t1.col1" +
                " JOIN Table3 AS t3 ON t3.col3 > t1.col1", query);
    }

    @Test
    public void complexSelect() {
        String query = new Querier()
                .select("col1")
                .distinct()
                .from("T001")
                .leftJoin("T002")
                .on("2 < 1")
                .join("T003")
                .on("1 > 2")
                .where("col1 > 0").and("col1 < 10")
                .groupBy("col1")
                .having("col1 > 0").or("col2 > 0")
                .orderBy("col2")
                .limit(1)
                .offset(2)
                .build();

        assertEquals("SELECT DISTINCT col1" +
                " FROM T001" +
                " LEFT JOIN T002 ON 2 < 1" +
                " JOIN T003 ON 1 > 2" +
                " WHERE col1 > 0 AND col1 < 10" +
                " GROUP BY col1 HAVING col1 > 0 OR col2 > 0" +
                " ORDER BY col2" +
                " LIMIT 1" +
                " OFFSET 2", query);
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
                .select("col1", "col2")
                .from("Table1")
                .limit(1)
                .build();

        assertEquals("SELECT col1, col2\nFROM Table1\nLIMIT 1", query);
    }

    @Test
    public void insertIntoSpecifiedColumns() {
        String query = new Querier()
                .insert("Table1")
                .column("Name, Surname")
                .value("jesus, ibn god")
                .build();

        assertEquals("INSERT INTO Table1 (Name, Surname) " +
                "\nVALUE (jesus, ibn god)", query);
    }

    @Test
    public void defaultInsert() {
        String query = new Querier()
                .insert("Table1")
                .value("jesus")
                .build();

        assertEquals("INSERT INTO Table1 " +
                "\nVALUE (jesus)", query);
    }
}