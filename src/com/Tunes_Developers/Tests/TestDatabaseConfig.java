package com.Tunes_Developers.Tests;

import com.Tunes_Developers.Config;
import com.Tunes_Developers.Database;
import com.Tunes_Developers.ManipulateData;
import com.Tunes_Developers.Table;

import java.util.List;

/**
 * Created by Geoffrey-Kimani on 11/19/2017.
 */
public class TestDatabaseConfig {
    public static void main(String[] args) throws Exception {
        Config config = new Config("C:/Users/Geoffrey-Kimani/Desktop");
        Database db = new Database(config);

        Table table = new Table(db,"students");
        ManipulateData manipulateData = new ManipulateData(table);

//        ResultSet rs = manipulateData.select("*").where("marks",0).get(20);
//
//        while (rs.next()) {
//            System.out.println(
//                    "Admission Number: " + rs.getString("adm_no") + "\n" +
//                            "Name: " + rs.getString("name") + "\n" +
//                            "Marks: " + rs.getInt("marks")+"\n" +
//                            "-------------------------------------------\n"
//            );
//        }

        List<Student> students = (List<Student>) manipulateData.select("*")
                .where("marks",0).get(Student.class,20);

        int count = 1;
        for (Student s : students) {

            System.out.println(count + ".  " + s.toString());
            count++;
        }
    }
}
