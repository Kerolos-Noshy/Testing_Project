package com.example.banksys;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class profileController implements Initializable {
    @FXML
    Button profile;
    @FXML
    private Label name;
    @FXML
    private Label accountno;
    @FXML
    private Label BD;
    @FXML
    private Label address;



//void show() throws NoSuchFieldException{
//
//
//    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {
            long tBefore = System.nanoTime();
            SystemManager sys = SystemManager.getInstance();
            Account user = sys.getLoggedInUser();
            name.setText(user.getName());

            accountno.setText(String.valueOf(user.getAccountID()));

            BD.setText(user.getBirth().toString());

            address.setText(user.getAddress());
            long tAfter = System.nanoTime();
            System.out.println("Time Taken to show Profile: "+String.format("%.5f",(tAfter-tBefore)*Math.pow(10,-9)));

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
    void profileButton(ActionEvent event) throws IOException {

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
    void billButton(ActionEvent event) throws IOException{

        Parent root1 = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("ShowBills.fxml")));
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
    void logoutButton(ActionEvent event) throws IOException {
        SystemManager sys = SystemManager.getInstance();
        sys.logOut();
        sys.resetBill();
        Parent root1 = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("login.fxml")));
        Stage stg = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene sc1 = new Scene(root1);
        stg.setScene(sc1);
        stg.show();
    }
    @FXML
    void transferbutton(ActionEvent event) throws IOException {
        Parent root1 = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Transfer.fxml")));
        Stage stg = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene sc1 = new Scene(root1);
        stg.setScene(sc1);
        stg.show();
    }


}
