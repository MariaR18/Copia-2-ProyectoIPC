/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Pantalla_2;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import static javafx.scene.control.Alert.AlertType.CONFIRMATION;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.AcountDAOException;
import model.User;
import model.Category;
import model.Charge;
import pantallas_cat.Añadir_gasto_2Controller;

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
    private Button ATRAS;
    @FXML
    private Pane PANEL3;
    @FXML
    private ImageView IMAGEN_PERFIL;
    @FXML
    private Button log_out;
    @FXML
    private TableColumn<Charge, String> NOMBRE;
    @FXML
    private TableColumn<Charge, String> DESCRIPCION;
    @FXML
    private TableColumn<Charge, Double> COSTE;
    @FXML
    private TableColumn<?, ?> UNIDADES;
    @FXML
    private TableColumn<Charge, Category> CATEGORIA;
    @FXML
    private TableColumn<Charge, LocalDate> FECHA;
    @FXML
    private TableColumn<Charge, Image> IMAGEN;
    @FXML
    private TableView<Charge> TABLA;
  
    private ObservableList<Charge> misgasto;
    @FXML
    private TableColumn<?, ?> ID;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        String css = this.getClass().getResource("/ESTILOS/HOJA_ESTILO.css").toExternalForm();
        PANEL3.getStylesheets().add(css);
        
        
        TABLA.setItems(misgasto);
        NOMBRE.setCellValueFactory(new PropertyValueFactory<Charge, String>("nombre"));
        DESCRIPCION.setCellValueFactory(new PropertyValueFactory<Charge, String>("descripción"));
        COSTE.setCellValueFactory(new PropertyValueFactory<Charge, Double>("cargo"));
        //UNIDADES.setCellValueFactory(new PropertyValueFactory<Charge, int>("Unidades"));
        CATEGORIA.setCellValueFactory(new PropertyValueFactory<Charge, Category>("categoria"));
        FECHA.setCellValueFactory(new PropertyValueFactory<Charge, LocalDate>("fecha"));
        IMAGEN.setCellValueFactory(new PropertyValueFactory<Charge, Image>("imagen"));
        //ID.setCellValueFactory(new PropertyValueFactory<Charge, int>("id"));
        
        ArrayList<Charge> misdatos = new ArrayList<Charge>();
        
        //Charge(String name, String description, double cost, int units, Image scanImage, LocalDate date, Category category)
        //misdatos.add(new Charge("Pepe", "García", 12, 1, "/resources/aceptar.png", 24/05/2024, ));
        
        
        
    }    


    @FXML
    private void editar_gasto(ActionEvent event) {
    }

    @FXML
    private void eliminar_gasto(ActionEvent event) {
    }

    @FXML
     private void anyade_gasto(ActionEvent event)throws AcountDAOException, IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/pantallas_cat/Añadir_gasto_2.fxml"));
            Parent root = loader.load();
            Añadir_gasto_2Controller controlador = loader.getController();
            Scene scene = new Scene (root);
            Stage stage = new Stage();
            stage.setScene(scene);
    
            
            stage.setTitle("Añadir gasto");
            stage.setResizable(false);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();
            stage.setOnCloseRequest(e -> controlador.closeWindows());
    }
    
    
    public void closeWindows() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


    @FXML
    private void volver(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Pantalla_2.fxml"));
            Parent root = loader.load();
            Pantalla_2Controller controlador = loader.getController();
            Scene scene = new Scene (root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
            stage.setOnCloseRequest(e -> controlador.closeWindows());
            stage.setTitle("Área socios");
            stage.setMinWidth(617); 
            stage.setMinHeight(435);
            Stage myStage = (Stage) this.ATRAS.getScene().getWindow();
            myStage.close();
        
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    @FXML
    private void log_out_(ActionEvent event) {
        String name = User.class.getName();
        Alert alert = new Alert(CONFIRMATION);
        alert.setTitle("Cerrar Sesión");
        alert.setHeaderText("Hola, "+ name);
        alert.setContentText("¿Esta seguro de que desea cerrar sesión?");
        
        alert.showAndWait();
    }

    @FXML
    private void LOG_OUT(MouseEvent event) {
        String name = User.class.getName();
        Alert alert = new Alert(CONFIRMATION);
        alert.setTitle("Cerrar Sesión");
        alert.setHeaderText("Hola, "+ name);
        alert.setContentText("¿Esta seguro de que desea cerrar sesión?");
        
        alert.showAndWait();
    }

    @FXML
    private void editarperfil(ActionEvent event) {
    }
    
}
