
package logica;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * @author matheus
 */
public class TelaHome extends Application {

     private static Stage stage;
    
     public static void main(String[] args) {
        launch(args);
    }
     
    @Override
    public void start(Stage stage) throws Exception {
         
        try {
                AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("/view/home.fxml"));
                
                stage.setTitle("Home");
                stage.setScene(new Scene(root));
                stage.setMaximized(true);
                stage.show();
                
            } catch (IOException ex) {
                Logger.getLogger(TelaHome.class.getName()).log(Level.SEVERE, null, ex);
            }
        
          
    }
    
    public static Stage getStage(){
        return stage;
    }
  

   
    
}
