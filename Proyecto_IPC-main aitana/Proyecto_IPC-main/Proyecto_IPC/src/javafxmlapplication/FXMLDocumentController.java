/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxmlapplication;

import Pantalla_2.Pantalla_2Controller;
import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import static javafx.scene.text.Font.font;
import javafx.stage.Stage;

import model.Acount;
import model.AcountDAOException;


/**
 *
 * @author jsoler
 */
public class FXMLDocumentController implements Initializable {
    // event handler, fired when button is clicked or 
    //                      when the button has the focus and enter is pressed
    @FXML
    private Label Cred_incorrectos;
    @FXML
    private PasswordField contra;
    @FXML
    private Button ini_sesion;
    @FXML
    private TextField usuario;
    @FXML
    private GridPane GRIDPANE;
    @FXML
    private Label TEXT;
    @FXML
    private Button registro;
    @FXML
    private Pane PANEL0;
    
   private JavaFXMLApplication mainApp;
    //=========================================================
    // you must initialize here all related with the object 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        String css = this.getClass().getResource("/ESTILOS/HOJA_ESTILO.css").toExternalForm();
        PANEL0.getStylesheets().add(css);
        
        usuario.requestFocus();
         
    }
   
    
    
    
    @FXML
    private void Contra_enter(KeyEvent event) {
        
        String nickname = usuario.getText();
        String password = contra.getText();
        
            if(event.getCode()==KeyCode.ENTER){
            try {
                
                if (Acount.getInstance().logInUserByCredentials(nickname, password) && !nickname.isEmpty() && !password.isEmpty()) {
          showAlert("Inicio de Sesión exitoso", "Inicio de sesión correcto, ¡Bienvenido!", Alert.AlertType.INFORMATION);
          
                
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Pantalla_2/Pantalla_2.fxml"));
            Parent root = loader.load();
            Pantalla_2Controller controlador = loader.getController();
            Scene scene = new Scene (root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Área socios");
            stage.setMinWidth(617); 
            stage.setMinHeight(435);
            
            stage.show();
            stage.setOnCloseRequest(e -> controlador.closeWindows());
            
            Stage myStage = (Stage) this.contra.getScene().getWindow();
            myStage.close();}
                else{
                    showAlert("Fallo en el Incio de Sesión", "Fallo iniciando sesión. Por favor vuelva a intentarlo", Alert.AlertType.ERROR);
                   
                    password = ("");
            }
        
        } catch (AcountDAOException | IOException ex) {
            System.out.println(ex);
        }
            }}     
    

    @FXML
    private void contra2(ActionEvent event) {
    }

    @FXML
    private void ir_sesion(ActionEvent event) {
        
        String nickname = usuario.getText();
        String password = contra.getText();
         try {
             if (Acount.getInstance().logInUserByCredentials(nickname, password)&& !nickname.isEmpty() && !password.isEmpty()) {
                showAlert("Inicio de Sesión exitoso", "Inicio de sesión correcto, ¡Bienvenido!", Alert.AlertType.INFORMATION);
                 
            
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Pantalla_2/Pantalla_2.fxml"));
            Parent root = loader.load();
            Pantalla_2Controller controlador = loader.getController();
            Scene scene = new Scene (root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
            JavaFXMLApplication.addStage(stage);
            stage.setOnCloseRequest(e -> controlador.closeWindows());
            stage.setTitle("Área socios");
            stage.setMinWidth(617); 
            stage.setMinHeight(435);
            Stage myStage = (Stage) this.ini_sesion.getScene().getWindow();
            myStage.close();
             
            }else {
                showAlert("Fallo en el Incio de Sesión", "Fallo iniciando sesión. Por favor vuelva a intentarlo", Alert.AlertType.ERROR);
            }
        } catch (AcountDAOException | IOException ex) {
            System.out.println(ex);
        }
    }

    @FXML
    private void usuario_enter(KeyEvent event) {
        if(event.getCode()==KeyCode.ENTER){
            contra.requestFocus();
        }
    }

    @FXML
    private void usuario2(ActionEvent event) {
    }


    @FXML
    private void registro_ir(ActionEvent event) {
        
        try {
            FXMLLoader loaderm = new FXMLLoader(getClass().getResource("Registro.fxml"));
            Parent root = loaderm.load();
            RegistroController controlador = loaderm.getController();
            Scene scene = new Scene (root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
            stage.setOnCloseRequest(e -> controlador.closeWindows());
            stage.setTitle("Registro");
            stage.setMinWidth(806); 
            stage.setMinHeight(508);
            JavaFXMLApplication.addStage(stage);
            Stage myStage = (Stage) this.registro.getScene().getWindow();
            myStage.close();
        
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    @FXML
    private void ir_registro(MouseEvent event) {
        try {
            FXMLLoader loaderm = new FXMLLoader(getClass().getResource("Registro.fxml"));
            Parent root = loaderm.load();
            RegistroController controlador = loaderm.getController();
            Scene scene = new Scene (root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
            stage.setOnCloseRequest(e -> controlador.closeWindows());
            stage.setTitle("Registro");
            stage.setMinWidth(806); 
            stage.setMinHeight(508);
            JavaFXMLApplication.addStage(stage);
            Stage myStage = (Stage) this.registro.getScene().getWindow();
            myStage.close();
        
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

  private void showAlert(String title, String message, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();  
     }  

   public void closeWindows() {
        // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    void setMainApp(JavaFXMLApplication aThis) {
        this.mainApp = mainApp;
    }
    
}
