module com.example.banksys {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.banksys to javafx.fxml;
    exports com.example.banksys;
}