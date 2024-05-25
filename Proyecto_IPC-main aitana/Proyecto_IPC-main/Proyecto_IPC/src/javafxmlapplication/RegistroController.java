/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package javafxmlapplication;

import Pantalla_2.Pantalla_2Controller;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.Acount;
import model.AcountDAOException;


/**
 * FXML Controller class
 *
 * @author crisb
 */
public class RegistroController implements Initializable {
    
     private BooleanProperty validPassword;
    private BooleanProperty validEmail;
    private BooleanProperty equalPasswords; 

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
    @FXML
    private Label cor_incorrecto;
    /**
     * Initializes the controller class.
     */
    
    public Image image;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        foto_perfil.setImage(new Image("/resources/Icono_persona_morado.png"));
        
        String css = this.getClass().getResource("/ESTILOS/HOJA_ESTILO.css").toExternalForm();
        PANEL1.getStylesheets().add(css);
        
        validEmail = new SimpleBooleanProperty();
        validPassword = new SimpleBooleanProperty();   
        equalPasswords = new SimpleBooleanProperty();
        
        validPassword.setValue(Boolean.FALSE);
        validEmail.setValue(Boolean.FALSE);
        equalPasswords.setValue(Boolean.FALSE);
        
        
        BooleanBinding validFields = Bindings.and(validEmail, validPassword).and(equalPasswords);
         

        correo.focusedProperty().addListener((observable,oldValue,newValue)-> {checkEditEmail();});
        cont.focusedProperty().addListener((observable,oldValue,newValue)-> {checkPassword();});
        //Contraseña2.focusedProperty().addListener((observable,oldValue,newValue)-> {checkEquals();});
        cont2.focusedProperty().addListener((observable,oldValue, newValue) -> {
            if(!newValue){
                    checkEquals();
}
});
        
     aceptar.disableProperty().bind(validEmail.not().or(validPassword.not().or(equalPasswords .not())));
        
    }
       
     private void checkEditEmail(){
        if(!Utils.checkEmail(correo.getText())){
            //Email incorrecto
            manageError(cor_incorrecto,correo,validEmail);
        }else{manageCorrect(cor_incorrecto, correo,validEmail);}
    }
    
   private void checkPassword(){
        if(!Utils.checkPassword(cont.getText())){
            //Contraseña incorrecta
            manageError(cont_incorrecta,cont,validPassword);
        }else{manageCorrect(cont_incorrecta, cont,validPassword);}
    }
   
   private void checkEquals(){
        if(cont.textProperty().getValueSafe().compareTo(cont2.textProperty().getValueSafe()) != 0){
            showErrorMessage(cont2_incorrecta,cont2);
            equalPasswords.setValue(Boolean.FALSE);
            cont.textProperty().setValue("");
            cont2.textProperty().setValue("");
            cont.requestFocus();
        }else manageCorrect(cont2_incorrecta,cont,equalPasswords);}
    
    
    private File selectedFile;

    @FXML
    private void jfchCargar_foto(ActionEvent event) {
        if(Cargar_foto.isPickOnBounds()){
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg", "*.gif"));
        selectedFile = fileChooser.showOpenDialog(((Node)event.getSource()).getScene().getWindow());
            if (selectedFile != null) {
                Image image = new Image(selectedFile.toURI().toString());
                foto_perfil.setImage(image);
                foto_perfil.setFitWidth(50);
                foto_perfil.setPreserveRatio(true);
            }
        }else{
            Image image = new Image(getClass().getResource("/resources/Icono_persona_morado.png").toExternalForm());
            foto_perfil.setImage(image);
            foto_perfil.setFitWidth(50);
            foto_perfil.setPreserveRatio(true);
        }   
    }

    void closeWindows() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @FXML
    private void nombre_enter(KeyEvent event) {
        if(event.getCode()==KeyCode.ENTER){
             apellido.requestFocus();
         }
    }

    @FXML
    private void apellido_enter(KeyEvent event) {
        if(event.getCode()==KeyCode.ENTER){
             usuario.requestFocus();
         }
    }

    @FXML
    private void usuario_enter(KeyEvent event) {
        if(event.getCode()==KeyCode.ENTER){
             correo.requestFocus();
         }
    }

    @FXML
    private void correo_enter(KeyEvent event) {
        if(event.getCode()==KeyCode.ENTER){
             cont.requestFocus();
         }
    }

    @FXML
    private void contraseña_enter(KeyEvent event) {
        if(event.getCode()==KeyCode.ENTER){
             cont2.requestFocus();
         }
    }

    @FXML
    private void contraseña2_enter(KeyEvent event) {
         if(event.getCode()==KeyCode.ENTER){
             fecha.requestFocus();
         }
        
    }

    @FXML
    private void foto_cargar_enter(KeyEvent event) {
    }

    @FXML
    private void fecha_enter(KeyEvent event) {
        if(event.getCode()==KeyCode.ENTER){
             Cargar_foto.requestFocus();
         }
    }

    @FXML
    private void elegir_fecha(ActionEvent event) {
        fecha.setValue(LocalDate.now());
       
    }
    
   private void ir_ventana2(MouseEvent event) {
       String name = nombre.getText();
        String nickName = usuario.getText();
        String email = correo.getText();
        String password = cont.getText();
        foto_perfil.setImage(image);
       try {
           if (Acount.getInstance().registerUser(name,"",nickName , email, password, image, LocalDate.now()))  {
          showAlert("Registro exitoso", "El Usuario se ha registrado correctamente, ¡Bienvenido!", Alert.AlertType.INFORMATION);
          
                
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLDocument.fxml"));
            Parent root = loader.load();
            FXMLDocumentController controlador = loader.getController();
            Scene scene = new Scene (root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Gestor finanzas - Inicio de sesión");
            stage.setMinWidth(676); 
            stage.setMinHeight(458);
            stage.show();
            stage.setOnCloseRequest(e -> controlador.closeWindows());
            
            Stage myStage = (Stage) this.aceptar.getScene().getWindow();
            myStage.close();}

           else{showAlert("Fallo registrando", "Fallo registrando al usuario. Por favor vuelve a intentarlo", Alert.AlertType.ERROR);
           }
        } catch (AcountDAOException | IOException ex) {
            System.out.println(ex);}
        
       
        
    }
   

    @FXML
    private void ir_pantalla2(ActionEvent event) {
        String name = nombre.getText();
        String nickName = usuario.getText();
        String email = correo.getText();
        String password = cont.getText();
        Image image = null;
        foto_perfil.setImage(image);
        
       try {
            if (Acount.getInstance().registerUser(name,"",email , nickName, password, image, LocalDate.now()))  {
          showAlert("Registro exitoso", "El Usuario se ha registrado correctamente, ¡Bienvenido!", Alert.AlertType.INFORMATION);
          
                
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLDocument.fxml"));
            Parent root = loader.load();
           FXMLDocumentController controlador = loader.getController();
            Scene scene = new Scene (root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Gestor finanzas - Inicio de sesión");
            stage.setMinWidth(666); 
            stage.setMinHeight(458);
            stage.show();
            stage.setOnCloseRequest(e -> controlador.closeWindows());
            
            Stage myStage = (Stage) this.aceptar.getScene().getWindow();
            myStage.close();}else{showAlert("Fallo registrando", "Fallo registrando al usuario. Por favor vuelve a intentarlo", Alert.AlertType.ERROR);
           }
        } catch (AcountDAOException | IOException ex) {
            System.out.println(ex);}
    }
        
    private void showAlert(String title, String message, Alert.AlertType alertType){
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();  
     }  

    private void Volver_atras(ActionEvent event) {
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
            stage.setMinWidth(666); 
            stage.setMinHeight(458);
            Stage myStage = (Stage) this.REGRESAR.getScene().getWindow();
            myStage.close();
        
        } catch (IOException ex) {
            System.out.println(ex);
        }}
    
    private void manageError(Label errorLabel,TextField textField, BooleanProperty boolProp ){
        boolProp.setValue(Boolean.FALSE);
        showErrorMessage(errorLabel,textField);
        textField.requestFocus();
 
    }
     private void manageCorrect(Label errorLabel,TextField textField, BooleanProperty boolProp ){
        boolProp.setValue(Boolean.TRUE);
        hideErrorMessage(errorLabel,textField);
        
    }
     private void showErrorMessage(Label errorLabel,TextField textField)
    {
        errorLabel.visibleProperty().set(true);
        textField.styleProperty().setValue("-fx-background-color: #FCE5E0");    
    }
     
      private void hideErrorMessage(Label errorLabel,TextField textField)
    {
        errorLabel.visibleProperty().set(false);
        textField.styleProperty().setValue("");
    }

    @FXML
    private void volver_pa_tras(MouseEvent event) {
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
            stage.setMinWidth(666); 
            stage.setMinHeight(458);
            Stage myStage = (Stage) this.REGRESAR.getScene().getWindow();
            myStage.close();
        
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    private void fecha_actual(ContextMenuEvent event) {
         fecha.setValue(LocalDate.now());
        
    }
    
    
   
        
    }

   
    
    
   

