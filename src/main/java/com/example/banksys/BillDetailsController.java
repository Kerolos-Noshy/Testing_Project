package com.example.banksys;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Map;
import java.util.Objects;
import java.util.ResourceBundle;

public class BillDetailsController implements Initializable{

    @FXML
    private Label date;

    @FXML
    private Label billid;
    @FXML
    private Label store;
    @FXML
    private Label details;
    @FXML
    private Label price;

    private int billId;

    @Override
    public void initialize(URL url, ResourceBundle rb)  {
        long tBefore = System.nanoTime();
        billId = BillManager.getInstance().getBillID();
        SystemManager sys = SystemManager.getInstance();
        Account user = sys.getLoggedInUser();
        for (Bill bill: user.getBills()){
            if(billId == bill.getBillID()){
                date.setText(String.valueOf(bill.getDate()));
                billid.setText(String.valueOf(billId));
                String storeName = sys.getAccountById(bill.getStoreID()).getName();
                store.setText(storeName);
                String billDetails = billDetails(bill);
                details.setText(billDetails);
                price.setText(bill.calculatePrice() + "$");
            }
        }
        long tAfter = System.nanoTime();
        System.out.println("Time Taken to Show Bill: "+String.format("%.5f",(tAfter-tBefore)*Math.pow(10,-9)));
    }
    public String billDetails(Bill bill){
        String d = "";

        for (Map.Entry<Item, Integer> entry : bill.getItemQuantities().entrySet()) {
            String price = String.valueOf(entry.getKey().getPrice());
            String item = entry.getKey().getName();
            String quantity = entry.getValue().toString();
            d += item + "(" + quantity + ")\t" + price + "$ * " + quantity+"\n";
        }
        return d;
    }

    @FXML
    void back(MouseEvent event) throws IOException {

        Parent root1 = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("ShowBills.fxml")));
        Stage stg = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene sc1 = new Scene(root1);
        stg.setScene(sc1);
        stg.show();
    }
}
