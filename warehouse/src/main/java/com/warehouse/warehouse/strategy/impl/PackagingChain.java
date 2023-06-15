package com.warehouse.warehouse.strategy.impl;

import com.warehouse.warehouse.strategy.IPackageChain;
import org.springframework.stereotype.Repository;

@Repository
public class PackagingChain {
    private IPackageChain woodChain;

    public PackagingChain(){
        //initializing the chain
        this.woodChain = new WoodPackaging();
        IPackageChain cardBoardChain = new CardBoardPackaging();
        IPackageChain plasticChain = new PlasticPackaging();

        //setting the chain of responsibility
        woodChain.setNextChain(cardBoardChain);
        cardBoardChain.setNextChain(plasticChain);
    }
    public IPackageChain getPackagingChain(){
        return woodChain;
    }
}
