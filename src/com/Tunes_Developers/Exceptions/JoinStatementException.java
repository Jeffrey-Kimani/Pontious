package com.Tunes_Developers.Exceptions;

/**
 * Created by Geoffrey-Kimani on 11/17/2017.
 */
public class JoinStatementException extends Exception {
    public JoinStatementException() {
        super("A join statement cannot be used with a where statement");
    }

    public JoinStatementException(String message) {
        super(message);
    }
}
