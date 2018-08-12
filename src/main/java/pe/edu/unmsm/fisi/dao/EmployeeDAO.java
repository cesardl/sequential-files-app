package pe.edu.unmsm.fisi.dao;

import pe.edu.unmsm.fisi.model.Employee;

import java.util.List;

/**
 * @author Cesardl
 */
public interface EmployeeDAO {

    boolean loadData();

    void persistData();

    List<Employee> list();

    Employee findEmployee(int code);

    boolean insert(Employee employee);

    boolean update(Employee employee);

    boolean delete(int code);
}
