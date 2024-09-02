
package app;

import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

public class Proyecto {
    private String nombreProyecto;
    private double presupuesto;
    private String fechaInicio;
    private String fechaFin;
    private ArrayList<Empleado> empleadoAsignados;

    public Proyecto() {
        this.nombreProyecto = JOptionPane.showInputDialog("Ingrese nombre del proyecto: ");
        this.presupuesto = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el presupuesto del proyecto: "));
        this.fechaInicio = JOptionPane.showInputDialog("Ingrese la fecha de Inicio del proyecto: ");
        this.fechaFin = JOptionPane.showInputDialog("Ingrese la fecha de Fin del proyecto: ");
        this.empleadoAsignados = new ArrayList<>();
    }

    public String getNombreProyecto() {
        return nombreProyecto;
    }

    public void setNombreProyecto(String nombreProyecto) {
        this.nombreProyecto = nombreProyecto;
    }

    public double getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(double presupuesto) {
        this.presupuesto = presupuesto;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }


    
    public void asignarEmpleado(Empleado empleado){
        empleadoAsignados.add(empleado);
        JOptionPane.showMessageDialog(null, "Empleado " + empleado.getNombre() + " asignado al proyecto: " + this.nombreProyecto);
    }
    
    public void mostrarEmpleadosAsignados(){
        StringBuilder listaEmpleados = new StringBuilder("Empleados asignados a el proyecto " + this.nombreProyecto + ":\n");
        for(Empleado empleado : empleadoAsignados){
            listaEmpleados.append(empleado.getNombre()).append("\n");
        }
        JOptionPane.showMessageDialog(null, listaEmpleados.toString());
    }
    
    
}
