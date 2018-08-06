package pe.edu.unmsm.fisi.dao.impl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pe.edu.unmsm.fisi.FakeData;
import pe.edu.unmsm.fisi.dao.EmployeeDAO;
import pe.edu.unmsm.fisi.model.Employee;

import static org.junit.Assert.*;

/**
 * Created on 05/08/2018.
 *
 * @author Cesardl
 */
public class EmployeeDAOImplTest {

    private EmployeeDAO dao = EmployeeDAOImpl.getInstance();

    @Before
    public void setUp() {
        dao.insert(FakeData.getEmployee1());
        dao.insert(FakeData.getEmployee2());
        dao.insert(FakeData.getEmployee3());
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