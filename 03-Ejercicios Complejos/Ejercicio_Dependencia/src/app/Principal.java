
package app;

public class Principal {
    public static void main(String[] args) {
        Empleado empleado1 = new Empleado();
        Empleado empleado2 = new Empleado();
        
        Departamento departamento = new Departamento();
        departamento.agregarEmpleado(empleado1);
        departamento.agregarEmpleado(empleado2);
        departamento.mostrarEmpleados();
        
        Proyecto proyecto = new Proyecto();
        proyecto.asignarEmpleado(empleado1);
        proyecto.asignarEmpleado(empleado2);
        proyecto.mostrarEmpleadosAsignados();
        
    }
}
