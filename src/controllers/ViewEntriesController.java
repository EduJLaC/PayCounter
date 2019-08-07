package controllers;

import Classes.Report;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class ViewEntriesController {

    @FXML TableView tableView;

    public void initialize() {

        Table();
    }
    
    private void Table(){
        TableColumn<String, Report> c1 = new TableColumn("Hora");

        TableColumn<String, Report> c2 = new TableColumn("Fecha");

        TableColumn<String, Report> c3 = new TableColumn("Lectura");

        TableColumn<String, Report> c4 = new TableColumn("Total a pagar");

        tableView.getColumns().add(c1);
        tableView.getColumns().add(c2);
        tableView.getColumns().add(c3);
        tableView.getColumns().add(c4);
        
        c1.prefWidthProperty().bind(tableView.widthProperty().multiply(0.25));
        c2.prefWidthProperty().bind(tableView.widthProperty().multiply(0.25));
        c3.prefWidthProperty().bind(tableView.widthProperty().multiply(0.25));
        c4.prefWidthProperty().bind(tableView.widthProperty().multiply(0.25));
        
        c1.setResizable(false);
        c2.setResizable(false);
        c3.setResizable(false);
        c4.setResizable(false);
    }
}
