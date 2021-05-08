package g55315.model.repository;



import g55315.model.dto.LineDto;
import g55315.model.exception.RepositoryException;
import g55315.model.jdbc.LineDao;

import java.util.List;

public class LineRepository implements Repository<Integer, LineDto> {

    private final LineDao dao;

    public LineRepository() throws RepositoryException {
        dao = LineDao.getInstance();
    }

    LineRepository(LineDao dao) {
        this.dao = dao;
    }


    @Override
    public List<LineDto> getAll() throws RepositoryException {
        return dao.selectAll();
    }

    @Override
    public List<LineDto> get(Integer key) throws RepositoryException {
        List<LineDto> refreshItem = dao.select(key);
        return refreshItem;
    }

    @Override
    public boolean contains(Integer key) throws RepositoryException {
        List<LineDto> refreshItem = dao.select(key);
        return refreshItem != null;
    }

    @Override
    public Integer add(LineDto item) throws RepositoryException {
        return null;
    }

    @Override
    public void remove(Integer key) throws RepositoryException {

    }

}
