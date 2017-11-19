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
    private boolean missingDatabaseName;
//    private Connection connection;

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
        connectionRemote(databaseName);
    }

    public Database(Config config) throws Exception {
        this.engine = new Engine(config.getConfigModel().getDatabase().getEngine());
        this.ipAddress = config.getConfigModel().getDatabase().getHost();
        this.portNumber = config.getConfigModel().getDatabase().getPort();
        this.databaseName = config.getConfigModel().getDatabase().getDatabaseName();
        this.username = config.getConfigModel().getDatabase().getUsername();
        this.password = config.getConfigModel().getDatabase().getPassword();

        if (ipAddress.equals("")) {
            connectionLocalHostNoDb();
            create(databaseName);
        } else {
            connectionRemote();
        }
    }

    public Database(String host, int port, String username, String password, Engine engine) throws Exception {
        this.ipAddress = host;
        this.portNumber = port+"";
        this.username = username;
        this.password = password;
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
        DatabaseMetaData dbMD = null;

        try (Connection con = openConnection()) {
            dbMD = con.getMetaData();
        }

        return dbMD;
    }

    public String getConnectionUrl() {
        return connectionUrl;
    }

//    public Statement getStatement() throws SQLException {
//        return this.connection.createStatement();
//    }
//
//    public ResultSet getResultSet(String query) throws SQLException {
//        return this.getStatement().executeQuery(query);
//    }

    public void create(String dbName) throws Exception {
        //Find the specified connection url
        String query = engine.getModel().getCreateDatabase();

        //Replace all the parameter slots for port number with the correct parameter
        ObservableList<ParameterDetails> details = EngineDecoder.getParameterDetails(query);
        query = EngineDecoder.replace(details.get(0),dbName,query);

        //Execute Create query
        this.databaseName = dbName;

        try (Connection con = openConnection()) {
            con.createStatement().execute(query);
        }

        if (missingDatabaseName) {
            connectionUrl = connectionUrl + dbName;
        }
    }

    public void drop(String dbName) throws Exception {
        //Find the specified connection url
        String query = engine.getModel().getDropDatabase();

        //Replace all the parameter slots for port number with the correct parameter
        ObservableList<ParameterDetails> details = EngineDecoder.getParameterDetails(query);
        query = EngineDecoder.replace(details.get(0),dbName,query);

        //Execute Create query
        this.databaseName = dbName;
        try (Connection con = openConnection()) {
            con.createStatement().execute(query);
        }
    }

    public void drop() throws Exception {
        //Find the specified connection url
        String query = engine.getModel().getDropDatabase();

        //Replace all the parameter slots for port number with the correct parameter
        ObservableList<ParameterDetails> details = EngineDecoder.getParameterDetails(query);
        query = EngineDecoder.replace(details.get(0),databaseName,query);

        //Execute Create query
        try (Connection con = openConnection()) {
            con.createStatement().execute(query);
        }
    }

    public Connection openConnection() throws SQLException {
        return DriverManager.getConnection(connectionUrl,username,password);
    }

    private void connectionLocalHost() throws Exception {
        //Find the specified connection url
        String connectionUrl = engine.getModel().getConnectionLocalHost();

        //Replace all the parameter slots for port number with the correct parameter
        ObservableList<ParameterDetails> details = EngineDecoder.getParameterDetails(connectionUrl);
        connectionUrl = EngineDecoder.replace(details.get(0),portNumber,connectionUrl);
        this.connectionUrl = connectionUrl+databaseName;
    }

    private void connectionLocalHostNoDb() throws Exception {
        //Find the specified connection url
        String connectionUrl = engine.getModel().getConnectionLocalHost();

        //Replace all the parameter slots for port number with the correct parameter
        ObservableList<ParameterDetails> details = EngineDecoder.getParameterDetails(connectionUrl);
        connectionUrl = EngineDecoder.replace(details.get(0),portNumber,connectionUrl);
        this.connectionUrl = connectionUrl;
        //Set the database name as missing
        missingDatabaseName = true;
    }

    private void connectionRemote(String databaseName) throws Exception {
        //Find the specified connection url
        String connectionUrl = engine.getModel().getConnectionRemote();

        //Replace all the parameter slots with the correct parameter
        ObservableList<ParameterDetails> details = EngineDecoder.getParameterDetails(connectionUrl);
        String[] parameters = {ipAddress,portNumber+""};
        connectionUrl = EngineDecoder.replace(details,parameters,connectionUrl);
        this.connectionUrl = connectionUrl+databaseName;
    }

    private void connectionRemote() throws Exception {
        //Find the specified connection url
        String connectionUrl = engine.getModel().getConnectionRemote();

        //Replace all the parameter slots with the correct parameter
        ObservableList<ParameterDetails> details = EngineDecoder.getParameterDetails(connectionUrl);
        String[] parameters = {ipAddress,portNumber+""};
        connectionUrl = EngineDecoder.replace(details,parameters,connectionUrl);
        this.connectionUrl = connectionUrl;
        //Set the database name as missing
        missingDatabaseName = true;
    }
}
