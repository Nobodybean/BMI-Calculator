package com.example.bmicalculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BMACalculatorController {
    private boolean isEnglish = true;
    @FXML
    private TextField bmiTextField, weightTextField, heightTextField;
    @FXML
    private RadioButton metricRadioBtn, englishRadioBtn;
    @FXML
    private TextField resultTextField;

    @FXML
    private ToggleGroup system;

    @FXML
    void onClick(ActionEvent event) {
        try {
            BigDecimal weight = new BigDecimal(weightTextField.getText());
            BigDecimal height = new BigDecimal(heightTextField.getText()).divide(BigDecimal.valueOf(100));
            BigDecimal bma = weight.divide(height.pow(2), RoundingMode.HALF_UP);
            if (this.isEnglish) {
                bma = bma.multiply(BigDecimal.valueOf(703));
            }
            bmiTextField.setText(bma.toString());
            if (bma.compareTo(BigDecimal.valueOf(18.5)) < 0) {
                resultTextField.setText("UnderWeight");
            }
            else if (bma.compareTo(BigDecimal.valueOf(25)) < 0) {
                resultTextField.setText("Normal");
            } else if (bma.compareTo(BigDecimal.valueOf(30)) < 0) {
                resultTextField.setText("Overweight");
            } else {
                resultTextField.setText("Obese");
            }
        }
        catch(Exception ex){
            System.out.println("Jungkook");
        }
    }

    public void initialize() {
        this.isEnglish = false;
        metricRadioBtn.setSelected(true);
    }

    public void getSystem(ActionEvent event) {
        if (metricRadioBtn.isSelected()) this.isEnglish = true;
        this.isEnglish = false;
    }
}
