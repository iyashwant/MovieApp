package com.example.iyashwant.movieapp;

/**
 * Created by iyashwant on 14/7/17.
 */

import java.io.Serializable;

public class FoodItem implements Serializable{

    private String food_id;
    private String food_name;
    private int food_price;
    private int quantity;


    public FoodItem(String food_id, String food_name, int food_price, int quantity) {
        this.food_id = food_id;
        this.food_name = food_name;
        this.food_price = food_price;
        this.quantity = quantity;
    }

    public int getQuantity(){
        return quantity;
    }


    public String getName(){
        return food_name;
    }


    public int getPrice(){
        return food_price;
    }

    public String getFoodID(){
        return food_id;
    }

    public void addQ(){
        quantity++;
    }

    public void delQ(){
        quantity--;
    }
}