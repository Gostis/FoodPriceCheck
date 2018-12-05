package com.example.lucasrung.foodapp;
import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;

public class Item {

    public int id;
    public String name;
    public String brand;
    public String img;

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Item(String name, int id, String brand, String img) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.img = img;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

}
