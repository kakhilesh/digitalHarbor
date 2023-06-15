package com.warehouse.warehouse.service;

import com.warehouse.warehouse.model.Order;
import com.warehouse.warehouse.model.OrderResponse;
import com.warehouse.warehouse.repository.OrderRepository;
import com.warehouse.warehouse.strategy.IPackageChain;
import com.warehouse.warehouse.strategy.impl.PackagingChain;
import com.warehouse.warehouse.strategy.impl.WoodPackaging;
import com.warehouse.warehouse.utility.OrderHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    OrderHelper orderHelper;

    @Autowired
    PackagingChain packagingChain;

    public Order placeOrder(Order order){
        IPackageChain woodChain = new WoodPackaging();
        PackagingChain packagingChain1 = new PackagingChain();
        packagingChain1.getPackagingChain().packaging(order);
        order = orderRepository.save(orderHelper.orderInvoicing(order));
        //Generate Response
        return order;
    }
}
