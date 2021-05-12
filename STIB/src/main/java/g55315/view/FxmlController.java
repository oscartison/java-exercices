package g55315.view;


import g55315.model.exception.RepositoryException;
import g55315.presenter.Presenter;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import org.controlsfx.control.SearchableComboBox;
import javafx.fxml.FXML;


import java.net.URL;

import java.util.List;
import java.util.ResourceBundle;

/**
 * class that controls the view
 */
public class FxmlController implements Initializable {

    @FXML
    private SearchableComboBox<String> origine;

    @FXML
    private SearchableComboBox<String> destination;

    @FXML
    private TextField favoName;


    @FXML
    private TableColumn stations;

    @FXML
    private TableColumn lignes;

    @FXML
    private TableView table;

    @FXML
    private ComboBox<String> favorites;

    private Presenter presenter;


    /**
     * setter for the presenter
     * @param presenter the presenter
     */
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    /**
     * handles the button search
     * @param e event
     * @throws RepositoryException
     */
    @FXML
    public void handleButton(ActionEvent e) throws  RepositoryException {
        if(origine.getValue() !=null && destination.getValue()!=null) {
            presenter.calculatePath(origine.getValue(), destination.getValue());
        }
    }

    /**
     * handles the + button
     * @param e event
     * @throws RepositoryException
     */
    @FXML
    public void addFavorite(ActionEvent e) throws  RepositoryException {
        if(origine.getValue()!=null && destination.getValue()!=null) {

            presenter.addFavorite(origine.getValue(), destination.getValue(),favoName.getText());
        }
    }

    /**
     * handles the v button
     * @param e event
     * @throws InterruptedException
     * @throws RepositoryException
     */
    @FXML
    public void searchFav(ActionEvent e) throws  RepositoryException {
        if(favorites.getValue()!=null) {
            presenter.searchFav(favorites.getValue());
        }

    }

    /**
     * handles the - button
     * @param e event
     * @throws InterruptedException
     * @throws RepositoryException
     */
    @FXML
    public void deleteFav(ActionEvent e) throws InterruptedException, RepositoryException {
        if(favorites.getValue()!=null) {
            presenter.deleteFav(favorites.getValue());
        }

    }

    /**
     * adds an object to the table
     * @param ob object to add
     */
    public void addToTable(Object ob) {
            table.getItems().add(ob);
    }

    /**
     * clear the table
     */
    public void clearTable() {
        table.getItems().clear();
    }



    public FxmlController() {
    }

    /**
     * sets the value of the 2 searchable combo boxes
     * @param stations the values to add to the boxes
     */
    public void setCombo(List<String> stations) {
            destination.getItems().addAll(stations);
            origine.getItems().addAll(stations);
    }

    /**
     * adds values to the favorite box
     * @param favorite the favorites to add
     */
    public void setFavorites(List<String> favorite) {
        favorites.getItems().clear();
        favorites.getItems().addAll(favorite);
    }


    /**
     * a getter for the station attribute
     * @return the station attribute
     */
    public TableColumn getStations() {
        return stations;
    }

    /**
     * a getter for the ligne attribute
     * @return the ligne attribute
     */
    public TableColumn getLignes() {
        return lignes;
    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

}
