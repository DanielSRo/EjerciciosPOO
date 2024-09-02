
package app;


import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

public class Venta {
    private Producto producto;
    private int cantidad;
    private LocalDate fecha;
    private double total;

    public Venta(Producto producto, int cantidad, LocalDate fecha) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.fecha = fecha;
        this.total = producto.getPrecio() * cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
        this.total = this.producto.getPrecio() * this.cantidad;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
        this.total = this.producto.getPrecio() * this.cantidad;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
    public double getTotal() {
        return total;
    }


    @Override
    public int hashCode() {
        return Objects.hash(producto,cantidad,fecha,total);
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
        final Venta other = (Venta) obj;
        if (this.cantidad != other.cantidad) {
            return false;
        }
        if (Double.doubleToLongBits(this.total) != Double.doubleToLongBits(other.total)) {
            return false;
        }
        if (!Objects.equals(this.producto, other.producto)) {
            return false;
        }
        return Objects.equals(this.fecha, other.fecha);
    }

    @Override
    public String toString() {
        return """
               Venta: 
               Producto: """+producto + "\n"
            + "Cantidad: " + cantidad + "\n"
            + "Fecha: " + fecha + "\n"
            + "Total: " + total + "\n";
    }
    
    
    
    
}
