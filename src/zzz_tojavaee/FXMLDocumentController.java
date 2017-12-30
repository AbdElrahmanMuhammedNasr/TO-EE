package zzz_tojavaee;


import  DataBase.ConnectionDB;
import Emp.EMp;

import ProEntered.pro;
import ProOuter.Outer;
import Search.search;


import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.mysql.jdbc.PreparedStatement;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import static javafx.scene.paint.Color.RED;
import javax.swing.JOptionPane;

public class FXMLDocumentController implements Initializable {

    @FXML
    private Pane login;

  @FXML
    private BorderPane p;

    //operation//

 
    @FXML
     JFXComboBox<?> Business;

        //operation//
    
    
        @FXML
     JFXTextField userName;

    @FXML
     JFXPasswordField password;
    
    //Type of operation in emp//
  
   
    @FXML
     public void Operation() throws IOException {

         EMp o = new  EMp();

    }
     
    @FXML
    void OperationPro() throws IOException {
        pro o = new pro();
    }
    
      @FXML
    void Outer() throws IOException {
        Outer o = new Outer ();

    }
    
        @FXML
    void tableEmp() throws IOException {
        search s = new search();

    }
    
    

    public void showBar() throws ClassNotFoundException, SQLException {
        
        String user =userName.getText();
        String pass=password.getText();
        
        ConnectionDB db = new ConnectionDB();
        Connection con = db.getConnection();
        
        if(con.isClosed())
        {
            JOptionPane.showMessageDialog(null, "NOT Connection With Database");
        }
        else
        {
            String commend = "select * from admin where  user_name = '" +user +"' and password = '"+pass+"'";
            PreparedStatement ps = (PreparedStatement)con.prepareStatement(commend);
            
            ResultSet resultSet=  ps.executeQuery();
            while (resultSet.next()) {

                p.setVisible(true);
                return;
            }
            userName.setText("");
            password.setText("");
            
          
            userName.backgroundProperty().setValue(new Background(new BackgroundFill(RED, CornerRadii.EMPTY, Insets.EMPTY)));
            password.backgroundProperty().setValue(new Background(new BackgroundFill(RED, CornerRadii.EMPTY, Insets.EMPTY)));
 
        }
        
      }

    @Override
    public void initialize(URL url, ResourceBundle rb) {


//        ObservableList list3 = FXCollections.observableArrayList("ADD Order", "DELETE Order", "UPDATE Order");
//        Business.setItems(list3);

        
        p.setVisible(false);
    }

    

}
