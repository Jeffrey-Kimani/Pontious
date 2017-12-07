package com.Tunes_Developers;

import com.Tunes_Developers.Exceptions.EngineNotFound;
import com.Tunes_Developers.Models.EngineModel;
import com.google.gson.Gson;
import com.tunes_developers.File;
import org.apache.commons.io.IOUtils;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

/**
 * Created by Geoffrey-Kimani on 10/9/2017.
 */
public class Engine {
    String location = Paths.get(System.getProperty("user.home"),".swara","engines").toString();
    String sqlEngine="";

    public Engine(String location, String sqlEngine) {
        this.location = location;
        this.sqlEngine = sqlEngine;
    }

    public Engine(String sqlEngine) throws IOException {
        copyEngines();
        this.sqlEngine = sqlEngine;
    }

    public EngineModel getModel() throws IOException, EngineNotFound {
        File file = new File(location+"/"+sqlEngine+".json");
        EngineModel engineModel = null;

        if (file.exists()) {
            Gson gson = new Gson();

            engineModel = gson.fromJson(file.getData(), EngineModel.class);
        }else{
            throw new EngineNotFound(sqlEngine);
        }

        return engineModel;
    }

    private void copyEngines() throws IOException {
        copySingleEngineFile("maria");
        copySingleEngineFile("mysql");
        copySingleEngineFile("sqlite");
    }

    private void copySingleEngineFile(String name) throws IOException {
        //Initialize a new file path to copy to
        Path path = Paths.get(System.getProperty("user.home"),".swara","engines",name+".json");
        Path directory = Paths.get(System.getProperty("user.home"),".swara","engines");
        if (!Files.exists(path)) {
            // Read data from the engine file
            InputStream in = getClass().getResourceAsStream("Engines/" +name+".json");
            String data = IOUtils.toString(in);
            IOUtils.closeQuietly(in);

            //Create the directory
            if (!Files.exists(directory)) {
                Files.createDirectory(directory);
            }
            //Create the file
            Files.createFile(path);

            //Write the contents of the old file to the new file
            PrintWriter pr = new PrintWriter(new FileWriter(path.toString()));
            pr.printf("%s",data);
            pr.close();
        }
    }
}
