package daos;

import repositories.Repository;

public class DAOObjectImp implements DAOInterface {
    static final char delimiter = ',';

    @Override
    public Repository load(String filename){
        Repository repository = new Repository();

        return repository;
    }

    @Override
    public void store(String filename, Repository repository) {

    }
}
