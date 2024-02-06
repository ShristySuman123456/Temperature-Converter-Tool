package com.shristy.javaFxApp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.beans.EventHandler;
import java.util.Optional;

public class MyMain extends Application {
	public static void main(String[] args){
		System.out.println("main");
		launch(args);
	}

	@Override
	public void init() throws Exception {
		System.out.println("init");
		super.init();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		System.out.println("start");

		FXMLLoader loader = new FXMLLoader(getClass().getResource("App_layout.fxml"));
		VBox rootNode = loader.load();

		MenuBar menuBar=createMenu();
		rootNode.getChildren().add(0,menuBar);
		Scene scene = new Scene(rootNode);

		primaryStage.setScene(scene);
		primaryStage.setTitle("Temperature Converter Tool");
		primaryStage.show();

	}
	private MenuBar createMenu(){
		//create file menu
		Menu fileMenu =new Menu("File");
		MenuItem newMenu = new MenuItem("New");

		newMenu.setOnAction(new javafx.event.EventHandler<javafx.event.ActionEvent>() {
			@Override
			public void handle(javafx.event.ActionEvent event) {
				System.out.println("New menu item clicked");
			}
		});

		MenuItem openMenu = new MenuItem("Open");
		MenuItem projectMenu = new MenuItem("Project");
		fileMenu.getItems().addAll(newMenu,openMenu,projectMenu);
		//create helpMenu
		Menu helpMenu =new Menu("Help");
		MenuItem aboutApp = new MenuItem("About");
		aboutApp.setOnAction(new javafx.event.EventHandler<javafx.event.ActionEvent>() {
			@Override
			public void handle(javafx.event.ActionEvent event) {
				aboutApp();
			}
		});

		MenuItem compileApp = new MenuItem("Compile");
		helpMenu.getItems().addAll(aboutApp,compileApp);
		//create Menubar
		Menu viewMenu =new Menu("View");
		MenuItem ToolMenu = new MenuItem("Toolkit");
		viewMenu.getItems().addAll(ToolMenu);

		Menu navigateMenu =new Menu("Navigate");
		MenuBar MenuBar = new MenuBar();
		MenuBar.getMenus().addAll(fileMenu,helpMenu,viewMenu,navigateMenu);

		return MenuBar;
	}

	private void aboutApp() {
		Alert alertDialog= new Alert(Alert.AlertType.WARNING);
		alertDialog.setTitle("My First Desktop App");
		alertDialog.setHeaderText("Learning javaFx");
		alertDialog.setContentText("I m just beginner but soon i will be pro and develop the java games");

		ButtonType yesBtn= new ButtonType("Yes");
		ButtonType noBtn = new ButtonType("no");
		alertDialog.getButtonTypes().setAll(yesBtn,noBtn);

		Optional<ButtonType> clickedbtn = alertDialog.showAndWait();
		if(clickedbtn.isPresent()&& clickedbtn.get()== yesBtn){
			System.out.println("yes,button is clicked");
		}
		else{
			System.out.println("no,button is clicked");
		}
		alertDialog.show();

	}

	@Override
	public void stop() throws Exception {

		System.out.println("stop");
		super.stop();
	}
}

