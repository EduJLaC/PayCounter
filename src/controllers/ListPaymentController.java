package controllers;

import Classes.Report;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ListPaymentController {
    
    @FXML TableView tableView;
    public static ObservableList<Report> data = FXCollections.observableArrayList();
    
    public void initialize(){
        TableColumn<String, Report> usernameC = new TableColumn<>("Nombre del usuario");
        usernameC.setCellValueFactory(new PropertyValueFactory<>("username"));
        usernameC.prefWidthProperty().bind(tableView.widthProperty().multiply(0.50));
        
        TableColumn<Double, Report> paymentC = new TableColumn<>("Monto a pagar");
        paymentC.setCellValueFactory(new PropertyValueFactory<>("payment"));
        paymentC.prefWidthProperty().bind(tableView.widthProperty().multiply(0.50));
    
        tableView.getColumns().addAll(usernameC, paymentC);
        tableView.setItems(data);
    }
}
