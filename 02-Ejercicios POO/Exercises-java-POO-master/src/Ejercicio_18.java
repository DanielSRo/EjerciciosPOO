public class Ejercicio_18 {
    static class Universidad {
        private String nombre;
        private String direccion;
        private int numeroEstudiantes;
        private int ranking;

        public Universidad(String nombre, String direccion, int numeroEstudiantes, int ranking) {
            this.nombre = nombre;
            this.direccion = direccion;
            this.numeroEstudiantes = numeroEstudiantes;
            this.ranking = ranking;
        }

        public String getNombre() { return nombre; }
        public void setNombre(String nombre) { this.nombre = nombre; }

        public String getDireccion() { return direccion; }
        public void setDireccion(String direccion) { this.direccion = direccion; }

        public int getNumeroEstudiantes() { return numeroEstudiantes; }
        public void setNumeroEstudiantes(int numeroEstudiantes) { this.numeroEstudiantes = numeroEstudiantes; }

        public int getRanking() { return ranking; }
        public void setRanking(int ranking) { this.ranking = ranking; }

        @Override
        public String toString() {
            return "Universidad: " + nombre + ", Dirección: " + direccion + ", Número de estudiantes: " + numeroEstudiantes + ", Ranking: " + ranking;
        }

        public static void main(String[] args) {
            Universidad uni1 = new Universidad("Universidad Nacional", "Calle 123", 40000, 1);
            Universidad uni2 = new Universidad("Universidad de los Andes", "Carrera 45", 20000, 2);

            System.out.println(uni1);
            System.out.println(uni2);
        }
    }
}
