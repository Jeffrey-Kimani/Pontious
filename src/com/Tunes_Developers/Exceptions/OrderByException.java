package com.Tunes_Developers.Exceptions;

/**
 * Created by Geoffrey-Kimani on 11/14/2017.
 */
public class OrderByException extends Exception {
    public OrderByException() {
        super("Another instance of 'orderBy' has already been called");
    }
}
