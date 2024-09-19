
package app;

import javax.swing.JOptionPane;

public class Empleado {
    private String nombre;
    private String edad;
    private double salario;
    private String puesto;

    public Empleado() {
        this.nombre = JOptionPane.showInputDialog("Ingrese el nombre del Empleado: ");
        this.edad = JOptionPane.showInputDialog("Ingrese la edad del Empleado: ");
        this.salario = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el salario del Empleado: "));
        this.puesto = JOptionPane.showInputDialog("Ingrese el puesto del Empleado: ");
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }
    
    public void asignarProyecto(Proyecto proyecto){
        JOptionPane.showMessageDialog(null,"Empleado " + this.nombre + " asignado al proyecto: " + proyecto.getNombreProyecto());
    }    
   
    
}
