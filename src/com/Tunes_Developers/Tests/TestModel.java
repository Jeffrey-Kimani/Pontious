package com.Tunes_Developers.Tests;

import com.Tunes_Developers.Config;
import com.Tunes_Developers.Database;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Geoffrey-Kimani on 11/19/2017.
 */
public class TestModel {
    public static void main(String[] args) throws Exception {
        Config config = new Config("C:/Users/Geoffrey-Kimani/Desktop");
        List<StudentModel> students;
        StudentModel student = new StudentModel(config);

        StudentModel student1 = (StudentModel) student.find(23);
//        System.out.println(student1.toString());


//      students = (List<StudentModel>) student.all();


        students = (List<StudentModel>) student.select()
                .where("marks",">",50)
                .orderBy("name")
                .get(20);

        int count = 1;
        for (StudentModel s : students) {
//            System.out.println(count+".  "+s.toString());
            count++;
        }

        List<StudentModel> generatedStudents = new ArrayList<>();
        for(int i=0;i<10;i++) {
            StudentModel s = (StudentModel) student.generateFakeModel();
            generatedStudents.add(s);
            System.out.println(s.toString());
        }

        student.save(generatedStudents);
        student.delete(generatedStudents);
    }
}
