public class Ejercicio_13 {
    static class Persona {
        private String nombre;
        private String apellido;
        private int edad;
        private String direccion;

        public Persona(String nombre, String apellido, int edad, String direccion) {
            this.nombre = nombre;
            this.apellido = apellido;
            this.edad = edad;
            this.direccion = direccion;
        }

        public String getNombre() { return nombre; }
        public void setNombre(String nombre) { this.nombre = nombre; }

        public String getApellido() { return apellido; }
        public void setApellido(String apellido) { this.apellido = apellido; }

        public int getEdad() { return edad; }
        public void setEdad(int edad) { this.edad = edad; }

        public String getDireccion() { return direccion; }
        public void setDireccion(String direccion) { this.direccion = direccion; }

        @Override
        public String toString() {
            return "Persona: " + nombre + " " + apellido + ", Edad: " + edad + ", Dirección: " + direccion;
        }

        public static void main(String[] args) {
            Persona persona1 = new Persona("Juan", "Pérez", 25, "Calle Falsa 123");
            Persona persona2 = new Persona("María", "González", 30, "Avenida Siempreviva 456");

            System.out.println(persona1);
            System.out.println(persona2);
        }
    }
}
