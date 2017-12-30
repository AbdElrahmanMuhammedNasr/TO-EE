package ProOuter;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Outer {
    
    public Outer () throws IOException {
       Stage stage =new Stage();
        Parent root =FXMLLoader.load(getClass().getResource("outer.fxml"));
        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
        
    }

}
