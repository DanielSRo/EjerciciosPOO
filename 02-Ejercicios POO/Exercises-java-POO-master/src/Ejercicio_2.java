public class Ejercicio_2 {
    class Estudiante {
        private String nombre;
        private int edad;
        private String carrera;
        private double promedio;

        public Estudiante(String nombre, int edad, String carrera, double promedio) {
            this.nombre = nombre;
            this.edad = edad;
            this.carrera = carrera;
            this.promedio = promedio;
        }

        public void imprimirValores() {
            System.out.println("Nombre: " + nombre);
            System.out.println("Edad: " + edad);
            System.out.println("Carrera: " + carrera);
            System.out.println("Promedio: " + promedio);
        }
    }
}
