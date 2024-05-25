/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package pantallas_cat;

import Pantalla_2.AñadirGastoController;
import Pantalla_2.Pantalla_2Controller;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import static javafx.scene.control.Alert.AlertType.CONFIRMATION;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafxmlapplication.FXMLDocumentController;
import javafxmlapplication.JavaFXMLApplication;
import model.Category;
import model.User;

/**
 * FXML Controller class
 *
 * @author 4444a
 */
public class Añadir_gasto_2Controller implements Initializable {

    @FXML
    private Pane panel5;
    @FXML
    private TextField cosye_txt;
    @FXML
    private TextField fecha_txt;
    @FXML
    private TextArea descrip_txt;
    @FXML
    private TextField titulo_txt;
    @FXML
    private Button atras_btn;
    @FXML
    private Button aceptar_btn;
    @FXML
    private Button log_out;
    @FXML
    private ImageView imagen_usuario;
    @FXML
    private ChoiceBox<Category> elegir_cat;
    @FXML
    private ImageView imagen;
    @FXML
    private Button seleccion_img;
    
    private JavaFXMLApplication mainApp;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        String css = this.getClass().getResource("/ESTILOS/HOJA_ESTILO.css").toExternalForm();
        panel5.getStylesheets().add(css);
        // TODO
    }    

    @FXML
    private void vuelve_atras(ActionEvent event) {
        try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/Pantalla_2/añadir gasto.fxml"));
                Parent root = loader.load();
                AñadirGastoController controlador = loader.getController();
                Scene scene = new Scene (root);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.setTitle("Gastos");
                stage.show();
                JavaFXMLApplication.addStage(stage);
                stage.setOnCloseRequest(e -> controlador.closeWindows());
                
                Stage myStage = (Stage) this.atras_btn.getScene().getWindow();
                myStage.close();
        
            } catch (IOException ex) {
                System.out.println(ex);
            }
    }

    @FXML
    private void acepta(ActionEvent event) {
        try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/Pantalla_2/añadir gasto.fxml"));
                Parent root = loader.load();
                AñadirGastoController controlador = loader.getController();
                Scene scene = new Scene (root);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.setTitle("Gastos");
                JavaFXMLApplication.addStage(stage);
                stage.show();
                stage.setOnCloseRequest(e -> controlador.closeWindows());
                Stage myStage = (Stage) this.aceptar_btn.getScene().getWindow();
                myStage.close();
        
            } catch (IOException ex) {
                System.out.println(ex);
            }
    }
    public void closeWindows() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
            
            Optional<ButtonType> result = alert.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK){
                JavaFXMLApplication.closeAllStages();
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/javafxmlapplication/FXMLDocument.fxml"));
                    Parent root = loader.load();
                    FXMLDocumentController controlador = loader.getController();
                    Scene scene = new Scene (root);
                    Stage stage = new Stage();
                    stage.setScene(scene);
                    stage.show();
                    stage.setOnCloseRequest(e -> controlador.closeWindows());
                    stage.setTitle("Gestor finanzas - Inicio de sesión");
            
                    Stage myStage = (Stage) this.log_out.getScene().getWindow();
                    myStage.close();
                    JavaFXMLApplication.addStage(stage);
                    System.out.println("Sesión cerrada");
            
                } catch (IOException ex) {
                    System.out.println(ex);
                }
            }
        }
    

    @FXML
    private void seleccionar_imagen(ActionEvent event) {
    }


    
}
