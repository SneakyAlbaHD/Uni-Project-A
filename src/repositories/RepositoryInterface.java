package repositories;

import java.util.List;

public interface RepositoryInterface<T> {
    void add(T item);

    T getItem(int id);

    List<T> getItems();

    void remove(int id);

    void setItems(List<T> items);

    void store(String filename);

    @Override
    String toString();
}
