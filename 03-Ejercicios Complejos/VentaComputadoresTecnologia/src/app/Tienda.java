
package app;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

public class Tienda {
    public List<Producto> productos;
    public List<Fabricante> fabricantes;
    public List<Venta> ventas;

    public Tienda() {
        this.productos = new ArrayList<>();
        this.fabricantes = new ArrayList<>();
        this.ventas = new ArrayList<>();
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public List<Fabricante> getFabricantes() {
        return fabricantes;
    }

    public void setFabricantes(List<Fabricante> fabricantes) {
        this.fabricantes = fabricantes;
    }

    public List<Venta> getVentas() {
        return ventas;
    }

    public void setVentas(List<Venta> ventas) {
        this.ventas = ventas;
    }
    
    private Fabricante buscarFabricante(String nombreFabriante){
        for (Fabricante fabricante : fabricantes) {
            if (fabricante.getNombre().equalsIgnoreCase(nombreFabriante)) {
                return fabricante;
            }
            
        }
        return null;
    }

    public void agregarProducto(){
        String nombreProducto = JOptionPane.showInputDialog("Ingrese el nombre del Producto: ");
    String codigo = JOptionPane.showInputDialog("Ingrese el Código del Producto: ");
    String tipo = JOptionPane.showInputDialog("Ingrese el Tipo del Producto: ");
    double precio = Double.parseDouble(JOptionPane.showInputDialog("Ingrese Precio del Producto: "));

    // Lista para almacenar los fabricantes asociados al producto
    List<Fabricante> fabricantesProducto = new ArrayList<>();
    Producto producto = new Producto(nombreProducto, codigo, tipo, precio, fabricantes);
    productos.add(producto);

    while (true) {
        // Solicita el nombre del fabricante
        String nombreFabricante = JOptionPane.showInputDialog("Ingrese el nombre del Fabricante (o presione cancelar para finalizar): ");
        
        // Si se cancela o se deja en blanco, se rompe el ciclo
        if (nombreFabricante == null || nombreFabricante.isEmpty()) {
            break;
        }

        // Busca el fabricante en la lista de fabricantes ya agregados
        Fabricante fabricante = buscarFabricante(nombreFabricante);
        
        // Si se encuentra, se agrega a la lista del producto
        if (fabricante != null) {
            fabricantesProducto.add(fabricante);
            break;
        } else {
            // Si no se encuentra, muestra un mensaje de error
            JOptionPane.showMessageDialog(null, "Fabricante no encontrado.");
            }
        }
    }
 
    
    public void agregarFabricante(){
        String nombreF = JOptionPane.showInputDialog("Ingrese el nombre del Fabricante: ");
        String paisF = JOptionPane.showInputDialog("Ingrese el país: ");
        int aFundacion = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el año de la fundación (AAAA): "));

        Fabricante fabricante = new Fabricante(nombreF, paisF, aFundacion);

        fabricantes.add(fabricante);
        JOptionPane.showMessageDialog(null, "¡¡¡Fabricante Agregado Exitosamente!!!");
    }
    
    private Producto buscarProducto(String codigo){
        
        for(Producto producto : productos){
        if (producto.getCodigo().equals(codigo)) {
            return producto;
            }
        }
       
        return null;
    }
    
    public void realizarVentas(){
        String codigo = JOptionPane.showInputDialog("Ingrese el codigo del Producto a comprar:");
        Producto producto = buscarProducto(codigo);

        if (producto != null) {
            int cantidadP = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad: "));
            LocalDate fecha = LocalDate.parse(JOptionPane.showInputDialog("Ingrese la fecha: "));
            Venta venta = new Venta(producto, cantidadP, fecha);
            ventas.add(venta);
            JOptionPane.showMessageDialog(null, "¡¡¡Venta Realizada Exitosamente!!!");
            JOptionPane.showMessageDialog(null, venta.toString());
        } else {
            JOptionPane.showMessageDialog(null, "Producto no encontrado.");
        }
    }
    
    public void calcularTotalVentas(){
       LocalDate fechaInicio = LocalDate.parse(JOptionPane.showInputDialog("Ingrese la fecha inicial (AAAA-MM-DD): "));
       LocalDate fechaFinal = LocalDate.parse(JOptionPane.showInputDialog("Ingrese la fecha finaL (AAAA-MM-DD):"));
        
        double totalVentas =  0.0;
        
        try {
            
            for (Venta venta : ventas) {
            LocalDate fechaVenta = venta.getFecha();
            if ((fechaVenta.isEqual(fechaInicio) || fechaVenta.isAfter(fechaInicio)) &&
            (fechaVenta.isEqual(fechaFinal) || fechaVenta.isBefore(fechaFinal))) { 
                totalVentas += venta.getTotal();
            }
        }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Formato de fecha incorrecto. Use el formato dd/MM/yyyy." + e.getMessage());
        }
        
        JOptionPane.showMessageDialog(null, "Total de ventas entre " + fechaInicio + "y" + fechaFinal + "es" + totalVentas);
        
    }
    
}
