public class Ejercicio_6 {
    class Cliente {
        private String nombre;
        private String direccion;
        private String telefono;
        private String email;

        public Cliente(String nombre, String direccion, String telefono, String email) {
            this.nombre = nombre;
            this.direccion = direccion;
            this.telefono = telefono;
            this.email = email;
        }

        public void imprimirValores() {
            System.out.println("Nombre: " + nombre);
            System.out.println("Dirección: " + direccion);
            System.out.println("Teléfono: " + telefono);
            System.out.println("Email: " + email);
        }
    }
}
