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
    
   
    //=========================================================
    // you must initialize here all related with the object 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        String css = this.getClass().getResource("/ESTILOS/HOJA_ESTILO.css").toExternalForm();
        PANEL0.getStylesheets().add(css);
        
        
    }
   
    
    
    
    @FXML
    private void Contra_enter(KeyEvent event) {
        
            if(event.getCode()==KeyCode.ENTER){
            try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Pantalla_2/Pantalla_2.fxml"));
            Parent root = loader.load();
            Pantalla_2Controller controlador = loader.getController();
            Scene scene = new Scene (root);
            Stage stage = new Stage();
            stage.setScene(scene);
            
            stage.show();
            stage.setOnCloseRequest(e -> controlador.closeWindows());
            
            Stage myStage = (Stage) this.contra.getScene().getWindow();
            myStage.close();
        
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
            }}     
    

    @FXML
    private void contra2(ActionEvent event) {
    }

    @FXML
    private void ir_sesion(ActionEvent event) {
         try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Pantalla_2/Pantalla_2.fxml"));
            Parent root = loader.load();
            Pantalla_2Controller controlador = loader.getController();
            Scene scene = new Scene (root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
            stage.setOnCloseRequest(e -> controlador.closeWindows());
            
            Stage myStage = (Stage) this.ini_sesion.getScene().getWindow();
            myStage.close();
        
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void usuario_enter(KeyEvent event) {
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
            
            Stage myStage = (Stage) this.registro.getScene().getWindow();
            myStage.close();
        
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
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
            
            Stage myStage = (Stage) this.registro.getScene().getWindow();
            myStage.close();
        
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    
}
