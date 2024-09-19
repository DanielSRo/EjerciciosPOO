public class Ejercicio_9 {
    class Pedido {
        private String codigoPedido;
        private String producto;
        private int cantidad;
        private double precioTotal;

        public Pedido(String codigoPedido, String producto, int cantidad, double precioTotal) {
            this.codigoPedido = codigoPedido;
            this.producto = producto;
            this.cantidad = cantidad;
            this.precioTotal = precioTotal;
        }

        public void imprimirValores() {
            System.out.println("Código del Pedido: " + codigoPedido);
            System.out.println("Producto: " + producto);
            System.out.println("Cantidad: " + cantidad);
            System.out.println("Precio Total: $" + precioTotal);
        }
    }
}
