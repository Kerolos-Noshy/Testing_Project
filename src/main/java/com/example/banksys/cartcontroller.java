package com.example.banksys;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;
import java.util.ResourceBundle;

public class cartcontroller implements Initializable {

    @FXML
    private TableColumn<Cart, Integer> Qtycolumn;

    @FXML
    private TableView<Cart> cart;

    @FXML
    private ComboBox<String> item;

    @FXML
    private TableColumn<Cart, String> itemcolumn;

    @FXML
    private Label price;

    @FXML
    private TableColumn<Cart, Double> pricecolumn;

    @FXML
    private Label confirmation;



    ObservableList<String> listt= FXCollections.observableArrayList();

    private Bill bill;

    ObservableList<Cart> list = FXCollections.observableArrayList();
    public ObservableList<Cart> setList(){
        SystemManager sys = SystemManager.getInstance();
        Bill b = sys.getBill();
        for(Item item1: b.getItems()){
            list.add(new Cart(item1.getName(), b.getItemQuantities().get(item1), item1.getPrice()));
            if(!b.isItemExist(item1))
                b.buyItem(item1,1);
        }
        return list;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb)  {
        SystemManager sys = SystemManager.getInstance();
        bill = sys.getBill();
        for (Item item : bill.getItems()){
            listt.add(item.getName());
        }
        item.setItems(listt);
        itemcolumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        pricecolumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        Qtycolumn.setCellValueFactory( new PropertyValueFactory<>("Qty"));
        cart.setItems(setList());

        price.setText(bill.calculatePrice()+"$");
    }

    @FXML
    void pressadd(MouseEvent event) {
        long tBefore = System.nanoTime();
        SystemManager sys = SystemManager.getInstance();
        ArrayList<Item> cartItems = sys.getBill().getItems();

        bill.buyItem(cartItems.get(item.getSelectionModel().getSelectedIndex()),1);
        list.get(item.getSelectionModel().getSelectedIndex())
                .setQty(list.get(item.getSelectionModel().getSelectedIndex()).getQty() + 1);
        price.setText(bill.calculatePrice()+"$");
        cart.setItems(list);

        cart.refresh();
        long tAfter = System.nanoTime();
        System.out.println("Time Taken to Increase Quantity: "+String.format("%.5f",(tAfter-tBefore)*Math.pow(10,-9)));
    }

    @FXML
    void pressminus(MouseEvent event) {
        long tBefore = System.nanoTime();
        SystemManager sys = SystemManager.getInstance();
        ArrayList<Item> cartItems = sys.getBill().getItems();

        bill.buyItem(cartItems.get(item.getSelectionModel().getSelectedIndex()),-1);
        int newQty = list.get(item.getSelectionModel().getSelectedIndex()).getQty() - 1;
        if(newQty == 0){
            int comboBoxIndex = item.getSelectionModel().getSelectedIndex();
            list.remove(comboBoxIndex);
            bill.removeItem(cartItems.get(comboBoxIndex));
            listt.remove(comboBoxIndex);
        } else{
        list.get(item.getSelectionModel().getSelectedIndex())
                .setQty(list.get(item.getSelectionModel().getSelectedIndex()).getQty() - 1);
}
        price.setText(bill.calculatePrice()+"$");
        cart.setItems(list);
        cart.refresh();
        long tAfter = System.nanoTime();
        System.out.println("Time Taken to Decrease Quantity: "+String.format("%.5f",(tAfter-tBefore)*Math.pow(10,-9)));

    }

    @FXML
    void buy(MouseEvent event) throws IOException{
        SystemManager sys = SystemManager.getInstance();
        Account acc = sys.getLoggedInUser();
        long tBefore = System.nanoTime();
        try {
            Transaction t = new Transaction(sys.getBill().calculatePrice(), acc.getAccountID(), sys.getStoreID());
            t.transfer();
            confirmation.setText("Items Purchased Successfully");
            acc.addBills(sys.getBill());
            sys.resetBill();
            list.clear();

        }
        catch (InsufficientBalance | InvalidTransaction e){
            confirmation.setText(e.getMessage());
        }
        long tAfter = System.nanoTime();
        System.out.println("Time Taken to buy the items: "+String.format("%.5f",(tAfter-tBefore)*Math.pow(10,-9)));
    }

    @FXML
    void back(MouseEvent event) throws IOException {

        Parent root1 = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("buyitem .fxml")));
        Stage stg = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene sc1 = new Scene(root1);
        stg.setScene(sc1);
        stg.show();
    }
}
