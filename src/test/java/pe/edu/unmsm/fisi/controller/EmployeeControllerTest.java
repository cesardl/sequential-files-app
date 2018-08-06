package pe.edu.unmsm.fisi.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import pe.edu.unmsm.fisi.FakeData;
import pe.edu.unmsm.fisi.dao.EmployeeDAO;
import pe.edu.unmsm.fisi.exceptions.EmployeeAlreadyExistsException;
import pe.edu.unmsm.fisi.exceptions.NoDataException;
import pe.edu.unmsm.fisi.exceptions.WrongEmployeeFieldException;
import pe.edu.unmsm.fisi.model.Employee;

import java.util.Collections;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

/**
 * Created on 05/08/2018.
 *
 * @author Cesardl
 */
@RunWith(MockitoJUnitRunner.class)
public class EmployeeControllerTest {

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

        controller.save(String.valueOf(code), "Fake Name", "12312.21");

        verify(dao, times(1)).findEmployee(anyInt());
        verify(dao, times(1)).insert(any(Employee.class));
    }

    @Test(expected = EmployeeAlreadyExistsException.class)
    public void saveEmployeeAlreadyExistsTest() throws WrongEmployeeFieldException, EmployeeAlreadyExistsException {
        int code = 1000;
        when(dao.findEmployee(code)).thenReturn(mock(Employee.class));

        controller.save(String.valueOf(code), "Fake Name", "12312.21");

        verify(dao, times(1)).findEmployee(anyInt());
        verifyNoMoreInteractions(dao);
    }
}