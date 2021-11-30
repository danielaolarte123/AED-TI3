package ui;

import dataStructures.Graph;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import model.IcesiMap;

public class Main extends Application {

	private IcesiMap icesiMap;
	private Controller controller;

	public Main() {

		icesiMap = new IcesiMap();

		controller=new Controller(icesiMap);
	}

	public static void main(String[] args) {
		launch(args);


	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		 FXMLLoader fxmload = new FXMLLoader(getClass().getResource("Pane.fxml"));
		 fxmload.setController(controller); Parent root=fxmload.load(); Scene
		 scene = new Scene(root,1280,720); primaryStage.setScene(scene);
		 primaryStage.show(); primaryStage.setTitle("ICESI MAP");
		primaryStage.setResizable(false);
		 
		 Image icon = new Image("resources/icon.png");
		  primaryStage.getIcons().add(icon);
		  controller.loadMenu();
		 

	}

}
