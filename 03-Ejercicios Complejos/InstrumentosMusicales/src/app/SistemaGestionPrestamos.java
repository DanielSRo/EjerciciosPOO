
package app;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class SistemaGestionPrestamos {
    public ArrayList<Instrumento> listaInstrumentos;
    public ArrayList<Prestamo> listaPrestamos;

    public SistemaGestionPrestamos() {
        this.listaInstrumentos = new ArrayList<>();
        this.listaPrestamos = new ArrayList<>();
    }
 
    public ArrayList<Instrumento> getListaInstrumentos() {
        return listaInstrumentos;
    }

    public void setListaInstrumentos(ArrayList<Instrumento> listaInstrumentos) {
        this.listaInstrumentos = listaInstrumentos;
    }

    public ArrayList<Prestamo> getListaPrestamos() {
        return listaPrestamos;
    }

    public void setListaPrestamos(ArrayList<Prestamo> listaPrestamos) {
        this.listaPrestamos = listaPrestamos;
    }
    
    public String entrada(String texto){
        return JOptionPane.showInputDialog(texto);
    }
    
    
    
    public void agregarInstrumento(){
        String nombre = entrada("Nombre del Instrumento: ");
        
        for (Instrumento instrumento : listaInstrumentos) {
            if(instrumento.getNombre().equalsIgnoreCase(nombre)){
                JOptionPane.showMessageDialog(null, "¡¡¡El Instrumento ya existe");
                return;
            }
        }
        String grupo = entrada("Nombre grupo Instrumento (cuerdas, cuerdas frotadas, vientos o maderas, metales, percusión): ");
        String estado = entrada("Estado del Instrumento (nuevo, usado, en reparación): ");
        int numEjemplares = Integer.parseInt(entrada("Numero de ejemplare: "));
        
        Instrumento instrumento = new Instrumento(nombre, grupo, estado, numEjemplares);
        listaInstrumentos.add(instrumento);
        JOptionPane.showMessageDialog(null, "¡¡¡El Instrumento ha sido Agregado Exitosamente");
        
    }
    

    
    public void eliminarInstrumentoPorNombre(){
        String nombre = entrada("Ingrese el nombre del Instrumento que desea eliminar: ");
        boolean eliminado = listaInstrumentos.removeIf(Instrumento -> Instrumento.getNombre().equalsIgnoreCase(nombre));
        if(eliminado){
            JOptionPane.showMessageDialog(null, "¡¡¡Instrumento eliminado Correctamente!!!");
        }else{
            JOptionPane.showMessageDialog(null, "¡¡¡Instrumento no encontrado!!!");
        }
        
    }
    
    public void actualizarEstadoInstrumento(){
        String nombre = entrada("Ingrese el nombre del instrumento a actualizar:");
        Instrumento instrumentoActualizar = null;
        
        for (Instrumento instrumento : listaInstrumentos) {
            if (instrumento.getNombre().equalsIgnoreCase(nombre)) {
                instrumentoActualizar = instrumento;
                break;
            }
        }
        if (instrumentoActualizar != null) {
            String nuevoEstado = entrada("Ingrese el nuevo estado del Instrumento:");
            instrumentoActualizar.setEstado(nuevoEstado);
            JOptionPane.showMessageDialog(null, "¡¡¡Estado del Instrumento actualizado correctamente!!!");
        }else{
            JOptionPane.showMessageDialog(null, "¡¡¡Instrumento no encontrado!!!");
        }
        
    }
    
    public void actualizarCantidadDisponible(){
        String nombre = entrada("Ingrese el nombre del Instrumento a actualizar:");
        Instrumento instrumentoActualizar = null;
        
        for (Instrumento instrumento : listaInstrumentos) {
            if (instrumento.getNombre().equalsIgnoreCase(nombre)) {
                instrumentoActualizar = instrumento;
                break;
            }  
        }
        
        if (instrumentoActualizar != null) {
            int nuevaCantidad = Integer.parseInt(entrada("Ingrese la nueva cantidad disponible:"));
            instrumentoActualizar.setCantidadDisponible(nuevaCantidad);
            JOptionPane.showMessageDialog(null, "¡¡¡Cantidad disponible del Instrumento actualizada correctamente!!!");
        }else{
            JOptionPane.showMessageDialog(null, "¡¡¡Instrumento no encontrado!!!");
        }
        
    }
    
    public void registrarPrestamo(){
        if(listaInstrumentos.isEmpty()){
            JOptionPane.showMessageDialog(null, "¡¡¡No hay Instrumentos Disponibles");
            return;
        }
        
        String nombreInstrumento = entrada("Ingrese el nombre del Instrumento a Prestar:");
        Instrumento InstrumentoPrestado = null;
        
        for (Instrumento instrumento : listaInstrumentos) {
            if(instrumento.getNombre().equalsIgnoreCase(nombreInstrumento)){
                InstrumentoPrestado = instrumento;
                break;
            }
        }
        
        if(InstrumentoPrestado == null){
            JOptionPane.showMessageDialog(null, "¡¡¡Instrumento no encontrado!!!");
            return;
        }
        if(InstrumentoPrestado.getCantidadDisponible() <= 0){
            JOptionPane.showMessageDialog(null, "¡¡¡No hay Instrumentos Disponibles!!!");
            return;
        }
        
        String nombreMiembro = entrada("Ingrese el nombre del usuario a prestar Instrumento:");
       
        Prestamo prestamo = new Prestamo(nombreMiembro, InstrumentoPrestado);
        listaPrestamos.add(prestamo);
        InstrumentoPrestado.setCantidadDisponible(InstrumentoPrestado.getCantidadDisponible() - 1);
        
        JOptionPane.showMessageDialog(null, "¡¡¡Prestamo registrado Exitosamente!!!\nFecha de Devolucion: " + prestamo.getFechaDevolucion());
    }
    
    public void registrarDevolucion(){
        String nombreMiembro = entrada("Ingrese el nombre del miembro que devuelve el Instrumento:");
        String nombreInstrumento = entrada("Ingrese el nombre del Instrumento que se devuelve:");
        boolean encontrado = false;
        
        for (Prestamo prestamo : listaPrestamos) {
            if (prestamo.getNombreMiembro().equalsIgnoreCase(nombreMiembro) &&
                prestamo.getInstrumento().getNombre().equalsIgnoreCase(nombreInstrumento)) {
                
                listaPrestamos.remove(prestamo);
                Instrumento instrumento = prestamo.getInstrumento();
                instrumento.setCantidadDisponible(instrumento.getCantidadDisponible() + 1);
                JOptionPane.showMessageDialog(null, "¡¡¡Devolución registrada exitosamente!!!");
                encontrado = true;
                break;
                
            }
            
        }
        
        if(!encontrado){
            JOptionPane.showMessageDialog(null, "¡¡¡No se encontró el préstamo del Instrumento!!!");
        }
        
    }
    
    public void generarReporteInstrumentosDisponibles(){
        StringBuilder reporte = new StringBuilder("Reporte de Instrumentos Disponibles:\n");
        
        for (Instrumento instrumento : listaInstrumentos) {
            if(instrumento.getCantidadDisponible() > 0){
                reporte.append("Nombre: ").append(instrumento.getNombre()).append("\n");
                reporte.append("Grupo: ").append(instrumento.getGrupo()).append("\n");
                reporte.append("Cantidad Disponible: ").append(instrumento.getCantidadDisponible()).append("\n\n");
                
                
            }
        }
        
        if(reporte.toString().equals("Reporte de Instrumentos Disponibles:\n")){
            reporte.append("No hay instrumentos Disponibles.");
        }
        JOptionPane.showMessageDialog(null, reporte.toString());
    }
    
    public void generarHistorialPrestamos(){
        StringBuilder historial = new StringBuilder("Historial de Prestamos:\n");
        
        for (Prestamo prestamo : listaPrestamos) {
            historial.append("Miembro: ").append(prestamo.getNombreMiembro()).append("\n");
            historial.append("Instrumento: ").append(prestamo.getInstrumento().getNombre()).append("\n");
            historial.append("Fecha de Inicio: ").append(prestamo.getFechaInicio()).append("\n");
            historial.append("Fecha de Devolucion: ").append(prestamo.getFechaDevolucion()).append("\n\n");
        }
        if(listaPrestamos.isEmpty()){
            historial.append("No hay prestamos registrados.");
        }
        JOptionPane.showMessageDialog(null,historial.toString());
    }
    
    public void generarReporteInstrumentosNoDevueltosATiempo(){
        if(listaPrestamos.isEmpty()){
            JOptionPane.showMessageDialog(null, "¡¡¡No hay prestamos registrados!!!");
            return;
        }
        StringBuilder prestamosAtrasados = new StringBuilder("Instrumentos no devueltos a tiempo:\n");
        boolean hayAtrasos = false;
        
        for(Prestamo prestamo : listaPrestamos){
            if (prestamo.isAtrasado()) {
            prestamosAtrasados.append("Miembro de la Banda: ").append(prestamo.getNombreMiembro()).append("\n");
            prestamosAtrasados.append("Instrumento: ").append(prestamo.getInstrumento().getNombre()).append("\n");
            prestamosAtrasados.append("Fecha de Devolucion Programada: ").append(prestamo.getNombreMiembro()).append("\n");
            
            hayAtrasos = true;
            }
            
        }
        if(hayAtrasos){
            JOptionPane.showMessageDialog(null, prestamosAtrasados.toString());
        }else{
            JOptionPane.showMessageDialog(null, "¡¡¡No hay prestamos atrasados!!!");
        }
    }
    
    public void generarReporteUsoPorGrupo(){
        StringBuilder reporte = new StringBuilder("Reporte de Uso por Grupo:\n");
        
        for (Instrumento instrumento : listaInstrumentos) {
            reporte.append("Grupo: ").append(instrumento.getGrupo()).append("\n");
            reporte.append("Nombre: ").append(instrumento.getNombre()).append("\n");
            reporte.append("Cantidad disponible: ").append(instrumento.getCantidadDisponible()).append("\n");
            
        }
        
        JOptionPane.showMessageDialog(null, reporte.toString());
    }
    
}
