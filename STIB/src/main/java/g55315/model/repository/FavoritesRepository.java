package g55315.model.repository;



import g55315.model.dto.FavoriteDto;
import g55315.model.exception.RepositoryException;
import g55315.model.jdbc.FavoriteDao;

import java.util.List;

public class FavoritesRepository implements Repository<String, FavoriteDto> {

    private final FavoriteDao dao;

    public FavoritesRepository() throws RepositoryException {
        dao = FavoriteDao.getInstance();
    }

    FavoritesRepository(FavoriteDao dao) {
        this.dao = dao;
    }


    @Override
    public List<FavoriteDto> getAll() throws RepositoryException {
        return dao.selectAll();
    }

    @Override
    public FavoriteDto get(String key) throws RepositoryException {
        FavoriteDto refreshItem = dao.select(key);
        return refreshItem;
    }

    @Override
    public boolean contains(String key) throws RepositoryException {
        FavoriteDto refreshItem = dao.select(key);
        return refreshItem != null;
    }

    @Override
    public String add(FavoriteDto item) throws RepositoryException {
        String key = item.getKey();
        if (contains(key)) {
            dao.update(item);
        } else {
            key = dao.insert(item);
        }
        return key;
    }

    @Override
    public void remove(String key) throws RepositoryException {
        dao.delete(key);
    }

}
