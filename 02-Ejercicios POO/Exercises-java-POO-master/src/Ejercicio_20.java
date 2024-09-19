public class Ejercicio_20 {
    static class Hotel {
        private String nombre;
        private String direccion;
        private int numeroHabitaciones;
        private int estrellas;

        public Hotel(String nombre, String direccion, int numeroHabitaciones, int estrellas) {
            this.nombre = nombre;
            this.direccion = direccion;
            this.numeroHabitaciones = numeroHabitaciones;
            this.estrellas = estrellas;
        }

        public String getNombre() { return nombre; }
        public void setNombre(String nombre) { this.nombre = nombre; }

        public String getDireccion() { return direccion; }
        public void setDireccion(String direccion) { this.direccion = direccion; }

        public int getNumeroHabitaciones() { return numeroHabitaciones; }
        public void setNumeroHabitaciones(int numeroHabitaciones) { this.numeroHabitaciones = numeroHabitaciones; }

        public int getEstrellas() { return estrellas; }
        public void setEstrellas(int estrellas) { this.estrellas = estrellas; }

        @Override
        public String toString() {
            return "Hotel: " + nombre + ", Dirección: " + direccion + ", Número de habitaciones: " + numeroHabitaciones + ", Estrellas: " + estrellas;
        }

        public static void main(String[] args) {
            Hotel hotel1 = new Hotel("Hotel El Dorado", "Calle 45", 100, 5);
            Hotel hotel2 = new Hotel("Hotel Costa Azul", "Avenida Playa", 50, 4);

            System.out.println(hotel1);
            System.out.println(hotel2);
        }
    }
}
