/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

public class Review {
    private String reviewer;
    private int rating;
    
    static final char EOLN='\n';       
    static final String QUOTE="\""; 

    public Review() {
        this.reviewer = "TBC";
        this.rating = 0;
    }

    public Review(String reviewer, int rating) {
        this.reviewer = reviewer;
        this.rating = rating;
    }

    public String getReviewer(){ return reviewer; }
    
    public void setReviewer(String reviewer){ this.reviewer = reviewer; }
    
    public int getRating(){ return rating; }
    
    public void setRating(int rating){ this.rating = rating; }

    @Override
    public String toString() {
        return "Review{" + "reviewer=" + reviewer + ", rating=" + rating + '}';
    }   

    public String toString(char delimiter) {
        return QUOTE + reviewer + QUOTE + delimiter + rating + EOLN;
    }
}
