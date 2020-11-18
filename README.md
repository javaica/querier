# SQL Query Builder

Simple yet useful query builder that simplifies query creation 
by restricting operator order.

## Usage

```java
String query = SelectExpression
                .select("col1", "col2")
                .from("Table1")
                .where("col1 > 0")
                .build();
```

```java
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
```

## License

The project is licensed under MIT License
