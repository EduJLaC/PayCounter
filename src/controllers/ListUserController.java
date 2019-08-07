package controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import sql.UserQueries;

public class ListUserController {

    @FXML private ListView<String> listView;
    public static String currentUser;

    UserQueries sql = new UserQueries();
    ObservableList<String> listUsers = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        listView.setItems(listUsers);
        listUsers.setAll(sql.getAllUsers());
    }

    private void setCurrentUser(String currentUser) {
        ListUserController.currentUser = currentUser;
    }

    @FXML
    void userSelected(ActionEvent event) {

        Stage stage = (Stage) listView.getScene().getWindow();
        setCurrentUser(listView.getSelectionModel().getSelectedItem());
        stage.close();
    }
    
    @FXML
    void cancelList(ActionEvent event){
        Stage stage = (Stage) listView.getScene().getWindow();
        stage.close();
    }

}
