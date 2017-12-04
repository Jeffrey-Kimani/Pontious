package com.Tunes_Developers;

import com.Tunes_Developers.Exceptions.JoinStatementException;
import com.Tunes_Developers.Exceptions.MissingParameter;
import com.Tunes_Developers.Exceptions.OrderByException;
import com.Tunes_Developers.Exceptions.WhereException;
import com.Tunes_Developers.Models.ParameterDetails;
import com.Tunes_Developers.Utils.EngineDecoder;
import javafx.collections.ObservableList;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import javax.xml.crypto.Data;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Geoffrey-Kimani on 11/14/2017.
 */
public class SelectStatement {
    private String query;
    private Table table;
    private boolean whereUsed;
    private boolean orderByUsed;
    private boolean innerJoinUsed = false;

    public SelectStatement(Table table,String query) {
        this.query = query;
        this.table = table;
    }

    public SelectStatement where(String column, String columnData) throws Exception {
        if (whereUsed) {
            //Find the specified create statement
            String query = table.getEngineModel().getWhereFormat();

            //Replace all the parameter slots with the correct parameter
            ObservableList<ParameterDetails> details = EngineDecoder.getParameterDetails(query);
            String[] parameters = {column,null,"'"+columnData+"'"};
            query = EngineDecoder.replace(details, parameters, query);

            //Find Where position
            int positionWhere = query.indexOf("WHERE");
            query = query.substring(0,positionWhere)+query.substring(positionWhere+6,query.length());

            int positionBracket = this.query.lastIndexOf(')');

            //Clean up the query statement by inserting where clause in the correct position
            this.query = this.query.substring(0, positionBracket) + " && "+ query +
                    this.query.substring(positionBracket, this.query.length());

            return this;
        } else {
            String query1 = table.getEngineModel().getMultipleWhere();
            //Find the specified create statement
            String query = table.getEngineModel().getWhereFormat();

            //Replace all the parameter slots with the correct parameter
            ObservableList<ParameterDetails> details = EngineDecoder.getParameterDetails(query);
            String[] parameters = {column,null,"'"+columnData+"'"};
            query = EngineDecoder.replace(details, parameters, query);

            //Find Where position
            int positionWhere = query.indexOf("WHERE");
            query = query.substring(0,positionWhere)+query.substring(positionWhere+6,query.length());

            //Replace all the parameter slots with the correct parameter for the multiple where
            details = EngineDecoder.getParameterDetails(query1);
            String [] parameter = {query};
            query1 = EngineDecoder.replace(details, parameter, query1);


            //Update query
            this.query = this.query+" "+query1;

            //Set where used as true
            whereUsed = true;

            //Return Select statement
            return this;
        }
    }

    public SelectStatement where(String column, int columnData) throws Exception {
        if (whereUsed) {
            //Find the specified create statement
            String query = table.getEngineModel().getWhereFormat();

            //Replace all the parameter slots with the correct parameter
            ObservableList<ParameterDetails> details = EngineDecoder.getParameterDetails(query);
            String[] parameters = {column,null,columnData+""};
            query = EngineDecoder.replace(details, parameters, query);

            //Find Where position
            int positionWhere = query.indexOf("WHERE");
            query = query.substring(0,positionWhere)+query.substring(positionWhere+6,query.length());

            int positionBracket = this.query.lastIndexOf(')');

            //Clean up the query statement by inserting where clause in the correct position
            this.query = this.query.substring(0, positionBracket) + " && "+ query +
                    this.query.substring(positionBracket, this.query.length());

            return this;
        } else {
            String query1 = table.getEngineModel().getMultipleWhere();

            //Find the specified create statement
            String query = table.getEngineModel().getWhereFormat();

            //Replace all the parameter slots with the correct parameter
            ObservableList<ParameterDetails> details = EngineDecoder.getParameterDetails(query);
            String[] parameters = {column,null,columnData+""};
            query = EngineDecoder.replace(details, parameters, query);

            //Find Where position
            int positionWhere = query.indexOf("WHERE");
            query = query.substring(0,positionWhere)+query.substring(positionWhere+6,query.length());

            //Replace all the parameter slots with the correct parameter for the multiple where
            details = EngineDecoder.getParameterDetails(query1);
            String [] parameter = {query};
            query1 = EngineDecoder.replace(details, parameter, query1);


            //Update query
            this.query = this.query+" "+query1;

            //Set where used as true
            whereUsed = true;

            //Return Select statement
            return this;
        }
    }

    public SelectStatement where(String column,String condition, String columnData) throws Exception {
        if (whereUsed) {
            //Find the specified create statement
            String query = table.getEngineModel().getWhereFormat();

            //Replace all the parameter slots with the correct parameter
            ObservableList<ParameterDetails> details = EngineDecoder.getParameterDetails(query);
            String[] parameters = {column,condition,"'"+columnData+"'"};
            query = EngineDecoder.replace(details, parameters, query);

            //Find Where position
            int positionWhere = query.indexOf("WHERE");
            query = query.substring(0,positionWhere)+query.substring(positionWhere+6,query.length());

            int positionBracket = this.query.lastIndexOf(')');

            //Clean up the query statement by inserting where clause in the correct position
            this.query = this.query.substring(0, positionBracket) + " && "+ query +
                    this.query.substring(positionBracket, this.query.length());

            return this;
        } else {
            String query1 = table.getEngineModel().getMultipleWhere();
            //Find the specified create statement
            String query = table.getEngineModel().getWhereFormat();

            //Replace all the parameter slots with the correct parameter
            ObservableList<ParameterDetails> details = EngineDecoder.getParameterDetails(query);
            String[] parameters = {column,condition,"'"+columnData+"'"};
            query = EngineDecoder.replace(details, parameters, query);

            //Find Where position
            int positionWhere = query.indexOf("WHERE");
            query = query.substring(0,positionWhere)+query.substring(positionWhere+6,query.length());

            //Replace all the parameter slots with the correct parameter for the multiple where
            details = EngineDecoder.getParameterDetails(query1);
            String [] parameter = {query};
            query1 = EngineDecoder.replace(details, parameter, query1);


            //Update query
            this.query = this.query+" "+query1;

            //Set where used as true
            whereUsed = true;

            //Return Select statement
            return this;
        }
    }

    public SelectStatement whereLike(String column, String columnData) throws Exception {
        if (whereUsed) {
            //Find the specified create statement
            String query = table.getEngineModel().getWhereLike();

            //Replace all the parameter slots with the correct parameter
            ObservableList<ParameterDetails> details = EngineDecoder.getParameterDetails(query);
            String[] parameters = {column,"'"+columnData+"'"};
            query = EngineDecoder.replace(details, parameters, query);

            //Find Where position
            int positionWhere = query.indexOf("WHERE");
            query = query.substring(0,positionWhere)+query.substring(positionWhere+6,query.length());

            int positionBracket = this.query.lastIndexOf(')');

            //Clean up the query statement by inserting where clause in the correct position
            this.query = this.query.substring(0, positionBracket) + " && "+ query +
                    this.query.substring(positionBracket, this.query.length());

            return this;
        } else {
            String query1 = table.getEngineModel().getMultipleWhere();
            //Find the specified create statement
            String query = table.getEngineModel().getWhereLike();

            //Replace all the parameter slots with the correct parameter
            ObservableList<ParameterDetails> details = EngineDecoder.getParameterDetails(query);
            String[] parameters = {column,"'"+columnData+"'"};
            query = EngineDecoder.replace(details, parameters, query);

            //Find Where position
            int positionWhere = query.indexOf("WHERE");
            query = query.substring(0,positionWhere)+query.substring(positionWhere+6,query.length());

            //Replace all the parameter slots with the correct parameter for the multiple where
            details = EngineDecoder.getParameterDetails(query1);
            String [] parameter = {query};
            query1 = EngineDecoder.replace(details, parameter, query1);


            //Update query
            this.query = this.query+" "+query1;

            //Set where used as true
            whereUsed = true;

            //Return Select statement
            return this;
        }
    }

    public SelectStatement whereNotLike(String column, String columnData) throws Exception {
        if (whereUsed) {
            //Find the specified create statement
            String query = table.getEngineModel().getWhereNotLike();

            //Replace all the parameter slots with the correct parameter
            ObservableList<ParameterDetails> details = EngineDecoder.getParameterDetails(query);
            String[] parameters = {column,"'"+columnData+"'"};
            query = EngineDecoder.replace(details, parameters, query);

            //Find Where position
            int positionWhere = query.indexOf("WHERE");
            query = query.substring(0,positionWhere)+query.substring(positionWhere+6,query.length());

            int positionBracket = this.query.lastIndexOf(')');

            //Clean up the query statement by inserting where clause in the correct position
            this.query = this.query.substring(0, positionBracket) + " && "+ query +
                    this.query.substring(positionBracket, this.query.length());

            return this;
        } else {
            String query1 = table.getEngineModel().getMultipleWhere();
            //Find the specified create statement
            String query = table.getEngineModel().getWhereNotLike();

            //Replace all the parameter slots with the correct parameter
            ObservableList<ParameterDetails> details = EngineDecoder.getParameterDetails(query);
            String[] parameters = {column,"'"+columnData+"'"};
            query = EngineDecoder.replace(details, parameters, query);

            //Find Where position
            int positionWhere = query.indexOf("WHERE");
            query = query.substring(0,positionWhere)+query.substring(positionWhere+6,query.length());

            //Replace all the parameter slots with the correct parameter for the multiple where
            details = EngineDecoder.getParameterDetails(query1);
            String [] parameter = {query};
            query1 = EngineDecoder.replace(details, parameter, query1);


            //Update query
            this.query = this.query+" "+query1;

            //Set where used as true
            whereUsed = true;

            //Return Select statement
            return this;
        }
    }

    public SelectStatement where(String column,String condition, int columnData) throws Exception {
        if (whereUsed) {
            //Find the specified create statement
            String query = table.getEngineModel().getWhereFormat();

            //Replace all the parameter slots with the correct parameter
            ObservableList<ParameterDetails> details = EngineDecoder.getParameterDetails(query);
            String[] parameters = {column,condition,columnData+""};
            query = EngineDecoder.replace(details, parameters, query);

            //Find Where position
            int positionWhere = query.indexOf("WHERE");
            query = query.substring(0,positionWhere)+query.substring(positionWhere+6,query.length());

            int positionBracket = this.query.lastIndexOf(')');

            //Clean up the query statement by inserting where clause in the correct position
            this.query = this.query.substring(0, positionBracket) + " && "+ query +
                    this.query.substring(positionBracket, this.query.length());

            return this;
        } else {
            String query1 = table.getEngineModel().getMultipleWhere();
            //Find the specified create statement
            String query = table.getEngineModel().getWhereFormat();

            //Replace all the parameter slots with the correct parameter
            ObservableList<ParameterDetails> details = EngineDecoder.getParameterDetails(query);
            String[] parameters = {column,condition,columnData+""};
            query = EngineDecoder.replace(details, parameters, query);

            //Find Where position
            int positionWhere = query.indexOf("WHERE");
            query = query.substring(0,positionWhere)+query.substring(positionWhere+6,query.length());

            //Replace all the parameter slots with the correct parameter for the multiple where
            details = EngineDecoder.getParameterDetails(query1);
            String [] parameter = {query};
            query1 = EngineDecoder.replace(details, parameter, query1);


            //Update query
            this.query = this.query+" "+query1;

            //Set where used as true
            whereUsed = true;

            //Return Select statement
            return this;
        }
    }

    public SelectStatement orWhere(String column, String columnData) throws Exception {
        if (whereUsed) {
            //Find the specified create statement
            String query = table.getEngineModel().getWhereFormat();

            //Replace all the parameter slots with the correct parameter
            ObservableList<ParameterDetails> details = EngineDecoder.getParameterDetails(query);
            String[] parameters = {column,null,"'"+columnData+"'"};
            query = EngineDecoder.replace(details, parameters, query);

            //Find Where position
            int positionWhere = query.indexOf("WHERE");
            query = query.substring(0,positionWhere)+query.substring(positionWhere+6,query.length());

            int positionBracket = this.query.lastIndexOf(')');

            //Clean up the query statement by inserting where clause in the correct position
            this.query = this.query.substring(0, positionBracket) + " || "+ query +
                    this.query.substring(positionBracket, this.query.length());

            return this;
        } else {
            throw new WhereException();
        }
    }

    public SelectStatement orWhere(String column, int columnData) throws Exception {
        if (whereUsed) {
            //Find the specified create statement
            String query = table.getEngineModel().getWhereFormat();

            //Replace all the parameter slots with the correct parameter
            ObservableList<ParameterDetails> details = EngineDecoder.getParameterDetails(query);
            String[] parameters = {column,null,columnData+""};
            query = EngineDecoder.replace(details, parameters, query);

            //Find Where position
            int positionWhere = query.indexOf("WHERE");
            query = query.substring(0,positionWhere)+query.substring(positionWhere+6,query.length());

            int positionBracket = this.query.lastIndexOf(')');

            //Clean up the query statement by inserting where clause in the correct position
            this.query = this.query.substring(0, positionBracket) + " || "+ query +
                    this.query.substring(positionBracket, this.query.length());

            return this;
        } else {
            throw new WhereException();
        }
    }

    public SelectStatement orWhere(String column,String condition, String columnData) throws Exception {
        if (whereUsed) {
            //Find the specified create statement
            String query = table.getEngineModel().getWhereFormat();

            //Replace all the parameter slots with the correct parameter
            ObservableList<ParameterDetails> details = EngineDecoder.getParameterDetails(query);
            String[] parameters = {column,condition,"'"+columnData+"'"};
            query = EngineDecoder.replace(details, parameters, query);

            //Find Where position
            int positionWhere = query.indexOf("WHERE");
            query = query.substring(0,positionWhere)+query.substring(positionWhere+6,query.length());

            int positionBracket = this.query.lastIndexOf(')');

            //Clean up the query statement by inserting where clause in the correct position
            this.query = this.query.substring(0, positionBracket) + " || "+ query +
                    this.query.substring(positionBracket, this.query.length());

            return this;
        } else {
            throw new WhereException();
        }
    }

    public SelectStatement orWhereLike(String column, String columnData) throws Exception {
        if (whereUsed) {
            //Find the specified create statement
            String query = table.getEngineModel().getWhereLike();

            //Replace all the parameter slots with the correct parameter
            ObservableList<ParameterDetails> details = EngineDecoder.getParameterDetails(query);
            String[] parameters = {column,"'"+columnData+"'"};
            query = EngineDecoder.replace(details, parameters, query);

            //Find Where position
            int positionWhere = query.indexOf("WHERE");
            query = query.substring(0,positionWhere)+query.substring(positionWhere+6,query.length());

            int positionBracket = this.query.lastIndexOf(')');

            //Clean up the query statement by inserting where clause in the correct position
            this.query = this.query.substring(0, positionBracket) + " || "+ query +
                    this.query.substring(positionBracket, this.query.length());

            return this;
        } else {
            throw new WhereException();
        }
    }

    public SelectStatement orWhereNotLike(String column, String columnData) throws Exception {
        if (whereUsed) {
            //Find the specified create statement
            String query = table.getEngineModel().getWhereNotLike();

            //Replace all the parameter slots with the correct parameter
            ObservableList<ParameterDetails> details = EngineDecoder.getParameterDetails(query);
            String[] parameters = {column,"'"+columnData+"'"};
            query = EngineDecoder.replace(details, parameters, query);

            //Find Where position
            int positionWhere = query.indexOf("WHERE");
            query = query.substring(0,positionWhere)+query.substring(positionWhere+6,query.length());

            int positionBracket = this.query.lastIndexOf(')');

            //Clean up the query statement by inserting where clause in the correct position
            this.query = this.query.substring(0, positionBracket) + " || "+ query +
                    this.query.substring(positionBracket, this.query.length());

            return this;
        } else {
            throw new WhereException();
        }
    }

    public SelectStatement orWhere(String column,String condition, int columnData) throws Exception {
        if (whereUsed) {
            //Find the specified create statement
            String query = table.getEngineModel().getWhereFormat();

            //Replace all the parameter slots with the correct parameter
            ObservableList<ParameterDetails> details = EngineDecoder.getParameterDetails(query);
            String[] parameters = {column,condition,columnData+""};
            query = EngineDecoder.replace(details, parameters, query);

            //Find Where position
            int positionWhere = query.indexOf("WHERE");
            query = query.substring(0,positionWhere)+query.substring(positionWhere+6,query.length());

            int positionBracket = this.query.lastIndexOf(')');

            //Clean up the query statement by inserting where clause in the correct position
            this.query = this.query.substring(0, positionBracket) + " || "+ query +
                    this.query.substring(positionBracket, this.query.length());

            return this;
        } else {
            throw new WhereException();
        }
    }

    public SelectStatement orderBy(String column) throws Exception {
        if (!orderByUsed) {
            //Find the specified create statement
            String query = table.getEngineModel().getOrderBy();

            //Replace all the parameter slots with the correct parameter
            ObservableList<ParameterDetails> details = EngineDecoder.getParameterDetails(query);
            String[] parameters = {column};
            query = EngineDecoder.replace(details, parameters, query);

            this.query = this.query + " " + query;
            //Set order by as used
            orderByUsed = true;

            return this;
        }else{
            throw new OrderByException();
        }
    }

    public SelectStatement orderByDesc(String column) throws Exception {
        if (!orderByUsed) {
            //Find the specified create statement
            String query = table.getEngineModel().getOrderByDesc();

            //Replace all the parameter slots with the correct parameter
            ObservableList<ParameterDetails> details = EngineDecoder.getParameterDetails(query);
            String[] parameters = {column};
            query = EngineDecoder.replace(details, parameters, query);

            this.query = this.query + " " + query;
            //Set order by as used
            orderByUsed = true;

            return this;
        }else{
            throw new OrderByException();
        }
    }

//    public JoinStatement from(String table) throws Exception {
//        if (!whereUsed && !orderByUsed) {
//            //Find the specified create statement
//            String query = this.table.getEngineModel().getFrom();
//
//            //Replace all the parameter slots with the correct parameter
//            ObservableList<ParameterDetails> details = EngineDecoder.getParameterDetails(query);
//            String[] parameters = {table};
//            query = EngineDecoder.replace(details, parameters, query);
//
//            this.query = this.query + " " + query;
//
//            return new JoinStatement(this.table,this.query);
//        } else if (whereUsed) {
//            throw new JoinStatementException();
//        } else {
//            throw new JoinStatementException("A join statement cannot be used with an orderBy statement");
//        }
//    }

    public SelectStatement innerJoin(String table) throws Exception {
        if (!whereUsed && !orderByUsed) {
            //Find the specified create statement
            String query = this.table.getEngineModel().getJoinFormat();

            //Replace all the parameter slots with the correct parameter
            ObservableList<ParameterDetails> details = EngineDecoder.getParameterDetails(query);
            String[] parameters = {table};
            query = EngineDecoder.replace(details, parameters, query);

            this.query = this.query + " " + query;
            this.innerJoinUsed = true;

            return this;
        } else if (whereUsed) {
            throw new JoinStatementException();
        } else {
            throw new JoinStatementException("A join statement cannot be used with an orderBy statement");
        }
    }

    public ResultSet on(String columnTable1, String columnTable2) throws Exception {
        if (innerJoinUsed) {
            //Find the specified create statement
            String query = table.getEngineModel().getOn();

            //Replace all the parameter slots with the correct parameter
            ObservableList<ParameterDetails> details = EngineDecoder.getParameterDetails(query);
            String[] parameters = {columnTable1, columnTable2};

            query = EngineDecoder.replace(details, parameters, query);

            this.query = this.query +" "+ query;

            ResultSet rs = null;
            try (java.sql.Connection con = table.getDatabase().openConnection()) {
                rs = con.createStatement().executeQuery(this.query);
            }

            return rs;
        } else {
            throw new JoinStatementException("An inner joint statement has not been implemented");
        }
    }

    public ResultSet get() throws SQLException {
        ResultSet rs = null;
        try (java.sql.Connection con = table.getDatabase().openConnection()) {
            rs = con.createStatement().executeQuery(this.query);
        }

        return rs;
    }

    public ResultSet first() throws Exception {
        return get(1);
    }

    public ResultSet get(int limit) throws Exception {
        //Find the specified create statement
        String query = table.getEngineModel().getLimitFormat();

        //Replace all the parameter slots with the correct parameter
        ObservableList<ParameterDetails> details = EngineDecoder.getParameterDetails(query);
        String[] parameters = {limit+""};
        query = EngineDecoder.replace(details, parameters, query);

        this.query += " " + query;

        ResultSet rs = null;
        try (java.sql.Connection con = table.getDatabase().openConnection()) {
            rs = con.createStatement().executeQuery(this.query);
        }

        return rs;
    }

    public List<?> get(Class format) throws SQLException {
        Database db = table.getDatabase();
        Sql2o sql = new Sql2o(db.getConnectionUrl(),db.getUsername(), db.getPassword());

        try (Connection con = sql.open()) {
            return con.createQuery(this.query).executeAndFetch(format);
        }
    }

    public Object first(Class format) throws Exception {
        List<?> items = get(format,1);
        return items.get(0);
    }

    public List<?> get(Class format,int limit) throws Exception {
        //Find the specified create statement
        String query = table.getEngineModel().getLimitFormat();

        //Replace all the parameter slots with the correct parameter
        ObservableList<ParameterDetails> details = EngineDecoder.getParameterDetails(query);
        String[] parameters = {limit+""};
        query = EngineDecoder.replace(details, parameters, query);

        this.query += " " + query;

        Database db = table.getDatabase();
        Sql2o sql = new Sql2o(db.getConnectionUrl(),db.getUsername(), db.getPassword());

        try (Connection con = sql.open()) {
            return con.createQuery(this.query).executeAndFetch(format);
        }
    }
}
