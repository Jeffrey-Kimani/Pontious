package com.Tunes_Developers.Exceptions;

/**
 * Created by Geoffrey-Kimani on 10/10/2017.
 */
public class NoParametersFound extends PontiousException {
    public NoParametersFound(String format) {
        super("There were no parameters found in: \""+format+"\"");
    }
}
