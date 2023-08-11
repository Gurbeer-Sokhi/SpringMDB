package com.CRUD.NEW;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.CRUD.NEW.model.Fighter;
import com.CRUD.NEW.repository.FighterRepository;

@SpringBootApplication
@EnableMongoRepositories
public class MdbSpringBootApplication implements CommandLineRunner {

    @Autowired
    FighterRepository FighterRepo;

    public static void main(String[] args) {
        SpringApplication.run(MdbSpringBootApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // TODO Auto-generated method stub
        System.out.println("-------------CREATE GROCERY ITEMS-------------------------------\n");

        createFighters();

        System.out.println("\n----------------SHOW ALL GROCERY ITEMS---------------------------\n");

        showAllFighters();

        System.out.println("\n--------------GET ITEM BY NAME-----------------------------------\n");

        getFighterByName("Whole Wheat Biscuit");

        System.out.println("\n-----------GET ITEMS BY CATEGORY---------------------------------\n");

        getFighterByWeight("millets");

        System.out.println("\n----------DELETE A GROCERY ITEM----------------------------------\n");

        deleteFighter(3);

        System.out.println("\n------------FINAL COUNT OF GROCERY ITEMS-------------------------\n");

        findCountOfFighters();

        System.out.println("\n-------------------THANK YOU---------------------------");
    }

    void createFighters() {
        System.out.println("Data creation started...");
        FighterRepo.save(new Fighter(1, "Khabib", "featherWeight", "28-0-0"));
        FighterRepo.save(new Fighter(2, "McGregor", "featherWeight", "30-1-4"));
        FighterRepo.save(new Fighter(3, "Alex", "featherWeight", "28-0-1"));

        System.out.println("Data creation complete...");
    }

    public void showAllFighters() {

        FighterRepo.findAll().forEach(Fighter -> System.out.println(getFighterDetails(Fighter)));
    }

    // 2. Get item by name
    public void getFighterByName(String name) {
        System.out.println("Getting item by name: " + name);
        Fighter item = FighterRepo.findFighterByName(name);
        System.out.println(getFighterDetails(item));
    }

    // 3. Get name and quantity of a all items of a particular category
    public void getFighterByWeight(String category) {
        System.out.println("Getting items for the category " + category);
        List<Fighter> list = FighterRepo.findAll(category);

        list.forEach(item -> System.out.println("Name: " + item.getName() + ", Weight: " + item.getWeightClass()));
    }

    // 4. Get count of documents in the collection
    public void findCountOfFighters() {
        long count = FighterRepo.count();
        System.out.println("Number of Fighters in the collection: " + count);
    }

    public String getFighterDetails(Fighter item) {

        System.out.println(
                "Item Name: " + item.getName() +
                        ", \nWeight: " + item.getWeightClass() +
                        ", \nFighter Record: " + item.getRecord());

        return "";
    }

    // public void updateCategoryName(String category) {

    // // Change to this new value
    // String newCategory = "munchies";

    // // Find all the items with the category snacks
    // List<Fighter> list = FighterRepo.findAll(category);

    // list.forEach(item -> {
    // // Update the category in each document
    // item.setCategory(newCategory);
    // });

    // Save all the items in database
    // List<Fighter> itemsUpdated = FighterRepo.saveAll(list);

    // if (itemsUpdated != null)
    // System.out.println("Successfully updated " + itemsUpdated.size() + "
    // items.");

    // }

    public void deleteFighter(int id) {
        FighterRepo.deleteById(id);
        System.out.println("Fighter with id " + id + " deleted...");
    }

}