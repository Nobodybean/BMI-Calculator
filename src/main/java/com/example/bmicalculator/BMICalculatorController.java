package com.example.bmicalculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class BMICalculatorController {
    public Button englshUnitsButton;
    private double weight;
    private double height;
    String ans = "";

    @FXML
    private TextField answerTextField;

    @FXML
    private Button englishUnitsButton;

    @FXML
    private Label heightLabel;

    @FXML
    private TextField heightTextField;

    @FXML
    private Button metricUnitsButton;

    @FXML
    private Label totalLabel;

    @FXML
    private Label weightLabel;

    @FXML
    private TextField weightTextField;

    @FXML
    void englishButtonPressed(ActionEvent event) {
        try{

            weight = Double.parseDouble(weightTextField.getText());

            height = Double.parseDouble(heightTextField.getText());

            double value = 703 * (weight/Math.pow(height,2));

            if(value<0){
                throw new NumberFormatException();
            }
            if(value<18.5){
                ans = "Underweight";
            }
            else if(value>=18.5 && value<= 24.99){
                ans = "Normal";
            }
            else if(value>=25 && value<= 29.99){
                ans = "Overweight";
            }
            else{
                ans = "Obese";
            }

            answerTextField.setText(ans);


        }
        catch (NumberFormatException ex){
            weightTextField.setText("Enter Weight");
            heightTextField.setText("Enter Height");
            weightTextField.selectAll();
            weightTextField.requestFocus();
        }
    }

    @FXML
    void metricButtonPressed(ActionEvent event) {
        try{

            weight = Double.parseDouble(weightTextField.getText());

            height = Double.parseDouble(heightTextField.getText());

            double value = (weight/Math.pow(height,2));
            if(value<0){
                throw new NumberFormatException();
            }
            if(value<18.5){
                ans = "Underweight";
            }
            else if(value>=18.5 && value<= 24.99){
                ans = "Normal";
            }
            else if(value>=25 && value<= 29.99){
                ans = "Overweight";
            }
            else{
                ans = "Obese";
            }

            answerTextField.setText(ans);


        }
        catch (NumberFormatException ex){
            weightTextField.setText("Enter Weight");
            heightTextField.setText("Enter Height");
            weightTextField.selectAll();
            weightTextField.requestFocus();
        }
    }


}