public class Ejercicio_16 {
    static class Proveedor {
        private String nombre;
        private String empresa;
        private String telefono;
        private String email;

        public Proveedor(String nombre, String empresa, String telefono, String email) {
            this.nombre = nombre;
            this.empresa = empresa;
            this.telefono = telefono;
            this.email = email;
        }

        public String getNombre() { return nombre; }
        public void setNombre(String nombre) { this.nombre = nombre; }

        public String getEmpresa() { return empresa; }
        public void setEmpresa(String empresa) { this.empresa = empresa; }

        public String getTelefono() { return telefono; }
        public void setTelefono(String telefono) { this.telefono = telefono; }

        public String getEmail() { return email; }
        public void setEmail(String email) { this.email = email; }

        @Override
        public String toString() {
            return "Proveedor: " + nombre + ", Empresa: " + empresa + ", Teléfono: " + telefono + ", Email: " + email;
        }

        public static void main(String[] args) {
            Proveedor proveedor1 = new Proveedor("Luis Gómez", "Tech Supplies", "123-456-7890", "luis@techsupplies.com");
            Proveedor proveedor2 = new Proveedor("Ana López", "Office Pro", "098-765-4321", "ana@officepro.com");

            System.out.println(proveedor1);
            System.out.println(proveedor2);
        }
    }
}
