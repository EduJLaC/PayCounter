package controllers;

import Classes.Report;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import sql.ReportQueries;
import sql.UserQueries;

public class AddEntryController {

    @FXML ComboBox comboUser;
    @FXML TextField LMField;
    @FXML TextField CFField;
    @FXML TextField MCField;
    @FXML TextField CEField;
    @FXML TextField APField;
    @FXML TextField ICField;
    @FXML TextField ERField;
    @FXML TextField opcField;

    Report report;
    UserQueries SQLuser = new UserQueries();
    ReportQueries SQLreport = new ReportQueries();
    ObservableList<String> users = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        opcField.setText("0");
        comboUser.setPromptText("Usuario");
        comboUser.setVisibleRowCount(4);
        comboUser.setOnMouseClicked((MouseEvent event) -> {
            users.removeAll(users);
            comboUser.setItems(users);
            users.addAll(SQLuser.getAllUsers());
        });
    }

    @FXML
    void addButton(ActionEvent e) {
        report = new Report(
                comboUser.getSelectionModel().getSelectedItem().toString(),
                Double.parseDouble(LMField.getText()),
                Double.parseDouble(CFField.getText()),
                Double.parseDouble(MCField.getText()),
                Double.parseDouble(CEField.getText()),
                Double.parseDouble(APField.getText()),
                Double.parseDouble(ICField.getText()),
                Double.parseDouble(ERField.getText()),
                opcField.getText());
        
        report.totalMonth(SQLreport.lastMonth(String.valueOf(report.getidUser())));

        SQLreport.AddEntry(report);  
        ListPaymentController.data.add(
                SQLreport.PaymentList(
                        comboUser.getSelectionModel().
                                getSelectedItem().toString()));
        
    }

    @FXML
    void showButton(ActionEvent e) {
        try {

            FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("../FXMLfiles/listPayment.fxml"));
            Parent listPaymentParent = (Parent) fxmlloader.load();
            Stage stage = new Stage();
            stage.setTitle("Lista de pagos");
            stage.getIcons().add(new Image("img/icons8-idea-bank-100.png"));
            stage.setScene(new Scene(listPaymentParent));
            stage.show();

        } catch (IOException ex) {
            Logger.getLogger(AddEntryController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
