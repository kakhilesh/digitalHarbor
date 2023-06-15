package com.warehouse.warehouse.model;

//import jakarta.persistence.*;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Duckling")
public class Duckling  {
    private int id;
    private String color;
    private String size;
    private double price;
    private int quantity;
    private boolean delete;

    public Duckling(int id, String color, String size, double price, int quantity, boolean delete) {
        this.id = id;
        this.color = color;
        this.size = size;
        this.price = price;
        this.quantity = quantity;
        this.delete = delete;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isDelete() {
        return delete;
    }

    public void setDelete(boolean delete) {
        this.delete = delete;
    }

    @Override
    public String toString() {
        return "Duckling{" +
                "id=" + id +
                ", color='" + color + '\'' +
                ", size='" + size + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", delete=" + delete +
                '}';
    }
}