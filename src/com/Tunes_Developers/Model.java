package com.Tunes_Developers;

import com.Tunes_Developers.Exceptions.MissingParameter;
import com.Tunes_Developers.Models.ParameterDetails;
import com.Tunes_Developers.Utils.EngineDecoder;
import com.Tunes_Developers.models.FakerEnvironment;
import javafx.collections.ObservableList;

import java.lang.reflect.Field;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Geoffrey-Kimani on 11/19/2017.
 */
public class Model {
    protected String tableName;
    protected String primaryKeyColumn;
    protected Table table;
    protected Faker faker;

    public Model() {
        primaryKeyColumn = "id";
    }

    public void createTable() throws Exception {

    }

    public List<?> all() throws Exception {
        return select().get();
    }

    public Object find(int id) throws Exception {
        return select().where(primaryKeyColumn,id).first();
    }

    public SelectStatementModel select() throws Exception {
        //Find the specified create statement
        String query = table.getEngineModel().getSelectFormat();

        //Replace all the parameter slots with the correct parameter
        ObservableList<ParameterDetails> details = EngineDecoder.getParameterDetails(query);
        String[] parameters = {"*",table.getTableName()};
        query = EngineDecoder.replace(details, parameters, query);

        return new SelectStatementModel(table,query,getClass());
    }

    public void delete(String primaryKey) throws Exception {
        ManipulateData manipulateData = new ManipulateData(table);
        manipulateData.deleteRow(primaryKeyColumn,primaryKey);
    }

    public Model generateFakeModel() {
        return this;
    }
}
