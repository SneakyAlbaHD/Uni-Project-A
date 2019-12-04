package repositories;

import daos.DAOTextImp;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Repository<T extends RepositoryObject> implements RepositoryInterface<T> {
    private List<T> items;
    
    public Repository() {
        items = new ArrayList<>();
    }
    
    public Repository(List<T> items) {
        this.items = items;
    }
    
    public Repository(String filename) {
        this();
        DAOTextImp dao = new DAOTextImp();
        items = dao.load(filename).getItems();
    }
    
    @Override
    public List<T> getItems() {
        return items;
    }
    
    @Override
    public void setItems(List<T> items) {
        this.items = items;
    }
    
    @Override
    public void add(T item) {
        items.add(item);
    }
       
    @Override
    public void remove(int id) {
        Predicate<T> predicate = e->e.getId() == id;
        items.removeIf(predicate);
    }
    
    @Override
    public T getItem(int id) {
        for (T item:items) {
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
