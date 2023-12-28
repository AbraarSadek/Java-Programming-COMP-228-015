module com.example.abraar_final {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.abraar_final to javafx.fxml;
    exports com.example.abraar_final;
}