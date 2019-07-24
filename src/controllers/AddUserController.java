package controllers;

import sql.UserQueries;
import java.util.Optional;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddUserController {

    @FXML TextField nameField;
    @FXML Button closeButton;

    UserQueries sql = new UserQueries();

    @FXML
    public void Initialize() {

    }

    @FXML
    void addUserButtonPressed(ActionEvent event) {

        Optional<ButtonType> result;
        Stage stage = (Stage) nameField.getScene().getWindow();
        result = displayAlert(Alert.AlertType.CONFIRMATION,
                "Confirmación", "¿Desea agregar este usuario?");
        if (result.get() == ButtonType.OK) {
            int res = sql.AddUser(nameField.getText());
            if (res == 0) {
                displayAlert(Alert.AlertType.ERROR,
                        "Error", "Ocurrió un problema, inténtelo de nuevo.");
            }else{
                displayAlert(Alert.AlertType.INFORMATION,"Exito",
                    "Usuario agregado exitosamente");
                stage.close();
            }
            
        }

    }

    @FXML
    void cancelButtonPressed(ActionEvent event) {
        // get a handle to the stage
        Stage stage = (Stage) closeButton.getScene().getWindow();
        // do what you have to do
        stage.close();
    }

    private Optional<ButtonType> displayAlert(
            Alert.AlertType type, String title, String message) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setContentText(message);
        return alert.showAndWait();
    }
}
