package sunat.gob.pe.airbnfx;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {
    public static Scene scene;
    @Override
    public void start(Stage stage) {
        try{
            Parent login = App.loadFXML("alquiler");
            scene = new Scene(login);
            stage.setScene(scene);
            stage.setTitle("Bienvenido al programa");
            stage.show();
        }catch(IOException ie){
            System.out.println(ie.getMessage());
        }
    }
    
    public static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }
    
     public static FXMLLoader getFXMLLoader(String fxml) throws IOException {
        return new FXMLLoader(App.class.getResource(fxml + ".fxml"));        
    }
    public static void main(String[] args) {
        launch();
    }

}