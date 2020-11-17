package aplicativo.moviles.evaluacion1.Ejercicio2;

public class Empleados {
    private String apellido;
    private String nombre;
    private int horasTrabajadas;
    private double suelHora;
    private String  tipoTrabajador;

    public Empleados(String apellido, String nombre, int horasTrabajadas, double suelHora, String tipoTrabajador) {
        this.apellido = apellido;
        this.nombre = nombre;
        this.horasTrabajadas = horasTrabajadas;
        this.suelHora = suelHora;
        this.tipoTrabajador = tipoTrabajador;

    }

    public String getApellido() {
        return apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public int getHorasTrabajadas() {
        return horasTrabajadas;
    }

    public double getSuelHora() {
        return suelHora;
    }

    public String getTipoTrabajador() {
        return tipoTrabajador;
    }

    public double sueldoBruto(){
        double sueldoBruto=(horasTrabajadas*suelHora);
        return sueldoBruto;
    }
    public double descontar_impuesto(){
        if (sueldoBruto()>1000){
            if (tipoTrabajador.equals("o")){
                return sueldoBruto()*0.10;
            }else{
                return sueldoBruto()*0.12;
            }
        }else{
            return 0;
        }
    }

    public double sueldo_neto(){
        double neto=sueldoBruto()-descontar_impuesto();
        return neto;
    }
}

