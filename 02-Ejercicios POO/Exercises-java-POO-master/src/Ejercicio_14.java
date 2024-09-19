public class Ejercicio_14 {
    static class Orden {
        private int numeroOrden;
        private String fecha;
        private String cliente;
        private double montoTotal;

        public Orden(int numeroOrden, String fecha, String cliente, double montoTotal) {
            this.numeroOrden = numeroOrden;
            this.fecha = fecha;
            this.cliente = cliente;
            this.montoTotal = montoTotal;
        }

        public int getNumeroOrden() { return numeroOrden; }
        public void setNumeroOrden(int numeroOrden) { this.numeroOrden = numeroOrden; }

        public String getFecha() { return fecha; }
        public void setFecha(String fecha) { this.fecha = fecha; }

        public String getCliente() { return cliente; }
        public void setCliente(String cliente) { this.cliente = cliente; }

        public double getMontoTotal() { return montoTotal; }
        public void setMontoTotal(double montoTotal) { this.montoTotal = montoTotal; }

        @Override
        public String toString() {
            return "Orden N°: " + numeroOrden + ", Fecha: " + fecha + ", Cliente: " + cliente + ", Monto Total: $" + montoTotal;
        }

        public static void main(String[] args) {
            Orden orden1 = new Orden(1, "2024-09-19", "Carlos Martínez", 150.75);
            Orden orden2 = new Orden(2, "2024-09-20", "Ana Rodríguez", 300.40);

            System.out.println(orden1);
            System.out.println(orden2);
        }
    }
}
