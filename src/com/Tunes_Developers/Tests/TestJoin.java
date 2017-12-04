package com.Tunes_Developers.Tests;

import com.Tunes_Developers.Database;
import com.Tunes_Developers.Engine;
import com.Tunes_Developers.ManipulateData;
import com.Tunes_Developers.Table;
import com.Tunes_Developers.Utils.FakerDatabase;

import java.sql.ResultSet;

/**
 * Created by Geoffrey-Kimani on 11/17/2017.
 */
public class TestJoin {
    public static void main(String[] args) throws Exception {
        Engine engine = new Engine("mysql");
        FakerDatabase fd = new FakerDatabase("English","Kenya");

        Database db = new Database("3306", "root", "J357~</5c0rp10n>", engine);
        db.create("gari");

        Table students = new Table(db, "cars");
        ManipulateData manipulateData = new ManipulateData(students);

        ResultSet rs = manipulateData.select("cars.name","companies.name","companies.year_established","cars.price")
                .innerJoin("companies")
                .on("cars.company_id","companies.id");

        while (rs.next()) {
            System.out.println(
                    "Company Name: "+
                    rs.getString("companies.name")+"\nCar Model: "+
                    rs.getString("cars.name")+"\nCompany Year Established:"+
                    rs.getString("companies.year_established")+"\nCar Price: "+
                    rs.getInt("cars.price")+"\n"+
                    "-------------------------------------------\n"
            );
        }
    }
}
