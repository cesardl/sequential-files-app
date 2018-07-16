package pe.edu.unmsm.fisi;

public class ArregloEmpleados {

    private final java.util.List<Employee> aList;

    public ArregloEmpleados() {
        aList = new java.util.ArrayList<>();
    }

    public void addEmpleado(Employee nuevo) {
        aList.add(nuevo);
    }

    public Employee getEmpleado(int posicion) {
        return aList.get(posicion);
    }

    public void setEmpleado(int posicion, Employee empleado) {
        aList.set(posicion, empleado);
    }

    public void sacaEmpleado(int posicion) {
        aList.remove(posicion);
    }

    public void sacaTodos() {
        for (int i = 0; i < numeroEmpleados(); i++) {
            aList.remove(i);
        }
    }

    public int buscaEmpleado(int codigo) {
        for (int i = 0; i < numeroEmpleados(); i++) {
            if (codigo == getEmpleado(i).getCodigo()) {
                return i;
            }
        }
        return -1;
    }

    public int numeroEmpleados() {
        return aList.size();
    }
}
