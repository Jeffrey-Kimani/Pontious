package com.Tunes_Developers;

import com.Tunes_Developers.Exceptions.EngineNotFound;
import com.Tunes_Developers.Models.EngineModel;
import com.google.gson.Gson;
import com.tunes_developers.File;

import java.io.IOException;

/**
 * Created by Geoffrey-Kimani on 10/9/2017.
 */
public class Engine {
    String location = getClass().getClassLoader().getResource("com/Tunes_Developers/Engines/").toString().substring(6);
    String sqlEngine="";

    public Engine(String location, String sqlEngine) {
        this.location = location;
        this.sqlEngine = sqlEngine;
    }

    public Engine(String sqlEngine) {
        this.sqlEngine = sqlEngine;
    }

    public EngineModel getModel() throws IOException, EngineNotFound {
        File file = new File(location+sqlEngine+".json");
        EngineModel engineModel = null;

        if (file.exists()) {
            Gson gson = new Gson();

            engineModel = gson.fromJson(file.getData(), EngineModel.class);
        }else{
            throw new EngineNotFound(sqlEngine);
        }

        return engineModel;
    }

    private void confirmMethods() {

    }
}
