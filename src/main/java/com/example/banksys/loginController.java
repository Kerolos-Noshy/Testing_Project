package com.example.banksys;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class loginController {
    @FXML
    private TextField username; //connect to backend
    @FXML
    private PasswordField password; //connect to backend
    @FXML
    private Button signUp; //connect to backend
    @FXML
    private Label wrong;


    @FXML
    void signup(ActionEvent event) throws IOException {
        Parent root1 = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("SignUp.fxml")));
        Stage stg = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene sc1 = new Scene(root1);
        stg.setScene(sc1);
        stg.show();


    }

    @FXML
    void loginButton(ActionEvent event) throws IOException {
        SystemManager sys = SystemManager.getInstance();
//        if (username.getText().equals("Farah")&& password.getText().equals("123"))
        long tBefore = System.nanoTime();
        if(sys.match(username.getText(),password.getText()))
        {
            Parent root1 = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("hello-view.fxml")));
            Stage stg = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene sc1 = new Scene(root1);
            stg.setScene(sc1);
            stg.show();
        }
        else if (username.getText().toString().isEmpty()||password.getText().toString().isEmpty())
        {
            wrong.setText("Please Fill All Fields");
        }
        else {
            wrong.setText("WRONG USERNAME OR PASSWORD");
        }
        long tAfter = System.nanoTime();
        System.out.println("Time Taken to Login: "+String.format("%.5f",(tAfter-tBefore)*Math.pow(10,-9)));
    }
}



//    @FXML
//    void signUp(ActionEvent event) throws IOException {
//        login l= new login();
//        l.ChangeScene("SignUp.fxml");
//    }
