package pe.edu.unmsm.fisi.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pe.edu.unmsm.fisi.model.Employee;

public class EmployeeController {

    private static final Logger LOG = LoggerFactory.getLogger(EmployeeController.class);

    private static final EmployeeController INSTANCE = new EmployeeController();

    private final java.util.List<Employee> employees;

    private EmployeeController() {
        employees = new java.util.ArrayList<>();
    }

    public static EmployeeController getInstance() {
        return INSTANCE;
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public Employee getEmployee(int index) {
        return employees.get(index);
    }

    public void setEmployee(int index, Employee employee) {
        employees.set(index, employee);
    }

    public void removeEmployee(int index) {
        employees.remove(index);
    }

    public void removeAll() {
        for (int i = 0; i < totalOfEmployees(); i++) {
            employees.remove(i);
        }
    }

    public int findEmployee(final int code) {
        for (int i = 0; i < totalOfEmployees(); i++) {
            if (code == getEmployee(i).getCode()) {
                return i;
            }
        }
        return -1;
    }

    public int totalOfEmployees() {
        return employees.size();
    }
}
