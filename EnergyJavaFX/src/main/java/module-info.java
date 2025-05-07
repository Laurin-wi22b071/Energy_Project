module org.example.demjavafxbb {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.demjavafxbb to javafx.fxml;
    exports org.example.demjavafxbb;
}