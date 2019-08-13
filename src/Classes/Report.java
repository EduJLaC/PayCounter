package Classes;

import sql.UserQueries;

public class Report {

    private int idUser;
    private String username;
    private double lecturaMes;
    private double cargoFijo;
    private double mantConexion;
    private double consumoEnergia;
    private double alumbradoPublico;
    private double interesComp;
    private double electRural;
    private double opcional;
    private double payment;
    
    UserQueries SQLuser = new UserQueries();

    public Report(){
        
    }
    
    public Report(String user, double lecturaMes, double cargoFijo, double mantConexion,
            double consumoEnergia, double alumbradoPublico, double interesComp,
            double electRural, String opcional) {

        this.idUser = SQLuser.getId(user);
        this.lecturaMes = lecturaMes;
        this.cargoFijo = cargoFijo;
        this.mantConexion = mantConexion;
        this.consumoEnergia = consumoEnergia;
        this.alumbradoPublico = alumbradoPublico;
        this.interesComp = interesComp;
        this.electRural = electRural;
        this.opcional = sumOpc(opcional);
    }
    
    
    public Report(String username, double payment){
        this.username = username;
        this.payment = payment;
    }
    
    private double sumOpc(String entrada){
        entrada = entrada.trim();
        entrada = entrada.replaceAll(" ", "");
        String temp[] = entrada.split(",");
        double sum = 0;
        
        for (String n : temp) {
            sum = sum + Double.parseDouble(n);
        }
        
        return sum;
    }
    
    public int getidUser(){
        return idUser;
    }
    
    public String getUsername(){
        return username;
    }

    public double getLecturaMes() {
        return lecturaMes;
    }

    public double getCargoFijo() {
        return cargoFijo;
    }

    public double getMantConexion() {
        return mantConexion;
    }

    public double getConsumoEnergia() {
        return consumoEnergia;
    }

    public double getAlumbradoPublico() {
        return alumbradoPublico;
    }

    public double getInteresComp() {
        return interesComp;
    }

    public double getElectRural() {
        return electRural;
    }

    public double getOpcional() {
        return opcional;
    }
    
    public double getPayment(){
        return payment;
    }
    
    public void totalMonth(double antMes) {

        double consumo = lecturaMes - antMes;
        consumo = consumo * consumoEnergia;
        double sumaImpuestos;

        sumaImpuestos = (cargoFijo + mantConexion + alumbradoPublico
                + interesComp + electRural + opcional) / UserQueries.nUsers;

        sumaImpuestos = sumaImpuestos + consumo;
        payment = sumaImpuestos + sumaImpuestos * 0.18;
    }
}
