package repositories;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import daos.DAOTextImp;
import model.Restaurant;


public class Repository implements RepositoryInterface, Serializable {
    private List<Restaurant> items;
    
    public Repository() {
        items = new ArrayList<>();
    }
    
    public Repository(List<Restaurant> items) {
        this.items = items;
    }
    
    public Repository(String filename) {
        this();
        DAOTextImp dao = new DAOTextImp();
        items = dao.load(filename).getItems();
    }
    
    @Override
    public List<Restaurant> getItems() {
        return items;
    }
    
    @Override
    public void setItems(List<Restaurant> items) {
        this.items = items;
    }
    
    @Override
    public void add(Restaurant item) {
        items.add(item);
    }
       
    @Override
    public void remove(int id) {
        Predicate<Restaurant> predicate = e->e.getId() == id;       
        items.removeIf(predicate);
    }
    
    @Override
    public Restaurant getItem(int id) {
        for (Restaurant item:items) {
            if (item.getId() == id) { return item; }
        }
        return null;
    }
    
    @Override
    public String toString() {
        return "\nItems: " + items;
    }    
    
    @Override
    public void store(String filename) {
        DAOTextImp dao = new DAOTextImp();
        dao.store(filename, this);
    }        
}
