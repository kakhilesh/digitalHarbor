package com.warehouse.warehouse.model;

public class OrderResponse {
    private int id;
    private String packageType;
    private String protectionType;
    private double discount;
    private double increment;
    private double totalAmount;

    public OrderResponse(int id, String packageType, String protectionType, double discount, double increment, double totalAmount) {
        this.id = id;
        this.packageType = packageType;
        this.protectionType = protectionType;
        this.discount = discount;
        this.increment = increment;
        this.totalAmount = totalAmount;
    }
}
