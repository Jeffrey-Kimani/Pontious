package com.Tunes_Developers.Tests;

import com.Tunes_Developers.Database;
import com.Tunes_Developers.Engine;
import com.Tunes_Developers.Table;

/**
 * Created by Geoffrey-Kimani on 10/13/2017.
 */
public class TestCreateColumns {
    public static void main(String[] args) throws Exception {
        Engine engine = new Engine("maria");

        Database db = new Database("3307","root","J357~</5c0rp10n>",engine);
        db.create("lash");

        Table tunes = new Table(db, "tunes");


//        System.out.println(tunes.bool("column_bool").getQuery());
//        System.out.println(tunes.date("column_date").getQuery());
//        System.out.println(tunes.time("column_time").getQuery());
//        System.out.println(tunes.dateTime("column_dateTime").getQuery());
//        System.out.println(tunes.timeStamp("column_timeStamp").getQuery());
//        System.out.println(tunes.timeStamps("").getQuery());
//        System.out.println(tunes.Double("column_double").getQuery());
//        System.out.println(tunes.Double("column_doubleConstrain",10,4).getQuery());
//        System.out.println(tunes.Float("column_float").getQuery());
//        System.out.println(tunes.json("column_json").getQuery());
//        System.out.println(tunes.character("column_character").getQuery());
//        System.out.println(tunes.string("column_string").getQuery());
//        System.out.println(tunes.string("column_StringConstrain",230).getQuery());
//        System.out.println(tunes.text("column_text").getQuery());
//        System.out.println(tunes.text("column_textConstrain",400).getQuery());
//        System.out.println(tunes.mediumText("column_mediumText").getQuery());
//        System.out.println(tunes.increment("column_increment").getQuery());
//        System.out.println(tunes.increment("column_incrementConstrain",5).getQuery());
//        System.out.println(tunes.integer("column_integer").getQuery());
//        System.out.println(tunes.integer("column_integerConstrain",4).getQuery());
//        System.out.println(tunes.bigInteger("column_bigInteger").getQuery());
//        System.out.println(tunes.smallInteger("column_smallInteger").getQuery());
//        System.out.println(tunes.tinyInteger("column_tinyInteger").getQuery());
//        System.out.println(tunes.decimal("column_decimal").getQuery());
//        System.out.println(tunes.decimal("column_decimalConstrain",10,4).getQuery());

        System.out.println(tunes.integer("column_integer").unsigned().getQuery());
        System.out.println(tunes.bool("column_bool").setDefault("false").getQuery());
        System.out.println(tunes.Double("milk_production").nullable().getQuery());
        System.out.println(tunes.Double("tyre_width").uniqueIndex("index_tyre_width").getQuery());
        System.out.println(tunes.integer("adm_number").primaryKey().getQuery());
        System.out.println(tunes.integer("id").autoIncrement().getQuery());
        System.out.println(tunes.string("email").unique().getQuery());
        System.out.println(tunes.integer("adm_number").primaryKey().autoIncrement().unique().unsigned().getQuery());
        System.out.println(tunes.bool("column_bool").setDefault("false").setDefault("true").getQuery());
        System.out.println(tunes.Double("tyre_width").uniqueIndex("index_tyre_width").uniqueIndex("index_tyre_width").getQuery());
    }
}
