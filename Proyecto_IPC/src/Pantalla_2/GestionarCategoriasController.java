/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Pantalla_2;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author ACOMGUI
 */
public class GestionarCategoriasController implements Initializable {

    @FXML
    private TextField textocategoria_añadir;
    @FXML
    private Button añadir;
    @FXML
    private Button editar;
    @FXML
    private Button eliminar;
    @FXML
    private Button volver_atras;
    @FXML
    private ListView<?> listview;
    @FXML
    private GridPane PANESITO;
    @FXML
    private Pane PANEL4;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        String css = this.getClass().getResource("/ESTILOS/HOJA_ESTILO.css").toExternalForm();
        PANEL4.getStylesheets().add(css);
        
    }    

    @FXML
    private void añadir_intro(KeyEvent event) {
    }


    @FXML
    private void editar_categoria(ActionEvent event) {
    }

    @FXML
    private void eliminar_categoriaa(ActionEvent event) {
    }

    @FXML
    private void volver_a_atrás(ActionEvent event) {
    }

    @FXML
    private void anyadir_categoria(ActionEvent event) {
    }

    void closeWindows() {
        //Gestthrow new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
