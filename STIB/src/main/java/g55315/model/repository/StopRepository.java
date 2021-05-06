package g55315.model.repository;


import g55315.model.dto.StopDto;
import g55315.model.exception.RepositoryException;
import g55315.model.jdbc.StopDao;

import java.util.List;

/**
 *
 * @author jlc
 */
public class StopRepository implements Repository<Integer, StopDto> {

    private final StopDao dao;

    public StopRepository() throws RepositoryException {
        dao = StopDao.getInstance();
    }

    StopRepository(StopDao dao) {
        this.dao = dao;
    }


    @Override
    public List<StopDto> getAll() throws RepositoryException {
        return dao.selectAll();
    }

    @Override
    public List<StopDto> get(Integer key) throws RepositoryException {
        List<StopDto> refreshItem = dao.select(key);
        return refreshItem;
    }

    @Override
    public boolean contains(Integer key) throws RepositoryException {
        List<StopDto> refreshItem = dao.select(key);
        return refreshItem != null;
    }

}