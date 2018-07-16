package pe.edu.unmsm.fisi;

public class Employee {

    private int codigo;
    private String nombre;
    private double sueldo;

    public Employee() {
        codigo = 0;
        nombre = "";
        sueldo = 0.0;
    }

    public Employee(int codigo, String nombre, double sueldo) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.sueldo = sueldo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public double descuentos() {
        return sueldo * 0.15;
    }

    public double neto() {
        return sueldo - descuentos();
    }
}
