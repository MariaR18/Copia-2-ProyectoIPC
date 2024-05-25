/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Pantalla_2;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafxmlapplication.FXMLDocumentController;
import javafxmlapplication.RegistroController;
import model.Acount;
import model.AcountDAOException;
import model.Category;
import model.User;




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
    private ListView<String> listview;
    @FXML
    private GridPane PANESITO;
    @FXML
    private Pane PANEL4;
    @FXML
    private ImageView IMAGEN_USUSARIO;
    @FXML
    private Button log_out;
    @FXML
    private TextField texto_desc;
    
    private ObservableList<String> datos = null;
    private boolean isEditing = false;
 
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        String css = this.getClass().getResource("/ESTILOS/HOJA_ESTILO.css").toExternalForm();
        PANEL4.getStylesheets().add(css);
        
        
        ArrayList<String> misdatos = new ArrayList<String>();
        datos = FXCollections.observableList(misdatos);
        listview.setItems(datos);
        
        listview.setCellFactory((c) -> {return new StringListCell();});
        
        añadir.setDisable(true);
        eliminar.disableProperty().bind(Bindings.equal(listview.getSelectionModel().selectedIndexProperty(), -1));
        editar.disableProperty().bind(Bindings.equal(listview.getSelectionModel().selectedIndexProperty(), -1));
        
        textocategoria_añadir.focusedProperty().addListener((a, b, c) -> {
            if (textocategoria_añadir.isFocused()) {
                añadir.setDisable(false);
                listview.getSelectionModel().select(-1);
            }
        });
       
        listview.focusedProperty().addListener((a, b, c) -> {
            if (listview.isFocused()) {
                añadir.setDisable(true);
            }
        });
        
        listview.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
        if (newValue != null) {
            String[] parts = newValue.split(" - ");
            if (parts.length == 2) {
                textocategoria_añadir.setText(parts[0]);
                texto_desc.setText(parts[1]);
            }
        }
        });
        
         listview.setOnMouseClicked(event -> {
            if (event.getClickCount() == 1) {
                String selectedItem = listview.getSelectionModel().getSelectedItem();
                if (selectedItem != null) {
                    String[] parts = selectedItem.split(" - ");
                    if (parts.length == 2) {
                        textocategoria_añadir.setText(parts[0]);
                        texto_desc.setText(parts[1]);
                    }
                }
            }
        });
        
        
       
    }

    @FXML
    private void editarperfil(ActionEvent event) {
        
        
        
    }
 
    
  class StringListCell extends ListCell<String> {
    @Override
    protected void updateItem(String item, boolean empty) {
        super.updateItem(item, empty);
        if (empty || item == null) {
            setText(null);
        } else {
            setText(item);
        }
    }
}
     
   /*class StringListCell extends ListCell<String> {

    public void updateItem(String names, boolean bln)  {
        
        try{
        
        if (bln ) // esta vacia
        {
            setText("");
        } else {
           //String categoria = new String("nombre"); // Crea una instancia de Category
        Acount.getInstance().getUserCategories();// Llama al método getName
        setText(names);
        
          
        }}catch(AcountDAOException ex){
            System.out.println(ex);
        } catch (IOException ex) {
            Logger.getLogger(GestionarCategoriasController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    }*/
      
 
    @FXML
    private void añadir_intro(KeyEvent event) {
        
    }
    

    @FXML
    private void editar_categoria(ActionEvent event) {
         int selectedIndex = listview.getSelectionModel().getSelectedIndex();
        if (selectedIndex != -1) {
            String nuevoNombre = textocategoria_añadir.getText().trim();
            String nuevaDescripcion = texto_desc.getText().trim();
            if (!nuevoNombre.isEmpty() && !nuevaDescripcion.isEmpty()) {
                String nuevaCategoria = nuevoNombre + " - " + nuevaDescripcion;
                datos.set(selectedIndex, nuevaCategoria);
                textocategoria_añadir.clear();
                texto_desc.clear();
                textocategoria_añadir.requestFocus();
            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Campos vacíos");
                alert.setHeaderText(null);
                alert.setContentText("Por favor, completa tanto el nombre como la descripción.");
                alert.showAndWait();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Sin selección");
            alert.setHeaderText(null);
            alert.setContentText("Por favor, selecciona una categoría para editar.");
            alert.showAndWait();
        }
    }

    @FXML
    private void eliminar_categoriaa(ActionEvent event) throws IOException, AcountDAOException {
       
        int selectedIndex = listview.getSelectionModel().getSelectedIndex();
        if (selectedIndex != -1) {
        datos.remove(selectedIndex);
        
        }
       
    }
    
    private void removeCategory(String categoryName) {
        // Implementa la lógica para eliminar la categoría aquí
        // Por ejemplo, si tienes una lista de categorías en algún lugar, la eliminas de esa lista
        System.out.println("Categoría " + categoryName + " eliminada."); // Esto es solo para propósitos de demostración
        // Aquí deberías implementar la lógica para eliminar la categoría de la fuente de datos real
    }
    
    @FXML
    private void volver_a_atrás(ActionEvent event) {
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
            
            Stage myStage = (Stage) this.volver_atras.getScene().getWindow();
            myStage.close();
        
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

   @FXML
    private void anyadir_categoria(ActionEvent event) throws AcountDAOException, IOException {
    String nuevoNombre = textocategoria_añadir.getText().trim();
    String nuevaDescripcion = texto_desc.getText().trim();

    if (nuevoNombre.isEmpty() || nuevaDescripcion.isEmpty()) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Campos vacíos");
        alert.setHeaderText(null);
        alert.setContentText("Por favor, completa tanto el nombre como la descripción.");
        alert.showAndWait();
        return;
    }

    // Comprobar si el nombre de la categoría ya existe en la lista
    for (String categoria : datos) {
        String[] parts = categoria.split(" - ");
        if (parts.length > 0 && parts[0].equalsIgnoreCase(nuevoNombre)) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Categoría duplicada");
            alert.setHeaderText(null);
            alert.setContentText("El nombre de la categoría ya existe. Por favor, elige otro nombre.");
            alert.showAndWait();
            return;
        }
    }

    datos.add(nuevoNombre + " - " + nuevaDescripcion);
    textocategoria_añadir.clear();
    texto_desc.clear();
    textocategoria_añadir.requestFocus();
        
        
    }
     
    public void closeWindows() {
        //Gestthrow new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @FXML
    private void LOG_OUT(MouseEvent event) {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Confirmación de cierre de sesión");
        alert.setHeaderText(null);
        alert.setContentText("¿Estás seguro de que deseas cerrar sesión?");
    
        Stage alertStage = (Stage) alert.getDialogPane().getScene().getWindow();
        alertStage.getIcons().add(new Image("/resources/Icono_persona_morado.png"));

        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK){
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
                System.out.println("Sesión cerrada");
            
            } catch (IOException ex) {
                System.out.println(ex);
            }
        }
    }

    private void selectCategoria(MouseEvent event) {
       /* Category categoria = this.listview.getSelectionModel().getSelectedItem();
        if(categoria !=null){
            this.textocategoria_añadir.setText(categoria.getName());
            //this.descripcion_txt.setText(categoria.getDescription());
        }*/
        
    }

    @FXML
    private void log_out_(ActionEvent event) {
    }
      
}
