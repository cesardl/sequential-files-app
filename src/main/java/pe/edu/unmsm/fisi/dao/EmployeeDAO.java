package pe.edu.unmsm.fisi.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pe.edu.unmsm.fisi.model.Employee;

/**
 * We will assume that the data is correct, only manage and persist entities.
 *
 * @author Cesardl
 */
public class EmployeeDAO {

    private static final Logger LOG = LoggerFactory.getLogger(EmployeeDAO.class);

    private static final EmployeeDAO INSTANCE = new EmployeeDAO();

    private final java.util.List<Employee> employees;

    private EmployeeDAO() {
        employees = new java.util.ArrayList<>();
    }

    public static EmployeeDAO getInstance() {
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

                employees.add(employee);
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
            for (int i = 0; i < employees.size(); i++) {
                Employee employee = employees.get(i);

                LOG.info("{}.- Code: {}", i + 1, employee.getCode());
                bw.write(String.valueOf(employee.getCode() + ","
                        + employee.getName() + ","
                        + String.valueOf(employee.getSalary()) + ","
                        + employee.descuentos() + "," + employee.neto()) + "\n");
            }
        } catch (java.io.IOException e) {
            LOG.error(e.getMessage(), e);
        }
    }

    public java.util.List<Employee> list() {
        return employees;
    }

    public Employee findEmployee(final int code) {
        return employees.stream()
                .filter(e -> code == e.getCode())
                .findAny()
                .orElse(null);
    }

    public boolean insert(final Employee employee) {
        return employees.add(employee);
    }

    public boolean update(final Employee employee) {
        Employee peek = employees.stream()
                .filter(e -> employee.getCode() == e.getCode())
                .peek(e -> {
                    e.setCode(employee.getCode());
                    e.setName(employee.getName());
                    e.setSalary(employee.getSalary());
                })
                .findAny()
                .orElse(null);
        return peek != null;
    }
}
