package com.CRUD.NEW.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.CRUD.NEW.model.Fighter;

public interface FighterRepository extends MongoRepository<Fighter, Integer> {

    @Query("{name:'?0'}")
    Fighter findFighterByName(String name);

    @Query(value = "{WeightClass:'?0'}", fields = "{name:1,Record:1}")
    List<Fighter> findAll(String WeightClass);

    public long count();
}
