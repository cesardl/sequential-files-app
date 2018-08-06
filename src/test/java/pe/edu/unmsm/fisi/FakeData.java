package pe.edu.unmsm.fisi;

import pe.edu.unmsm.fisi.model.Employee;

import java.util.ArrayList;
import java.util.List;

/**
 * Fake data for unit test for simple App.
 *
 * @author Cesardl
 */
public class FakeData {

    private static final List<Employee> employees;

    private static final Employee employee1;
    private static final Employee employee2;
    private static final Employee employee3;

    static {
        employee1 = new Employee(10001, "Georgi Facello", 85097);
        employee2 = new Employee(10002, "Bezalel Simmel", 65909);
        employee3 = new Employee(10003, "Parto Bamford", 43699);

        employees = new ArrayList<>();
        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);
    }

    public static List<Employee> getEmployees() {
        return employees;
    }

    public static Employee getEmployee1() {
        return employee1;
    }

    public static Employee getEmployee2() {
        return employee2;
    }

    public static Employee getEmployee3() {
        return employee3;
    }
}
