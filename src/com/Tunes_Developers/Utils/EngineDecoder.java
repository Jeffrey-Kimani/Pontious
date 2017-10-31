package com.Tunes_Developers.Utils;

import com.Tunes_Developers.Exceptions.MissingParameter;
import com.Tunes_Developers.Models.ParameterDetails;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Geoffrey-Kimani on 10/10/2017.
 */
public class EngineDecoder {
    public static ObservableList<ParameterDetails> getParameterDetails(String format) {
        ObservableList<ParameterDetails> parameterDetails = FXCollections.observableArrayList();

        Pattern pattern = Pattern.compile("\\$\\{(.*?)\\}");
        Matcher matcher = pattern.matcher(format);

        while (matcher.find()) {
            String Default = matcher.group();
            int param = Integer.parseInt(Default.substring(2,Default.indexOf(':')));
            Default = Default.substring(Default.indexOf(":")+1,Default.lastIndexOf('}'));

            parameterDetails.add(new ParameterDetails(
                    param,
                    matcher.start(),
                    matcher.end(),
                    Default
            ));
        }

        return parameterDetails;
    }

    public static String replace(ParameterDetails details, String replaceWith, String content) {
        return content.substring(0,details.getStratsAt())+replaceWith+content.substring(details.getEndsAt());
    }

    public static String replace(ObservableList<ParameterDetails> details, String [] replaceWith, String content) throws MissingParameter {
        //Initialize required variables
        boolean found = false;
        String data = content;

        //For each parameter in the replace array
        for(int i=0;i<replaceWith.length;i++) {
            //Go through all the parameters specified
            for (ParameterDetails d : details) {
                //If parameter number is equal to the provided parameter
                if ((d.getParameterNum()-1) == i) {
                    //Set found as true and replace the parameter slot with the parameter
                    found = true;
                    if (replaceWith[i] == null) {
                        data = data.substring(0,d.getStratsAt())+d.getDefaultValue()+data.substring(d.getEndsAt());
                    }else{
                        data = data.substring(0,d.getStratsAt())+replaceWith[i]+data.substring(d.getEndsAt());
                    }

                    //Set up new parameter location details to avoid mix ups in cases where the parameter length is not
                    //equal to the parameter slot length
                    details = EngineDecoder.getParameterDetails(data);
                }
            }

            //If parameter was not found throw a parameter missing exception
            if (!found) {
                throw new MissingParameter(content);
            }
        }

        return data;
    }
}
