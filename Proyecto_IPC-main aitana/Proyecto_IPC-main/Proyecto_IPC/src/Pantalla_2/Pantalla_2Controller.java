/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Pantalla_2;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import static javafx.scene.control.Alert.AlertType.CONFIRMATION;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafxmlapplication.FXMLDocumentController;
import javafxmlapplication.JavaFXMLApplication;
import model.Acount;
import model.AcountDAOException;
import model.User;

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
    @FXML
    private ImageView IMAGEN_USUARIO;
    private Image imagen;
    @FXML
    private Button log_out;
    
    private JavaFXMLApplication mainApp;
    @FXML
    private Button perfil;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        String css = this.getClass().getResource("/ESTILOS/HOJA_ESTILO.css").toExternalForm();
            PANEL2.getStylesheets().add(css);
        try {
            imagen = Acount.getInstance().getLoggedUser().getImage();
            IMAGEN_USUARIO = new ImageView(imagen);
        
        } catch (AcountDAOException ex) {
            System.out.println(ex);
        } catch (IOException ex) {
            System.out.println(ex);
        }
        IMAGEN_USUARIO.setFitWidth(50);
        IMAGEN_USUARIO.setPreserveRatio(true);
        log_out.setGraphic(IMAGEN_USUARIO);
        
    }    
     

    @FXML
    private void gestionar(ActionEvent event) {
        try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("gestionar categorias.fxml"));
                Parent root = loader.load();
                GestionarCategoriasController controlador = loader.getController();
                Scene scene = new Scene (root);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.setTitle("Gestionar categorías");
                stage.setMinWidth(811); 
                stage.setMinHeight(570);
                stage.show();
                stage.setOnCloseRequest(e -> controlador.closeWindows());
                JavaFXMLApplication.addStage(stage);
                Stage myStage = (Stage) this.gestionar_categorias.getScene().getWindow();
                myStage.close();
        
            } catch (IOException ex) {
                System.out.println(ex);
            }
    }


    @FXML
    private void visualizar(ActionEvent event) {
        try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("añadir gasto.fxml"));
                Parent root = loader.load();
                AñadirGastoController controlador = loader.getController();
                Scene scene = new Scene (root);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.setTitle("Gastos");
                stage.setMinWidth(1100); 
                stage.setMinHeight(683);
                stage.show();
                stage.setOnCloseRequest(e -> controlador.closeWindows());
                JavaFXMLApplication.addStage(stage);
                Stage myStage = (Stage) this.visualizar_gasto.getScene().getWindow();
                myStage.close();
        
            } catch (IOException ex) {
                System.out.println(ex);
            }
    }

    public void closeWindows() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @FXML
    private void ATRAS(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/javafxmlapplication/FXMLDocument.fxml"));
            Parent root = loader.load();
            FXMLDocumentController controlador = loader.getController();
            Scene scene = new Scene (root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
            
            JavaFXMLApplication.addStage(stage);
            stage.setOnCloseRequest(e -> controlador.closeWindows());
            stage.setTitle("Gestor finanzas - Inicio de sesión");
            stage.setMinWidth(666); 
            stage.setMinHeight(458);
            Stage myStage = (Stage) this.VOLVER_A.getScene().getWindow();
            myStage.close();
        
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
    public void setMainApp(JavaFXMLApplication mainApp){
        this.mainApp = mainApp;
    }
      @FXML
    private void log_out_(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmación de cierre de sesión");
        alert.setHeaderText(null);
        alert.setContentText("¿Estás seguro de que deseas cerrar sesión?");
    
        Stage alertStage = (Stage) alert.getDialogPane().getScene().getWindow();
        alertStage.getIcons().add(new Image("/resources/Icono_persona_morado.png"));
        mainApp.closeAllStages();
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK){
            mainApp.closeAllStages();
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/javafxmlapplication/FXMLDocument.fxml"));
                Parent root = loader.load();
                FXMLDocumentController controlador = loader.getController();
                Scene scene = new Scene (root);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.show();
                JavaFXMLApplication.addStage(stage);
                stage.setOnCloseRequest(e -> controlador.closeWindows());
                stage.setTitle("Gestor finanzas - Inicio de sesión");
                stage.setMinWidth(666); 
                stage.setMinHeight(458);
                Stage myStage = (Stage) this.log_out.getScene().getWindow();
                myStage.close();
                System.out.println("Sesión cerrada");
            
            } catch (IOException ex) {
                System.out.println(ex);
            }
        }
    }


    @FXML
    private void CERRAR_SESION(MouseEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmación de cierre de sesión");
        alert.setHeaderText(null);
        alert.setContentText("¿Estás seguro de que deseas cerrar sesión?");
    
        Stage alertStage = (Stage) alert.getDialogPane().getScene().getWindow();
        alertStage.getIcons().add(new Image("/resources/Icono_persona_morado.png"));

        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK){
            mainApp.closeAllStages();
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/javafxmlapplication/FXMLDocument.fxml"));
                Parent root = loader.load();
                FXMLDocumentController controlador = loader.getController();
                Scene scene = new Scene (root);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.show();
                JavaFXMLApplication.addStage(stage);
                stage.setOnCloseRequest(e -> controlador.closeWindows());
                stage.setTitle("Gestor finanzas - Inicio de sesión");
            
                Stage myStage = (Stage) this.log_out.getScene().getWindow();
                myStage.close();
                System.out.println("Sesión cerrada");
            
            } catch (IOException ex) {
                System.out.println(ex);
            }
        }
    }

    @FXML
    private void editarperfil(ActionEvent event) {
    }
    
}
