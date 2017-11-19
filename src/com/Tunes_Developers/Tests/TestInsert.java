package com.Tunes_Developers.Tests;

import com.Tunes_Developers.Database;
import com.Tunes_Developers.Engine;
import com.Tunes_Developers.ManipulateData;
import com.Tunes_Developers.Table;
import com.Tunes_Developers.Utils.FakerDatabase;

import java.sql.ResultSet;

/**
 * Created by Geoffrey-Kimani on 10/14/2017.
 */
public class TestInsert {
    public static void main(String[] args) throws Exception {
        Engine engine = new Engine("maria");
        FakerDatabase fd = new FakerDatabase("English","Kenya");

        Database db = new Database(3307, "root", "J357~</5c0rp10n>", engine);
        db.create("karis");

        Table students = new Table(db, "students");
        students.increment("id");
        students.string("name", 150);
        students.string("email", 180);
        students.string("adm_no", 30);
        students.integer("marks", 3);
        students.createTable();

        ManipulateData manipulateData = new ManipulateData(students);
        manipulateData.updateCellString("name","Mercy Mwaniki");
        manipulateData.updateCellString("email","mercym@gmail.com");
        manipulateData.updateCellString("adm_no","J17-7766-2015");
        manipulateData.updateCellInt("marks","90");
//
//        long currentTime = System.nanoTime();
//        manipulateData.insertRows(100000);
//        double elapsedTime = (double) (System.nanoTime() - currentTime)/1000000000;

//        System.out.println(elapsedTime);

//        manipulateData.cellString("name", "Geoffrey Kariithi");
//        manipulateData.cellString("email", "geoffreykariithi@gmail.com");
//        manipulateData.cellString("adm_no","J17-5544-2015");
//        manipulateData.cellInt("marks", "98");
//        manipulateData.insertRow();

//        manipulateData.updateRow("2");

//        manipulateData.deleteRow("2");

//        ResultSet rs = manipulateData.select("id","name","adm_no").get();
//
//        while (rs.next()) {
//            System.out.println(
//                    rs.getInt("id")+"\n"+
//                    rs.getString("name")+"\n"+
//                    rs.getString("adm_no")+
//                    "\n------------------------------------\n"
//            );
//        }

        ResultSet rs =
                manipulateData.select("id","name","adm_no","marks")
                .where("marks",82)
                .get();

        while (rs.next()) {
            System.out.println(
                    rs.getInt("id")+"\n"+
                            rs.getString("name")+"\n"+
                            rs.getInt("marks")+
                            "\n------------------------------------\n"
            );
        }
    }
}
