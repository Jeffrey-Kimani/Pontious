package com.Tunes_Developers.Exceptions;

/**
 * Created by Geoffrey-Kimani on 10/10/2017.
 */
public class MissingParameter extends PontiousException {
    public MissingParameter(String format) {
        super("A Parameter is missing in format: \""+format+"\"");
    }
}
