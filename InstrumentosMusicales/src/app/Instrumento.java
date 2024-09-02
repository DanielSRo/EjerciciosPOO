
package app;

public class Instrumento {
    private String nombre;
    private String grupo;
    private String estado;
    private int cantidadDisponible;

    public Instrumento(String nombre, String grupo, String estado, int cantidadDisponible) {
        this.nombre = nombre;
        this.grupo = grupo;
        this.estado = estado;
        this.cantidadDisponible = cantidadDisponible;
    }
    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getCantidadDisponible() {
        return cantidadDisponible;
    }

    public void setCantidadDisponible(int cantidadDisponible) {
        this.cantidadDisponible = cantidadDisponible;
    }

    @Override
    public String toString() {
        return "Instrumento{" + "nombre=" + nombre + ", grupo=" + grupo + ", estado=" + estado + ", cantidadDisponible=" + cantidadDisponible + '}';
    }
    
    
    
    
}
