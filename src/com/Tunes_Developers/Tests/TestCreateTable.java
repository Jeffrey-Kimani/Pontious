package com.Tunes_Developers.Tests;

import com.Tunes_Developers.Database;
import com.Tunes_Developers.Engine;
import com.Tunes_Developers.Table;

/**
 * Created by Geoffrey-Kimani on 10/13/2017.
 */
public class TestCreateTable {
    public static void main(String[] args) throws Exception {
        Engine engine = new Engine("maria");

        Database db = new Database(3307,"root","J357~</5c0rp10n>",engine);
        db.create("lash");

        Table tunes = new Table(db, "tunes");
        tunes.bool("column_bool");
        tunes.date("column_date");
        tunes.time("column_time");
        tunes.dateTime("column_dateTime");
        tunes.timeStamp("column_timeStamp");
        tunes.timeStamps();
        tunes.Double("column_double");
        tunes.Double("column_doubleConstrain",10,4);
        tunes.Float("column_float");
//        tunes.json("column_json");
        tunes.character("column_character");
        tunes.string("column_string");
        tunes.string("column_StringConstrain",230);
        tunes.text("column_text");
        tunes.text("column_textConstrain",400);
        tunes.mediumText("column_mediumText");
        tunes.increment("column_increment");
//        tunes.increment("column_incrementConstrain",5);
        tunes.integer("column_integer");
        tunes.integer("column_integerConstrain",4);
        tunes.bigInteger("column_bigInteger");
        tunes.smallInteger("column_smallInteger");
        tunes.tinyInteger("column_tinyInteger");
        tunes.decimal("column_decimal");
        tunes.decimal("column_decimalConstrain",10,4);
        tunes.createTable();
//        tunes.createTemporaryTable();

//        tunes.dropTable();
//        tunes.closeConnection();

        Table cows = new Table(db,"cows");
        cows.integer("id").unsigned().autoIncrement().primaryKey().unique();
        cows.string("name").unique();
        cows.string("breed").nullable().unique().unsigned();
        cows.integer("milk_production").unsigned().setDefault("0");
        cows.createTable();

//        cows.dropTable();
//        cows.renameTable("goats");

//        cows.dropColumn("breed");
    }
}
