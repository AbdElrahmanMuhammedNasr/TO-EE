package ProEntered;

import DataBase.ConnectionDB;
import com.jfoenix.controls.JFXTextField;
import com.mysql.jdbc.PreparedStatement;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javax.swing.JOptionPane;

public class ProController implements Initializable {

    //=================================ADD=======================
    @FXML
    private JFXTextField AddId;

    @FXML
    private JFXTextField AddName;

    @FXML
    private JFXTextField AddKind;

    @FXML
    private JFXTextField AddNumber;

    @FXML
    private JFXTextField AddPrice;

    @FXML
    private JFXTextField AddDate;

    @FXML
    public void Add() {

        try {

            int id = Integer.parseInt(AddId.getText());
            String name = AddName.getText();
            String kind = AddKind.getText();

            int number1 = Integer.parseInt(AddNumber.getText());
            String number = String.valueOf(number1);

            int price = Integer.parseInt(AddPrice.getText());
            String date = AddDate.getText();

            ConnectionDB c = new ConnectionDB();
            Connection con = c.getConnection();

            String commed = "insert into pro value ( "
                    + id
                    + ",'" + name.toLowerCase() + "'"
                    + ",'" + kind.toLowerCase() + "'"
                    + ",'" + number.toLowerCase() + "'"
                    + "," + price
                    + ",'" + date.toLowerCase() + "')";
            PreparedStatement ps = (PreparedStatement) con.prepareStatement(commed);
            ps.execute();

            JOptionPane.showMessageDialog(null, "ADD IS DONE");
            AddId.setText("");
            AddName.setText("");
            AddKind.setText("");
            AddNumber.setText("");
            AddPrice.setText("");
            AddDate.setText("");

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "ERROR :: Check  your input");
            AddId.setText("");
            AddName.setText("");
            AddKind.setText("");
            AddNumber.setText("");
            AddPrice.setText("");
            AddDate.setText("");
        }

    }
    //============================End ADD=================================

    //=============================Delete================================
    @FXML
    private JFXTextField DeleteName;

    @FXML
    public void Delete() throws ClassNotFoundException, SQLException {
        try {
            String name = DeleteName.getText();

            ConnectionDB c = new ConnectionDB();
            Connection con = c.getConnection();

            String commed = "delete from pro where name ='" + name + "'";

            PreparedStatement ps = (PreparedStatement) con.prepareStatement(commed);
            ps.execute();

            JOptionPane.showMessageDialog(null, "DELETE IS DONE");
            DeleteName.setText("");
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "ERROR :: Check your input");
            DeleteName.setText("");
        }

    }
    //================================end delete=======================

    //===================================Update =========================
    @FXML
    private JFXTextField UPdateName;

    @FXML
    private JFXTextField UpdatePer;

    @FXML
    void Update() {

        try {
            String name = UPdateName.getText();
            int per = Integer.parseInt(UpdatePer.getText());
            ConnectionDB c = new ConnectionDB();
            Connection con = c.getConnection();

            String commed = "update pro set price =(price *" + per + ") where name ='" + name + "'";

            PreparedStatement ps = (PreparedStatement) con.prepareStatement(commed);
            ps.execute();

            JOptionPane.showMessageDialog(null, "UPDATE IS DONE");
            UPdateName.setText("");
            UpdatePer.setText("");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR::Check your input");
            UPdateName.setText("");
            UpdatePer.setText("");

        }

    }
    //==================================end UPdate==========================

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
