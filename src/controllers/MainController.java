package controllers;

import sql.UserQueries;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainController {

    @FXML BorderPane borderPane;
    @FXML MenuBar menuBar;

    @FXML Menu userMenuBar;
    @FXML MenuItem listUsersMenu;
    @FXML MenuItem addUserMenu;
    @FXML MenuItem deleteUserMenu;
    
    @FXML Menu reportMenuBar;
    @FXML MenuItem addEntryMenu;
    @FXML MenuItem viewEntriesMenu;
    
    @FXML Menu aboutMenuBar;

    

    @FXML MenuItem listUsersItem;

    UserQueries sql = new UserQueries();

    @FXML
    public void initialize() {
        
        addMenuItems();
        menuIcons();
        loadUI("../FXMLfiles/addEntry.fxml");

        listUsersMenu.setOnAction(e->{
            try {
                FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("../FXMLfiles/listUser.fxml"));
                Parent addUserParent = (Parent) fxmlloader.load();
                Stage stage = new Stage();
                stage.setTitle("Añadir usuario");
                stage.getIcons().add(new Image("img/icons8-idea-bank-100.png"));
                stage.setScene(new Scene(addUserParent));
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        addUserMenu.setOnAction(e -> {
            try {
                FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("../FXMLfiles/addUser.fxml"));
                Parent addUserParent = (Parent) fxmlloader.load();
                Stage stage = new Stage();
                stage.setTitle("Añadir usuario");
                stage.getIcons().add(new Image("img/icons8-idea-bank-100.png"));
                stage.setScene(new Scene(addUserParent));
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        deleteUserMenu.setOnAction(e -> {
            try {
                FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("../FXMLfiles/deleteUser.fxml"));
                Parent deleteUserParent = (Parent)fxmlloader.load();
                Stage stage = new Stage();
                stage.setTitle("Eliminar usuario");
                stage.getIcons().add(new Image("img/icons8-idea-bank-100.png"));
                stage.setScene(new Scene(deleteUserParent));
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        addEntryMenu.setOnAction(e -> {
            loadUI("../FXMLfiles/addEntry.fxml");
        });
        
        viewEntriesMenu.setOnAction(e -> {
            loadUI("../FXMLfiles/viewEntries.fxml");
        });
        
    }
    
    private void addMenuItems(){
        aboutMenuBar = new Menu("Acerca De");
        menuBar.getMenus().add(aboutMenuBar);
    }
    
    private void menuIcons(){
        userMenuBar.setGraphic(new ImageView("img/icons8-male-user-48.png"));
        reportMenuBar.setGraphic(new ImageView("img/icons8-invoice-48.png"));
        aboutMenuBar.setGraphic(new ImageView("img/icons8-about-48.png"));
        
        listUsersMenu.setGraphic(new ImageView("img/icons8-add-user-group-man-man-24.png"));
        addUserMenu.setGraphic(new ImageView("img/icons8-add-user-male-24.png"));
        deleteUserMenu.setGraphic(new ImageView("img/icons8-delete-user-male-24.png"));
        
        addEntryMenu.setGraphic(new ImageView("img/icons8-add-receipt-24.png"));
        viewEntriesMenu.setGraphic(new ImageView("img/icons8-receipt-24.png"));
    }
    
    private void loadUI(String ui){
        Parent root = null;
        
        try {
            root = FXMLLoader.load(getClass().getResource(ui));
        } catch (IOException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        borderPane.setCenter(root);
          
    }
}
