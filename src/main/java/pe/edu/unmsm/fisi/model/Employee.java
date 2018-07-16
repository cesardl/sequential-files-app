package pe.edu.unmsm.fisi.model;

/**
 * @author Cesardl
 */
public class Employee {

    private int code;
    private String name;
    private double salary;

    public Employee() {
        code = 0;
        name = "";
        salary = 0.0;
    }

    public Employee(int code, String name, double salary) {
        this.code = code;
        this.name = name;
        this.salary = salary;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double descuentos() {
        return salary * 0.15;
    }

    public double neto() {
        return salary - descuentos();
    }
}
