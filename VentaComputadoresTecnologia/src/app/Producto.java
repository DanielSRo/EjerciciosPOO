
package app;

import java.util.List;
import java.util.Objects;

public class Producto {
    private String nombreProducto;
    private String codigo;
    private String tipo;
    private double precio;
    private List<Fabricante> fabricantes;

    public Producto(String nombreProducto, String codigo, String tipo, double precio,List<Fabricante> fabricantes) {
        this.nombreProducto = nombreProducto;
        this.codigo = codigo;
        this.tipo = tipo;
        this.precio = precio;
        this.fabricantes = fabricantes;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public List<Fabricante> getListaFabricantes() {
        return fabricantes;
    }

    public void setListaFabricantes(List<Fabricante> fabricantes) {
        this.fabricantes = fabricantes;
    }
    
    

    @Override
    public int hashCode() {
       return Objects.hash(codigo);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Producto other = (Producto) obj;
        return Objects.equals(this.codigo, other.codigo);
    }

    @Override
    public String toString() {
        return """
               Producto: 
               Producto: """+nombreProducto + "\n"
            + "Codigo: " + codigo + "\n"
            + "tipo: " + tipo + "\n"
            + "Precio: " + precio + "\n"
            + "Fabricante: " + fabricantes + "\n";
    }
    
}
