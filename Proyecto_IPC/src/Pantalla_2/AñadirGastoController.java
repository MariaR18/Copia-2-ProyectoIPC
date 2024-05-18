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
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author ACOMGUI
 */
public class AñadirGastoController implements Initializable {

    @FXML
    private Button añadir_gasto;
    @FXML
    private Button editar;
    @FXML
    private Button eliminar;
    @FXML
    private GridPane GRIDPANEE;
    @FXML
    private Button ATRAS;
    @FXML
    private Pane PANEL3;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        String css = this.getClass().getResource("/ESTILOS/HOJA_ESTILO.css").toExternalForm();
        PANEL3.getStylesheets().add(css);
        
    }    


    @FXML
    private void editar_gasto(ActionEvent event) {
    }

    @FXML
    private void eliminar_gasto(ActionEvent event) {
    }

    @FXML
    private void anyade_gasto(ActionEvent event) {
    }
    
    public void closeWindows() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
