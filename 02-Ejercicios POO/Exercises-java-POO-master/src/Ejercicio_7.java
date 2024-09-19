public class Ejercicio_7 {
    class Paciente {
        private String nombre;
        private int edad;
        private String enfermedad;
        private String doctor;

        public Paciente(String nombre, int edad, String enfermedad, String doctor) {
            this.nombre = nombre;
            this.edad = edad;
            this.enfermedad = enfermedad;
            this.doctor = doctor;
        }

        public void imprimirValores() {
            System.out.println("Nombre: " + nombre);
            System.out.println("Edad: " + edad);
            System.out.println("Enfermedad: " + enfermedad);
            System.out.println("Doctor: " + doctor);
        }
    }
}
