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

public class DeleteUserController {

    @FXML private TextField nameField;
    @FXML private Button closeButton;

    UserQueries sql = new UserQueries();

    @FXML
    void deleteUserButtonPressed(ActionEvent event) {

        Optional<ButtonType> result;
        result = displayAlert(Alert.AlertType.CONFIRMATION,
                "Confirmación", "¿Desea eliminar este usuario?");
        Stage stage = (Stage) nameField.getScene().getWindow();

        if (result.get() == ButtonType.OK) {
            int res = sql.DeleteUser(nameField.getText());
            if (res == 0) {
                displayAlert(Alert.AlertType.ERROR,
                        "Error", "Ocurrió un problema, inténtelo de nuevo.");
            }else{
                displayAlert(Alert.AlertType.INFORMATION,"Exito",
                    "Usuario eliminado exitosamente");
                stage.close();
            }
        }
    }

    @FXML
    void cancelButtonPressed(ActionEvent event) {
        Stage stage = (Stage) closeButton.getScene().getWindow();
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
