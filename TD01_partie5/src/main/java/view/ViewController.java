/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Etudiant;

/**
 *
 * @author oscar
 */
public class ViewController implements Initializable{

    @FXML
    private Button sendButton;

    @FXML
    private TextField id;

    @FXML
    private TextField prenom;

    @FXML
    private TextField nom;

    @FXML
    private TableColumn<Etudiant, Integer> numCol;

    @FXML
    private TableColumn<Etudiant, String> nomCol;

    @FXML
    private TableColumn<Etudiant, String> prenomCol;

    @FXML
    private TableView table;

    public ViewController() {
    }

    public void init() {
        numCol.setCellValueFactory(new PropertyValueFactory<>("num"));
        prenomCol.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        nomCol.setCellValueFactory(new PropertyValueFactory<>("nom"));
    }

    @FXML
    public void handleButton(ActionEvent e) {
        try {
            int idField = Integer.parseInt(id.getText());
            Etudiant et = new Etudiant(idField, prenom.getText(), nom.getText());
            table.getItems().add(et);
            id.clear();
            prenom.clear();
            nom.clear();
            id.setStyle(null);

        } catch (Exception error) {
            id.setStyle("-fx-control-inner-background: RED");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
               init();
    }
}
