package repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import daos.DAOTextImp;
import model.Restaurant;


public class Repository implements RepositoryInterface {
    private List<Restaurant> items;
    
    public Repository() {
        this.items = new ArrayList<>();
    }
    
    public Repository(List<Restaurant> items) {
        this.items = items;
    }
    
    public Repository(String filename) {
        this();
        DAOTextImp dao = new DAOTextImp();
        this.items = dao.load(filename).getItems();
    }
    
    @Override
    public List<Restaurant> getItems() {
        return this.items;
    }
    
    @Override
    public void setItems(List<Restaurant> items) {
        this.items = items;
    }
    
    @Override
    public void add(Restaurant item) {
        this.items.add(item);
    }
       
    @Override
    public void remove(int id) {
        Predicate<Restaurant> predicate = e->e.getId() == id;       
        this.items.removeIf(predicate);
    }
    
    @Override
    public Restaurant getItem(int id) {
        for (Restaurant item:this.items) {
            if (item.getId() == id)
                return item;
        }
        return null;
    }
    
    @Override
    public String toString() {
        return "\nItems: " + this.items;
    }    
    
    @Override
    public void store(String filename) {
        DAOTextImp dao = new DAOTextImp();
        dao.store(filename, this);
    }        
}
