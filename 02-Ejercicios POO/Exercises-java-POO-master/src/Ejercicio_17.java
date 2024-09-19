public class Ejercicio_17 {
    static class Factura {
        private int numeroFactura;
        private String fecha;
        private String cliente;
        private double importeTotal;

        public Factura(int numeroFactura, String fecha, String cliente, double importeTotal) {
            this.numeroFactura = numeroFactura;
            this.fecha = fecha;
            this.cliente = cliente;
            this.importeTotal = importeTotal;
        }

        public int getNumeroFactura() { return numeroFactura; }
        public void setNumeroFactura(int numeroFactura) { this.numeroFactura = numeroFactura; }

        public String getFecha() { return fecha; }
        public void setFecha(String fecha) { this.fecha = fecha; }

        public String getCliente() { return cliente; }
        public void setCliente(String cliente) { this.cliente = cliente; }

        public double getImporteTotal() { return importeTotal; }
        public void setImporteTotal(double importeTotal) { this.importeTotal = importeTotal; }

        @Override
        public String toString() {
            return "Factura N°: " + numeroFactura + ", Fecha: " + fecha + ", Cliente: " + cliente + ", Importe Total: $" + importeTotal;
        }

        public static void main(String[] args) {
            Factura factura1 = new Factura(101, "2024-09-19", "Carlos Martínez", 500.75);
            Factura factura2 = new Factura(102, "2024-09-20", "María Rodríguez", 320.40);

            System.out.println(factura1);
            System.out.println(factura2);
        }
    }
}
