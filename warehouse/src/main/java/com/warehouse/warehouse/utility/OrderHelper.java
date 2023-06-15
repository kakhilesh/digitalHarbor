package com.warehouse.warehouse.utility;


import com.warehouse.warehouse.constant.Country;
import com.warehouse.warehouse.constant.PackagingMaterial;
import com.warehouse.warehouse.constant.ShipmentMode;
import com.warehouse.warehouse.model.Order;
import org.springframework.stereotype.Repository;

@Repository
public class OrderHelper {
    public Order orderInvoicing(Order order){
        double totalPrice = 0.0;
        double discount = 0.0;
        double increment = 0.0;
        totalPrice = order.getPrice()* order.getQuantity();
        if(order.getQuantity() > 100)
            discount += totalPrice*0.20;
        if(order.getPackageType().equals(PackagingMaterial.WOOD.toString()))
            increment += totalPrice*0.05;
        if(order.getPackageType().equals(PackagingMaterial.PLASTIC.toString()))
            increment += totalPrice*0.1;
        if(order.getPackageType().equals(PackagingMaterial.CARDBOARD.toString()))
            discount += totalPrice*0.01;
        if(order.getShippingTo().equals(Country.USA.toString()))
            increment += totalPrice*0.18;
        else if(order.getShippingTo().equals(Country.BOLIVIA.toString()))
            increment += totalPrice*0.13;
        else if(order.getShippingTo().equals(Country.INDIA.toString()))
            increment += totalPrice*0.19;
        else
            increment += totalPrice*0.15;
        if(order.getModeOfShipment().equals(ShipmentMode.SEA.toString()))
            increment += totalPrice + 400.0;
        if(order.getModeOfShipment().equals(ShipmentMode.LAND.toString()))
            increment += order.getQuantity()*10.0;
        if(order.getModeOfShipment().equals(ShipmentMode.AIR.toString())) {
            increment += order.getQuantity() * 30.0;
            if (order.getQuantity() > 1000)
                discount += totalPrice * 0.15;
        }
        order.setInvoiceAmount(totalPrice + increment - discount);
        order.setDiscounts(discount);
        order.setIncrements(increment);
        return order;
    }
}
