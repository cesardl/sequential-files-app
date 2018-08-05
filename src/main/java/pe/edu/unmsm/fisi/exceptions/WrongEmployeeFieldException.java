/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.unmsm.fisi.exceptions;

/**
 * @author Cesardl
 */
public class WrongEmployeeFieldException extends Exception {

    private static final long serialVersionUID = -4619684837787782252L;

    private final ErrorLocation errorLocation;

    public enum ErrorLocation {
        CODE, NAME, SALARY
    }

    public WrongEmployeeFieldException(final ErrorLocation errorLocation, final String message) {
        super(message);
        this.errorLocation = errorLocation;
    }

    public ErrorLocation getErrorLocation() {
        return errorLocation;
    }
}
