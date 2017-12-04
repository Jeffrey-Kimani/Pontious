package com.Tunes_Developers;

import com.Tunes_Developers.Models.ParameterDetails;
import com.Tunes_Developers.Utils.EngineDecoder;
import javafx.collections.ObservableList;

/**
 * Created by Geoffrey-Kimani on 12/1/2017.
 */
public class DB {
    private static Database db;
    private static Table dbTable;
    private static SelectStatementModel selectStatementModel;

    public static SelectStatement table(String table) throws Exception {
        db = new Database();
        dbTable = new Table(db,table);
        ManipulateData manipulateData = new ManipulateData(dbTable);
        return manipulateData.select("*");
    }

    public static SelectStatementModel table(String table,Class<?> Class) throws Exception {
        //Initialize the required variables
        db = new Database();
        dbTable = new Table(db,table);

        //Find the specified create statement
        String query = dbTable.getEngineModel().getSelectFormat();

        //Replace all the parameter slots with the correct parameter
        ObservableList<ParameterDetails> details = EngineDecoder.getParameterDetails(query);
        String[] parameters = {"*",dbTable.getTableName()};
        query = EngineDecoder.replace(details, parameters, query);

        //Return the class SelectStatementModel to manipulate data
        return new SelectStatementModel(dbTable,query,Class);
    }
}
