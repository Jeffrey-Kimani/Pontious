package com.Tunes_Developers.Tests;

import com.Tunes_Developers.DB;

import java.sql.ResultSet;

/**
 * Created by Geoffrey-Kimani on 12/1/2017.
 */
public class TestDB {
    public static void main(String[] args) throws Exception {
//        ResultSet rs = DB.table("students").where("marks","20").orderBy("marks").get();
//
//        while (rs.next()) {
//            System.out.println(
//                    "Name: "+rs.getString("name")+"\n" +
//                    "Admission: "+rs.getString("adm_no")+"\n" +
//                    "Marks: "+rs.getInt("marks")+"\n" +
//                    "-----------------------------------------\n"
//            );
//        }
        Company company = new Company();
        Car cars = new Car();

        for (Object c : company.all()) {
            Company com = (Company) c;

            System.out.println(
                    "Name: "+com.name+"\n" +
                    "Year Established: "+com.year_established+"\n" +
                    "++++++++++++++++++++++++++++++++++++"
            );

            for (Object o : com.cars()) {
                Car car = (Car) o;

                System.out.println(
                        "Name: " + car.name + "\n" +
                        "Type: " + car.type_id + "\n" +
                        "Price: "+car.price+"\n"
                );
            }

            System.out.println("-----------------------------------------\n");
        }
    }
}
