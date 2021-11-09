package ui;

import dataStructures.Graph;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

	// private FIBAController fibaController;
	// private FIBA fiba;

	public Main() {

		// fiba = new FIBA();

		// fibaController=new FIBAController(fiba);
	}

	public static void main(String[] args) {
		// launch(args);

		Graph <String>graph = new Graph<String>();
		graph.insertVertex("1");
		graph.insertVertex("2");
		graph.insertVertex("3");
		graph.insertVertex("4");
		graph.insertVertex("5");
		graph.insertVertex("6");
		graph.insertVertex("7");
		graph.insertVertex("8");
		graph.insertVertex("9");
		graph.insertVertex("10");
		graph.insertVertex("11");
		
		graph.insertEdge("1", "2",1);
		graph.insertEdge("1", "3",1);
		graph.insertEdge("2", "4",1);
	
	
		graph.insertEdge("5", "1",1);
		graph.insertEdge("5", "2",1);
		graph.insertEdge("5", "3",1);
		graph.insertEdge("5", "4",1);
	
		graph.insertEdge("5", "6",1);
		graph.insertEdge("5", "7",1);
		graph.insertEdge("3", "6",1);
		graph.insertEdge("4", "7",1);
		graph.insertEdge("2", "9",1);
		graph.insertEdge("9", "4",1);
		graph.insertEdge("6", "7",1);
		graph.insertEdge("6", "10",1);
		graph.insertEdge("11", "7",1);
		graph.insertEdge("9", "7",1);
		graph.insertEdge("9", "11",1);
		graph.insertEdge("10", "11",1);
		graph.insertEdge("8", "6",1);
		graph.insertEdge("8", "7",1);
		graph.insertEdge("8", "10",1);
		graph.insertEdge("8", "11",1);

		
	
        System.out.println(graph);



	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		/*
		 * //FXMLLoader fxmload = new FXMLLoader(getClass().getResource("Pane.fxml"));
		 * fxmload.setController(fibaController); Parent root=fxmload.load(); Scene
		 * scene = new Scene(root,700,500); primaryStage.setScene(scene);
		 * primaryStage.show(); primaryStage.setTitle("FIBA");
		 * primaryStage.setResizable(false);
		 * 
		 * Image icon = new Image("resources/FIBA-logo.png");
		 * primaryStage.getIcons().add(icon); fibaController.loadMenu();
		 */

	}

}
