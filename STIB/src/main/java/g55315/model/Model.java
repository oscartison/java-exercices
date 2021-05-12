package g55315.model;

import g55315.model.config.ConfigManager;
import g55315.model.designpattern.Observable;
import g55315.model.designpattern.Observer;
import g55315.model.dijkstra.StibGraph;
import g55315.model.dto.FavoriteDto;
import g55315.model.dto.StationDto;
import g55315.model.dto.StopDto;
import g55315.model.exception.RepositoryException;
import g55315.model.repository.FavoritesRepository;
import g55315.model.repository.StationRepository;
import g55315.model.repository.StopRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * the model of the whole application
 */
public class Model implements Observable {

    private List<Observer> listObservers;
    private StibGraph stibGraph;
    private StopRepository stopRepository;
    private StationRepository stationRepository;
    private FavoritesRepository favoritesRepository;
    private List<StopDto> path;

    /**
     * gets the shortest path
     * @return the path
     */
    public List<StopDto> getPath() {
        return path;
    }

    /**
     * a constructor for the class
     */
    public Model() {
        try {
            listObservers = new ArrayList<>();
            ConfigManager.getInstance().load();
            stopRepository = new StopRepository();
            stationRepository = new StationRepository();
            favoritesRepository = new FavoritesRepository();
            stibGraph =  new StibGraph();
            path = new ArrayList<>();
        } catch (RepositoryException | IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * a getter for all the favorites in the database
     * @return the favorites
     * @throws RepositoryException
     */
    public List<String> getFavorites() throws RepositoryException {
        List<String> favoToString = new ArrayList<>();
            List<FavoriteDto> favos = favoritesRepository.getAll();
            for(FavoriteDto fav:favos) {
                favoToString.add(fav.getKey());
            }
        return favoToString;
    }

    /**
     * a getter for the names of all the stations
     * @return the name of all the stations
     * @throws RepositoryException
     */
    public List<String> getStationNames() throws RepositoryException {
            List<StationDto> dtos = stationRepository.getAll();
            List<String> stationNames = new ArrayList<>();
            for(StationDto station:dtos) {
                stationNames.add(station.getKey());
            }
            return stationNames;
    }

    /**
     * a getter for the favorite in the database with this id
     * @param id the id of the favorite to get
     * @return the favorite with the given id
     * @throws RepositoryException
     */
    public FavoriteDto getFavorite(String id) throws RepositoryException {

            return favoritesRepository.get(id);

    }

    /**
     * deletes the favorite with the given id
     * @param id the id of the favorite to delete
     * @throws RepositoryException
     */
    public void deleteFav(String id) throws RepositoryException {
            favoritesRepository.remove(id);
            notifyObservers();
    }

    /**
     * calculates the path from a begin station to an end station
     * @param begin the begin station
     * @param end the end station
     * @throws RepositoryException
     */
    public void calucatePath(String begin, String end) throws RepositoryException {
        stibGraph.shortestPath(begin, end);
        List<String> pathNames = stibGraph.getPath();
        path.clear();
        for(String name: pathNames) {
                StopDto stop = stopRepository.get(name);
                path.add(stop);
        }
        notifyObservers();
    }

    /**
     * inserts a favorite in the database
     * @param begin the begin station of the new favorite
     * @param end the end station of the new favorite
     * @param name
     * @throws RepositoryException
     */
    public void insertFavoite(String begin, String end, String name) throws RepositoryException {
            favoritesRepository.add(new FavoriteDto(name,begin,end));
            notifyObservers();
    }

    @Override
    public void addObserver(Observer obs) {
        listObservers.add(obs);
    }

    @Override
    public void notifyObservers() {
        notifyObservers(null);
    }

    @Override
    public void notifyObservers(Object arg) {
        for (Observer obs : listObservers) {
            obs.update(this, arg);
        }
    }
}
