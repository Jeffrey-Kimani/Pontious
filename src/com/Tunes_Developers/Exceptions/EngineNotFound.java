package com.Tunes_Developers.Exceptions;

/**
 * Created by Geoffrey-Kimani on 10/9/2017.
 */
public class EngineNotFound extends PontiousException {
    public EngineNotFound(String engine) {
        super("The Engine: \""+engine+"\" could not be found");
    }
}
