package com.Tunes_Developers;

import com.Tunes_Developers.Exceptions.MissingParameter;
import com.Tunes_Developers.Models.ColumnType;
import com.Tunes_Developers.Models.FakerItem;
import com.Tunes_Developers.Models.ParameterDetails;
import com.Tunes_Developers.Utils.DecodeFakerItem;
import com.Tunes_Developers.Utils.EngineDecoder;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;

/**
 * Created by Geoffrey-Kimani on 10/14/2017.
 */
public class ManipulateData {
    Table table;
    ObservableList<ColumnType> columns = FXCollections.observableArrayList();
    ObservableList<FakerItem> fakerItems = FXCollections.observableArrayList();
    ObservableList<ObservableList<String>> data = FXCollections.observableArrayList();
    int iterations = 0;
    int remainder = 0;
    String columnsFormat = "";

    public ManipulateData(Table table) {
        this.table = table;
    }

    public Table getTable() {
        return table;
    }

    public void cellInt(String column, String data) {
        columns.add(new ColumnType(column, false));
        fakerItems.add(new FakerItem(data));
    }

    public void cellString(String column, String data) {
        columns.add(new ColumnType(column, true));
        fakerItems.add(new FakerItem(data));
    }

    public void cellInt(String column, FakerItem item) {
        columns.add(new ColumnType(column, false));
        fakerItems.add(item);
    }

    public void cellString(String column, FakerItem item) {
        columns.add(new ColumnType(column, true));
        fakerItems.add(item);
    }

    public void updateCellInt(String column, String data) {
        columns.add(new ColumnType(column, true));
        fakerItems.add(new FakerItem(data));
    }

    public void updateCellString(String column, String data) {
        columns.add(new ColumnType(column, true));
        fakerItems.add(new FakerItem(data));
    }

    public SelectStatement select(String... items) throws Exception {
        String allItems = "";

        for (String s : items) {
            allItems += s+", ";
        }

        allItems = allItems.substring(0,allItems.length()-2);
        //Find the specified create statement
        String query = table.getEngineModel().getSelectFormat();

        //Replace all the parameter slots with the correct parameter
        ObservableList<ParameterDetails> details = EngineDecoder.getParameterDetails(query);
        String[] parameters = {allItems,table.getTableName()};
        query = EngineDecoder.replace(details, parameters, query);

        return new SelectStatement(table,query);
    }

//    public void insertRows(int nbRows) throws Exception {
//        String columnsFormat = "";
//
//        for (int i = 0; i < columns.size(); i++) {
//            ColumnType columnType = columns.get(i);
//            columnsFormat += columnType.getColumn();
//
//            if (i < columns.size() - 1) {
//                columnsFormat += ", ";
//            }
//        }
//
//        if (nbRows > 5000) {
//            int iterations = (int) nbRows / 5000;
//            int remainder = nbRows % 5000;
//
//            for (int i = 0; i < iterations; i++) {
//                insertRows(columnsFormat, generateData(5000));
//            }
//
//            if (remainder > 0) {
//                insertRows(columnsFormat, generateData(remainder));
//            }
//        } else {
//            insertRows(columnsFormat, generateData(nbRows));
//        }
//    }

    public void insertRow() throws Exception {
        String columnsFormat = "";

        for (int i = 0; i < columns.size(); i++) {
            ColumnType columnType = columns.get(i);
            columnsFormat += columnType.getColumn();

            if (i < columns.size() - 1) {
                columnsFormat += ", ";
            }
        }

        insertRows(columnsFormat, generateData(1));
    }

    public void updateRow(String primaryKey, String primaryKeyValue) throws Exception {
        String updateFormat = "";

        for (int i = 0; i < columns.size(); i++) {
            ColumnType columnType = columns.get(i);

            if (columnType.isString()) {
                updateFormat += columnType.getColumn() + "= '" + fakerItems.get(i).getData() + "'";
            }else{
                updateFormat += columnType.getColumn() + "= " + fakerItems.get(i).getData();
            }
            columnsFormat += columnType.getColumn();

            if (i < columns.size() - 1) {
                updateFormat += ", ";
            }
        }

        //Find the specified create statement
        String query = table.getEngineModel().getUpdateFormat();

        //Replace all the parameter slots with the correct parameter
        ObservableList<ParameterDetails> details = EngineDecoder.getParameterDetails(query);
        String[] parameters = {table.getTableName(), updateFormat, primaryKey,primaryKeyValue};
        query = EngineDecoder.replace(details, parameters, query);

        try (Connection con = table.getDatabase().openConnection()) {
            con.createStatement().execute(query);
        }
    }

    public void updateRow(String primaryKeyValue) throws Exception {
        String updateFormat = "";

        for (int i = 0; i < columns.size(); i++) {
            ColumnType columnType = columns.get(i);

            if (columnType.isString()) {
                updateFormat += columnType.getColumn() + "= '" + fakerItems.get(i).getData() + "'";
            }else{
                updateFormat += columnType.getColumn() + "= " + fakerItems.get(i).getData();
            }
            columnsFormat += columnType.getColumn();

            if (i < columns.size() - 1) {
                updateFormat += ", ";
            }
        }

        //Find the specified create statement
        String query = table.getEngineModel().getUpdateFormat();

        //Replace all the parameter slots with the correct parameter
        ObservableList<ParameterDetails> details = EngineDecoder.getParameterDetails(query);
        String[] parameters = {table.getTableName(), updateFormat, "id",primaryKeyValue};
        query = EngineDecoder.replace(details, parameters, query);

        try (Connection con = table.getDatabase().openConnection()) {
            con.createStatement().execute(query);
        }
    }

    public void insertRows(int nbRows) {
        Thread thread1,thread2,thread3,thread4,thread5;
        for (int i = 0; i < columns.size(); i++) {
            ColumnType columnType = columns.get(i);
            columnsFormat += columnType.getColumn();

            if (i < columns.size() - 1) {
                columnsFormat += ", ";
            }
        }

        if (nbRows > 5) {
            int nbRowsEach = nbRows/4;
            int nbRemainder = nbRows%4;

            thread1 = new InsertBackground(columns,data,fakerItems,table,columnsFormat,nbRowsEach);
            thread2 = new InsertBackground(columns,data,fakerItems,table,columnsFormat,nbRowsEach);
            thread3 = new InsertBackground(columns,data,fakerItems,table,columnsFormat,nbRowsEach);
            thread4 = new InsertBackground(columns,data,fakerItems,table,columnsFormat,nbRowsEach);

            thread1.start();
            thread2.start();
            thread3.start();
            thread4.start();

            if (remainder > 0) {
                 thread5 = new InsertBackground(columns,data,fakerItems,table,columnsFormat,remainder);
                 thread5.start();
            }
        }else{
            thread1 = new InsertBackground(columns,data,fakerItems,table,columnsFormat,nbRows);
        }
    }

    private void insertRows(String columns, String data) throws Exception {
        //Find the specified create statement
        String query = table.getEngineModel().getInsertMultipleFormat();

        //Replace all the parameter slots with the correct parameter
        ObservableList<ParameterDetails> details = EngineDecoder.getParameterDetails(query);
        String[] parameters = {table.getTableName(), columns, data};
        query = EngineDecoder.replace(details, parameters, query);

        try (Connection con = table.getDatabase().openConnection()) {
            con.createStatement().execute(query);
        }
    }

    public void deleteRow(String primaryKey, String primaryKeyData) throws Exception {
        //Find the specified create statement
        String query = table.getEngineModel().getDeleteFrom();

        //Replace all the parameter slots with the correct parameter
        ObservableList<ParameterDetails> details = EngineDecoder.getParameterDetails(query);
        String[] parameters = {table.getTableName(), primaryKey, primaryKeyData};
        query = EngineDecoder.replace(details, parameters, query);

        try (Connection con = table.getDatabase().openConnection()) {
            con.createStatement().execute(query);
        }
    }

    public void deleteRow(String primaryKeyData) throws Exception {
        //Find the specified create statement
        String query = table.getEngineModel().getDeleteFrom();

        //Replace all the parameter slots with the correct parameter
        ObservableList<ParameterDetails> details = EngineDecoder.getParameterDetails(query);
        String[] parameters = {table.getTableName(), null, primaryKeyData};
        query = EngineDecoder.replace(details, parameters, query);

        try (Connection con = table.getDatabase().openConnection()) {
            con.createStatement().execute(query);
        }
    }

    private String generateData(int nbRows) {
        String dataFormat = "";
        //Decode
        DecodeFakerItem decoder = new DecodeFakerItem(fakerItems);
        data = decoder.generateData(nbRows);

        for (int i = 0; i < nbRows; i++) {
            ObservableList<String> row = data.get(i);
            String rowData = "";

            for (int j = 0; j < row.size(); j++) {
                if (columns.get(j).isString()) {
                    rowData += "'" + row.get(j) + "'";
                } else {
                    rowData += row.get(j);
                }

                if (j < row.size() - 1) {
                    rowData += ", ";
                }
            }

            rowData = "(" + rowData + ")";

            if (i < nbRows - 1) {
                rowData += ", ";
            } else {
                rowData += " ";
            }

            dataFormat += rowData;
        }

        return dataFormat;
    }
}
