public class Ejercicio_1 {
     class Libro {
        private String ISBN;
        private String titulo;
        private String autor;
        private boolean disponible;

        public Libro(String ISBN, String titulo, String autor, boolean disponible) {
            this.ISBN = ISBN;
            this.titulo = titulo;
            this.autor = autor;
            this.disponible = disponible;
        }

        public void imprimirValores() {
            System.out.println("ISBN: " + ISBN);
            System.out.println("Título: " + titulo);
            System.out.println("Autor: " + autor);
            System.out.println("Disponible: " + disponible);
        }
    }
}
