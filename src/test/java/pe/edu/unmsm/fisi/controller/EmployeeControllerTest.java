package pe.edu.unmsm.fisi.controller;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import pe.edu.unmsm.fisi.FakeData;
import pe.edu.unmsm.fisi.dao.EmployeeDAO;
import pe.edu.unmsm.fisi.exceptions.EmployeeAlreadyExistsException;
import pe.edu.unmsm.fisi.exceptions.EmployeeNotFoundException;
import pe.edu.unmsm.fisi.exceptions.NoDataException;
import pe.edu.unmsm.fisi.exceptions.WrongEmployeeFieldException;
import pe.edu.unmsm.fisi.model.Employee;

import java.util.Collections;

import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;
import static pe.edu.unmsm.fisi.FakeData.*;

/**
 * Created on 05/08/2018.
 *
 * @author Cesardl
 */
@RunWith(MockitoJUnitRunner.class)
public class EmployeeControllerTest {

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @InjectMocks
    private EmployeeController controller;

    @Mock
    private EmployeeDAO dao;

    @Test
    public void listEmployeesTest() throws NoDataException {
        when(dao.list()).thenReturn(FakeData.getEmployees());

        String result = controller.list();
        assertFalse(result.isEmpty());
    }

    @Test(expected = NoDataException.class)
    public void emptyListEmployeesTest() throws NoDataException {
        when(dao.list()).thenReturn(Collections.emptyList());
        controller.list();

        fail();
    }

    @Test
    public void saveEmployeeTest() throws WrongEmployeeFieldException, EmployeeAlreadyExistsException {
        int code = 1000;
        when(dao.findEmployee(code)).thenReturn(null);

        controller.save(String.valueOf(code), FAKE_NAME, FAKE_SALARY);

        verify(dao, times(1)).findEmployee(anyInt());
        verify(dao, times(1)).insert(any(Employee.class));
    }

    @Test(expected = EmployeeAlreadyExistsException.class)
    public void saveEmployeeAlreadyExistsTest() throws WrongEmployeeFieldException, EmployeeAlreadyExistsException {
        int code = 1000;
        when(dao.findEmployee(code)).thenReturn(mock(Employee.class));

        controller.save(String.valueOf(code), FAKE_NAME, FAKE_SALARY);

        verify(dao, times(1)).findEmployee(anyInt());
        verifyNoMoreInteractions(dao);
    }

    @Test
    public void saveEmployeeWithWrongCodeFieldTest() throws WrongEmployeeFieldException, EmployeeAlreadyExistsException {
        exceptionRule.expect(WrongEmployeeFieldException.class);
        exceptionRule.expect(hasProperty("errorLocation", is(WrongEmployeeFieldException.ErrorLocation.CODE)));

        controller.save("A1De4", FAKE_NAME, FAKE_SALARY);

        fail();
    }

    @Test
    public void saveEmployeeWithWrongNameFieldTest() throws WrongEmployeeFieldException, EmployeeAlreadyExistsException {
        exceptionRule.expect(WrongEmployeeFieldException.class);
        exceptionRule.expect(hasProperty("errorLocation", is(WrongEmployeeFieldException.ErrorLocation.NAME)));

        controller.save(FAKE_CODE, "", FAKE_SALARY);

        fail();
    }

    @Test
    public void saveEmployeeWithWrongSalaryFieldTest() throws WrongEmployeeFieldException, EmployeeAlreadyExistsException {
        exceptionRule.expect(WrongEmployeeFieldException.class);
        exceptionRule.expect(hasProperty("errorLocation", is(WrongEmployeeFieldException.ErrorLocation.SALARY)));

        controller.save(FAKE_CODE, FAKE_NAME, "A1De4");

        fail();
    }

    @Test
    public void modifyEmployeeTest() throws WrongEmployeeFieldException, EmployeeNotFoundException {
        int code = 1000;
        when(dao.findEmployee(code)).thenReturn(mock(Employee.class));

        controller.modify(String.valueOf(code), FAKE_NAME, FAKE_SALARY);

        verify(dao, times(1)).findEmployee(anyInt());
        verify(dao, times(1)).update(any(Employee.class));
    }

    @Test(expected = EmployeeNotFoundException.class)
    public void modifyNotExistingEmployeeTest() throws WrongEmployeeFieldException, EmployeeNotFoundException {
        when(dao.findEmployee(Integer.parseInt(FAKE_CODE))).thenReturn(null);

        controller.modify(FAKE_CODE, FAKE_NAME, FAKE_SALARY);

        verify(dao, times(1)).findEmployee(anyInt());
        verifyNoMoreInteractions(dao);
    }

    @Test
    public void modifyEmployeeWithWrongCodeFieldTest() throws WrongEmployeeFieldException, EmployeeNotFoundException {
        exceptionRule.expect(WrongEmployeeFieldException.class);
        exceptionRule.expect(hasProperty("errorLocation", is(WrongEmployeeFieldException.ErrorLocation.CODE)));

        controller.modify("A1De4", FAKE_NAME, FAKE_SALARY);

        fail();
    }

    @Test
    public void modifyEmployeeWithWrongNameFieldTest() throws WrongEmployeeFieldException, EmployeeNotFoundException {
        exceptionRule.expect(WrongEmployeeFieldException.class);
        exceptionRule.expect(hasProperty("errorLocation", is(WrongEmployeeFieldException.ErrorLocation.NAME)));

        controller.modify(FAKE_CODE, "", FAKE_SALARY);

        fail();
    }

    @Test
    public void modifyEmployeeWithWrongSalaryFieldTest() throws WrongEmployeeFieldException, EmployeeNotFoundException {
        exceptionRule.expect(WrongEmployeeFieldException.class);
        exceptionRule.expect(hasProperty("errorLocation", is(WrongEmployeeFieldException.ErrorLocation.SALARY)));

        controller.modify(FAKE_CODE, FAKE_NAME, "A1De4");

        fail();
    }

    @Test
    public void findEmployeeTest() throws WrongEmployeeFieldException, EmployeeNotFoundException {
        when(dao.findEmployee(Integer.valueOf(FAKE_CODE))).thenReturn(mock(Employee.class));

        controller.find(FAKE_CODE);

        verify(dao, times(1)).findEmployee(anyInt());
        verifyNoMoreInteractions(dao);
    }

    @Test
    public void findEmployeeWithWrongCodeFieldTest() throws WrongEmployeeFieldException, EmployeeNotFoundException {
        exceptionRule.expect(WrongEmployeeFieldException.class);
        exceptionRule.expect(hasProperty("errorLocation", is(WrongEmployeeFieldException.ErrorLocation.CODE)));

        controller.find("A1De4");

        fail();
    }

    @Test(expected = EmployeeNotFoundException.class)
    public void findNotExistingEmployeeTest() throws WrongEmployeeFieldException, EmployeeNotFoundException {
        when(dao.findEmployee(Integer.parseInt(FAKE_CODE))).thenReturn(null);

        controller.find(FAKE_CODE);

        verify(dao, times(1)).findEmployee(anyInt());
        verifyNoMoreInteractions(dao);
    }

    @Test
    public void deleteEmployeeTest() throws WrongEmployeeFieldException {
        when(dao.delete(Integer.parseInt(FAKE_CODE))).thenReturn(true);

        boolean result = controller.delete(FAKE_CODE);
        assertTrue(result);
    }

    @Test
    public void deleteNotExistingEmployeeTest() throws WrongEmployeeFieldException {
        when(dao.delete(Integer.parseInt(FAKE_CODE))).thenReturn(false);

        boolean result = controller.delete(FAKE_CODE);
        assertFalse(result);
    }

    @Test
    public void deleteEmployeeWithWrongCodeFieldTest() throws WrongEmployeeFieldException {
        exceptionRule.expect(WrongEmployeeFieldException.class);
        exceptionRule.expect(hasProperty("errorLocation", is(WrongEmployeeFieldException.ErrorLocation.CODE)));

        controller.delete("A1De4");

        fail();
    }
}