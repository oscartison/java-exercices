/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Etudiant;

/**
 *
 * @author oscar
 */
public class MyTableView extends TableView{
    
    
    public MyTableView() {
        super();
        
        TableColumn<Etudiant,Integer> numCol = new TableColumn<>("Numéro");
        TableColumn<Etudiant,String> prenomCol = new TableColumn<>("Prénom");
        TableColumn<Etudiant,String> nomCol = new TableColumn<>("Nom");
        
        numCol.setCellValueFactory(new PropertyValueFactory<>("num"));
        prenomCol.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        nomCol.setCellValueFactory(new PropertyValueFactory<>("nom"));
        
        this.getColumns().setAll(numCol,prenomCol,nomCol);
        
        Etudiant std1 = new Etudiant(1,"Arthur","Paquot");
        Etudiant std2 = new Etudiant(2,"Israe","Serokh");
        this.getItems().add(std1);
        this.getItems().add(std2);
    }
}
