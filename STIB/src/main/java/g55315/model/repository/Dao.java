package g55315.model.repository;

import g55315.model.dto.StopDto;
import g55315.model.exception.RepositoryException;
import g55315.model.dto.Dto;

import java.util.List;

/**
 * Data access object of a resource (file, database, web service).
 *
 * @see
 * <a href="https://en.wikipedia.org/wiki/Data_access_object"> Wikipedia</a>
 *
 * @author jlc
 * @param <K> key of an item.
 * @param <T> item of the resource.
 */
public interface Dao<K, T extends Dto<K>> {
    /**
     * Returns all the elements of the resource. This method can be long.
     *
     * @return all the elements of the resource.
     * @throws RepositoryException if the resource can't be accessed.
     */
    List<T> selectAll() throws RepositoryException;

    /**
     * Returns an element based on its key.
     *
     * @param key key of the element to select.
     * @return an element based on its key.
     * @throws RepositoryException if the resource can't be accessed.
     */
    List<T> select(K key) throws RepositoryException;



    }

