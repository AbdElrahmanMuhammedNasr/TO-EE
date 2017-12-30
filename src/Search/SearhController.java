package Search;

import DataBase.ConnectionDB;
import com.jfoenix.controls.JFXTextField;
import com.mysql.jdbc.PreparedStatement;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;

public class SearhController implements Initializable {

    ObservableList<emp> list = FXCollections.observableArrayList();
    ObservableList<pro> list2 = FXCollections.observableArrayList();

    @FXML
    TableView<emp> table;

    @FXML
    TableColumn< emp, String> id;

    @FXML
    TableColumn<emp, String> name;

    @FXML
    TableColumn< emp, String> date;

    @FXML
    TableColumn< emp, String> salary;

    @FXML
    TableColumn<emp, String> jop;

    //=============================================================================
    @FXML
    TableView<pro> table2;

    @FXML
    TableColumn<pro, Integer> id2;

    @FXML
    TableColumn<pro, String> name2;

    @FXML
    TableColumn<pro, String> kind2;

    @FXML
    TableColumn<pro, String> number2;

    @FXML
    TableColumn<pro, Integer> price2;

    @FXML
    TableColumn<pro, String> date2;
    //====================================================================================

    @FXML
    private JFXTextField empName;

    @FXML
    private JFXTextField empJop;

    @FXML
    void se(KeyEvent event) {
 
        // remove table
        ObservableList<emp> Filters = FXCollections.observableArrayList();

        list.stream().filter(p -> p.getName().startsWith(empName.getText().toLowerCase())).forEach(p -> {
            Filters.add(new emp(p.getId(), p.getName(), p.getSalary(), p.getDate(), p.getCourse()));

        });
        table.setItems(Filters);

    }
    
    
       @FXML
    void se2(KeyEvent event) {
           ObservableList<emp> Filters = FXCollections.observableArrayList();

           list.stream().filter(p -> p.getCourse().startsWith(empJop.getText().toLowerCase())).forEach(p -> {
               Filters.add(new emp(p.getId(), p.getName(), p.getSalary(), p.getDate(), p.getCourse()));

           });
           table.setItems(Filters);

    }
    //========================================================================================
        @FXML
    private JFXTextField proKind;

    @FXML
    private JFXTextField ProDate;
    
    
      @FXML
    void se3(KeyEvent event) {
         ObservableList<pro> Filters = FXCollections.observableArrayList();

           list2.stream().filter(p -> p.getKind().startsWith(proKind.getText().toLowerCase())).forEach((pro p) -> {
               Filters.add(new pro(p.getId(),p.getName(),p.getKind(),p.getNumber(),p.getPrice(),p.getDate()));

           });
           table2.setItems(Filters);

    }

    @FXML
    void se4(KeyEvent event) {
         ObservableList<pro> Filters = FXCollections.observableArrayList();

           list2.stream().filter(p -> p.getDate().startsWith(ProDate.getText().toLowerCase())).forEach((pro p) -> {
               Filters.add(new pro(p.getId(),p.getName(),p.getKind(),p.getNumber(),p.getPrice(),p.getDate()));

           });
           table2.setItems(Filters);


    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //==========================================================================================

        ConnectionDB c = new ConnectionDB();
        try {
            Connection con = c.getConnection();

            String commed = "select id , name , salary , date , course from emp ";
            PreparedStatement ps = (PreparedStatement) con.prepareStatement(commed);

            ResultSet result = ps.executeQuery();
            while (result.next()) {
                list.add(new emp(result.getString("id"), result.getString("name"), result.getString("salary"), result.getString("date"), result.getString("course")));

            }

            id.setCellValueFactory(new PropertyValueFactory<emp, String>("id"));
            name.setCellValueFactory(new PropertyValueFactory<emp, String>("name"));
            date.setCellValueFactory(new PropertyValueFactory<emp, String>("salary"));
            salary.setCellValueFactory(new PropertyValueFactory<emp, String>("date"));
            jop.setCellValueFactory(new PropertyValueFactory<emp, String>("course"));

            table.setItems(list);

        } catch (Exception e0) {

        }
        //================================================================================

        try {
            ConnectionDB c2 = new ConnectionDB();
            Connection con = c2.getConnection();

            String commed = "select id , name , kind , number , price ,date from pro ";
            PreparedStatement ps = (PreparedStatement) con.prepareStatement(commed);

            ResultSet result = ps.executeQuery();
            while (result.next()) {
                list2.add(new pro(result.getInt("id"), result.getString("name"), result.getString("kind"), result.getString("number"), result.getInt("price"), result.getString("date")));

            }

            id2.setCellValueFactory(new PropertyValueFactory<pro, Integer>("id"));
            name2.setCellValueFactory(new PropertyValueFactory<pro, String>("name"));
            kind2.setCellValueFactory(new PropertyValueFactory<pro, String>("kind"));
            number2.setCellValueFactory(new PropertyValueFactory<pro, String>("number"));
            price2.setCellValueFactory(new PropertyValueFactory<pro, Integer>("price"));
            date2.setCellValueFactory(new PropertyValueFactory<pro, String>("date"));

            table2.setItems(list2);

        } catch (Exception e0) {

        }

    }

}
