package com.example.banksys;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.ResourceBundle;

public class SignUpController implements Initializable {

    @FXML
    private DatePicker Birthdate;

    @FXML
    private TextField address;

    @FXML
    private Label fillfield;

    @FXML
    private ComboBox<String> gender;

    @FXML
    private TextField name;

    @FXML
    private PasswordField password;

    @FXML
    private ComboBox<String> type;


    @Override
    public void initialize(URL url, ResourceBundle rb){
        ObservableList<String> list= FXCollections.observableArrayList("Female","Male");
        gender.setItems(list);
        ObservableList<String> listType= FXCollections.observableArrayList("Checking","Saving");
        type.setItems(listType);
    }

    //for backend
    void getAndAdd() throws InvalidPass{
        String Name= name.getText();
        String add= address.getText();
        String BD=Birthdate.getValue().toString();
        String pass=password.getText();
        char g= gender.getSelectionModel().getSelectedItem().toString().charAt(0);
        String t=type.getSelectionModel().getSelectedItem().toString();
        SystemManager sys = SystemManager.getInstance();
        final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        sys.addAccount(Name, pass,t ,add, LocalDate.parse(BD,dtf), g);
    }




    @FXML
    void NewAccountButton(ActionEvent event) throws IOException {
      //  System.out.println(gender.getValue());
        long tBefore = System.nanoTime();

        if (name.getText().toString().isEmpty()||address.getText().isEmpty()||password.getText().isEmpty()||gender.getSelectionModel().isEmpty()||Birthdate.getValue().toString().isEmpty())
        {
            fillfield.setText("Please Fill All Fields");
        }
        else {
            try{
                getAndAdd();
            }
            catch (Exception e){
                fillfield.setText("Password must be more than 6 characters");
                return;
            }
            long tAfter = System.nanoTime();
            System.out.println("Time Taken to Sign UP: "+String.format("%.5f",(tAfter-tBefore)*Math.pow(10,-9)));
            Parent root1 = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("hello-view.fxml")));
            Stage stg=(Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene sc1=new Scene(root1);
            stg.setScene(sc1);
            stg.show();
       }

    }

    @FXML
    void back(MouseEvent event) throws IOException {
        Parent root1 = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("login.fxml")));
        Stage stg = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene sc1 = new Scene(root1);
        stg.setScene(sc1);
        stg.show();
    }
}
//