package ui;

import java.io.IOException;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;
import model.IcesiMap;

public class Controller {

    private IcesiMap icesiMap;

    @FXML
    private AnchorPane mainPane;

    @FXML
    private ComboBox<String> initPoint;

    @FXML
    private ComboBox<String> finalPoint;

    public Controller(IcesiMap icesiMap) {
        this.icesiMap = icesiMap;

    }

    @FXML
    public void loadMenu() throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Menu.fxml"));
        fxmlLoader.setController(this);
        Parent pane = fxmlLoader.load();

        mainPane.getChildren().clear();
        mainPane.getChildren().addAll(pane);

        initPoint.getItems().addAll("Points", "Rebounds", "Assists", "Robberies", "Blocks");
        finalPoint.getItems().addAll("Points", "Rebounds", "Assists", "Robberies", "Blocks");

    }

    @FXML
    public void findBestRoute(Event event) throws IOException {

            loadRoute();
        

    }

    @FXML
	public void loadRoute() throws IOException {

		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Route.fxml"));
		fxmlLoader.setController(this);
		Parent pane = fxmlLoader.load();
        
		mainPane.getChildren().clear();
		mainPane.getChildren().addAll(pane);

        //List view


	}

}
