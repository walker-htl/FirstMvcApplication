package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import model.DataModel;
import model.Person;

import java.io.IOException;

public class OutputController {
    private DataModel dataModel;

    public OutputController() {
    }

    public void initialize(DataModel dataModel) {
        this.dataModel = dataModel;

        ObservableList<String> items = FXCollections.observableArrayList();

        for (Person person:dataModel.getList()){
            items.add(person.getFirstName() + " - " + person.getLastName());
        }

        listView.setItems(items);
    }

    @FXML
    private Button backButton;

    @FXML
    private ListView<String> listView;

    @FXML
    protected void handleBackButton(ActionEvent event) throws IOException {
        Parent inputViewParent = FXMLLoader.load(getClass().getResource("/view/inputView.fxml"));
        Scene inputViewScene = new Scene(inputViewParent);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(inputViewScene);
        window.show();
    }
}
