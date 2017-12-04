package com.Tunes_Developers.Tests;

import com.Tunes_Developers.Model;

/**
 * Created by Geoffrey-Kimani on 12/1/2017.
 */
public class Car extends Model {
    public int id;
    public String name;
    public int company_id;
    public int type_id;
    public int price;

    public Car(int id, String name, int company_id, int type_id, int price) throws Exception {
        super("cars");
        this.id = id;
        this.name = name;
        this.company_id = company_id;
        this.type_id = type_id;
        this.price = price;
    }

    public Car() throws Exception {
        super("cars");
    }
}
