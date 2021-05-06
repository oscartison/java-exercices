package g55315.view;


import g55315.model.config.ConfigManager;
import g55315.model.dto.StopDto;
import g55315.model.exception.RepositoryException;
import g55315.model.repository.StopRepository;
import g55315.presenter.Presenter;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import org.controlsfx.control.SearchableComboBox;
import javafx.fxml.FXML;


import java.io.IOException;
import java.net.URL;

import java.util.List;
import java.util.ResourceBundle;

public class FxmlController implements Initializable {

    @FXML
    private SearchableComboBox<String> origine;

    @FXML
    private SearchableComboBox<String> destination;

    @FXML
    private Button search;

    @FXML
    private TableColumn stations;

    @FXML
    private TableColumn lignes;

    @FXML
    private TableView table;

    private Presenter presenter;


    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    @FXML
    public void handleButton(ActionEvent e) throws InterruptedException {
        presenter.calculatePath(origine.getValue(),destination.getValue());
    }



    public FxmlController() {
    }

    public void setCombo(List<String> stations) {
            destination.getItems().addAll(stations);
            origine.getItems().addAll(stations);
    }

    public TableColumn getStations() {
        return stations;
    }

    public TableColumn getLignes() {
        return lignes;
    }

    public TableView getTable() {
        return table;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("je suis ici");
    }

}
