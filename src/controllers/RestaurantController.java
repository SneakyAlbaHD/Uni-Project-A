/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import helpers.InputHelper;
import model.Restaurant;
import repositories.Repository;

import java.util.List;

public class RestaurantController {
    private final Repository repository;

    public RestaurantController() {
       InputHelper input = new InputHelper();
       char opt = input.readCharacter("Load Restaurants from an existing file? [Y/N]");
       if (Character.toLowerCase(opt) == 'y'){
            String file = input.readString("Enter path to file");
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
                case 'A': 
                    addRestaurant();
                    break;
                case 'B':  
                    addReview();
                    break;
                case 'C': 
                    listLocationRestaurantDataInNameOrder();
                    break;                    
                case 'D': 
                    listRestaurantRatings();
                    break;
                case 'Q': 
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
        return inputHelper.readCharacter("Enter choice", "ABCDQ");
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
    }     
}
