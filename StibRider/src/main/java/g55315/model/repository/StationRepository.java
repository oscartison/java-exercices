package g55315.model.repository;

import g55315.model.dto.StationDto;
import g55315.model.exception.RepositoryException;
import g55315.model.jdbc.StationDao;

import java.util.List;

/**
 * class that manages the station part of the database
 */
public class StationRepository implements Repository<String, StationDto> {

    private final StationDao dao;

    public StationRepository() throws RepositoryException {
        dao = StationDao.getInstance();
    }

    StationRepository(StationDao dao) {
        this.dao = dao;
    }


    @Override
    public List<StationDto> getAll() throws RepositoryException {
        return dao.selectAll();
    }

    @Override
    public StationDto get(String key) throws RepositoryException {
        StationDto refreshItem = dao.select(key);
        return refreshItem;
    }

    @Override
    public boolean contains(String key) throws RepositoryException {
        StationDto refreshItem = dao.select(key);
        return refreshItem != null;
    }

    @Override
    public String add(StationDto item) throws RepositoryException {
        return null;
    }

    @Override
    public void remove(String key) throws RepositoryException {

    }

}
