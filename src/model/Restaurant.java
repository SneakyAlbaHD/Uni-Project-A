/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import repositories.RepositoryObject;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Restaurant extends RepositoryObject implements Comparable<Restaurant> {
    private final int id;
    private String name;
    private String location;
    private List<Review> reviewsCollection;
    
    private static int lastIdAllocated = 0;
    
    static final char EOLN='\n';       
    static final String QUOTE="\""; 

    public Restaurant() {
        this.id = ++lastIdAllocated;
        this.name = "TBC";
        this.location = "TBC";
        this.reviewsCollection = new ArrayList<>();        
    }

    public Restaurant(String name, String location) {
        this.id = ++lastIdAllocated;
        this.name = name;
        this.location = location;
        this.reviewsCollection = new ArrayList<>();
    }

    public Restaurant(String name, String location, List<Review> reviewsCollection) {
        this.id = ++lastIdAllocated;        
        this.name = name;
        this.location = location;
        this.reviewsCollection = reviewsCollection;
    }

    public Restaurant(int id, String name, String location, List<Review> reviewsCollection) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.reviewsCollection = reviewsCollection;
        if (id > Restaurant.lastIdAllocated)
            Restaurant.lastIdAllocated = id;            
    }

    public int getId() {
        return id;
    }    

    public String getName(){
        return name;
    } 
    public void setName(String name) { this.name = name; }
    
    public String getLocation(){
        return location;
    } 
    public void setLocation(String location) {
        this.location = location;
    }
    
    public List<Review> getReviewsCollection(){
        return reviewsCollection;
    } 
    public void setReviewsCollection(List<Review> reviewsCollection) {
        this.reviewsCollection = reviewsCollection;
    }
    
    @Override
    public String toString() {
        return "\nRestaurant Id: " + id +
               " - Name: " + name +
               " - Location: " + location +
               "\nReviews: " + reviewsCollection + "\n";
    }    
    
    public String toString (char delimiter) {
        String out = id + delimiter +
                QUOTE + name + QUOTE + delimiter +
                QUOTE + location + QUOTE + delimiter +
                reviewsCollection.size() + EOLN;

        for (Review review : reviewsCollection){
            out += review.toString(delimiter);
        }

        return out;
    }
    
    @Override
    public boolean equals(Object o){
        if(o instanceof Restaurant){
           Restaurant r = (Restaurant)o;
           return r.getId() == id &&
                  r.getName() == name &&
                  r.getLocation() == location &&
                  r.getReviewsCollection().equals(reviewsCollection);
        }
        else{
            return false;
        }
    }
    
    @Override
    public int hashCode(){
        return id*9 + name.hashCode()*9 + location.hashCode()*9 + reviewsCollection.hashCode();
    }

    @Override
    public int compareTo(Restaurant compareRestaurant){
        int resId=compareRestaurant.getId();
        return id - resId;
    }

    public static Comparator<Restaurant> IdComparator = (r1, r2) -> {
        int id1 = r1.getId();
        int id2 = r2.getId();
        return id1 - id2;
    };

    public static Comparator<Restaurant> NameComparator = (r1, r2) -> {
        String name1 = r1.getName();
        String name2 = r2.getName();
        return name1.compareTo(name2);
    };
}
