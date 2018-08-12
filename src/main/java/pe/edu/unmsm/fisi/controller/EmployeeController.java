package pe.edu.unmsm.fisi.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pe.edu.unmsm.fisi.dao.EmployeeDAO;
import pe.edu.unmsm.fisi.exceptions.EmployeeAlreadyExistsException;
import pe.edu.unmsm.fisi.exceptions.EmployeeNotFoundException;
import pe.edu.unmsm.fisi.exceptions.NoDataException;
import pe.edu.unmsm.fisi.exceptions.WrongEmployeeFieldException;
import pe.edu.unmsm.fisi.model.Employee;

import java.util.List;
import java.util.stream.Collectors;

/**
 * All validation will made on controller layer
 *
 * @author Cesardl
 */
public class EmployeeController {

    private static final Logger LOG = LoggerFactory.getLogger(EmployeeController.class);

    private final EmployeeDAO dao;

    public EmployeeController(EmployeeDAO dao) {
        this.dao = dao;
    }

    private int readCode(final String s) throws WrongEmployeeFieldException {
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException nfe) {
            throw new WrongEmployeeFieldException(WrongEmployeeFieldException.ErrorLocation.CODE, "Ingrese codigo entrero", nfe);
        }
    }

    private String readName(final String s) throws WrongEmployeeFieldException {
        if (s.isEmpty()) {
            throw new WrongEmployeeFieldException(WrongEmployeeFieldException.ErrorLocation.NAME, "Ingrese nombre del empleado");
        } else {
            return s.trim();
        }
    }

    private double readSalary(final String s) throws WrongEmployeeFieldException {
        try {
            return Double.parseDouble(s);
        } catch (NumberFormatException nfe) {
            throw new WrongEmployeeFieldException(WrongEmployeeFieldException.ErrorLocation.SALARY, "Ingrese sueldo numerico", nfe);
        }
    }

    public String list() throws NoDataException {
        List<Employee> employees = dao.list();
        if (employees.isEmpty()) {
            throw new NoDataException();

        } else {
            LOG.info("Reading {} employees", employees.size());
            return employees.stream().map(employee
                    -> String.format("%-8d", employee.getCode())
                    .concat(String.format("%-30s", employee.getName()))
                    .concat(String.format("%-10.1f", employee.getSalary()))
                    .concat(String.format("%-10.1f", employee.descuentos()))
                    .concat(String.format("%-10.1f\n", employee.neto())))
                    .collect(Collectors.joining());
        }
    }

    public void save(final String textFieldCodeText, final String textFieldNameText, final String textFieldSalaryText) throws WrongEmployeeFieldException, EmployeeAlreadyExistsException {
        int code = readCode(textFieldCodeText);
        String name = readName(textFieldNameText);
        double salary = readSalary(textFieldSalaryText);

        Employee employee = dao.findEmployee(code);
        if (employee == null) {
            LOG.info("Saving employee");
            dao.insert(new Employee(code, name, salary));
        } else {
            throw new EmployeeAlreadyExistsException();
        }
    }

    public void modify(final String textFieldCodeText, final String textFieldNameText, final String textFieldSalaryText) throws WrongEmployeeFieldException, EmployeeNotFoundException {
        int code = readCode(textFieldCodeText);
        String name = readName(textFieldNameText);
        double salary = readSalary(textFieldSalaryText);

        Employee employee = dao.findEmployee(code);
        if (employee == null) {
            throw new EmployeeNotFoundException();
        } else {
            LOG.info("Modifying employee");
            dao.update(new Employee(code, name, salary));
        }
    }

    public Employee find(final String textFieldCodeText) throws WrongEmployeeFieldException, EmployeeNotFoundException {
        int code = readCode(textFieldCodeText);

        Employee employee = dao.findEmployee(code);
        if (employee == null) {
            throw new EmployeeNotFoundException();
        } else {
            return employee;
        }
    }

    public boolean delete(String textFieldCodeText) throws WrongEmployeeFieldException {
        int code = readCode(textFieldCodeText);

        return dao.delete(code);
    }

    public void persist() {
        dao.persistData();
    }
}
