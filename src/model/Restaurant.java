/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mga
 */
public class Restaurant {
    private final int id;
    private String name;
    private String location;
    private List<Review> reviewsCollection;
    
    private static int lastIdAllocated = 0;
    
    static final char EOLN='\n';       
    static final String QUOTE="\""; 

    /**
     *
     */
    public Restaurant() {
        this.id = ++lastIdAllocated;
        this.name = "TBC";
        this.location = "TBC";
        this.reviewsCollection = new ArrayList<>();        
    }

    /**
     *
     * @param name
     * @param location
     */
    public Restaurant(String name, String location) {
        this.id = ++lastIdAllocated;
        this.name = name;
        this.location = location;
        this.reviewsCollection = new ArrayList<>();
    }

    /**
     *
     * @param name
     * @param location
     * @param reviewsCollection
     */
    public Restaurant(String name, String location, List<Review> reviewsCollection) {
        this.id = ++lastIdAllocated;        
        this.name = name;
        this.location = location;
        this.reviewsCollection = reviewsCollection;
    }

    /**
     *
     * @param id
     * @param name
     * @param location
     * @param reviewsCollection
     */
    public Restaurant(int id, String name, String location, List<Review> reviewsCollection) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.reviewsCollection = reviewsCollection;
        if (id > Restaurant.lastIdAllocated)
            Restaurant.lastIdAllocated = id;            
    }
    
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }    

    // Methods required: getters, setters, add, hashCode, equals, compareTo, comparator
    public String getName(){
        return this.name;
    } 
    public void setname(String name) {
        this.name = name;
    }
    
     public String getLocation(){
        return this.location;
    } 
    public void setLocation(String location) {
        this.location = location;
    }
    
    
     public List<Review> getReviewsCollection(){
        return this.reviewsCollection;
    } 
    public void setReviewsCollection(List<Review> reviewsCollection) {
        this.reviewsCollection = reviewsCollection;
    }
    
    @Override
    public String toString() {
        return "\nRestaurant Id: " + id + " - Name: " + name +            
                " - Location: " + location + "\nReviews: " + reviewsCollection + "\n";
    }    
    
    public String toString (char delimiter ) {
        String a = this.id + delimiter + QUOTE + this.name + QUOTE + delimiter + QUOTE + this.location + QUOTE + delimiter + Integer.toString(this.reviewsCollection.size())+EOLN;
        String b = "";
        for (int i = 0; i < this.reviewsCollection.size(); i++){
            b = b + reviewsCollection.get(i).toString(delimiter);
        }
        return a+b;
    }
    
    @Override
    public boolean equals(Object o){
        if(o instanceof Restaurant){
           Restaurant r = (Restaurant)o;
           return r.id == this.id; 
        }
        else{
            return false;
        }
    }
    
    @Override
    public int hashCode(){
        return getId()*16 + getLocation().hashCode()*16 + getName().hashCode()*16;
    }
     
    public int compareTo(Restaurant compareRestaurant){
        int resid=compareRestaurant.getId();
        return this.id - resid;
    }
}
