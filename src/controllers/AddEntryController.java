package controllers;

import Classes.Report;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sql.ReportQueries;
import sql.UserQueries;

public class AddEntryController {
    
    @FXML TextField LMField;
    @FXML TextField CFField;
    @FXML TextField MCField;
    @FXML TextField CEField;
    @FXML TextField APField;
    @FXML TextField ICField;
    @FXML TextField ERField;
    @FXML TextField opcField;
    
    Report report;
    
    ReportQueries SQLreport = new ReportQueries();
    UserQueries sql = new UserQueries();
    
    @FXML
    public void initialize(){
        opcField.setText("0");
    }
    
    @FXML
    void addButton(ActionEvent e){
        report = new Report(Double.parseDouble(LMField.getText()),
        Double.parseDouble(CFField.getText()), 
        Double.parseDouble(MCField.getText()),
        Double.parseDouble(CEField.getText()),
        Double.parseDouble(APField.getText()),
        Double.parseDouble(ICField.getText()),
        Double.parseDouble(ERField.getText()),
        Double.parseDouble(opcField.getText()));
        
        SQLreport.AddEntry(report);
        
        Stage stage = (Stage)opcField.getScene().getWindow();
        stage.close();
    }
    
    @FXML
    void returnButton(ActionEvent e){
        System.out.println(SQLreport.lastMonth());
    }
}
