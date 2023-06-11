package com.example.banksys;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class TransferController {
    @FXML
    private Label wrongT;
    @FXML
    private TextField account;
    @FXML
    private TextField amount;

    @FXML
    void history(ActionEvent event)  throws IOException{
        Parent root1 = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("history.fxml")));
        Stage stg = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene sc1 = new Scene(root1);
        stg.setScene(sc1);
        stg.show();
    }

    @FXML
    void BillsButton(ActionEvent event) throws IOException {
        Parent root1 = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("ShowBills.fxml")));
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
    void TransferButton(ActionEvent event)  throws IOException {
        Parent root1 = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Transfer.fxml")));
        Stage stg = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene sc1 = new Scene(root1);
        stg.setScene(sc1);
        stg.show();
    }

    @FXML
    void logoutButton(ActionEvent event) throws IOException {
        Parent root1 = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("login.fxml")));
        Stage stg = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene sc1 = new Scene(root1);
        stg.setScene(sc1);
        stg.show();
    }

    @FXML
    void profileButton(ActionEvent event) throws IOException  {
        Parent root1 = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("profile.fxml")));
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
    void confirm(MouseEvent event) throws IOException {
        if (amount.getText().toString().isEmpty()||account.getText().toString().isEmpty())
        {
            wrongT.setText("Please Fill All Fields");
        }


        else {
            SystemManager sys = SystemManager.getInstance();
            Account to = sys.getAccountById(Integer.parseInt(account.getText()));

            if (to != null) {
                try {
                    Transaction t = new Transaction(Double.parseDouble(amount.getText()), sys.getLoggedInUser().getAccountID()
                            , to.getAccountID());
                    t.transfer();
                } catch (InsufficientBalance | InvalidTransaction e) {
                    wrongT.setText(e.getMessage());
                    return;
                }
                wrongT.setText("Success");
//            Parent root1 = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("hello-view.fxml")));
//            Stage stg = (Stage) ((Node) event.getSource()).getScene().getWindow();
//            Scene sc1 = new Scene(root1);
//            stg.setScene(sc1);
//            stg.show();
            } else {
                wrongT.setText("Refused!!");
            }
        }
    }
}
