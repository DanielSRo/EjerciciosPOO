public class Ejercicio_15 {
    static class Mascota {
        private String nombre;
        private String tipo;
        private int edad;
        private String dueño;

        public Mascota(String nombre, String tipo, int edad, String dueño) {
            this.nombre = nombre;
            this.tipo = tipo;
            this.edad = edad;
            this.dueño = dueño;
        }

        public String getNombre() { return nombre; }
        public void setNombre(String nombre) { this.nombre = nombre; }

        public String getTipo() { return tipo; }
        public void setTipo(String tipo) { this.tipo = tipo; }

        public int getEdad() { return edad; }
        public void setEdad(int edad) { this.edad = edad; }

        public String getDueño() { return dueño; }
        public void setDueño(String dueño) { this.dueño = dueño; }

        @Override
        public String toString() {
            return "Mascota: " + nombre + ", Tipo: " + tipo + ", Edad: " + edad + ", Dueño: " + dueño;
        }

        public static void main(String[] args) {
            Mascota mascota1 = new Mascota("Rex", "Perro", 5, "Juan Pérez");
            Mascota mascota2 = new Mascota("Mia", "Gato", 3, "Ana González");

            System.out.println(mascota1);
            System.out.println(mascota2);
        }
    }
}
