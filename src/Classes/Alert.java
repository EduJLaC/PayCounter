
package Classes;

import java.util.Optional;
import javafx.scene.control.ButtonType;

public class Alert {
    public static Optional<ButtonType> displayAlert(
            javafx.scene.control.Alert.AlertType type, String title, String message) {
        javafx.scene.control.Alert alert = new javafx.scene.control.Alert(type);
        alert.setTitle(title);
        alert.setContentText(message);
        return alert.showAndWait();
    }
}
