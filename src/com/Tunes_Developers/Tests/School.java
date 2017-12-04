package com.Tunes_Developers.Tests;

import com.Tunes_Developers.*;
import com.Tunes_Developers.models.FakerEnvironment;

import java.util.List;

/**
 * Created by Geoffrey-Kimani on 11/23/2017.
 */
public class School extends Model {
    public int id;
    public String title;
    public String created_at;
    public String updated_at;
    String tableName = "school";
    String primaryKeyColumn = "id";

    public School(Config config) throws Exception {
        Database db = new Database(config);
        table = new Table(db,tableName);
        FakerEnvironment fakerEnvironment = config.getConfigModel().getFaker();
        faker = new Faker(fakerEnvironment.getLanguage(), fakerEnvironment.getLanguage());
    }

    public School() {

    }

    @Override
    public void createTable() throws Exception {
        table.increment("id");
        table.string("title",45);
        table.timeStamps();
    }

//    public List<StudentModel> students() throws Exception {
//        return (List<StudentModel>) hasMany(new StudentModel(),"school_id");
//    }
}
