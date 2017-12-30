package Search;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class search {

    public search() throws IOException {
        Stage stage = new Stage();
        
        Parent root =FXMLLoader.load(getClass().getResource("searh.fxml"));
        
          
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

}


