/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author mga
 */
public class Review {
    
    private String reviewer;
    private int rating;
    
    static final char EOLN='\n';       
    static final String QUOTE="\""; 

    /**
     *
     */
    public Review() {
        this.reviewer = "TBC";
        this.rating = 0;
    }

    /**
     *
     * @param reviewer
     * @param rating
     */
    public Review(String reviewer, int rating) {
        this.reviewer = reviewer;
        this.rating = rating;
    }
    
    // Methods required: getters, setters
    public String getReviewer(){
        return this.reviewer;
    }
    
    public void setReviewer(String reviewer){
        this.reviewer = reviewer;
    }
    
    public int getRating(){
        return this.rating;
    }
    
    
    public void setRating(int rating){
        this.rating = rating;
    }
    
     
    
    /**
     *
     * @return
     */
    
    @Override
    public String toString() {
        return "Review{" + "reviewer=" + reviewer + ", rating=" + Integer.toString(rating) + '}';
    }   
    
    
     
    public String toString(char delimiter) {
        return QUOTE + reviewer + QUOTE + delimiter + Integer.toString(rating) + EOLN;
    }   

}
