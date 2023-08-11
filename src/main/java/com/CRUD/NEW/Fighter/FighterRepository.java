package com.CRUD.NEW.Fighter;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface FighterRepository extends MongoRepository<Fighter, Integer> {

    @Query("{name:'?0'}")
    Fighter findFighterByName(String name);

    @Query(value = "{WeightClass:'?0'}", fields = "{name:1,Record:1}")
    List<Fighter> findAll(String WeightClass);

    public long count();
}
