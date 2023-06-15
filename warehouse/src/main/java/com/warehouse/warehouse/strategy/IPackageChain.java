package com.warehouse.warehouse.strategy;


import com.warehouse.warehouse.model.Order;

public interface IPackageChain {
    void setNextChain(IPackageChain nextChain);

    Order packaging(Order order);
}
