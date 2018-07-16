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

    public boolean loadData() {
        try (java.io.FileReader fr = new java.io.FileReader("employees.txt");
             java.io.BufferedReader br = new java.io.BufferedReader(fr)) {
            String linea;
            while ((linea = br.readLine()) != null) {
                java.util.StringTokenizer st = new java.util.StringTokenizer(linea, ",");
                Employee employee = new Employee();
                employee.setCode(Integer.parseInt(st.nextToken()));
                employee.setName(st.nextToken());
                employee.setSalary(Double.parseDouble(st.nextToken()));
                addEmployee(employee);
            }
            return true;
        } catch (java.io.IOException | NumberFormatException e) {
            LOG.error(e.getMessage(), e);
            return false;
        }
    }

    public void persistData() {
        try (java.io.FileWriter fw = new java.io.FileWriter("employees.txt");
             java.io.BufferedWriter bw = new java.io.BufferedWriter(fw)) {
            for (int i = 0; i < totalOfEmployees(); i++) {
                Employee employee = getEmployee(i);
                LOG.info("{}.- Code: {}", i, employee.getCode());
                bw.write(String.valueOf(employee.getCode() + ","
                        + employee.getName() + ","
                        + String.valueOf(employee.getSalary()) + ","
                        + employee.descuentos() + "," + employee.neto()) + "\n");
            }
        } catch (java.io.IOException e) {
            LOG.error(e.getMessage(), e);
        }
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
