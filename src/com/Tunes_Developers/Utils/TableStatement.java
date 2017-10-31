package com.Tunes_Developers.Utils;

import com.Tunes_Developers.Exceptions.MissingParameter;
import com.Tunes_Developers.Models.ParameterDetails;
import com.Tunes_Developers.Table;
import javafx.collections.ObservableList;

/**
 * Created by Geoffrey-Kimani on 10/10/2017.
 */
public class TableStatement {
    private String query;
    private Table table;
    private String column;
    private ObservableList<String> columns;

    public TableStatement(Table table,String column) {
        this.column = column;
        columns = table.getColumns();
        this.table = table;
        this.query = columns.get(columns.size()-1);
    }

    public String getQuery() {
        return query;
    }

    public TableStatement setDefault(String defaultValue) {
        String definedQuery = table.getEngineModel().getMakeDefault();

        if (!this.query.contains("DEFAULT")) {
            //Find the specified create statement

            //Replace all the parameter slots with the correct parameter
            ObservableList<ParameterDetails> details = EngineDecoder.getParameterDetails(definedQuery);
            definedQuery = EngineDecoder.replace(details.get(0),defaultValue,definedQuery);

            //Construct new query
            this.query += " "+definedQuery;
        }

        //Set the new query to the table columns list
        columns.set(columns.size()-1,this.query);

        //Set up the new columns list in the table class
        table.setColumns(columns);

        //Return a table Statement Class to provide nullable and other fields
        return new TableStatement(table,column);
    }

    public TableStatement nullable() {
        if (this.query.contains("NOT NULL")) {
            this.query = query.substring(0,query.indexOf("NOT NULL"))+table.getEngineModel().getMakeNullable()+
                    query.substring(query.indexOf("NOT NULL")+8,query.length());
        }else{
            this.query = this.query + table.getEngineModel().getMakeNullable();
        }
        //Set the new query to the table columns list
        columns.set(columns.size()-1,query);

        //Set up the new columns list in the table class
        table.setColumns(columns);

        //Return a table Statement Class to provide nullable and other fields
        return new TableStatement(table,column);
    }

    public TableStatement uniqueIndex(String indexName) throws MissingParameter {
        String definedQuery = table.getEngineModel().getMakeUniqueIndex();

        if (!this.query.contains("INDEX")) {
            //Find the specified create statement

            //Replace all the parameter slots with the correct parameter
            ObservableList<ParameterDetails> details = EngineDecoder.getParameterDetails(definedQuery);
            String[] parameters = {indexName,table.getTableName(),column};
            definedQuery = EngineDecoder.replace(details,parameters,definedQuery);

            //Construct new query
            this.query += " "+definedQuery;
        }

        //Set the new query to the table columns list
        columns.set(columns.size()-1,this.query);

        //Set up the new columns list in the table class
        table.setColumns(columns);

        //Return a table Statement Class to provide nullable and other fields
        return new TableStatement(table,column);
    }

    public TableStatement unsigned() {
        if (!query.contains(table.getEngineModel().getMakeUnsigned())) {
            if (query.contains("NOT NULL")) {
                this.query = this.query.substring(0,query.indexOf("NOT NULL"))+table.getEngineModel().getMakeUnsigned()
                        +" "+this.query.substring(query.indexOf("NOT NULL")+8,query.length());

                //Set the new query to the table columns list
                columns.set(columns.size()-1,query);

                //Set up the new columns list in the table class
                table.setColumns(columns);
            }
        }

        //Return a table Statement Class to provide nullable and other fields
        return new TableStatement(table,column);
    }

    public TableStatement primaryKey() {
        if (!query.contains(table.getEngineModel().getMakePrimaryKey())) {
            this.query = this.query +" "+ table.getEngineModel().getMakePrimaryKey();

            //Set the new query to the table columns list
            columns.set(columns.size()-1,query);

            //Set up the new columns list in the table class
            table.setColumns(columns);
        }

        //Return a table Statement Class to provide nullable and other fields
        return new TableStatement(table,column);
    }

    public TableStatement autoIncrement() {
        if (!query.contains(table.getEngineModel().getMakeAutoIncrement())) {
            this.query = this.query +" "+ table.getEngineModel().getMakeAutoIncrement();

            //Set the new query to the table columns list
            columns.set(columns.size()-1,query);

            //Set up the new columns list in the table class
            table.setColumns(columns);
        }

        //Return a table Statement Class to provide nullable and other fields
        return new TableStatement(table,column);
    }

    public TableStatement unique() {
        if (!query.contains(table.getEngineModel().getMakeUnique())) {
            this.query = this.query +" "+ table.getEngineModel().getMakeUnique();

            //Set the new query to the table columns list
            columns.set(columns.size()-1,query);

            //Set up the new columns list in the table class
            table.setColumns(columns);
        }

        //Return a table Statement Class to provide nullable and other fields
        return new TableStatement(table,column);
    }
}
