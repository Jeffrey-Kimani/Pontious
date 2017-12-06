package com.Tunes_Developers.Tests;

import com.Tunes_Developers.*;
import com.Tunes_Developers.Exceptions.MissingParameter;
import com.Tunes_Developers.models.FakerEnvironment;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Geoffrey-Kimani on 11/19/2017.
 */
public class StudentModel extends Model {
    String tableName = "students";
    String primaryKeyColumn = "id";

    //Database Fields
    public int id;
    public String name;
    public String email;
    public String adm_no;
    public int marks;

    public StudentModel(Config config) throws Exception {
        super("school");
        Database db = new Database(config);
        table = new Table(db,tableName);
        FakerEnvironment fakerEnvironment = config.getConfigModel().getFaker();
        faker = new Faker(fakerEnvironment.getLanguage(), fakerEnvironment.getLanguage());
    }

    public StudentModel() throws Exception {
        super("school");

    }

    public StudentModel(int id, String name, String email, String adm_no, int marks) throws Exception {
        super("school");
        this.id = id;
        this.name = name;
        this.email = email;
        this.adm_no = adm_no;
        this.marks = marks;
    }

    @Override
    public void createTable() throws Exception {
        table.increment("id");
        table.string("name", 150);
        table.string("email", 180);
        table.string("adm_no", 30);
        table.integer("marks", 3);
        table.createTable();
    }

    @Override
    public Model generateFakeModel() throws Exception {
        return new StudentModel(
               Integer.parseInt(faker.numerifyAboveZero("######")),
                faker.name(),
                faker.emailResource(),
                faker.numerifyAboveZero("J##-####-201#"),
                Integer.parseInt(faker.numerifyAboveZero("##"))
        );
    }

    public void delete(List<StudentModel> items) throws Exception {
        ManipulateData manipulateData = new ManipulateData(table);
        for (StudentModel studentModel : items) {
            manipulateData.deleteRow(primaryKeyColumn,studentModel.id+"");
        }
    }

    public void save(List<StudentModel> items) throws Exception {
        for (StudentModel studentModel : items) {
            ManipulateData manipulateData = new ManipulateData(table);

            manipulateData.cellInt("id",studentModel.id+"");
            manipulateData.cellString("adm_no",studentModel.adm_no);
            manipulateData.cellString("name",studentModel.name);
            manipulateData.cellString("email",studentModel.email);
            manipulateData.cellInt("marks",studentModel.marks+"");
            manipulateData.insertRow();
        }
    }

    public void update(List<StudentModel> items) throws Exception {
        for (StudentModel studentModel : items) {
            ManipulateData manipulateData = new ManipulateData(table);

            manipulateData.cellString("adm_no",studentModel.adm_no);
            manipulateData.cellString("name",studentModel.name);
            manipulateData.cellString("email",studentModel.email);
            manipulateData.cellInt("marks",studentModel.marks+"");
            manipulateData.updateRow(studentModel.id+"");
        }
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", adm_no='" + adm_no + '\'' +
                ", marks=" + marks +
                '}';
    }
}
