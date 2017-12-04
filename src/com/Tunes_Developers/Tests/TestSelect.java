package com.Tunes_Developers.Tests;

import com.Tunes_Developers.Database;
import com.Tunes_Developers.Engine;
import com.Tunes_Developers.ManipulateData;
import com.Tunes_Developers.Table;
import com.Tunes_Developers.Utils.FakerDatabase;

import java.sql.ResultSet;

/**
 * Created by Geoffrey-Kimani on 11/14/2017.
 */
public class TestSelect {
    public static void main(String[] args) throws Exception{
        Engine engine = new Engine("mysql");
        FakerDatabase fd = new FakerDatabase("English","Kenya");

        Database db = new Database("3306", "root", "J357~</5c0rp10n>", engine);
        db.create("karis");

        Table students = new Table(db, "students");
        students.increment("id");
        students.string("name", 150);
        students.string("email", 180);
        students.string("adm_no", 30);
        students.integer("marks", 3);
        students.createTable();

        ManipulateData manipulateData = new ManipulateData(students);

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

//        ResultSet rs =
//                manipulateData.select("id","name","adm_no","marks")
//                        .where("marks",82)
//                        .get();
//
//        while (rs.next()) {
//            System.out.println(
//                    rs.getInt("id")+"\n"+
//                            rs.getString("name")+"\n"+
//                            rs.getInt("marks")+
//                            "\n------------------------------------\n"
//            );
//        }

//        ResultSet rs =
//                manipulateData.select("id","name","adm_no","marks")
//                        .where("name","Amanda Mutenyo")
//                        .get();
//
//        while (rs.next()) {
//            System.out.println(
//                    rs.getInt("id")+"\n"+
//                            rs.getString("name")+"\n"+
//                            rs.getInt("marks")+
//                            "\n------------------------------------\n"
//            );
//        }

//        ResultSet rs =
//                manipulateData.select("id","name","adm_no","marks")
//                        .where("marks",">=",87)
//                        .get();
//
//        while (rs.next()) {
//            System.out.println(
//                    rs.getInt("id")+"\n"+
//                            rs.getString("name")+"\n"+
//                            rs.getInt("marks")+
//                            "\n------------------------------------\n"
//            );
//        }

//        ResultSet rs =
//                manipulateData.select("id","name","adm_no","marks")
//                        .where("name","<","Amanda Mutenyo")
//                        .get();
//
//        while (rs.next()) {
//            System.out.println(
//                    rs.getInt("id")+"\n"+
//                            rs.getString("name")+"\n"+
//                            rs.getInt("marks")+
//                            "\n------------------------------------\n"
//            );
//        }

//        ResultSet rs =
//                manipulateData.select("id","name","adm_no","marks")
//                        .whereLike("name","amanda%")
//                        .get();
//
//        while (rs.next()) {
//            System.out.println(
//                    rs.getInt("id")+"\n"+
//                            rs.getString("name")+"\n"+
//                            rs.getInt("marks")+
//                            "\n------------------------------------\n"
//            );
//        }

//        ResultSet rs =
//                manipulateData.select("id","name","adm_no","marks")
//                        .whereNotLike("name","a%")
//                        .get();
//
//        while (rs.next()) {
//            System.out.println(
//                    rs.getInt("id")+"\n"+
//                            rs.getString("name")+"\n"+
//                            rs.getInt("marks")+
//                            "\n------------------------------------\n"
//            );
//        }

//        ResultSet rs =
//                manipulateData.select("id","name","adm_no","marks")
//                        .whereLike("name","amanda%")
//                        .get();
//
//        while (rs.next()) {
//            System.out.println(
//                    rs.getInt("id")+"\n"+
//                            rs.getString("name")+"\n"+
//                            rs.getInt("marks")+
//                            "\n------------------------------------\n"
//            );
//        }

//        ResultSet rs =
//                manipulateData.select("id","name","adm_no","marks")
//                        .whereLike("name","amanda%")
//                        .where("marks",">",70)
//                        .get();
//
//        while (rs.next()) {
//            System.out.println(
//                    rs.getInt("id")+"\n"+
//                            rs.getString("name")+"\n"+
//                            rs.getInt("marks")+
//                            "\n------------------------------------\n"
//            );
//        }

//        ResultSet rs =
//                manipulateData.select("id","name","adm_no","marks")
//                        .where("marks",0)
//                        .orWhere("marks",10)
//                        .get();
//
//        while (rs.next()) {
//            System.out.println(
//                    rs.getInt("id")+"\n"+
//                            rs.getString("name")+"\n"+
//                            rs.getInt("marks")+
//                            "\n------------------------------------\n"
//            );
//        }

//        ResultSet rs =
//                manipulateData.select("id","name","adm_no","marks")
//                        .where("marks",0)
//                        .orWhere("marks",10)
//                        .orderByDesc("name")
//                        .get();
//
//        while (rs.next()) {
//            System.out.println(
//                    rs.getInt("id")+"\n"+
//                            rs.getString("name")+"\n"+
//                            rs.getInt("marks")+
//                            "\n------------------------------------\n"
//            );
//        }

        ResultSet rs =
                manipulateData.select("id","name","adm_no","marks")
                        .where("marks",0)
                        .orWhere("marks",10)
                        .orderByDesc("name")
                        .get(5);

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
