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

        InputHelper input = new InputHelper();
        String name = input.readString("Please enter the name of the Restaurant to add");
        String location = input.readString("Please enter the location of the Restaurant to add");

        Restaurant restaurant = new Restaurant(name, location);
        repository.add(restaurant);
    }
    
    private void addReview() {        
        System.out.format("\033[31m%s\033[0m%n", "Add Restaurant Review");
        System.out.format("\033[31m%s\033[0m%n", "=====================");

        InputHelper input = new InputHelper();

        int id = input.readInt("Please enter the id of the Restaurant to review");

        String reviewer = input.readString("Please enter the name of the reviewer");
        int rating = input.readInt("Please enter the restaurant's rating [1 - 5]", 5, 1);

        Review review = new Review(reviewer, rating);
        repository.getItem(id).addReview(review);
    }    
      

    private void listLocationRestaurantDataInNameOrder() {        
        System.out.format("\033[31m%s\033[0m%n", "Name Order");
        System.out.format("\033[31m%s\033[0m%n", "==========");

        InputHelper input = new InputHelper();
        String location = input.readString("Please enter a location");
        
        List<Restaurant> temp = new ArrayList<>();
        for (Restaurant r: repository.getItems()) {
            if (r.getLocation().equals(location)){ temp.add(r); }
        }
        temp.sort(Restaurant.NameComparator);
        System.out.println(temp);
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
