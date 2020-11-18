# SQL Query Builder

Simple yet useful query builder that simplifies query creation 
by restricting operator order.

## Usage

```java
String query = new QueryBuilder()
                .select("col1", "col2")
                .from("Table1")
                .where("col1 > 0")
                .build();
```

Result:
```sql
SELECT col1, col2 FROM Table1 WHERE col1 > 0
```

```java
QueryBuilder queryBuilder = new QueryBuilder();
String query = queryBuilder
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

### Query syntax customizing

Query syntax can be customized by creating custom SyntaxProvider
and passing it to QueryBuilder

```java
SyntaxProvider provider = new DefaultSyntaxProvider() {
    @Override
    public String delimiter() {
        return "\n";
    }
};
QueryBuilder queryBuilder = new QueryBuilder(provider);
String query = queryBuilder
        .select("col1")
        .from("T001")
```
Result:
```sql
SELECT col1
FROM T001
```

## License

The project is licensed under MIT License
