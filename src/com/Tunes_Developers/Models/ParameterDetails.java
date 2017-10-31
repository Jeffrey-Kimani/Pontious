package com.Tunes_Developers.Models;

/**
 * Created by Geoffrey-Kimani on 10/10/2017.
 */
public class ParameterDetails {
    private int parameterNum;
    private int stratsAt;
    private int endsAt;
    private String defaultValue;

    public ParameterDetails(int parameterNum, int stratsAt, int endsAt,String defaultValue) {
        this.parameterNum = parameterNum;
        this.stratsAt = stratsAt;
        this.endsAt = endsAt;
        this.defaultValue = defaultValue;
    }

    public int getParameterNum() {
        return parameterNum;
    }

    public int getStratsAt() {
        return stratsAt;
    }

    public int getEndsAt() {
        return endsAt;
    }

    public String getDefaultValue() {
        return defaultValue;
    }
}
