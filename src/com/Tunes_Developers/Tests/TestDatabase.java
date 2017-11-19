package com.Tunes_Developers.Tests;

import com.Tunes_Developers.Database;
import com.Tunes_Developers.Engine;
import com.Tunes_Developers.Exceptions.PontiousException;

import java.io.IOException;

/**
 * Created by Geoffrey-Kimani on 10/10/2017.
 */
public class TestDatabase {
    public static void main(String[] args) throws Exception {
        Engine engine = new Engine("maria");

        Database db = new Database(3307,"root","J357~</5c0rp10n>",engine);
        db.setDatabaseName("lash");
//        Database dbRemote = new Database("46.101.81.163",3306,"muc","root","secret",engine);

        Database dbRemote = new Database("127.0.0.1",3307,"root","J357~</5c0rp10n>",engine);

        dbRemote.create("lash");
//        db.create("lash");
//        db.drop();
    }
}
