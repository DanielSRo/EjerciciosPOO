public class Ejercicio_10 {
    class Evento {
        private String nombre;
        private String fecha;
        private String lugar;
        private int asistentes;

        public Evento(String nombre, String fecha, String lugar, int asistentes) {
            this.nombre = nombre;
            this.fecha = fecha;
            this.lugar = lugar;
            this.asistentes = asistentes;
        }

        public void imprimirValores() {
            System.out.println("Nombre: " + nombre);
            System.out.println("Fecha: " + fecha);
            System.out.println("Lugar: " + lugar);
            System.out.println("Asistentes: " + asistentes);
        }
    }
}
