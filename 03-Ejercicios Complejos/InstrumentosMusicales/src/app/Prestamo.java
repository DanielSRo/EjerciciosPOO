
package app;

import java.time.LocalDate;

public class Prestamo {
    private Instrumento instrumento;
    private String nombreMiembro;
    private LocalDate fechaInicio;
    private LocalDate fechaDevolucion;

    public Prestamo(String nombreMiembro, Instrumento instrumento) {
        this.instrumento = instrumento;
        this.nombreMiembro = nombreMiembro;
        this.fechaInicio = LocalDate.now();
        this.fechaDevolucion = fechaInicio.plusWeeks(1);
    }

    public Instrumento getInstrumento() {
        return instrumento;
    }

    public void setInstrumento(Instrumento instrumento) {
        this.instrumento = instrumento;
    }

    public String getNombreMiembro() {
        return nombreMiembro;
    }

    public void setNombreMiembro(String nombreMiembro) {
        this.nombreMiembro = nombreMiembro;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(LocalDate fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }


    public boolean isAtrasado(){
        return LocalDate.now().isAfter(fechaDevolucion);
    }
    
}
