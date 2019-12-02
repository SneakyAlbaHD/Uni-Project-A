package repositories;

import model.Restaurant;

import java.util.List;

public interface RepositoryInterface {
    void add(Restaurant item);

    Restaurant getItem(int id);

    List<Restaurant> getItems();

    void remove(int id);

    void setItems(List<Restaurant> items);

    void store(String filename);

    @Override
    String toString();
}
