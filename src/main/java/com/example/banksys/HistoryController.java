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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Objects;
import java.util.ResourceBundle;

public class HistoryController implements Initializable {

    @FXML
    private TableView<History> hist;

    @FXML
    private TableColumn<History, Integer> idcolumn;

    @FXML
    private TableColumn<History, Double> amountcolumn;

    @FXML
    private TableColumn<History, LocalDate> date;

    @FXML
    private TableColumn<History, String> detailscolumn;


    public ObservableList<History> setList(){
        ObservableList<History> list = FXCollections.observableArrayList();
        SystemManager sys = SystemManager.getInstance();
        Account user = sys.getLoggedInUser();
        for (Transaction t : user.getTransactions()){
            String details;
           if (t.getToAccountId() == user.getAccountID())
               details = "Received from " + sys.getAccountById(t.getFromAccountId()).getName();
           else
               details = "Sent to " + sys.getAccountById(t.getToAccountId()).getName();
            list.add(new History(t.getTransactionId(), t.getTransactionDate(), details, t.getAmount()));
        }
        return list;
    }


    @Override
    public void initialize(URL url, ResourceBundle rb)  {
        long tBefore = System.nanoTime();
        amountcolumn.setCellValueFactory(new PropertyValueFactory<>("amount"));
        idcolumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        date.setCellValueFactory(new PropertyValueFactory<>("date"));
        detailscolumn.setCellValueFactory(new PropertyValueFactory<>("details"));
        hist.setItems(setList());
        long tAfter = System.nanoTime();
        System.out.println("Time Taken to Show Transaction History: "+String.format("%.5f",(tAfter-tBefore)*Math.pow(10,-9)));
    }

    @FXML
    void billbutton(ActionEvent event) throws IOException{
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
    void history(ActionEvent event) throws IOException {
        Parent root1 = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("history.fxml")));
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
    void logoutbutton(ActionEvent event)throws IOException {
        Parent root1 = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("login.fxml")));
        Stage stg = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene sc1 = new Scene(root1);
        stg.setScene(sc1);
        stg.show();
    }

    @FXML
    void mtrnasferbutton(ActionEvent event) throws IOException{
        Parent root1 = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Transfer.fxml")));
        Stage stg = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene sc1 = new Scene(root1);
        stg.setScene(sc1);
        stg.show();

    }

    @FXML
    void profilebutton(ActionEvent event) throws IOException{
        Parent root1 = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("profile.fxml")));
        Stage stg = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene sc1 = new Scene(root1);
        stg.setScene(sc1);
        stg.show();

    }
}
