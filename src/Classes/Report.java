package Classes;

public class Report {

    private final double lecturaMes;
    private final double cargoFijo;
    private final double mantConexion;
    private final double consumoEnergia;
    private final double alumbradoPublico;
    private final double interesComp;
    private final double electRural;
    private final double opcional;

    public Report(double lecturaMes, double cargoFijo, double mantConexion,
            double consumoEnergia, double alumbradoPublico, double interesComp,
            double electRural, double opcional) {

        this.lecturaMes = lecturaMes;
        this.cargoFijo = cargoFijo;
        this.mantConexion = mantConexion;
        this.consumoEnergia = consumoEnergia;
        this.alumbradoPublico = alumbradoPublico;
        this.interesComp = interesComp;
        this.electRural = electRural;
        this.opcional = opcional;
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

    public double totalMonth(double antMes) {

        double consumo = lecturaMes - antMes;
        consumo = consumo * consumoEnergia;
        double sumaImpuestos;
        double total;

        sumaImpuestos = (cargoFijo + mantConexion + alumbradoPublico
                + interesComp + electRural + opcional) / 5;

        sumaImpuestos = sumaImpuestos + consumo;
        total = sumaImpuestos + sumaImpuestos * 0.18;
        return total;
    }
}
