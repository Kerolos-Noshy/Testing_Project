package com.example.banksys;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    private Label accounttype;

    @FXML
    private Label currentamount;
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        SystemManager sys = SystemManager.getInstance();
        Account user = sys.getLoggedInUser();
        accounttype.setText(user.getAccountType());

        currentamount.setText(user.getBalance() + "$");

    }

    @FXML
    void history(ActionEvent event)  throws IOException{
        Parent root1 = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("history.fxml")));
        Stage stg = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene sc1 = new Scene(root1);
        stg.setScene(sc1);
        stg.show();
    }

    @FXML
    void profilebutton(ActionEvent event) throws IOException {
        Parent root1 = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("profile.fxml")));
        Stage stg = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene sc1 = new Scene(root1);
        stg.setScene(sc1);
        stg.show();

    }
    @FXML
    void buyitem(ActionEvent event) throws IOException {
        Parent root1 = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("buyitem .fxml")));
        Stage stg = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene sc1 = new Scene(root1);
        stg.setScene(sc1);
        stg.show();
    }
    @FXML
    void homebutton(ActionEvent event) throws IOException{
        Parent root1 = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("hello-view.fxml")));
        Stage stg = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene sc1 = new Scene(root1);
        stg.setScene(sc1);
        stg.show();
    }
    @FXML
    void TransferButton(ActionEvent event) throws IOException {
        Parent root1 = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Transfer.fxml")));
        Stage stg = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene sc1 = new Scene(root1);
        stg.setScene(sc1);
        stg.show();
    }
    @FXML
    void logoutButton(ActionEvent event) throws IOException {
        SystemManager sys = SystemManager.getInstance();
        sys.logOut();
        Parent root1 = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("login.fxml")));
        Stage stg = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene sc1 = new Scene(root1);
        stg.setScene(sc1);
        stg.show();

    }
    @FXML
    void billButton(ActionEvent event) throws IOException{
        Parent root1 = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("ShowBills.fxml")));
        Stage stg = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene sc1 = new Scene(root1);
        stg.setScene(sc1);
        stg.show();
    }
}