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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class BuyController implements Initializable {

    @FXML
    private Label price;
    @FXML
    private ComboBox<String> item;
    @FXML
    private Label approvebuying;

    ObservableList<String> list= FXCollections.observableArrayList();
    @Override
    public void initialize(URL url, ResourceBundle rb){
        SystemManager sys = SystemManager.getInstance();
        for (Item item : sys.getItems()){
            list.add(item.getName());
        }
        item.setItems(list);
    }
    @FXML
    void billButton(ActionEvent event) throws IOException {
        Parent root1 = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("ShowBills.fxml")));
        Stage stg = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene sc1 = new Scene(root1);
        stg.setScene(sc1);
        stg.show();
    }


    @FXML
    void addToCart(MouseEvent event) throws IOException {
        long tBefore = System.nanoTime();
        SystemManager sys = SystemManager.getInstance();
        Item [] items = sys.getItems();
        Bill bill = sys.getBill();
        Item currentItem = items[item.getSelectionModel().getSelectedIndex()];
        if(!bill.isItemExist(currentItem)) {
            bill.buyItem(currentItem, 1);
            approvebuying.setText("Item added to cart");
        }
        else
            approvebuying.setText("Item already in cart");
        long tAfter = System.nanoTime();
        System.out.println("Time Taken to Add to Cart: "+String.format("%.5f",(tAfter-tBefore)*Math.pow(10,-9)));
    }

    @FXML
    void showPrice(MouseEvent event) throws IOException{
        SystemManager sys = SystemManager.getInstance();
        Item[] items = sys.getItems();
        price.setText(items[item.getSelectionModel().getSelectedIndex()].getPrice() + "$");
    }


    @FXML
    void buyitem(ActionEvent event)  throws IOException{
        Parent root1 = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("buyitem .fxml")));
        Stage stg = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene sc1 = new Scene(root1);
        stg.setScene(sc1);
        stg.show();
    }

    @FXML
    void homebutton(ActionEvent event) throws IOException {
        Parent root1 = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("hello-view.fxml")));
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
    void profileButton(ActionEvent event)  throws IOException{
        Parent root1 = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("profile.fxml")));
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
    @FXML
    void history(ActionEvent event)  throws IOException{
        Parent root1 = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("history.fxml")));
        Stage stg = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene sc1 = new Scene(root1);
        stg.setScene(sc1);
        stg.show();
    }
    @FXML
    void cart(ActionEvent event) throws IOException {
        Parent root1 = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("cart.fxml")));
        Stage stg = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene sc1 = new Scene(root1);
        stg.setScene(sc1);
        stg.show();

    }

}
