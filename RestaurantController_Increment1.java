package controllers;

import helpers.InputHelper;
import java.util.ArrayList;
import model.Restaurant;
import model.Review;
import repositories.Repository;

import java.util.List;

public class RestaurantController {
    private final Repository<Restaurant> repository;

    public RestaurantController() {
       InputHelper input = new InputHelper();
       char opt = input.readCharacter("Load Restaurants from an existing file? [Y/N]");
       if (Character.toLowerCase(opt) == 'y'){
            String file = input.readString("Enter path to file to load (relative or absolute)");
            this.repository = new Repository(file);
       }
       else {
           this.repository = new Repository();
       }
    }

    public void run() {
        boolean finished = false;
        
        do {
            char choice = displayMenu();
            switch (choice) {
                case 'a':
                    addRestaurant();
                    break;
                case 'b':
                    addReview();
                    break;
                case 'c':
                    listLocationRestaurantDataInNameOrder();
                    break;                    
                case 'd':
                    listRestaurantRatings();
                    break;
                case 'q':
                    finished = true;
            }
        } while (!finished);
    }
    
    private char displayMenu() {
        listRestaurantDataInIdOrder();
        InputHelper inputHelper = new InputHelper();
        System.out.print("\nA. Add Restaurant");
        System.out.print("\tB. Add Restaurant Review");        
        System.out.print("\tC. List Location Restaurant Data In Name Order");
        System.out.print("\tD. List Restaurant Ratings");       
        System.out.print("\tQ. Quit\n");         
        return Character.toLowerCase(inputHelper.readCharacter("Enter choice", "ABCDQ"));
    }    
    
    private void addRestaurant() {
        System.out.format("\033[31m%s\033[0m%n", "Add Restaurant");
        System.out.format("\033[31m%s\033[0m%n", "==============");
    }
    
    private void addReview() {        
        System.out.format("\033[31m%s\033[0m%n", "Add Restaurant Review");
        System.out.format("\033[31m%s\033[0m%n", "=====================");
    }    
      

    private void listLocationRestaurantDataInNameOrder() {        
        System.out.format("\033[31m%s\033[0m%n", "Name Order");
        System.out.format("\033[31m%s\033[0m%n", "==========");
    }    
    
    private void listRestaurantRatings() {
        System.out.format("\033[31m%s\033[0m%n", "Restaurant Ratings");
        System.out.format("\033[31m%s\033[0m%n", "==================");
    }    
    
    private void listRestaurantDataInIdOrder() {        
        System.out.format("\033[31m%s\033[0m%n", "Restaurant Id Order");
        System.out.format("\033[31m%s\033[0m%n", "===================");

        repository.getItems().sort(Restaurant.IdComparator);
        System.out.println(repository.getItems());
    }
}
