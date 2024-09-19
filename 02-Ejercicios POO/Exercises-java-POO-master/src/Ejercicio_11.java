public class Ejercicio_11 {
    static class Pelicula {
        private String titulo;
        private String director;
        private int año;
        private String genero;

        public Pelicula(String titulo, String director, int año, String genero) {
            this.titulo = titulo;
            this.director = director;
            this.año = año;
            this.genero = genero;
        }

        public String getTitulo() { return titulo; }
        public void setTitulo(String titulo) { this.titulo = titulo; }

        public String getDirector() { return director; }
        public void setDirector(String director) { this.director = director; }

        public int getAño() { return año; }
        public void setAño(int año) { this.año = año; }

        public String getGenero() { return genero; }
        public void setGenero(String genero) { this.genero = genero; }

        @Override
        public String toString() {
            return "Película: " + titulo + ", Director: " + director + ", Año: " + año + ", Género: " + genero;
        }
    }
    public static void main(String[] args) {
        Pelicula p1 = new Pelicula("Inception", "Christopher Nolan", 2010, "Ciencia ficción");
        Pelicula p2 = new Pelicula("Titanic", "James Cameron", 1997, "Romance");

        System.out.println(p1);
        System.out.println(p2);
    }
}
