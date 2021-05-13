package g55315.model.repository;



import g55315.model.dto.FavoriteDto;
import g55315.model.exception.RepositoryException;
import g55315.model.jdbc.FavoriteDao;

import java.util.List;

public class FavoritesRepository implements Repository<Integer, FavoriteDto> {

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
    public FavoriteDto get(Integer key) throws RepositoryException {
        FavoriteDto refreshItem = dao.select(key);
        return refreshItem;
    }

    @Override
    public boolean contains(Integer key) throws RepositoryException {
        FavoriteDto refreshItem = dao.select(key);
        return refreshItem != null;
    }

    @Override
    public Integer add(FavoriteDto item) throws RepositoryException {
        Integer key = item.getKey();
        if (contains(key)) {
            dao.update(item);
        } else {
            key = dao.insert(item);
        }
        return key;
    }

    @Override
    public void remove(Integer key) throws RepositoryException {
        dao.delete(key);
    }

}
