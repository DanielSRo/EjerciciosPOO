public class Ejercicio_3 {
    class Empleado {
        private String nombre;
        private String puesto;
        private double salario;
        private int antiguedad;

        public Empleado(String nombre, String puesto, double salario, int antiguedad) {
            this.nombre = nombre;
            this.puesto = puesto;
            this.salario = salario;
            this.antiguedad = antiguedad;
        }

        public void imprimirValores() {
            System.out.println("Nombre: " + nombre);
            System.out.println("Puesto: " + puesto);
            System.out.println("Salario: " + salario);
            System.out.println("Antigüedad: " + antiguedad + " años");
        }
    }
}
