package com.Tunes_Developers.Exceptions;

/**
 * Created by Geoffrey-Kimani on 10/9/2017.
 */
public class PontiousException extends Exception {
    public PontiousException() {
    }

    public PontiousException(String message) {
        super(message);
    }

    public PontiousException(String message, Throwable cause) {
        super(message, cause);
    }

    public PontiousException(Throwable cause) {
        super(cause);
    }
}
