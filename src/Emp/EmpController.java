package Emp;

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

public class EmpController implements Initializable {

    //======================== ADD  ==================================
    @FXML
    private JFXTextField AddID;

    @FXML
    private JFXTextField AddName;

    @FXML
    private JFXTextField AddDate;

    @FXML
    private JFXTextField AddSalary;

    @FXML
    private JFXTextField AddCourse;

    @FXML
    public void ADDEMP() throws ClassNotFoundException, SQLException {

        try {

            int id1 = Integer.parseInt(AddID.getText());
            String id = String.valueOf(id1);
            String name = AddName.getText();
            String date = AddDate.getText();
            int salary = Integer.parseInt(AddSalary.getText());
            String course = AddCourse.getText();

            //======================================
            ConnectionDB c = new ConnectionDB();
            Connection con = c.getConnection();
            //=======================================

            String commed = "insert into emp values ("
                    + " '" + id.toLowerCase() + "'"
                    + ", '" + name.toLowerCase() + "'"
                    + ", '" + date.toLowerCase() + "'"
                    + ", " + salary
                    + ", '" + course.toLowerCase() + " ')";

            PreparedStatement ps = (PreparedStatement) con.prepareStatement(commed);
            ps.execute();

            JOptionPane.showMessageDialog(null, "Done");
            AddID.setText("");
            AddName.setText("");
            AddDate.setText("");
            AddSalary.setText("");
            AddCourse.setText("");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, " ERROR::Check Your Input again");
            AddID.setText("");
            AddName.setText("");
            AddDate.setText("");
            AddSalary.setText("");
            AddCourse.setText("");
        }

    }

    //=================================End ADD===================================================
    //=================================DELETE===================================================
    @FXML
    private JFXTextField DeleteId;

    @FXML
    public void Delete() {

        try {
            int id1 = Integer.parseInt(DeleteId.getText());
            String id = String.valueOf(id1);

            //======================================
            ConnectionDB c = new ConnectionDB();
            Connection con = c.getConnection();
            //=====================================
            String commed = "delete from emp where id ='" + id + "'";

            PreparedStatement ps = (PreparedStatement) con.prepareStatement(commed);
            ps.execute();

            JOptionPane.showMessageDialog(null, "DELETE IS DONE");
            DeleteId.setText("");

            System.out.println(id);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR:::Check your input");
            DeleteId.setText("");

        }

    }

    //====================================End Delete=============================================
    //===================================Update All=============================================
    @FXML
    private JFXTextField persent;

    @FXML
    void UpdateAll() throws ClassNotFoundException, SQLException {
        
        try {
                int per = Integer.parseInt(persent.getText());
            //======================================
            ConnectionDB c = new ConnectionDB();
            Connection con = c.getConnection();
            //=====================================
            String commed = "update  emp set salary = (salary *" + per + ")";
            PreparedStatement ps = (PreparedStatement) con.prepareStatement(commed);
            ps.execute();

            JOptionPane.showMessageDialog(null, "UPDATE IS DONE");
            persent.setText("");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR::Check your input");
            persent.setText("");

        }

    }

    //===================================End UpdateALl=============================================
    //=================================UPdate One==================================================
    @FXML
    private JFXTextField UpdateOneId;

    @FXML
    private JFXTextField UpdateOnePersent;

    @FXML
    public void UpdateOne() {

        try {
            int id1 = Integer.parseInt(UpdateOneId.getText());
            String id = String.valueOf(id1);

            int per = Integer.parseInt(UpdateOnePersent.getText());
            //=======================================
            ConnectionDB c = new ConnectionDB();
            Connection con = c.getConnection();
            //=====================================

            String commed = "update emp set salary =(salary *" + per + ") where id ='" + id + "'";
            PreparedStatement ps = (PreparedStatement) con.prepareStatement(commed);
            ps.execute();
            JOptionPane.showMessageDialog(null, "UPDATE IS DONE");
            UpdateOneId.setText("");
            UpdateOnePersent.setText("");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR::Check your input");
            UpdateOneId.setText("");
            UpdateOnePersent.setText("");
        }

    }

    //=================================End Update One===============================================
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
