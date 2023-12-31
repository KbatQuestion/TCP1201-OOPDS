package Part1;

import java.util.ArrayList;
import java.util.HashMap;

public class Product {

    private String name;
    private double price;
    private int quantity;

    public Product(){
        this.name = "";
        this.price = 0;
        this.quantity = 0;

    }

    public Product (String name, double price, int quantity){
        this.name = name;
        this.price = price;
        this.quantity = quantity;

    }

    public String getName(){
        return name;

    }

    public void setName (String name){
        this.name =name;
    }

    public double getPrice(){
        return price;
    }

    public void setPrice (double Price){
        this.price =price;
    }

    public Integer getQuantity(){
        return quantity;

    }

    public void setQuantity (int quantity){
        this.quantity =quantity;
    }

   
    




    
}
