module com.example.abraar_15_lab5 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.abraar_15_lab5 to javafx.fxml;
    exports com.example.abraar_15_lab5;
}