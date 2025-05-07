package org.example.demjavafxbb;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class GUIController {
    @FXML
    private Label welcomeText;
    public TextField tfNum1;
    public TextField tfNum2;
    public Label labelResult;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    public void onPlusButtonClick(ActionEvent actionEvent) {
        double num1 = Double.parseDouble(tfNum1.getText());
        double num2 = Double.parseDouble(tfNum2.getText());
        double result = num1 + num2;
        labelResult.setText(String.valueOf(result));
    }

    public void onMinusButtonClick(ActionEvent actionEvent) {
        double num1 = Double.parseDouble(tfNum1.getText());
        double num2 = Double.parseDouble(tfNum2.getText());
        double result = num1 - num2;
        labelResult.setText(String.valueOf(result));
    }

    public void onMultiplyButtonClick(ActionEvent actionEvent) {
        double num1 = Double.parseDouble(tfNum1.getText());
        double num2 = Double.parseDouble(tfNum2.getText());
        double result = num1 * num2;
        labelResult.setText(String.valueOf(result));
    }

    public void onDivideButtonClick(ActionEvent actionEvent) {
        double num1 = Double.parseDouble(tfNum1.getText());
        double num2 = Double.parseDouble(tfNum2.getText());
        if (num2 == 0) {
            labelResult.setText(String.valueOf("Kann nicht durch 0 dividieren"));
        } else {
            double result = num1 / num2;
            labelResult.setText(String.valueOf(result));
        }

    }


}