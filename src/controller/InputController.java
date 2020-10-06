package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.Window;
import model.DataModel;
import model.Person;
import view.ShowAlert;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class InputController {
    private DataModel dataModel;

    @FXML
    private TextField firstNameField;

    @FXML
    private TextField secondNameField;

    @FXML
    private Button addButton;

    @FXML
    private Button showAllButton;

    @FXML
    protected void handleAddButton(ActionEvent event){
        Window owner = addButton.getScene().getWindow();

        if (firstNameField.getText().isEmpty()) {
            ShowAlert.showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                    "Please enter a first name");
            return;
        }

        if(secondNameField.getText().isEmpty()) {
            ShowAlert.showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                    "Please enter a second name");
            return;
        }

        if (dataModel == null)
        {
            dataModel = new DataModel();
        }

        dataModel.addPerson(new Person(firstNameField.getText(), secondNameField.getText()));
        firstNameField.clear();
        secondNameField.clear();
    }

    @FXML
    protected void handleShowAllButton(ActionEvent event) throws IOException {
        System.out.println("showAll");
        System.out.println(dataModel.toString());

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/view/outputView.fxml"));
        Parent outputViewParent = loader.load();
        Scene outputViewScene = new Scene(outputViewParent);

        OutputController outputController = loader.getController();
        outputController.initialize(dataModel);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(outputViewScene);
    }

}

