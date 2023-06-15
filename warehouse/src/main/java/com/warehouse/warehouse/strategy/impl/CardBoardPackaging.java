package com.warehouse.warehouse.strategy.impl;

import com.warehouse.warehouse.constant.PackagingMaterial;
import com.warehouse.warehouse.constant.PackagingProtection;
import com.warehouse.warehouse.constant.ShipmentMode;
import com.warehouse.warehouse.constant.Size;
import com.warehouse.warehouse.model.Order;
import com.warehouse.warehouse.strategy.IPackageChain;


public class CardBoardPackaging implements IPackageChain {

        private IPackageChain chain;

        @Override
        public void setNextChain(IPackageChain nextChain) {
            this.chain=nextChain;
        }

        @Override
        public Order packaging(Order order) {
            if(order.getSize().equals(Size.Medium.toString())){
                order.setPackageType(PackagingMaterial.CARDBOARD.toString());
                if(order.getModeOfShipment().equals(ShipmentMode.AIR.toString()))
                    order.setPackageProtection(PackagingProtection.BUBBLE_BAGS.toString());
                else if(order.getModeOfShipment().equals(ShipmentMode.LAND.toString()))
                    order.setPackageProtection(PackagingProtection.PLASTIC_PALLETS.toString());
                else
                    //default mode of shipment SEA
                    order.setPackageProtection(PackagingProtection.ABSORBING_PALLETS.toString());
            }else{
                this.chain.packaging(order);
            }
            return order;
        }

    }
