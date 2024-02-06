package com.shristy.javaFxApp;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
	public Labeled welcomeLabel;
    @FXML
	public ChoiceBox<String> choiceBox;
    @FXML
    public TextField userInputField;
    @FXML
    public Button buttonConvert;

    private static final String  C_TO_F_TEXT="celsius To Fahrenheit";
	private static final String  F_TO_C_TEXT="Fahrenheit To celsius";
	private boolean isC_TO_F=true;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		choiceBox.getItems().add(C_TO_F_TEXT);
		choiceBox.getItems().add(F_TO_C_TEXT);

		choiceBox.setValue(C_TO_F_TEXT);

	choiceBox.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
		@Override
		public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
			System.out.println(newValue);
			if(newValue.equals(isC_TO_F)){
				isC_TO_F=true;
			}
			else{
				isC_TO_F=false;
			}
		}
	});

      buttonConvert.setOnAction(new EventHandler<ActionEvent>() {
	      @Override
	      public void handle(ActionEvent event) {
		      System.out.println("Button Clicked");
		      convert();
	      }
      });
	}
	private void convert(){
		String input= userInputField.getText();
		float enteredTemperature=0.0f;
		try {
			 enteredTemperature=Float.parseFloat(input);
		}catch (Exception ex){
			warnUser();
            return;
		}
        float newTemperature=0.0f;
		if(isC_TO_F) {
			newTemperature = (enteredTemperature * 9 / 5) + 32;
		}
		else {
			newTemperature =(enteredTemperature -32) * 5 / 9;
			}
		display(newTemperature);
		}

		private void warnUser() {
			Alert alert =new Alert(Alert.AlertType.ERROR);
			alert.setTitle("Error Occured");
			alert.setHeaderText("Invalid Temperature occured");
			alert.setContentText("Enter valid Temperature");
			alert.show();
	}

		private void display(float newTemperature){
		    String unit= isC_TO_F? "F":"C";
			System.out.println("The new temperature is:" +newTemperature +unit);

			Alert alert =new Alert(Alert.AlertType.INFORMATION);
			alert.setTitle("Result");
			alert.setContentText("The new temperature is:" +newTemperature +unit);
			alert.show();

	}
}
