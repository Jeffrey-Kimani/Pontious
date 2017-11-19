package com.Tunes_Developers.Tests;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Geoffrey-Kimani on 11/19/2017.
 */
public class OldFormat {
    public static void main(String[] args) throws SQLException {
        //Write Connection Statement
        Connection con = DriverManager.getConnection("jdbc:mariadb://localhost:3307/karis", "small_shephard", "</Q0W4L5Q!>");
        //Write Query
        String query = "SELECT * FROM students";

        //Define a result set
        ResultSet rs = con.createStatement().executeQuery(query);

        //Iterate through result set
        while (rs.next()) {
            //Use the old format of getting integers and strings to get data
            System.out.println(
                    "{ " +
                        "id= "+rs.getInt("id")+
                        ", name= "+rs.getString("name")+
                        ", email= "+rs.getString("email")+
                        ", adm_no= "+rs.getString("adm_no")+
                        ", marks= "+rs.getString("marks")+
                    "}"
            );
        }
    }
}
