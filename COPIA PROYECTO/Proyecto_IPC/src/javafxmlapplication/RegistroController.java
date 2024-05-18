/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package javafxmlapplication;

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
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author crisb
 */
public class RegistroController implements Initializable {

    @FXML
    private Button Cargar_foto;
    @FXML
    private ImageView foto_perfil;
    @FXML
    private Label cont_incorrecta;
    @FXML
    private Label cont2_incorrecta;
    @FXML
    private TextField nombre;
    @FXML
    private TextField apellido;
    @FXML
    private TextField usuario;
    @FXML
    private TextField correo;
    @FXML
    private PasswordField cont;
    @FXML
    private PasswordField cont2;
    @FXML
    private DatePicker fecha;
    @FXML
    private Button aceptar;
    @FXML
    private Button REGRESAR;
    @FXML
    private Pane PANEL1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        String css = this.getClass().getResource("/ESTILOS/HOJA_ESTILO.css").toExternalForm();
        PANEL1.getStylesheets().add(css);
        
        
    } 

    @FXML
    private void jfchCargar_foto(ActionEvent event) {
    }

    void closeWindows() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @FXML
    private void nombre_enter(KeyEvent event) {
    }

    @FXML
    private void apellido_enter(KeyEvent event) {
    }

    @FXML
    private void usuario_enter(KeyEvent event) {
    }

    @FXML
    private void correo_enter(KeyEvent event) {
    }

    @FXML
    private void contraseña_enter(KeyEvent event) {
    }

    @FXML
    private void contraseña2_enter(KeyEvent event) {
    }

    @FXML
    private void foto_cargar_enter(KeyEvent event) {
    }

    @FXML
    private void fecha_enter(KeyEvent event) {
    }

    @FXML
    private void elegir_fecha(ActionEvent event) {
    }

    private void ir_ventana2(MouseEvent event) {
        try {
            FXMLLoader loaderu = new FXMLLoader(getClass().getResource("Pantalla_2.fxml"));
            Parent root = loaderu.load();
            RegistroController controlador = loaderu.getController();
            Scene scene = new Scene (root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
            stage.setOnCloseRequest(e -> controlador.closeWindows());
            
            Stage myStage = (Stage) this.aceptar.getScene().getWindow();
            myStage.close();
        
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void ir_pantalla2(ActionEvent event) {
        
    }

   
    
    
   

}
