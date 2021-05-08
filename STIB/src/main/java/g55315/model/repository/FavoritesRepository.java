package g55315.model.repository;



import g55315.model.dto.FavoriteDto;
import g55315.model.dto.LineDto;
import g55315.model.exception.RepositoryException;
import g55315.model.jdbc.FavoriteDao;
import g55315.model.jdbc.LineDao;

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
    public List<FavoriteDto> get(Integer key) throws RepositoryException {
        List<FavoriteDto> refreshItem = dao.select(key);
        return refreshItem;
    }

    @Override
    public boolean contains(Integer key) throws RepositoryException {
        List<FavoriteDto> refreshItem = dao.select(key);
        return refreshItem != null;
    }

    @Override
    public Integer add(FavoriteDto item) throws RepositoryException {
        return dao.insert(item);
    }

    @Override
    public void remove(Integer key) throws RepositoryException {
        dao.delete(key);
    }

}
