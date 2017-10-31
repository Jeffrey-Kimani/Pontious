package com.Tunes_Developers;

import com.Tunes_Developers.Models.EngineModel;
import com.Tunes_Developers.Models.ParameterDetails;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tunes_developers.File;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
	// write your code here
        EngineModel model = new EngineModel();
//
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        String data = gson.toJson(model);
        try {
            File.writeText("C:\\Users\\Geoffrey-Kimani\\Desktop\\engine.json",data);
        } catch (IOException e) {
            e.printStackTrace();
        }

//        Engine engine = new Engine("maria");
//        EngineModel model = null;
//
//        try {
//            model = engine.getModel();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (PontiousException ex) {
//            ex.printStackTrace();
//        }
//
//        System.out.println(model.getUpdateFormat());

//        Pattern logEntry = Pattern.compile("\\{[^{}]*\\}");
//        Pattern logEntry = Pattern.compile("\\{[^{}]+\\}");
//        Pattern logEntry = Pattern.compile("\\$\\{(.*?)\\}");
////        Pattern logEntry = Pattern.compile("\\$[\\s\\S]*$");
////        Pattern logEntry = Pattern.compile("\\$[\\s\\S]*$");
//
//        Matcher matcher = logEntry.matcher("${1:Hello World} DATETIME NOT NULL, ${2:Params 2}");
//
//        while (matcher.find()) {
//            System.out.println(matcher.group()+"  -  "+matcher.start()+"  -  "+matcher.end());
//
//            String Default = matcher.group();
//            int param = Integer.parseInt(Default.substring(2,Default.indexOf(':')));
//            Default = Default.substring(Default.indexOf(":")+1,Default.lastIndexOf('}'));
//
//            System.out.println(param+"    - "+Default);
//        }

//        String format = "${1:Hello World} DATETIME NOT NULL, ${2:Params 2}";
//
//        for (ParameterDetails details : EngineDecoder.getParameterDetails(format)) {
//            System.out.println(details.getParameterNum()+"     -  "+details.getDefaultValue());
//            System.out.println(format.substring(details.getStratsAt(),details.getEndsAt())+"------");
//            System.out.println(details.getStratsAt()+"--------"+details.getEndsAt()+"\n");
//        }


    }
}
