
package app;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Departamento {
    private String nombreDepartamento;
    private String Ubicacion;
    private final ArrayList<Empleado> empleados;

    public Departamento() {
        this.nombreDepartamento = JOptionPane.showInputDialog("Ingrese el nombre del Departamento: ");
        this.Ubicacion = JOptionPane.showInputDialog("Ingrese la ubicacion del departamento: ");
        this.empleados = new ArrayList<>();
    }

    public String getNombreDepartamento() {
        return nombreDepartamento;
    }

    public void setNombreDepartamento(String nombreDepartamento) {
        this.nombreDepartamento = nombreDepartamento;
    }

    public String getUbicacion() {
        return Ubicacion;
    }

    public void setUbicacion(String Ubicacion) {
        this.Ubicacion = Ubicacion;
    }

    
    public void agregarEmpleado(Empleado empleado){
        empleados.add(empleado);
        JOptionPane.showMessageDialog(null, "Empleado " + empleado.getNombre() + " agregar al departamento: " + this.nombreDepartamento);
    }
    
    public void mostrarEmpleados(){
        StringBuilder mostrar = new StringBuilder("Empleados en el departamento " + this.nombreDepartamento + ":\n");
        for(Empleado empleado : empleados){
            mostrar.append(empleado.getNombre()).append("\n");
        }
        JOptionPane.showMessageDialog(null, mostrar.toString());
    }
    
    
}
