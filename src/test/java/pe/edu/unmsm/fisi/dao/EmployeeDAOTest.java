package pe.edu.unmsm.fisi.dao;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pe.edu.unmsm.fisi.model.Employee;

import static org.junit.Assert.*;

/**
 * Created on 04/08/2018.
 *
 * @author Cesardl
 */
public class EmployeeDAOTest {

    private EmployeeDAO dao = EmployeeDAO.getInstance();

    @Before
    public void setUp() {
        dao.insert(new Employee(10001, "Georgi Facello", 85097));
        dao.insert(new Employee(10002, "Bezalel Simmel", 65909));
        dao.insert(new Employee(10003, "Parto Bamford", 43699));
    }

    @Test
    public void insertEmployeeTest() {
        Employee employee = new Employee(10004, "Chirstian Koblick", 42283);

        boolean result = dao.insert(employee);
        assertTrue(result);
        assertEquals(4, dao.list().size());
    }

    @Test
    public void updateEmployeeTest() {
        Employee e = new Employee(10002, "Bezalel Simmel", 67534);

        boolean result = dao.update(e);
        assertTrue(result);
        assertEquals(3, dao.list().size());

        Employee employee = dao.findEmployee(e.getCode());
        assertEquals(e.getCode(), employee.getCode());
        assertEquals(e.getName(), employee.getName());
        assertEquals(e.getSalary(), employee.getSalary(), 0);
    }

    @Test
    public void updateNotRegisteredEmployeeTest() {
        Employee e = new Employee(10005, "Kyoichi Maliniak", 82621);

        boolean result = dao.update(e);
        assertFalse(result);
        assertEquals(3, dao.list().size());

        Employee employee = dao.findEmployee(e.getCode());
        assertNull(employee);
    }

    @After
    public void setDown() {
        dao.list().clear();
    }
}
