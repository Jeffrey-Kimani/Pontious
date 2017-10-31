package com.Tunes_Developers.Models;

/**
 * Created by Geoffrey-Kimani on 10/14/2017.
 */
public class ColumnType {
    private String column;
    private boolean string;

    public ColumnType(String column, boolean string) {
        this.column = column;
        this.string = string;
    }

    public String getColumn() {
        return column;
    }

    public boolean isString() {
        return string;
    }
}
