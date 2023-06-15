package com.warehouse.warehouse.service;

import com.warehouse.warehouse.model.Duckling;
import com.warehouse.warehouse.repository.DucklingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DucklingService {
    @Autowired
    DucklingRepository ducklingRepository;

    public List<Duckling> getAll(){
        List<Duckling> ducklings = ducklingRepository.findAll();
        ducklings = ducklings.stream()
                .sorted(Comparator.comparingInt(Duckling::getQuantity))
                .collect(Collectors.toList());
        return ducklings;
    }

    public List<Duckling> getAllActive(){
        List<Duckling> duckingList=  ducklingRepository.findAll();
        duckingList = duckingList.stream().filter(Duckling -> Duckling.isDelete()==false).sorted(Comparator.comparingInt(Duckling::getQuantity)).collect(Collectors.toList());
        return duckingList;
    }

    public Duckling add(Duckling duckling) {
        Duckling existingduckling = ducklingRepository.findByColorAndSizeAndPrice(duckling.getColor(), duckling.getSize(), duckling.getPrice());
        if (existingduckling != null) {
            //already exist so update the quantity
            existingduckling.setQuantity(existingduckling.getQuantity() + duckling.getQuantity());
            return ducklingRepository.save(existingduckling);
        } else {
            //does not exist with same color and price
            //if id present
            existingduckling = ducklingRepository.getById(duckling.getId());
            if (existingduckling != null) {
                //nothing as already present
                return existingduckling;
            } else {
                return ducklingRepository.save(duckling);
            }
        }
    }


    public Duckling delete(int id){
        //soft delete
        //this method will set the delete flag as true
        boolean deleted = true;
        Duckling duckling = ducklingRepository.getById(id);
        duckling.setDelete(deleted);
        return ducklingRepository.save(duckling);
    }

    public Duckling edit(Duckling duckling){
        Duckling existingDucking = ducklingRepository.getById(duckling.getId());
        //only price and quantity will be updated
        if(existingDucking!=null) {
            existingDucking.setQuantity(duckling.getQuantity());
            existingDucking.setPrice(duckling.getPrice());
            return ducklingRepository.save(existingDucking);
        }else{
            return ducklingRepository.save(duckling);
        }
    }


}
