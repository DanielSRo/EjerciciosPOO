public class Ejercicio_8 {
    class Curso {
        private String nombre;
        private String codigo;
        private int creditos;
        private String profesor;

        public Curso(String nombre, String codigo, int creditos, String profesor) {
            this.nombre = nombre;
            this.codigo = codigo;
            this.creditos = creditos;
            this.profesor = profesor;
        }

        public void imprimirValores() {
            System.out.println("Nombre: " + nombre);
            System.out.println("Código: " + codigo);
            System.out.println("Créditos: " + creditos);
            System.out.println("Profesor: " + profesor);
        }
    }
}
