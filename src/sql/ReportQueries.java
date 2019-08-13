package sql;

import Classes.Report;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReportQueries {
    private static final String URL = "jdbc:mysql://remotemysql.com:3306/obsZ7jMTsl?autoReconnect=true&useSSL=false";
    private static final String USERNAME = "obsZ7jMTsl";
    private static final String PASSWORD = "U7CiN59KBE";
    
    private Connection connection;
    private PreparedStatement addEntry;
    private Statement lastMonth;
    private Statement paymentList;
    private PreparedStatement Reportlist;
     
    public ReportQueries(){
        
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            
            lastMonth = connection.createStatement();
            
            addEntry = connection.prepareStatement(
                    "INSERT INTO Report "
                    + "(idUser, Hour, Date, LM, CF, MC, CE, AP, IC, ER, Opc, Payment) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            
            paymentList = connection.createStatement();
            
        } catch (SQLException ex) {
            Logger.getLogger(ReportQueries.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public double lastMonth(String idUser){
        try {
            ResultSet rs = lastMonth.executeQuery("SELECT LM "
                    + "FROM Report WHERE idUser = " + idUser 
                    + " ORDER BY LM DESC LIMIT 0,1");
            rs.first();
            return rs.getDouble("LM");
        } catch (SQLException ex) {
            Logger.getLogger(ReportQueries.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
        
    }
    
    public int AddEntry(Report report){
        try{
            
            addEntry.setInt(1, report.getidUser());
            addEntry.setTime(2, Time.valueOf(LocalTime.now()));
            addEntry.setDate(3, Date.valueOf(LocalDate.now()));
            addEntry.setDouble(4, report.getLecturaMes());
            addEntry.setDouble(5, report.getCargoFijo());
            addEntry.setDouble(6, report.getMantConexion());
            addEntry.setDouble(7, report.getConsumoEnergia());
            addEntry.setDouble(8, report.getAlumbradoPublico());
            addEntry.setDouble(9, report.getInteresComp());
            addEntry.setDouble(10, report.getElectRural());
            addEntry.setDouble(11, report.getOpcional());
            addEntry.setDouble(12, report.getPayment());
            
            return addEntry.executeUpdate();
        }catch(SQLException sql){
            Logger.getLogger(UserQueries.class.getName()).log(Level.SEVERE, null, sql);
            return 0;
        }
    }
    
    public Report PaymentList(String username){
        try {
            ResultSet rs = paymentList.executeQuery("SELECT Username, Payment "
                    + "FROM Report, InfoUser WHERE Username = '" + username + "' ");
            rs.last();
            return new Report(rs.getString(1), rs.getDouble(2));
        } catch (SQLException ex) {
            Logger.getLogger(ReportQueries.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
//    public List<Report> ReportList(){
//        
//        
//    }
}
