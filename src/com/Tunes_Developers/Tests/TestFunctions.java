package com.Tunes_Developers.Tests;

import com.Tunes_Developers.Database;
import com.Tunes_Developers.Engine;
import com.Tunes_Developers.ManipulateData;
import com.Tunes_Developers.Table;
import com.Tunes_Developers.Utils.FakerDatabase;

/**
 * Created by Geoffrey-Kimani on 11/14/2017.
 */
public class TestFunctions {
    public static void main(String[] args) throws Exception {
        Engine engine = new Engine("maria");
        FakerDatabase fd = new FakerDatabase("English","Kenya");

        Database db = new Database(3307, "small_shephard", "</Q0W4L5Q!>", engine);
        db.create("karis");

        Table students = new Table(db, "students");
        students.increment("id");
        students.string("name", 150);
        students.string("email", 180);
        students.string("adm_no", 30);
        students.integer("marks", 3);
        students.createTable();

        ManipulateData insert = new ManipulateData(students);
        insert.cellString("name", fd.name());
        insert.cellString("email", fd.emailResource());
        insert.cellString("adm_no",fd.numerify("J##-####-201#"));
        insert.cellInt("marks", fd.numerifyAboveZero("##"));
        insert.insertRows(100);


    }
}
