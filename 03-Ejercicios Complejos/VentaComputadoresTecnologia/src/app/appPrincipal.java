
package app;

import javax.swing.JOptionPane;

public class appPrincipal {
    public static void main(String[] args) {
         Tienda tienda = new Tienda();
         
          while (true) {            
            String[] opciones = {
                "Agregar Producto",
                "Agregar Fabricante",
                "Realizar Venta",
                "Calcular Total De Ventas",
                "Salir"
            };
            String seleccion = (String)JOptionPane.showInputDialog(null, "Selecione una Opcion",
                    "Sistema de Gestion de Tienda",JOptionPane.QUESTION_MESSAGE,null,
                    opciones,opciones[0]);
            
            if (seleccion == null || seleccion.equalsIgnoreCase("Salir")) {
                break;
            }
            switch (seleccion) {
                case "Agregar Producto":
                    tienda.agregarProducto();
                    break;
                case "Agregar Fabricante":
                    tienda.agregarFabricante();
                    break;
                case "Realizar Venta":
                    tienda.realizarVentas();
                    break;
                case "Calcular Total De Ventas":
                    tienda.calcularTotalVentas();
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Cuidado!!! Opcion No valida");
                    break;
            }
        }
        JOptionPane.showMessageDialog(null, "Grcaias por utilizar nuestro Sistema de Gestion de Reserva");
    }
    
}
