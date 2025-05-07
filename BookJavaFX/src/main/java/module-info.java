module org.example.javafxbb {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.net.http;
    requires com.fasterxml.jackson.databind;
    requires java.desktop;


    opens org.example.javafxbb to javafx.fxml;
    exports org.example.javafxbb;
}