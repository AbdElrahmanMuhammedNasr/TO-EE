package ProOuter;

import DataBase.ConnectionDB;
import com.jfoenix.controls.JFXTextField;
import com.mysql.jdbc.PreparedStatement;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

public class OuterController implements Initializable {

    @FXML
    private JFXTextField toWho;

    @FXML
    private JFXTextField kind;

    @FXML
    private JFXTextField possib;

    @FXML
    private JFXTextField number;

    @FXML
    private JFXTextField price;

    @FXML
    void insert() {

        try{
            String who = toWho.getText();
            String ki = kind.getText();
            String po=possib.getText();
            String num = number.getText();
            int pri = Integer.parseInt(price.getText());
            
            ConnectionDB c = new ConnectionDB();
            Connection con = c.getConnection();
            
            String commed = "insert into pro2 value ("
                    + "'" + who + "'"
                    + ",'" + ki + "'"
                    + ",'" + po + "'"
                    + ",'" + num + "'"
                    + ",'" + pri + "')";
            
            PreparedStatement ps = (PreparedStatement)con.prepareStatement(commed);
            ps.execute();
            
            JOptionPane.showMessageDialog(null, "INSERT IS DONE ");
            toWho.setText("");
            kind.setText("");
            possib.setText("");
            number.setText("");
            price.setText("");
            
            
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "ERROR ::Check you input ");
            toWho.setText("");
            kind.setText("");
            possib.setText("");
            number.setText("");
            price.setText("");
            
        }

    }
    //==============================================================================
    @FXML
    private TextField AllPrice;
    int x =0;
    @FXML
    void GET() throws ClassNotFoundException, SQLException {
         
        try {
           
            ConnectionDB c = new ConnectionDB();
            Connection con = c.getConnection();

            ResultSet r = (ResultSet) con.prepareStatement("select sum (price) from pro2");

            r.getString("price");

            AllPrice.setText(String.valueOf(r));
        }
        
        catch(Exception e)
        {
          JOptionPane.showMessageDialog(null, "ERROR");

        }

    }
    //=============================================================================

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
