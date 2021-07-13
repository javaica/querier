package com.github.kuzznya.querier.builder.create;

import com.github.kuzznya.querier.builder.Querier;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CreateTest {

    @Test
    public void createDatabase() {
        String query = new Querier()
                .create()
                .database("MyBase")
                .build();

        assertEquals("CREATE DATABASE MyBase", query);
    }

    @Test
    public void createTable() {
        String query = new Querier()
                .create()
                .table("Contacts")
                .INT("contact_id", 11)
                .VARCHAR("last_name", 30)
                .VARCHAR("first_name", 30)
                .DATE("birthday")
                .build();

        assertEquals("CREATE TABLE Contacts " +
                "(contact_id INT(11), " +
                "last_name VARCHAR(30), " +
                "first_name VARCHAR(30), " +
                "birthday DATE)", query);
    }
}
