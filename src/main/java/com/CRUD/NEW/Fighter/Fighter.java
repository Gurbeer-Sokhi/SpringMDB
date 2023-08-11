package com.CRUD.NEW.Fighter;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Fighters")
public class Fighter {

    @Id
    private int Id;
    private String Name;
    private String WeightClass;
    private String Record;

    public Fighter(int id, String Name, String WeightClass, String record) {
        Id = id;
        this.Name = Name;
        this.WeightClass = WeightClass;
        Record = record;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public String getWeightClass() {
        return WeightClass;
    }

    public void setWeightClass(String weightClass) {
        this.WeightClass = weightClass;
    }

    public String getRecord() {
        return Record;
    }

    public void setRecord(String record) {
        Record = record;
    }

}
