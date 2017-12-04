package com.Tunes_Developers.Exceptions;

/**
 * Created by Geoffrey-Kimani on 11/14/2017.
 */
public class WhereException extends Exception {
    public WhereException() {
        super("A where clause has not been implemented. An 'orWhere' clause cannot be called before a where clause is called");
    }
}
