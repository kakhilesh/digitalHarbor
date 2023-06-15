package com.warehouse.warehouse.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Order")
public class Order {
    private int id;
    private String color;
    private String size;
    private int quantity;

    private String packageType;
    private String packageProtection;
    private String shippingTo;
    private double invoiceAmount;
    private String modeOfShipment;
    private double price;
    private double discounts;
    private double increments;


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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getPackageType() {
        return packageType;
    }

    public void setPackageType(String packageType) {
        this.packageType = packageType;
    }

    public String getPackageProtection() {
        return packageProtection;
    }

    public void setPackageProtection(String packageProtection) {
        this.packageProtection = packageProtection;
    }

    public String getShippingTo() {
        return shippingTo;
    }

    public void setShippingTo(String shippingTo) {
        this.shippingTo = shippingTo;
    }

    public double getInvoiceAmount() {
        return invoiceAmount;
    }

    public void setInvoiceAmount(double invoiceAmount) {
        this.invoiceAmount = invoiceAmount;
    }

    public String getModeOfShipment() {
        return modeOfShipment;
    }

    public void setModeOfShipment(String modeOfShipment) {
        this.modeOfShipment = modeOfShipment;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDiscounts() {
        return discounts;
    }

    public void setDiscounts(double discounts) {
        this.discounts = discounts;
    }

    public double getIncrements() {
        return increments;
    }

    public void setIncrements(double increments) {
        this.increments = increments;
    }

    public Order(int id, String color, String size, int quantity, String shippingTo, String modeOfShipment, double price) {
        this.id = id;
        this.color = color;
        this.size = size;
        this.quantity = quantity;
        this.shippingTo = shippingTo;
        this.modeOfShipment = modeOfShipment;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", color='" + color + '\'' +
                ", size='" + size + '\'' +
                ", quantity=" + quantity +
                ", packageType='" + packageType + '\'' +
                ", packageProtection='" + packageProtection + '\'' +
                ", shippingTo='" + shippingTo + '\'' +
                ", invoiceAmount=" + invoiceAmount +
                ", modeOfShipment='" + modeOfShipment + '\'' +
                ", price=" + price +
                ", discounts=" + discounts +
                ", increments=" + increments +
                '}';
    }
}
