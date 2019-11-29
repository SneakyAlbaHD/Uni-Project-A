package daos;

import model.Restaurant;
import model.Review;
import repositories.Repository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static com.sun.javafx.util.Utils.stripQuotes;

public class DAOTextImp implements DAOInterface {
    static final char delimiter = ',';

    @Override
    public Repository load(String filename){
        Repository repository = new Repository();

        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(filename))){
            String[] temp;
            String line = bufferedReader.readLine();
            while (line!=null) {
                temp=line.split(Character.toString(delimiter));
                int id = Integer.parseInt(temp[0]);
                String name = stripQuotes(temp[1]);
                String location = stripQuotes(temp[2]);
                List<Review> reviewsCollection = new ArrayList<>();
                int num = Integer.parseInt(temp[3]);
                for (int i = 0; i < num; i++) {
                    line = bufferedReader.readLine();
                    temp=line.split(Character.toString(delimiter));
                    String reviewer = stripQuotes(temp[0]);
                    int rating = Integer.parseInt(temp[1]);
                    Review review = new Review(reviewer, rating);
                    reviewsCollection.add(review);
                }
                Restaurant restaurant = new Restaurant(id, name, location, reviewsCollection);
                repository.add(restaurant);
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return repository;
    }

    @Override
    public void store(String filename, Repository repository) {
        try (PrintWriter printWriter = new PrintWriter(new FileWriter(filename))) {
            for (int i = 1; i <= repository.getItems().size(); i++) {
                printWriter.println(repository.getItem(i).toString(delimiter));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
