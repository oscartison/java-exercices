package g55315.presenter;

import g55315.model.Model;
import g55315.model.designpattern.Observable;
import g55315.model.designpattern.Observer;
import g55315.model.dto.FavoriteDto;
import g55315.model.dto.StopDto;
import g55315.model.exception.RepositoryException;
import g55315.view.FxmlController;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.List;

/**
 * the presenter of the application
 */
public class Presenter implements Observer {
   private Model model;

    private FxmlController view;

    /**
     * initializes the presenter
     * @throws RepositoryException
     */
    public void init() throws RepositoryException {

        view.setCombo(model.getStationNames());
        view.setFavorites(model.getFavorites());
        view.getStations().setCellValueFactory(new PropertyValueFactory<>("key"));
        view.getLignes().setCellValueFactory(new PropertyValueFactory<>("id_line"));}

    /**
     * calculates path from begin station to end station
     * @param begin begin station
     * @param end end station
     * @throws RepositoryException
     */
    public void calculatePath(String begin, String end) throws RepositoryException {
        model.calucatePath(begin, end);
    }

    /**
     * constructor for the presenter
     * @param view the view of the presenter
     */
    public Presenter(FxmlController view) {
        this.view = view;
        model = new Model();
        model.addObserver(this);
    }

    /**
     * searches the path for a certain favorite
     * @param fav the string of the favorite
     * @throws RepositoryException
     */
    public void searchFav(String fav) throws RepositoryException {
        FavoriteDto favoriteDtos  = model.getFavorite(fav);
        calculatePath(favoriteDtos.getOrigin(),favoriteDtos.getDestination());
    }

    /**
     * deletes a certain favorite
     * @param fav the favorite to delete
     * @throws RepositoryException
     */
    public void deleteFav(String fav) throws RepositoryException {
        model.deleteFav(fav);

    }

    /**
     * adds a traject to the favorites
     * @param begin the begin station
     * @param end the end station
     * @throws RepositoryException
     */
    public void addFavorite(String begin,String end,String name) throws RepositoryException {
        model.insertFavoite(begin, end,name);
    }

    @Override
    public void update(Observable observable, Object arg) {
        if(observable instanceof Model) {
            Model model = (Model) observable;
            List<StopDto> stops = model.getPath();
            view.clearTable();
            for(StopDto stop:stops) {
                view.addToTable(stop);
            }
            try {
                view.setFavorites(model.getFavorites());
            } catch (RepositoryException e) {
                e.printStackTrace();
            }
        }
    }
}
