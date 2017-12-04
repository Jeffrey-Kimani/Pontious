package com.Tunes_Developers.Tests;

import com.Tunes_Developers.Model;

import java.util.List;

/**
 * Created by Geoffrey-Kimani on 12/1/2017.
 */
public class Company extends Model {
    public int id;
    public String name;
    public int country;
    public int year_established;

    public Company() throws Exception {
        super("companies");
    }

    public Company(int id, String name, int country, int year_established) throws Exception {
        super("companies");
        this.id = id;
        this.name = name;
        this.country = country;
        this.year_established = year_established;
    }

    public List<Car> cars() throws Exception {
        return (List<Car>) hasMany(new Car(),"company_id",this.id+"");
    }
}
