package com.Tunes_Developers;

import com.Tunes_Developers.Models.EngineModel;
import com.Tunes_Developers.Models.ParameterDetails;
import com.Tunes_Developers.Utils.EngineDecoder;
import javafx.collections.ObservableList;

import java.sql.*;

/**
 * Created by Geoffrey-Kimani on 10/10/2017.
 */
public class Database {
    private String databaseName = null;
    private String username = null;
    private String password = null;
    private String ipAddress = null;
    private String portNumber = null;
    private String connectionUrl = null;
    private Engine engine;
    private EngineModel engineModel;
    private Connection connection;

    public Database(int portNumber,String databaseName, String username, String password, Engine engine) throws Exception {
        this.databaseName = databaseName;
        this.username = username;
        this.password = password;
        this.portNumber = portNumber+"";
        this.engine = engine;
        connectionLocalHost();
    }

    public Database(int portNumber, String username, String password, Engine engine) throws Exception {
        this.username = username;
        this.password = password;
        this.portNumber = portNumber+"";
        this.engine = engine;
        connectionLocalHostNoDb();
    }

    public Database(String ipAddress, int portNumber, String databaseName, String username, String password, Engine engine) throws Exception {
        this.databaseName = databaseName;
        this.username = username;
        this.password = password;
        this.ipAddress = ipAddress;
        this.portNumber = portNumber+"";
        this.engine = engine;
        connectionRemote();
    }

    public void setDatabaseName(String databaseName) {
        this.databaseName = databaseName;
    }

    public String getDatabaseName() {
        return databaseName;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public String getPortNumber() {
        return portNumber;
    }

    public Engine getEngine() {
        return engine;
    }

    public DatabaseMetaData databaseMetaData() throws SQLException {
        return this.connection.getMetaData();
    }

    public Statement getStatement() throws SQLException {
        return this.connection.createStatement();
    }

    public ResultSet getResultSet(String query) throws SQLException {
        return this.getStatement().executeQuery(query);
    }

    public void closeConnection() throws SQLException {
        this.connection.close();
    }

    public void create(String dbName) throws Exception {
        //Find the specified connection url
        String query = engine.getModel().getCreateDatabase();

        //Replace all the parameter slots for port number with the correct parameter
        ObservableList<ParameterDetails> details = EngineDecoder.getParameterDetails(query);
        query = EngineDecoder.replace(details.get(0),dbName,query);

        //Execute Create query
        this.databaseName = dbName;
        getStatement().execute(query);

        closeConnection();
        connectionLocalHost();
    }

    public void drop(String dbName) throws Exception {
        //Find the specified connection url
        String query = engine.getModel().getDropDatabase();

        //Replace all the parameter slots for port number with the correct parameter
        ObservableList<ParameterDetails> details = EngineDecoder.getParameterDetails(query);
        query = EngineDecoder.replace(details.get(0),dbName,query);

        //Execute Create query
        this.databaseName = dbName;
        getStatement().execute(query);
    }

    public void drop() throws Exception {
        //Find the specified connection url
        String query = engine.getModel().getDropDatabase();

        //Replace all the parameter slots for port number with the correct parameter
        ObservableList<ParameterDetails> details = EngineDecoder.getParameterDetails(query);
        query = EngineDecoder.replace(details.get(0),databaseName,query);

        //Execute Create query
        getStatement().execute(query);
    }

    private void connectionLocalHost() throws Exception {
        //Find the specified connection url
        String connectionUrl = engine.getModel().getConnectionLocalHost();

        //Replace all the parameter slots for port number with the correct parameter
        ObservableList<ParameterDetails> details = EngineDecoder.getParameterDetails(connectionUrl);
        connectionUrl = EngineDecoder.replace(details.get(0),portNumber,connectionUrl);
        this.connectionUrl = connectionUrl;

        //Initialize Connection
        this.connection = DriverManager.getConnection(connectionUrl+databaseName,username,password);
    }

    private void connectionLocalHostNoDb() throws Exception {
        //Find the specified connection url
        String connectionUrl = engine.getModel().getConnectionLocalHost();

        //Replace all the parameter slots for port number with the correct parameter
        ObservableList<ParameterDetails> details = EngineDecoder.getParameterDetails(connectionUrl);
        connectionUrl = EngineDecoder.replace(details.get(0),portNumber,connectionUrl);
        this.connectionUrl = connectionUrl;

        //Initialize Connection
        this.connection = DriverManager.getConnection(connectionUrl,username,password);
    }

    private void connectionRemote() throws Exception {
        //Find the specified connection url
        String connectionUrl = engine.getModel().getConnectionRemote();

        //Replace all the parameter slots with the correct parameter
        ObservableList<ParameterDetails> details = EngineDecoder.getParameterDetails(connectionUrl);
        String[] parameters = {ipAddress,portNumber+""};
        connectionUrl = EngineDecoder.replace(details,parameters,connectionUrl);
        this.connectionUrl = connectionUrl;

        //Initialize Connection
        this.connection = DriverManager.getConnection(connectionUrl+databaseName,username,password);
    }
}
