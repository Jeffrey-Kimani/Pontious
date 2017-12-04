package com.Tunes_Developers;

import com.Tunes_Developers.Models.ParameterDetails;
import com.Tunes_Developers.Utils.EngineDecoder;
import javafx.collections.ObservableList;
import java.util.List;

/**
 * Created by Geoffrey-Kimani on 11/19/2017.
 */
public class Model {
    public String tableName;
    protected String primaryKeyColumn;
    protected Database db;
    protected Table table;
    protected Faker faker;
    protected ManipulateData manData;

    public Model(String tableName) throws Exception {
        this.tableName = tableName;
        this.db = new Database();
        this.table = new Table(db,tableName);
        this.manData = new ManipulateData(table);
        primaryKeyColumn = "id";
    }

    public Model(String tableName, String primaryKeyColumn)  {
        this.tableName = tableName;
        this.primaryKeyColumn = primaryKeyColumn;
    }

    public void createTable() throws Exception {

    }

    public List<?> all() throws Exception {
        return select().get();
    }

    public Object find(String id) throws Exception {
        return select().where(primaryKeyColumn,id).first();
    }

    public SelectStatementModel select() throws Exception {
        db = new Database();
        table = new Table(db,tableName);
        //Find the specified create statement
        String query = table.getEngineModel().getSelectFormat();

        //Replace all the parameter slots with the correct parameter
        ObservableList<ParameterDetails> details = EngineDecoder.getParameterDetails(query);
        String[] parameters = {"*",table.getTableName()};
        query = EngineDecoder.replace(details, parameters, query);

        return DB.table(tableName,getClass());
    }

    public void delete(String primaryKey) throws Exception {
        db = new Database();
        table = new Table(db,tableName);
        ManipulateData manipulateData = new ManipulateData(table);
        manipulateData.deleteRow(primaryKeyColumn,primaryKey);
    }

    protected Object hasOne(Model relatedClass,String field,String data) throws Exception {
        return DB.table(relatedClass.tableName,relatedClass.getClass()).where(field,data).first();
    }

    protected List<?> hasMany(Model relatedClass,String field,String data) throws Exception {
        return DB.table(relatedClass.tableName,relatedClass.getClass()).where(field,data).get();
    }

    public Object generateFakeModel() {
        return this;
    }
}
