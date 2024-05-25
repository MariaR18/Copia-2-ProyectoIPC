/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxmlapplication;

import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class JavaFXMLApplication extends Application {
    
    private static Scene scene;
    
    
    
    static void setRoot (Parent root){
        scene.setRoot (root);
    }
    private static List <Stage> openStages= new ArrayList<>();
    
    @Override
    public void start(Stage stage) throws Exception {
        //======================================================================
        // 1- creación del grafo de escena a partir del fichero FXML
        FXMLLoader loader= new  FXMLLoader(getClass().getResource("FXMLDocument.fxml"));
        Parent root = loader.load();
        //======================================================================
        // 2- creación de la escena con el nodo raiz del grafo de escena
        FXMLDocumentController controller = loader.getController();
        controller.setMainApp(this);
        //======================================================================
        // 3- asiganación de la escena al Stage que recibe el metodo 
        //     - configuracion del stage
        //     - se muestra el stage de manera no modal mediante el metodo show()
        stage.setScene(new Scene(root));
        stage.setTitle("Gestor finanzas - Inicio de sesión");
        stage.setMinWidth(666); 
        stage.setMinHeight(458);
        
        stage.show();
        addStage(stage);
    }
    
     /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
        
    }
    
    public static void closeAllStages() {
        for (Stage stage : openStages) {
            if(stage!=null){
                stage.close();
            }
        }
        openStages.clear();
    }
    
    public static void addStage(Stage stage) {
        openStages.add(stage);
    }
    
    public static void removeStage(Stage stage){
        openStages.remove(stage);
    }

    


    
}
