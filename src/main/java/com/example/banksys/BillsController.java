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
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Objects;
import java.util.ResourceBundle;

public  class BillsController  implements Initializable {
    @FXML
    private TableView<Bills> Bills;

    @FXML
    private TableColumn<Bills, String> billsourcecolumn;

    @FXML
    private TableColumn<Bills, LocalDate> datecolumn;

    @FXML
    private TableColumn<Bills, Double> pricecolumn;

    @FXML
    private TableColumn<Bills, Integer> billidcolumn;

    @FXML
    private TextField billId;

    @FXML
    private Button showDetails;


    ObservableList<Bills> list = FXCollections.observableArrayList();
    public ObservableList<Bills> setList(){
        SystemManager sys = SystemManager.getInstance();
        Account user = sys.getLoggedInUser();
        for (Bill b: user.getBills()){
            int storeId = b.getStoreID();
            list.add(new Bills(b.getBillID(), b.getDate(), sys.getAccountById(storeId).getName(), b.calculatePrice()));
        }
        return list;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb)  {
        long tBefore = System.nanoTime();
        billidcolumn.setCellValueFactory(new PropertyValueFactory<>("billid"));
        datecolumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        billsourcecolumn.setCellValueFactory(new PropertyValueFactory<>("store"));
        pricecolumn.setCellValueFactory( new PropertyValueFactory<>("price"));
        Bills.setItems(setList());
        long tAfter = System.nanoTime();
        System.out.println("Time Taken to Show Bill History: "+String.format("%.5f",(tAfter-tBefore)*Math.pow(10,-9)));
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
    void billbutton(ActionEvent event) throws IOException {
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
    void logoutbutton(ActionEvent event) throws IOException {
        Parent root1 = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("login.fxml")));
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
    void mtrnasferbutton(ActionEvent event) throws IOException{
        Parent root1 = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Transfer.fxml")));
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
    void showBillDetails(ActionEvent event) throws IOException {
        BillManager.getInstance().setBillID(Integer.parseInt(billId.getText()));
        Parent root1 = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("BillDetails.fxml")));
        Stage stg = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene sc1 = new Scene(root1);
        stg.setScene(sc1);
        stg.show();

    }


}
