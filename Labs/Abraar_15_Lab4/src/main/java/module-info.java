module com.example.abraar_15_lab4 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.abraar_15_lab4 to javafx.fxml;
    exports com.example.abraar_15_lab4;
}