package controllers;


import sql.UserQueries;
import java.io.IOException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class MainController {

    @FXML private ComboBox comboUser;

    private final UserQueries sql = new UserQueries();

    public ObservableList<String> users = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        comboUser.setOnMouseClicked((MouseEvent event) -> {
            users.removeAll(users);
            comboUser.setItems(users);
            getUsers();
        });
    }

    public void getUsers(){
        users.addAll(sql.getAllUsers());
    }
    
    @FXML
    void loginButtonPressed(ActionEvent event) throws IOException {
        
        FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("../FXMLfiles/entry.fxml"));
        Parent entryParent = (Parent)fxmlloader.load();
        Stage stage = new Stage();
        stage.setTitle("Principal");
        stage.setScene(new Scene(entryParent));
        stage.show();
    }
    
    @FXML
    void addUserButtonPressed(ActionEvent event) throws IOException {
        
        FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("../FXMLfiles/addUser.fxml"));
        Parent addUserParent = (Parent)fxmlloader.load();
        Stage stage = new Stage();
        stage.setTitle("Añadir usuario");
        stage.getIcons().add(new Image("img/icons8-add-user-male-100.png"));
        stage.setScene(new Scene(addUserParent));
        stage.show();
    }
    
    @FXML
    void deleteUserButtonPressed(ActionEvent event) throws IOException {
        
        FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("../FXMLfiles/deleteUser.fxml"));
        Parent deleteUserParent = (Parent)fxmlloader.load();
        Stage stage = new Stage();
        stage.setTitle("Eliminar usuario");
        stage.getIcons().add(new Image("img/icons8-denied-100.png"));
        stage.setScene(new Scene(deleteUserParent));
        stage.show();
    }

    private void displayAlert(
            Alert.AlertType type, String title, String message) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
