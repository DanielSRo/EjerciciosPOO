
package app;

import javax.swing.JOptionPane;

public class appRegistro {
    public static void main(String[] args) {
        SistemaGestionPrestamos registro = new SistemaGestionPrestamos();
        
        byte opcion;
        do{
            opcion = Byte.parseByte(JOptionPane.showInputDialog(
                    """
                    Menu Principal
                    1.Agregar Instruemento
                    2.Eliminar Instrumento Por Nombre
                    3.Actualizar estado Instrumento
                    4.Actializar Cantidad Disponible
                    5.Registrar Prestamos
                    6.Registrar La Devolucion
                    7.Generar Reporte Instrumentos Disponibles
                    8.Historial prestamos
                    9.Reporte de instrumentos no devueltos a tiempo
                    10.Generer Reporte de Instrumentos de uno Por Grupo
                    11.Salir
                    """));
            
            switch (opcion) {
                case 1:
                    registro.agregarInstrumento();
                    break;
                case 2:
                    registro.eliminarInstrumentoPorNombre();
                    break;    
                case 3:
                    registro.actualizarEstadoInstrumento();
                    break;
                case 4:
                    registro.actualizarCantidadDisponible();
                    break;
                case 5:
                    registro.registrarPrestamo();
                    break;    
                case 6:
                    registro.registrarDevolucion();
                case 7:
                    registro.generarReporteInstrumentosDisponibles();
                    break;
                case 8:
                    registro.generarHistorialPrestamos();
                    break;    
                case 9:
                    registro.generarReporteInstrumentosNoDevueltosATiempo();
                    break;
                case 10:
                    registro.generarReporteUsoPorGrupo();
                    break;
                case 11:
                    JOptionPane.showMessageDialog(null, "¡¡¡Gracias por utilizar el sistema!!!");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "¡¡¡Opcion NO valida!!!");
            }
        }
        while (opcion != 11);
    }
    
}
