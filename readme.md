<<<<<<< HEAD
# Pontious
=======
#Pontious

>>>>>>> b4f6514200ca38bba1d7185018b6a05473eeeade
Pontious is an ORM library that provides a way to do SQL queries without necessarily writing SQL Query code. It is built over SQL2o to provide a nice ORM touch. Pontious allows you to work with almost all SQL related engines; MariaDB and MySql are supported by default. Very soon most of the engines will be supported too.

When used with the faker library it can insert test data to your database.

Pontious makes it easy to work with a relational database in java. Its functionality of working without SQL query codes and database connections gives it an edge over the API's used in java.

Pontious is heavily inspired by the ORM provided by laravel and the Eloquent features provided by Laravel. Most of it's functionality if not all are related to the Laravel API. Pontious was built by Tunes Developers and is open source.

# Table of Contents

- [Installation]
- [Pontious Protocol]
  - [Engine]
  - [Database Connection]
    - [Manual Connections]
    - [Config Connections]
    - [Droping and Creating a database]
- [Tables]
  - [Supported Methods]
  - [Droping and Renaming a table]
- [Manipulating Data]
  - [Inserting Data]
    - [Inserting Fake data]
  - [Updating Data]
  - [Deleting Data]
  - [Reading Data]
    - [Where Clause]
      - [Supported Methods]
    - [Where Like Clause]
    - [Or Where Clause]
    - [Order By Clause]
    - [Join Clause]
- [Eloquent Models]
  - [Setting up a Model]
  - [Implementing Model Methods]
- [DB class]


## Pontious Protocol
### Engine
Pontious is built to work with various SQL related engines. As specified above MariaDB and MySql are provided by default. Below is a sample engine: 

```json
{
  "connectionRemote": "jdbc:mariadb://${1:46.101.81.163}:${2:3306}/",
  "connectionLocalHost": "jdbc:mariadb://localhost:${1:3306}/",
  "createDatabase": "CREATE DATABASE IF NOT EXISTS ${1:machakos_university}",
  "dropDatabase": "DROP DATABASE IF EXISTS ${1:machakos_university}",
  "createTable": "CREATE TABLE IF NOT EXISTS ${1:tunes_table} (${2:columns})",
  "alterTable": "ALTER TABLE ${1:tune_table_name} RENAME TO  ${2:new_table_name}",
  "dropTable": "DROP TABLE IF EXISTS ${1:tunes_row}",
  "createTemporaryTable": "CREATE TEMPORARY TABLE IF NOT EXISTS ${1:tunes_table} (${2:columns})",
  "dropColumn": "ALTER TABLE ${1:tune_table_name} DROP ${2:tunes_column}",
  "createBool": "${1:tunes_bool} BOOLEAN NOT NULL",
  "createDate": "${1:tunes_date} DATE NOT NULL",
  "createTime": "${1:tunes_time} TIME NOT NULL",
  "createDateTime": "${1:tunes_date_time} DATETIME NOT NULL",
  "createTimestamp": "${1:tunes_timestamp} TIMESTAMP NOT NULL",
  "createTimestamps": "created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP, updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP",
  "createDouble": "${1:tunes_double} DOUBLE(${1:9}, ${2:2}) NOT NULL",
  "createFloat": "${1:tunes_float} FLOAT NOT NULL",
  "createJson": "${1:tunes_json} JSON NOT NULL",
  "createCharacter": "${1:tunes_character} CHAR(${2:1}) NOT NULL",
  "createStringConstrain": "${1:tunes_string} VARCHAR(${2:150}) NOT NULL",
  "createString": "${1:tunes_string_255} VARCHAR(255) NOT NULL",
  "createText": "${1:tunes_text} TEXT(${2:777}) NOT NULL",
  "createMediumText": "${1:tunes_medium_text} MEDIUMTEXT NOT NULL",
  "createIncrement": "${1:id} INT UNSIGNED AUTO_INCREMENT PRIMARY KEY",
  "createIncrementConstrain": "${1:id} INT(${2:6}) AUTO_INCREMENT",
  "createInteger": "${1:tunes_int} INT(${2:8}) NOT NULL",
  "createBigInteger": "${1:tunes_big_int} BIGINT NOT NULL",
  "createSmallInteger": "${1:tunes_small_int} SMALLINT NOT NULL",
  "createTinyInteger": "${1:tunes_tiny_int} TINYINT NOT NULL",
  "createDecimal": "${1:tunes_decimal} Decimal(${2:9},${3:2}) NOT NULL",
  "makeDefault": "DEFAULT ${1:}",
  "makeNullable": "",
  "makeUniqueIndex": "CREATE UNIQUE INDEX ${1:tunes_index} ON ${2:table_name} ${3:column_name}",
  "makeUnsigned": "UNSIGNED",
  "makePrimaryKey": "PRIMARY KEY",
  "makeAutoIncrement": "AUTO_INCREMENT",
  "makeUnique": "UNIQUE",
  "makeForeignKey": "",
  "on": "ON ${1:table_name2.column} = ${2:table_name2.column}",
  "selectFormat": "SELECT ${1:tunes_colums} FROM ${2:table_name}",
  "whereFormat": "WHERE ${1:tunes_column} ${2:=} ${3:column_data}",
  "whereLike": "WHERE ${1:tunes_column} LIKE ${2:column_data}",
  "whereNotLike": "WHERE ${1:tunes_column} NOT LIKE ${2:column_data}",
  "multipleWhere": "WHERE (${1:whereData})",
  "orderBy": "ORDER BY ${1:tunes_column} ASC",
  "limitFormat": "LIMIT ${1:10}",
  "orderByDesc": "ORDER BY ${1:tunes_column} DESC",
  "from": "FROM ${1:tunes_table}",
  "whereThreeFormat": "",
  "joinFormat": "INNER JOIN ${1:tunes_table}",
  "deleteSelectFormat": "DELETE FROM ${1:tunes_table} WHERE ${2:where_query}",
  "deleteFrom": "DELETE FROM ${1:tunes_table} WHERE ${2:id} = ${3:primary_key_value}",
  "insertFormat": "INSERT INTO ${1:tunes_table} (${2:column1,column2}) VALUES (${3:data1,data2})",
  "insertMultipleFormat": "INSERT INTO ${1:tunes_table} (${2:column1,column2}) VALUES ${3:data1,data2}",
  "updateFormat": "UPDATE ${1:tunes_table} SET ${2:column = 'value'} WHERE ${3:primary_key} = ${4:primary_key_value}",
  "updateMultipleFormat": "UPDATE ${1:tunes_table} SET ${2:column = 'value'} WHERE ${3:where_query}",
  "deleteFormat": ""
}
```

The common commands are all declared in one engine file so that you don't have to re-write them again. Take an example of a create database query

```sql
CREATE DATABASE IF NOT EXISTS cars;
```

This query creates a database 'cars' if one does not exist. In the pontious engine file this query is defined as:

```json
"createDatabase": "CREATE DATABASE IF NOT EXISTS ${1:cars}
```

In the create database query, only one field changes each time that query is written, and that is the database name. So that this query is re-usable, the database name is wrapped in ``${1: db_name}`` . The `$` symbol defines that a dynamic field is being initialized, the `{}` defines that anything inside these braces should not be added to the sql query, the `1` defines the number of the parameter, so that when re-using the query, everything will be put in-order. The `db_name` defines the default content to be placed in the query if nothing is specified when executing the query.

This is pretty much like the sublime text snippet definition syntax. This makes creating an engine a simple experience. If you are interested in creating an engine file for your favourite engine, that is an example of how its done.

### Database Connection
Database connections can either be done manually during creation of an object or via the use of the Config library.

#### Manual Connections
To define a manual connection you create an engine object with the name of your engine. You will then create a database object with the port number, the username, the password and the engine object for a localhost connection and the ip address, the port number, the username, the password and the engine object for a remote connection.

```java
import com.Tunes_Developers.Database;
import com.Tunes_Developers.Engine;
import com.Tunes_Developers.Exceptions.PontiousException;

public class Main {
    public static void main(String[] args) throws Exception {
        Engine engine = new Engine("mysql");

        //Localhost connection
        Database db = new Database("3307","root","secret",engine);

        //Remote Connection
        Database dbRemote = new Database("127.43.22.12",3306,"root","secret",engine);
    }
}
```

#### Config Connections
Config connections are done using the configuration api provided by Tunes Developers. A config api, consolidates all the configurations needed in an application to one file so that they dont have to be initialized every time they are needed. Take an example of the database object. Each time it is initalized, the port number, ip address, username, password and engine is required. If you are initalizing this object a couple of times in your code, not only will creating this object be repetative but it will also waste a lot of time.

The config api provides a way to setup all this required variables once. It is much like the .env file in php. Below is an example of a default database configuration:

```json
{
  "database": {
    "host": "",
    "port": "3307",
    "engine": "maria",
    "username": "root",
    "databaseName": "cars",
    "password": "secret"
  },
  "faker": {
    "language": "English",
    "country": "Kenya"
  },
}
```

The database object can accept a configuration object. For example:

```java
import com.Tunes_Developers.Config;
import com.Tunes_Developers.Database;

public class TestDatabaseConfig {
    public static void main(String[] args) throws Exception {
        Config config = new Config("C:/Users/Geoffrey-Kimani/Desktop");
        Database db = new Database(config);
    }
}
```

The configuration object created requires the location of the configurations file. This location does not include the file name or extension. Each configurations file should have the name env.json. This means, When the above code is compiled it will search for an env.json file in the specified location and initalize the database details for the Database object.

The config object can also be initialized without a location being provided. The default location is a hidden folder in the users location of the Operating System. When the config finds that the default file does not exist, it will create the configuration file with the default variables for each fields, just as specified in the sample configuration file.

### Droping and Creating a Database
It is possible to drop or create a database in pontious. To create a database the method `db.create("database_name")` is used. This method implements a query with an if condition to make sure an error message is not returned in case the database exists. To drop a database the method `db.drop("database_name")` is used.

These two methods discussed above can be used without a parameter if the database name was defined in the configurations file or in the database object.

## Tables
Creating a table with the pontious api is an easy task since no SQL query code is written by the programmer. Below is an example of creating a vehicles table and a brand table that we will be using throughout this documentation.

```java
import com.Tunes_Developers.Config;
import com.Tunes_Developers.Database;
import com.Tunes_Developers.Table;

public class Main {
    public static void main(String[] args) throws Exception {
        Database db = new Database();

        //Create a vehicles table
        Table vehicles = new Table(db,"vehicles");
        vehicles.integer("id").primaryKey().autoIncrement().unsigned().unique();
        vehicles.string("model_name",200);
        vehicles.integer("horse_power",6).unsigned();
        vehicles.integer("brand_id");
        vehicles.Double("price",12,2);
        vehicles.text("description",500);
        vehicles.timestamps();
        vehicles.createTable();

        //Create a brand table
        Table brand = new Table(db,"brand");
        brand.increment("id");
        brand.string("title",50);
        brand.integer("year_established",4).unsigned();
        brand.timestamps();
        brand.createTable();
    }
}
```

The vehicles table will have an `id` field as the primary key, auto incremented, unsigned and unique, a `model_name` as a var char wit 200 characters, the `horse_power` as an integer with a maximum of 6 digits and unsigned, the `brand_id` as an integer that is unsigned, a `price` field that is a double, unsigned and has a total of 12 digits with 2 decimal points, a `description` field with 500 characters and lastly a `created_at` field and an `updated_at` field created by the timestamps method.

The model table will have an `id` field simillar to the vehicles table id, a `title` field with 50 characters, a `year_established` field with 4 integers and timestamp fields (`created_at` and `updated_at`).

### Suported Methods
Below is a list of the supported methods when creating a table

``bool(String columnName)``
``date(String columnName)``
``time(String columnName)``
``dateTime(String columnName)``
``timeStamp(String columnName)``
Creates a column in the table of the type time stamp
``timeStamps(String columnName)``
Creates two columns (created_at and updated_at) in the table of the time stamp type
``Double(String columnName)``
``Double(String columnName, int nbTotalDigits, int nbDecimalPoints)``
``Float(String columnName)``
``json(String columnName)``
``character(String columnName)``
``string(String columnName)``
Creates a VarChar column with a maximum length of 255.
``string(String columnName, int constrain)``
Checks the constrain provided. If the constrain is less than 255, it creates a VarChar column and if the constrain is greater than 255 it creates a Text column.
``text(String columnName)``
``text(String columnName, int constrain)``
``mediumText(String columnName)``
``increment(String columnName)``
Creates a column in the table that is a primary key, auto inremented, unsigned and unique.
``increment(String columnName, int constrain)``
Similar to the increment method. Only that you can specify the length of the column.
``integer(String columnName)``
``integer(String columnName, int constrain)``
``bigInteger(String columnName)``
``bigInteger(String columnName, int constrain)``
``smallInteger(String columnName)``
``tinyInteger(String columnName)``
``decimal(String columnName)``
``decimal(String columnName, int nbTotalDigits, int nbDecimalPoints)``

### Droping and Renaming a Table
To drop a table use the method ``table.dropTable()``. To rename a table use the method ``table.renameTable("new_table_name")``.

## Manipulating Data
Every database has to have a way to manipulate data in the database. There has to be a way to insert, update, delete and read data from the database.

### Inserting Data
Inserting data to a database has never been as easy as this in java.

```java
import com.Tunes_Developers.Database;
import com.Tunes_Developers.ManipulateData;
import com.Tunes_Developers.Table;

public class TestInsert {
    public static void main(String[] args) throws Exception {
      Database db = new Database();
      Table vehicles = new Table(db,"vehicles");

      ManipulateData manVehicles = new ManipulateData(vehicles);
      manVehicles.cellString("model_name","Ranger");
      manVehicles.cellInt("horse_power","1200");
      manVehicles.cellInt("brand_id","5");
      manVehicles.cellInt("price","5000000");
      manVehicles.cellString("description","The ford Ranger stands out in the list of double cabs pick-ups. With its size, horse power, durability and other functionalities, it outdoes Isuzu D-Max and Nissan Navara");
      manVehicles.insertRow();
  }
}
```

The above code inserts a row to the vehicles table in the cars database. When inserting data you will need two methods; the `cellString()` and the `cellInt()` methods. The `cellString()` is used to insert data that will be wrapped in quatation marks when inserting it using normal sql queries e.g. var characters, text, date and time etc. The `cellInt()` method is used to insert data made up of numbers only e.g. floats, doubles, decimals, integers etc.

#### Inserting Fake data
The pontious api can be used with the faker api from Tunes Developers to insert fake records to the database. Fake records are rows with data that simulates the normal data a user will input but this data has not been necessarily inputed by a user.

This fake data is important to a programmer for testing purposes when constructing a system. The faker api when used with the pontious api can generate large amounts of data, depending on the programmers need. Whether you need 5 records in a table or 20 000 000 records to check the versatility of a system, pontious is for you.

The faker api gives you a lot of functionality and flexinility, check out the link below to know the functionalities of the faker api https://github.com/Jeffrey-Kimani/Faker 

```java
import com.Tunes_Developers.Database;
import com.Tunes_Developers.ManipulateData;
import com.Tunes_Developers.Table;

public class TestInsert {
    public static void main(String[] args) throws Exception {
      Database db = new Database();
      Table vehicles = new Table(db,"vehicles");
      FakerDatabase fd = new FakerDatabase();

      ManipulateData manVehicles = new ManipulateData(vehicles);
      manVehicles.cellString("model_name",fd.words(3));
      manVehicles.cellInt("horse_power",fd.numerifyAboveZero("####"));
      manVehicles.cellInt("brand_id",fd.numerifyNoZeros("##","24"));
      manVehicles.cellInt("price",fd.numerify("#########.##"));
      manVehicles.cellString("description",fd.text(1,4));
      manVehicles.insertRows(1000);
  }
}
```

The above code creates 1000 records in the database. All the fields are populated with the relevant data. The faker api can generte a wide range of data e.g. names, email addresses, ipv4 addresses, ipv6 addresses, color codes (hex,rgb,rgba), cities, countries, credit card numbers and their types etc.

### Updating Data
You can also update data using the pontious api. Below is an example

```java
import com.Tunes_Developers.Database;
import com.Tunes_Developers.ManipulateData;
import com.Tunes_Developers.Table;

public class TestInsert {
    public static void main(String[] args) throws Exception {
      Database db = new Database();
      Table vehicles = new Table(db,"vehicles");

      ManipulateData manVehicles = new ManipulateData(vehicles);
      manVehicles.cellString("model_name","Ranger");
      //Changed the horse power
      manVehicles.cellInt("horse_power","880");
      manVehicles.cellInt("brand_id","5");
      manVehicles.cellInt("price","5000000");
      manVehicles.cellString("description","The ford Ranger stands out in the list of double cabs pick-ups. With its size, horse power, durability and other functionalities, it outdoes Isuzu D-Max and Nissan Navara");
      manVehicles.updateRow("id","4");
  }
}
```

The above code updates the row with the `id` as 4 to have the fields specified. If the primary column is named id you can use this method `updateRow("4")`, no need to specifiy the primary key column since by default this column is named id.

### Deleting Data
Below is an example of how you can delete a row.

```java
import com.Tunes_Developers.Database;
import com.Tunes_Developers.ManipulateData;
import com.Tunes_Developers.Table;

public class TestInsert {
    public static void main(String[] args) throws Exception {
      Database db = new Database();
      Table vehicles = new Table(db,"vehicles");

      ManipulateData manVehicles = new ManipulateData(vehicles);
      manVehicles.deleteRow("id","5");
  }
}
```

The above example deletes a row with the column id as 5 from the table.

### Reading Data
The normal way for reading data from the database in java is by the use of result sets. Pontious api provides this functionality, but it also provides a way to use objects. By making use of the Sql2o api pontious can fetch data from the relational database and convert it into defined object. This will be discussed later, for now we will tackle fetching data using the `ResultSet` class.

Below is code to demonstrate how to fetch data from the database.
```java
import com.Tunes_Developers.Database;
import com.Tunes_Developers.ManipulateData;
import com.Tunes_Developers.Table;
import java.sql.ResultSet;

public class TestInsert {
    public static void main(String[] args) throws Exception {
      Database db = new Database();
      Table vehicles = new Table(db,"vehicles");

      ManipulateData manVehicles = new ManipulateData(vehicles);

      ResultSet rs = manVehicles.select("id","model_name","horse_power","price").get(10);

      while(rs.next()) {
        System.out.println(
          "id: "+rs.getInt("id")+"\n"+
          "Model Name: "+rs.getString("model_name")+"\n"+
          "Horse Power: "+rs.getString("horse_power")+"\n"+
          "Price: "+rs.getDouble("price")+"\n"
        );
      }
  }
}
```

The above code grabs 10 records from the database and display the necessary fields. The `select()` method can fetch any number of fields from the database. The `get()` method can take an integer argument to specify the number of records you want fetched. If used without a parameter it gets all the records in the database table.

#### Where Clause
Reading  data can be used with the where clause to filter out the data fetched. Below is an example.

```java
import com.Tunes_Developers.Database;
import com.Tunes_Developers.ManipulateData;
import com.Tunes_Developers.Table;
import java.sql.ResultSet;

public class TestInsert {
    public static void main(String[] args) throws Exception {
      Database db = new Database();
      Table vehicles = new Table(db,"vehicles");

      ManipulateData manVehicles = new ManipulateData(vehicles);

      ResultSet rs = 
          manVehicles.select("id","model_name","horse_power","price")
                    .where("id",">=",20)
                    .where("price","<"2000000)
                    .where("price",">=",100000)
                    .get(10);

      while(rs.next()) {
        System.out.println(
          "id: "+rs.getInt("id")+"\n"+
          "Model Name: "+rs.getString("model_name")+"\n"+
          "Horse Power: "+rs.getString("horse_power")+"\n"+
          "Price: "+rs.getDouble("price")+"\n"
        );
      }
  }
}
```

The above example will fetch records that match the where conditions provided. which means the records fetched will have an `id` greater than 20, a price less than 2 000 000 and a price greater than or equal to 100 000. The where methods can be chained together as demonstrated above.

##### Supported Methods
The are a number of where methods provided by the api, they include

1. `where(String column, int columnData)`
Selects records where the column data is equal to the one provided. The above method takes the second argument as an integer

2. `where(String column, String columnData)`
Similar to number 1 only that it takes a string as the second argument.

3. `where(String column,String condition, String columnData)`
Selects records where the column data matches the condition specified. e.g. where("price",">=","100000").

4. `where(String column,String condition, int columnData)`
Similar to number 3 only that it takes the second argument as a String.

#### Where Like Clause
This is a where clause with a like clause in it. Below is an example

```java
import com.Tunes_Developers.Database;
import com.Tunes_Developers.ManipulateData;
import com.Tunes_Developers.Table;
import java.sql.ResultSet;

public class TestInsert {
    public static void main(String[] args) throws Exception {
      Database db = new Database();
      Table vehicles = new Table(db,"vehicles");

      ManipulateData manVehicles = new ManipulateData(vehicles);

      ResultSet rs = 
          manVehicles.select("id","model_name","horse_power","price")
                    .where("price",">=",100000)
                    .whereLike("name","ra%")
                    .whereNotLike("name","maclaren%")
                    .get(10);

      while(rs.next()) {
        System.out.println(
          "id: "+rs.getInt("id")+"\n"+
          "Model Name: "+rs.getString("model_name")+"\n"+
          "Horse Power: "+rs.getString("horse_power")+"\n"+
          "Price: "+rs.getDouble("price")+"\n"
        );
      }
  }
}
```

The above code has added an implementation for the `whereLike()` and `whereNotLike()` methods. It selects record where the name matches `ra%` condition and the name does not match `maclaren%` condition. The API also provides a `whereNotLike()` clause to implement the not condition.

#### Or Where Clause
When chaining many where clauses together you may need the use of an or symbol `||`. When many where methods are chainned together the generated sql query chains the using `&&`. To chain a specific method using `||`, the `orWhere()` method is provided. Below is an example.
```java
import com.Tunes_Developers.Database;
import com.Tunes_Developers.ManipulateData;
import com.Tunes_Developers.Table;
import java.sql.ResultSet;

public class TestInsert {
    public static void main(String[] args) throws Exception {
      Database db = new Database();
      Table vehicles = new Table(db,"vehicles");

      ManipulateData manVehicles = new ManipulateData(vehicles);

      ResultSet rs = 
          manVehicles.select("id","model_name","horse_power","price")
                    .where("id",20)
                    .orwhere("name","Ractis")
                    .orWhere("price","250000")
                    .get();

      while(rs.next()) {
        System.out.println(
          "id: "+rs.getInt("id")+"\n"+
          "Model Name: "+rs.getString("model_name")+"\n"+
          "Horse Power: "+rs.getString("horse_power")+"\n"+
          "Price: "+rs.getDouble("price")+"\n"
        );
      }
  }
}
```

The code above fetches records where the `id` is equal to 20 or where the `name` is equal to `Ractis` or where the `price` is equal to 250 000. The or clause is also available in the following methods `orWhereLike(String column, String columnData)`, `orWhereNotLike(String column, String columnData)` and all the where methods discussed above.

#### Order By Clause
The orderBy methods can be used to order the records by a specified manner. Below is an example.

```java
import com.Tunes_Developers.Database;
import com.Tunes_Developers.ManipulateData;
import com.Tunes_Developers.Table;
import java.sql.ResultSet;

public class TestInsert {
    public static void main(String[] args) throws Exception {
      Database db = new Database();
      Table vehicles = new Table(db,"vehicles");

      ManipulateData manVehicles = new ManipulateData(vehicles);

      ResultSet rs = 
          manVehicles.select("id","model_name","horse_power","price")
                    .where("price",">=",100000)
                    .orderBy("price")
                    .get(10);

      while(rs.next()) {
        System.out.println(
          "id: "+rs.getInt("id")+"\n"+
          "Model Name: "+rs.getString("model_name")+"\n"+
          "Horse Power: "+rs.getString("horse_power")+"\n"+
          "Price: "+rs.getDouble("price")+"\n"
        );
      }
  }
}
```

The code above fetches the data from the database where the price is greater than 100 000 and sorts them in ascending order and fetches only 10 records. It then prints them out on the console. To sort in descending order use the method `orderByDesc(String columnName)`.

#### Join Clause
The API provides for a way to use the Join clause when reading data from the database. Below is an example
```java
import com.Tunes_Developers.Database;
import com.Tunes_Developers.ManipulateData;
import com.Tunes_Developers.Table;
import java.sql.ResultSet;

public class TestInsert {
    public static void main(String[] args) throws Exception {
      Database db = new Database();
      Table vehicles = new Table(db,"vehicles");

      ManipulateData manVehicles = new ManipulateData(vehicles);

      ResultSet rs = 
          manVehicles.select(
                      "vehicles.id","vehicles.model_name",
                      "vehicles.horse_power","vehicles.brand_id"
                      "vehicles.price",
                      "brands.title","brands.id"
                      )
                    .innerJoin("brands")
                    .on("vehicles.brand_id","brands.id");

      while(rs.next()) {
        System.out.println(
          "id: "+rs.getInt("vehicles.id")+"\n"+
          "Brand: "+rs.getString("brands.id")
          "Model Name: "+rs.getString("vehicles.model_name")+"\n"+
          "Horse Power: "+rs.getString("vehicles.horse_power")+"\n"+
          "Price: "+rs.getDouble("vehicles.price")+"\n"
        );
      }
  }
}
```

The above example will return all the records from the vehicles table and link each record with the specific related brand. This means that you can display the brand title when printing out the vehicles details.

## Eloquent Models
When reading data from the database, using result sets could be tidious and repetitive especially when working with very huge database. We have therefore provided and ORM to convert a relational Database Item from a ResultSet into an object of a specific class.

In this topic, we will discuss how to set-up a model, how to manipulate data and how to model relationships using a the Eloquent Model.

### Seting up a Model.
When creating an app especially when using JavaFX. The following approach is used.

View -> Controller -> Model

The view is what is seen by the user. The controller is what controls the view. It fetches data from the model and manipulates it to be displayed in a view. It acts as an intermediary between a View and a controller. The model interacts with the database, It is a class representing a real world object. It contains variable to define object characteristics and methods to define relationships with other objects. It is used to manipulate data from the relational database.

Below is an example of how to set-up a model.

```java
import java.util.List;
import com.Tunes_Developers.Model

public class Vehicle extends Model{
  public int id;
  public String model_name;
  public int horse_power;
  public int brand_id;
  public int price;
  public String description;

  public Vehicle() throws Exception {
    super("vehicles");
  }

  public Vehicle(int id, String model_name, int horse_power,
                  int brand_id,int price, int description) throws Exception {
      super("vehicles");
      this.id = id;
      this.model_name = model_name;
      this.brand_id = brand_id;
      this.price = price;
      this.description = description;
  }

  public Vehicle(String model_name, int horse_power,
                  int brand_id,int price, int description) throws Exception {
      super("vehicles");
      this.model_name = model_name;
      this.brand_id = brand_id;
      this.price = price;
      this.description = description;
  }

  public void insert(List<Vehicle> vehicles) {
      for(Vehicle v:vehicles) {
        manData.cellString("model_name",v.model_name);
        manData.cellInt("horse_power",v.horse_power);
        manData.cellInt("brand_id",v.brand_id);
        manData.cellInt("price",v.price);
        manData.cellInt("description",v.description);
        manData.insertRow();
      }
  }

  public void remove(List<Vehicle> vehicles) {
      for(Vehicle v:vehicles) {
        manData.deleteRow(primaryKeyColumn,v.id);
      }
  }

  public void update(List<Vehicle> vehicles) {
        for(Vehicle v:vehicles) {
        manData.cellString("model_name",v.model_name);
        manData.cellInt("horse_power",v.horse_power);
        manData.cellInt("brand_id",v.brand_id);
        manData.cellInt("price",v.price);
        manData.cellInt("description",v.description);
        manData.updateRow(primaryKeyColumn,v.id);
      }
  }

  public Brand brand() {
      return (Brand) hasOne(new Brand(),"brand_id",id+"");
  }
}
```

The above class is a sample model for the Vehicle Object. In the above code we have defined methods to 
  1. insert a vehicle
  2. To Update a vehicle
  3. To Remove a vehicle
  4. To Return a related Brand

Extending from the Model class provides a lot of functionalities. Some of them incluide:
  1. Objects such as tables, database and ManipulateData have already been initialized.
  2. Provides a way to set the table name and the primary key column.
  3. Addition of features to manipulate data.
  4. Addtion of methods to model relationships i.e. `hasOne()` and `hasMany()` to model the relationships between model.
  5. Adition of methods to find an item by id or get all items i.e. `find()` and `get()`.

### Implementing Model Methods
We are now going to look at an example of how we can put into use the above Model.

```java
import java.util.List;

public class TestModel {
    public static void main(String[] args) throws Exception {
      Vehicle vehicle = new Vehicle();
      List<Vehicle> vehicles = new List<Vehicles> ();

      //Inserting Data
      vehicles.add(new Vehicle("D-Max",600,2,2000000,"The Isuzu D-Max is a great double cab pick-up vehicle."));
      vehicles.add(new Vehicle("Ractis",200,4,220000,"Toyota Ractis is a great to move around the city."));
      vehicle.insert(vehicles);

      //Removing data
      vehicles.remove(vehicles);

      //Updating data
      vehicles.set(0,vehicles.get(0).horse_power = 330);
      vehicles.update(vehicles);
  }
}
```

The above example demontrates how to insert, remove or update data using the Model. Easy, right? To simplify the update process you can used ObservableList defined in JavaFx. With ObservableLists you do not need a `set()` method to update an item in the list.

Below is an example of added functionalities in the model and some use for the Brand relationship defined earlier.

```java
import java.util.List;

public class TestModel {
    public static void main(String[] args) throws Exception {
      Vehicle vehicle = new Vehicle();

      //Find a vehicle with id 2
      vehicle1 = vehicles.find("2");
      System.out.println(
          "id: "+vehicle1.id+"\n"+
          "Model Name: "+vehicle1.model_name+"\n"+
          "Horse Power: "+vehicle1.horse_power+"\n"+
          "Price: "+vehicle1.price+"\n"
        );


      //Find vehicles where price > 100,000 and price < 2,000,000 and print them out
      List<Vehicle> vehicles = (List<Vehicle>) vehicle.select()
                          .where("price",">",100000)
                          .where("price",">",2000000)
                          .orderByDesc("price")
                          .get();

      for(Vehicle v:vehicles) {
        System.out.println(
          "id: "+v.id+"\n"+
          "Model Name: "+v.model_name+"\n"+
          "Horse Power: "+v.horse_power+"\n"+
          "Price: "+v.price+"\n"+
          "----------------------------------------\n\n"
        );
      }


      //Get all vehicle from the database and print them out.
      vehicles = (List<Vehicle>) vehicle.all();

      for(Vehicle v:vehicles) {
        System.out.println(
          "id: "+v.id+"\n"+
          "Model Name: "+v.model_name+"\n"+
          "Horse Power: "+v.horse_power+"\n"+
          "Price: "+v.price+"\n"+
          "----------------------------------------\n\n"
        );
      }

      //Printing out the related Brand
      for(Vehicle v:vehicles) {
        System.out.println(
          "id: "+v.id+"\n"+
          "Model Name: "+v.model_name+"\n"+
          "Horse Power: "+v.horse_power+"\n"+
          "Brand: "+v.brand().title+"\n"+
          "Price: "+v.price+"\n"+
          "----------------------------------------\n\n"
        );
      }
  }
}
```

## DB Class
You might need a way to read data from the database without creating objects. For this functionality the DB class comes in handy. For the current version,  it can only fetch data. Write and Delete operations are not supported in the DB class. Below is an example of how to use this class.

```java
import com.Tunes_Developers.DB;

public class TestDB {
  public static void main(String[] args) throws Exception {
    ResultSet rs = DB.table("cars")
                    .where("id",20)
                    .orwhere("name","Ractis")
                    .orWhere("price","250000")
                    .get();

    while(rs.next()) {
        System.out.println(
          "id: "+rs.getInt("id")+"\n"+
          "Model Name: "+rs.getString("model_name")+"\n"+
          "Horse Power: "+rs.getString("horse_power")+"\n"+
          "Price: "+rs.getDouble("price")+"\n"
        );
    }
  }
}

```


The Pontious API provides a lot more functionalities. Download this project and check them out. Very soon the JAR file will be in Maven and Gradle. Dont forget to Fork me.
