package com.Tunes_Developers;


import com.Tunes_Developers.Exceptions.MissingParameter;
import com.Tunes_Developers.Models.EngineModel;
import com.Tunes_Developers.Models.ParameterDetails;
import com.Tunes_Developers.Utils.EngineDecoder;
import com.Tunes_Developers.Utils.TableStatement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Geoffrey-Kimani on 10/10/2017.
 */
public class Table {
    private Database database;
    private String tableName;
    private String query;
    private EngineModel engineModel;
    private ObservableList<String> columns = FXCollections.observableArrayList();
    private String column;

    public Table(Database database, String tableName) throws Exception {
        this.database = database;
        this.tableName = tableName;
        engineModel = database.getEngine().getModel();
    }

    public Database getDatabase() {
        return database;
    }

    public String getTableName() {
        return tableName;
    }

    public void setColumns(ObservableList<String> columns) {
        this.columns = columns;
    }

    public ObservableList<String> getColumns() {
        return columns;
    }

    public EngineModel getEngineModel() {
        return engineModel;
    }

    public TableStatement bool(String column) {
        //Find the specified create statement
        String query = engineModel.getCreateBool();

        //Replace all the parameter slots with the correct parameter
        ObservableList<ParameterDetails> details = EngineDecoder.getParameterDetails(query);
        query = EngineDecoder.replace(details.get(0),column,query);

        //Push the new query to the queries list
        columns.add(query);

        //Return a table Statement Class to provide nullable and other fields
        return new TableStatement(this,column);
    }

    public TableStatement date(String column) {
        //Find the specified create statement
        String query = engineModel.getCreateDate();

        //Replace all the parameter slots with the correct parameter
        ObservableList<ParameterDetails> details = EngineDecoder.getParameterDetails(query);
        query = EngineDecoder.replace(details.get(0),column,query);

        //Push the new query to the queries list
        columns.add(query);

        //Return a table Statement Class to provide nullable and other fields
        return new TableStatement(this,column);
    }

    public TableStatement time(String column) {
        //Find the specified create statement
        String query = engineModel.getCreateTime();

        //Replace all the parameter slots with the correct parameter
        ObservableList<ParameterDetails> details = EngineDecoder.getParameterDetails(query);
        query = EngineDecoder.replace(details.get(0),column,query);

        //Push the new query to the queries list
        columns.add(query);

        //Return a table Statement Class to provide nullable and other fields
        return new TableStatement(this,column);
    }

    public TableStatement dateTime(String column) {
        //Find the specified create statement
        String query = engineModel.getCreateDateTime();

        //Replace all the parameter slots with the correct parameter
        ObservableList<ParameterDetails> details = EngineDecoder.getParameterDetails(query);
        query = EngineDecoder.replace(details.get(0),column,query);

        //Push the new query to the queries list
        columns.add(query);

        //Return a table Statement Class to provide nullable and other fields
        return new TableStatement(this,column);
    }

    public TableStatement timeStamp(String column) {
        //Find the specified create statement
        String query = engineModel.getCreateTimestamp();

        //Replace all the parameter slots with the correct parameter
        ObservableList<ParameterDetails> details = EngineDecoder.getParameterDetails(query);
        query = EngineDecoder.replace(details.get(0),column,query);

        //Push the new query to the queries list
        columns.add(query);

        //Return a table Statement Class to provide nullable and other fields
        return new TableStatement(this,column);
    }

    public TableStatement timeStamps() {
        //Find the specified create statement
        String query = engineModel.getCreateTimestamps();

        //Push the new query to the queries list
        columns.add(query);

        //Return a table Statement Class to provide nullable and other fields
        return new TableStatement(this,column);
    }

    public TableStatement Double(String column, int nbTotalDigits, int nbDecimalPoints) throws MissingParameter {
        //Find the specified create statement
        String query = engineModel.getCreateDecimal();

        //Replace all the parameter slots with the correct parameter
        ObservableList<ParameterDetails> details = EngineDecoder.getParameterDetails(query);
        String[] parameters = {column,nbTotalDigits+"",nbDecimalPoints+""};
        query = EngineDecoder.replace(details,parameters,query);


        //Push the new query to the queries list
        columns.add(query);

        //Return a table Statement Class to provide nullable and other fields
        return new TableStatement(this,column);
    }

    public TableStatement Double(String column) throws MissingParameter {
        //Find the specified create statement
        String query = engineModel.getCreateDecimal();

        //Replace all the parameter slots with the correct parameter
        ObservableList<ParameterDetails> details = EngineDecoder.getParameterDetails(query);
        String[] parameters = {column,null,null};
        query = EngineDecoder.replace(details,parameters,query);


        //Push the new query to the queries list
        columns.add(query);

        //Return a table Statement Class to provide nullable and other fields
        return new TableStatement(this,column);
    }

    public TableStatement Float(String column) {
        //Find the specified create statement
        String query = engineModel.getCreateFloat();

        //Replace all the parameter slots with the correct parameter
        ObservableList<ParameterDetails> details = EngineDecoder.getParameterDetails(query);
        query = EngineDecoder.replace(details.get(0),column,query);

        //Push the new query to the queries list
        columns.add(query);

        //Return a table Statement Class to provide nullable and other fields
        return new TableStatement(this,column);
    }

    public TableStatement json(String column) {
        //Find the specified create statement
        String query = engineModel.getCreateJson();

        //Replace all the parameter slots with the correct parameter
        ObservableList<ParameterDetails> details = EngineDecoder.getParameterDetails(query);
        query = EngineDecoder.replace(details.get(0),column,query);

        //Push the new query to the queries list
        columns.add(query);

        //Return a table Statement Class to provide nullable and other fields
        return new TableStatement(this,column);
    }

    public TableStatement character(String column) throws MissingParameter {
        //Find the specified create statement
        String query = engineModel.getCreateCharacter();

        //Replace all the parameter slots with the correct parameter
        ObservableList<ParameterDetails> details = EngineDecoder.getParameterDetails(query);
        String[] parameters = {column,null};
        query = EngineDecoder.replace(details,parameters,query);


        //Push the new query to the queries list
        columns.add(query);

        //Return a table Statement Class to provide nullable and other fields
        return new TableStatement(this,column);
    }

    public TableStatement string(String column) {
        //Find the specified create statement
        String query = engineModel.getCreateString();

        //Replace all the parameter slots with the correct parameter
        ObservableList<ParameterDetails> details = EngineDecoder.getParameterDetails(query);
        query = EngineDecoder.replace(details.get(0),column,query);

        //Push the new query to the queries list
        columns.add(query);

        //Return a table Statement Class to provide nullable and other fields
        return new TableStatement(this,column);
    }

    public TableStatement string(String column, int constrain) throws MissingParameter {
        if (constrain < 255) {
            //Find the specified create statement
            String query = engineModel.getCreateStringConstrain();

            //Replace all the parameter slots with the correct parameter
            ObservableList<ParameterDetails> details = EngineDecoder.getParameterDetails(query);
            String[] parameters = {column,constrain+""};
            query = EngineDecoder.replace(details,parameters,query);

            //Push the new query to the queries list
            columns.add(query);

            //Return a table Statement Class to provide nullable and other fields
            return new TableStatement(this,column);
        }else{
           return text(column,constrain);
        }
    }

    public TableStatement text(String column) throws MissingParameter {
        //Find the specified create statement
        String query = engineModel.getCreateText();

        //Replace all the parameter slots with the correct parameter
        ObservableList<ParameterDetails> details = EngineDecoder.getParameterDetails(query);
        String[] parameters = {column,null};
        query = EngineDecoder.replace(details,parameters,query);

        //Push the new query to the queries list
        columns.add(query);

        //Return a table Statement Class to provide nullable and other fields
        return new TableStatement(this,column);
    }

    public TableStatement text(String column,int constrain) throws MissingParameter {
        //Find the specified create statement
        String query = engineModel.getCreateText();

        //Replace all the parameter slots with the correct parameter
        ObservableList<ParameterDetails> details = EngineDecoder.getParameterDetails(query);
        String[] parameters = {column,constrain+""};
        query = EngineDecoder.replace(details,parameters,query);

        //Push the new query to the queries list
        columns.add(query);

        //Return a table Statement Class to provide nullable and other fields
        return new TableStatement(this,column);
    }

    public TableStatement mediumText(String column) {
        //Find the specified create statement
        String query = engineModel.getCreateMediumText();

        //Replace all the parameter slots with the correct parameter
        ObservableList<ParameterDetails> details = EngineDecoder.getParameterDetails(query);
        query = EngineDecoder.replace(details.get(0),column,query);

        //Push the new query to the queries list
        columns.add(query);

        //Return a table Statement Class to provide nullable and other fields
        return new TableStatement(this,column);
    }

    public TableStatement increment(String column) {
        //Find the specified create statement
        String query = engineModel.getCreateIncrement();

        //Replace all the parameter slots with the correct parameter
        ObservableList<ParameterDetails> details = EngineDecoder.getParameterDetails(query);
        query = EngineDecoder.replace(details.get(0),column,query);

        //Push the new query to the queries list
        columns.add(query);

        //Return a table Statement Class to provide nullable and other fields
        return new TableStatement(this,column);
    }

    public TableStatement increment(String column, int constrain) throws MissingParameter {
        //Find the specified create statement
        String query = engineModel.getCreateIncrementConstrain();

        //Replace all the parameter slots with the correct parameter
        ObservableList<ParameterDetails> details = EngineDecoder.getParameterDetails(query);
        String[] parameters = {column,constrain+""};
        query = EngineDecoder.replace(details,parameters,query);

        //Push the new query to the queries list
        columns.add(query);

        //Return a table Statement Class to provide nullable and other fields
        return new TableStatement(this,column);
    }

    public TableStatement integer(String column) throws MissingParameter {
        //Find the specified create statement
        String query = engineModel.getCreateInteger();

        //Replace all the parameter slots with the correct parameter
        ObservableList<ParameterDetails> details = EngineDecoder.getParameterDetails(query);
        String[] parameters = {column,null,null};
        query = EngineDecoder.replace(details,parameters,query);


        //Push the new query to the queries list
        columns.add(query);

        //Return a table Statement Class to provide nullable and other fields
        return new TableStatement(this,column);
    }

    public TableStatement integer(String column, int constrain) throws MissingParameter {
        //Find the specified create statement
        String query = engineModel.getCreateInteger();

        //Replace all the parameter slots with the correct parameter
        ObservableList<ParameterDetails> details = EngineDecoder.getParameterDetails(query);
        String[] parameters = {column,constrain+""};
        query = EngineDecoder.replace(details,parameters,query);

        //Push the new query to the queries list
        columns.add(query);

        //Return a table Statement Class to provide nullable and other fields
        return new TableStatement(this,column);
    }

    public TableStatement bigInteger(String column) {
        //Find the specified create statement
        String query = engineModel.getCreateBigInteger();

        //Replace all the parameter slots with the correct parameter
        ObservableList<ParameterDetails> details = EngineDecoder.getParameterDetails(query);
        query = EngineDecoder.replace(details.get(0),column,query);

        //Push the new query to the queries list
        columns.add(query);

        //Return a table Statement Class to provide nullable and other fields
        return new TableStatement(this,column);
    }

    public TableStatement smallInteger(String column) {
        //Find the specified create statement
        String query = engineModel.getCreateSmallInteger();

        //Replace all the parameter slots with the correct parameter
        ObservableList<ParameterDetails> details = EngineDecoder.getParameterDetails(query);
        query = EngineDecoder.replace(details.get(0),column,query);

        //Push the new query to the queries list
        columns.add(query);

        //Return a table Statement Class to provide nullable and other fields
        return new TableStatement(this,column);
    }

    public TableStatement tinyInteger(String column) {
        //Find the specified create statement
        String query = engineModel.getCreateTinyInteger();

        //Replace all the parameter slots with the correct parameter
        ObservableList<ParameterDetails> details = EngineDecoder.getParameterDetails(query);
        query = EngineDecoder.replace(details.get(0),column,query);

        //Push the new query to the queries list
        columns.add(query);

        //Return a table Statement Class to provide nullable and other fields
        return new TableStatement(this,column);
    }

    public TableStatement decimal(String column) throws MissingParameter {
        //Find the specified create statement
        String query = engineModel.getCreateDecimal();

        //Replace all the parameter slots with the correct parameter
        ObservableList<ParameterDetails> details = EngineDecoder.getParameterDetails(query);
        String[] parameters = {column,null,null};
        query = EngineDecoder.replace(details,parameters,query);


        //Push the new query to the queries list
        columns.add(query);

        //Return a table Statement Class to provide nullable and other fields
        return new TableStatement(this,column);
    }

    public TableStatement decimal(String column, int nbTotalDigits, int nbDecimalPoints) throws MissingParameter {
        //Find the specified create statement
        String query = engineModel.getCreateDecimal();

        //Replace all the parameter slots with the correct parameter
        ObservableList<ParameterDetails> details = EngineDecoder.getParameterDetails(query);
        String[] parameters = {column,nbTotalDigits+"",nbDecimalPoints+""};
        query = EngineDecoder.replace(details,parameters,query);

        //Push the new query to the queries list
        columns.add(query);

        //Return a table Statement Class to provide nullable and other fields
        return new TableStatement(this,column);
    }

    public void createTable() throws MissingParameter, SQLException {
        String allColumns = "";
        for (String s : columns) {
            allColumns += s+", ";
        }

        if (allColumns.length() < 1) {

        }else{
            //Find the specified create statement
            String query = engineModel.getCreateTable();

            //Replace all the parameter slots with the correct parameter
            ObservableList<ParameterDetails> details = EngineDecoder.getParameterDetails(query);
            String[] parameters = {tableName,allColumns.substring(0,allColumns.length()-2)};
            query = EngineDecoder.replace(details,parameters,query);

            try (Connection con = getDatabase().openConnection()) {
                con.createStatement().execute(query);
            }
        }
    }

    public void createTemporaryTable() throws MissingParameter, SQLException {
        String allColumns = "";
        for (String s : columns) {
            allColumns += s+", ";
        }

        if (allColumns.length() < 1) {

        }else{
            //Find the specified create statement
            String query = engineModel.getCreateTemporaryTable();

            //Replace all the parameter slots with the correct parameter
            ObservableList<ParameterDetails> details = EngineDecoder.getParameterDetails(query);
            String[] parameters = {tableName,allColumns.substring(0,allColumns.length()-2)};
            query = EngineDecoder.replace(details,parameters,query);

            try (Connection con = getDatabase().openConnection()) {
                con.createStatement().execute(query);
            }
        }
    }

    public void dropTable() throws SQLException {
        //Find the specified create statement
        String query = engineModel.getDropTable();

        //Replace all the parameter slots with the correct parameter
        ObservableList<ParameterDetails> details = EngineDecoder.getParameterDetails(query);
        query = EngineDecoder.replace(details.get(0),tableName,query);

        try (Connection con = getDatabase().openConnection()) {
            con.createStatement().execute(query);
        }
    }

    public void dropColumn(String columnName) throws MissingParameter, SQLException {
        //Find the specified create statement
        String query = engineModel.getDropColumn();

        //Replace all the parameter slots with the correct parameter
        ObservableList<ParameterDetails> details = EngineDecoder.getParameterDetails(query);
        String[] parameters = {tableName,columnName};
        query = EngineDecoder.replace(details,parameters,query);

        try (Connection con = getDatabase().openConnection()) {
            con.createStatement().execute(query);
        }
    }

    public void renameTable(String newName) throws MissingParameter, SQLException {
        //Find the specified create statement
        String query = engineModel.getAlterTable();

        //Replace all the parameter slots with the correct parameter
        ObservableList<ParameterDetails> details = EngineDecoder.getParameterDetails(query);
        String[] parameters = {tableName,newName};
        query = EngineDecoder.replace(details,parameters,query);

        try (Connection con = getDatabase().openConnection()) {
            con.createStatement().execute(query);
        }
    }
}
