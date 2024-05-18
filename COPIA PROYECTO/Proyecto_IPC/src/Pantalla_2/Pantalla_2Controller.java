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
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author crisb
 */
public class Pantalla_2Controller implements Initializable {

    @FXML
    private Button gestionar_categorias;
    @FXML
    private Button visualizar_gasto;
    @FXML
    private Label text1;
    @FXML
    private GridPane gridpane2;
    @FXML
    private Label text2;
    @FXML
    private Button VOLVER_A;
    @FXML
    private Pane PANEL2;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        String css = this.getClass().getResource("/ESTILOS/HOJA_ESTILO.css").toExternalForm();
        PANEL2.getStylesheets().add(css);
    }    

    @FXML
    private void gestionar(ActionEvent event) {
    }


    @FXML
    private void visualizar(ActionEvent event) {
    }

    public void closeWindows() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
