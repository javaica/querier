# SQL Query Builder

Simple yet useful query builder that simplifies query creation 
by restricting operator order.

The purpose of this project is to create really easy-to-use solution
for query building so that if the code compiles,
then query operators are valid (not counting content, of course).

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

Aliases:

```java
String query = new QueryBuilder()
                .select("column1").as("first")
                .select("column2").as("second")
                .from("Table1")
                .build();
```

Result:
```sql
SELECT column1 AS first, column2 AS second FROM Table1
```

```java
String query = new QueryBuilder()
                .select("t1.col1", "t2.col2", "t3.col3")
                .from("Table1").as("t1")
                .leftJoin("Table2").as("t2")
                .on("t2.col2 = t1.col1")
                .join("Table3").as("t3")
                .on("t3.col3 > t1.col1")
                .build();
```

Result:
```sql
SELECT t1.col1, t2.col2, t3.col3 FROM Table1 AS t1 LEFT JOIN Table2 AS t2 ON t2.col2 = t1.col1 JOIN Table3 AS t3 ON t3.col3 > t1.col1
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
        .build();
```

Result:
```sql
SELECT col1
FROM T001
```

## License

The project is licensed under MIT License.
