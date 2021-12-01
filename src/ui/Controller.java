package ui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import model.IcesiMap;
import model.Place;

public class Controller {

    private IcesiMap icesiMap;

    @FXML
    private AnchorPane mainPane;

    @FXML
    private ComboBox<String> initPoint;

    @FXML
    private ComboBox<String> finalPoint;

    @FXML
    private ListView<String> listView;

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

        initPoint.getItems().addAll(icesiMap.getPlaces());
        finalPoint.getItems().addAll(icesiMap.getPlaces());

    }

    @FXML
    public void findBestRoute(ActionEvent event) throws IOException {

        loadRoute();

    }

    @FXML
    public void loadRoute() throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Route.fxml"));
        fxmlLoader.setController(this);
        Parent pane = fxmlLoader.load();

        mainPane.getChildren().clear();
        mainPane.getChildren().addAll(pane);

        try {

            // List view
            Place initialPlace = new Place(initPoint.getSelectionModel().getSelectedItem());
            Place finalPlace = new Place(finalPoint.getSelectionModel().getSelectedItem());
            listView.getItems().addAll(icesiMap.lowerCostPath(initialPlace, finalPlace));
        } catch (Exception e) {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("ERROR");
            alert.setHeaderText("Select a valid option");
            alert.showAndWait();
        }

    }

    @FXML
    public void changePoints(ActionEvent event) {

        String aux = initPoint.getSelectionModel().getSelectedItem();

        initPoint.getSelectionModel().select(finalPoint.getSelectionModel().getSelectedItem());

        finalPoint.getSelectionModel().select(aux);

    }

}
