package com.github.kuzznya.query;

import com.github.kuzznya.query.builder.select.SelectExpression;

public class QueryTest {

    public static void main(String[] args) {
        String query = SelectExpression
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
        System.out.println(query);
    }
}
