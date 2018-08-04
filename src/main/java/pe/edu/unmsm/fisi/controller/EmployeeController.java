package pe.edu.unmsm.fisi.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pe.edu.unmsm.fisi.dao.EmployeeDAO;
import pe.edu.unmsm.fisi.exceptions.WrongEmployeeFieldException;
import pe.edu.unmsm.fisi.model.Employee;

/**
 * All validation will made on controller layer
 *
 * @author Cesardl
 */
public class EmployeeController {

    private static final Logger LOG = LoggerFactory.getLogger(EmployeeController.class);

    private final EmployeeDAO dao = EmployeeDAO.getInstance();

    private int leerCodigo(final String s) {
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException nfe) {
            return -666;
        }
    }

    private String leerNombre(final String s) {
        try {
            if (s.charAt(0) == ' ') {
                return s.trim();
            }
            return s;
        } catch (Exception e) {
            return null;
        }
    }

    private double leerSueldo(final String s) {
        try {
            return Double.parseDouble(s);
        } catch (NumberFormatException nfe) {
            return -666;
        }
    }

    public void saveOrModify(final String textFieldCodeText, final String textFieldNameText, final String textFieldSalaryText) throws WrongEmployeeFieldException {
        int code = leerCodigo(textFieldCodeText);
        String name = leerNombre(textFieldNameText);
        double salary = leerSueldo(textFieldSalaryText);

        if (code == -666) {
            throw new WrongEmployeeFieldException(WrongEmployeeFieldException.ErrorLocation.CODE, "Ingrese codigo entrero");

        } else if (name == null) {
            throw new WrongEmployeeFieldException(WrongEmployeeFieldException.ErrorLocation.NAME, "Ingrese nombre del empleado");

        } else if (salary == -666) {
            throw new WrongEmployeeFieldException(WrongEmployeeFieldException.ErrorLocation.SALARY, "Ingrese sueldo numerico");

        } else {
            Employee employee = dao.findEmployee(code);
            if (employee == null) {
                LOG.info("Saving employee");
                dao.insert(new Employee(code, name, salary));
            } else {
                LOG.info("Modifying employee");
                dao.update(new Employee(code, name, salary));
            }
        }
    }

    public Employee find(final String code) {
        return null;
    }
}
