package com.Tunes_Developers.Models;

/**
 * Created by Geoffrey-Kimani on 10/14/2017.
 */
public class FakerItem {
    String language = null;
    String country = null;
    String param1 = null;
    String param2 = null;
    String data = null;
    boolean faker = true;
    int fakerType = 0;
    int paramInt1 = 0;
    int paramInt2 = 0;
    int paramInt3 = 0;

    public FakerItem(String data) {
        faker = false;
        this.language = "English";
        this.country = "Kenya";
        this.data = data;
    }

    public FakerItem(String language, String country, int fakerType) {
        this.language = language;
        this.country = country;
        this.fakerType = fakerType;
    }

    public FakerItem(String language, String country, int fakerType, String param1) {
        this.language = language;
        this.country = country;
        this.fakerType = fakerType;
        this.param1 = param1;
    }

    public FakerItem(String language, String country, int fakerType, String param1, String param2) {
        this.language = language;
        this.country = country;
        this.fakerType = fakerType;
        this.param1 = param1;
        this.param2 = param2;
    }

    public FakerItem(String language, String country, int fakerType, int paramInt1) {
        this.language = language;
        this.country = country;
        this.fakerType = fakerType;
        this.paramInt1 = paramInt1;
    }

    public FakerItem(String language, String country, int fakerType, int paramInt1, int paramInt2) {
        this.language = language;
        this.country = country;
        this.fakerType = fakerType;
        this.paramInt1 = paramInt1;
        this.paramInt2 = paramInt2;
    }

    public FakerItem(String language, String country, int fakerType, int paramInt1, int paramInt2, int paramInt3) {
        this.language = language;
        this.country = country;
        this.fakerType = fakerType;
        this.paramInt1 = paramInt1;
        this.paramInt2 = paramInt2;
        this.paramInt3 = paramInt3;
    }

    public String getLanguage() {
        return language;
    }

    public String getCountry() {
        return country;
    }

    public int getFakerType() {
        return fakerType;
    }

    public String getParam1() {
        return param1;
    }

    public String getParam2() {
        return param2;
    }

    public int getParamInt1() {
        return paramInt1;
    }

    public int getParamInt2() {
        return paramInt2;
    }

    public int getParamInt3() {
        return paramInt3;
    }

    public boolean isFaker() {
        return faker;
    }

    public String getData() {
        return data;
    }
}
