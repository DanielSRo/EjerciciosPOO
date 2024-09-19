public class Ejercicio_4 {
    class Producto {
        private String codigo;
        private String nombre;
        private double precio;
        private int stock;

        public Producto(String codigo, String nombre, double precio, int stock) {
            this.codigo = codigo;
            this.nombre = nombre;
            this.precio = precio;
            this.stock = stock;
        }

        public void imprimirValores() {
            System.out.println("Código: " + codigo);
            System.out.println("Nombre: " + nombre);
            System.out.println("Precio: $" + precio);
            System.out.println("Stock: " + stock);
        }
    }
}
