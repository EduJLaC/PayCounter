package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;

public class EntryController {
    @FXML MenuBar menuBar;
    
    Menu user = new Menu("Usuario");
    
    @FXML
    public void initialize(){
        menuBar.getMenus().add(user);
    }
}
