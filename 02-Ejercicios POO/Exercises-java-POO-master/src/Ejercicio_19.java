public class Ejercicio_19 {
    static class Juego {
        private String titulo;
        private String plataforma;
        private int añoLanzamiento;
        private String genero;

        public Juego(String titulo, String plataforma, int añoLanzamiento, String genero) {
            this.titulo = titulo;
            this.plataforma = plataforma;
            this.añoLanzamiento = añoLanzamiento;
            this.genero = genero;
        }

        public String getTitulo() { return titulo; }
        public void setTitulo(String titulo) { this.titulo = titulo; }

        public String getPlataforma() { return plataforma; }
        public void setPlataforma(String plataforma) { this.plataforma = plataforma; }

        public int getAñoLanzamiento() { return añoLanzamiento; }
        public void setAñoLanzamiento(int añoLanzamiento) { this.añoLanzamiento = añoLanzamiento; }

        public String getGenero() { return genero; }
        public void setGenero(String genero) { this.genero = genero; }

        @Override
        public String toString() {
            return "Juego: " + titulo + ", Plataforma: " + plataforma + ", Año de lanzamiento: " + añoLanzamiento + ", Género: " + genero;
        }

        public static void main(String[] args) {
            Juego juego1 = new Juego("The Legend of Zelda", "Nintendo Switch", 2017, "Aventura");
            Juego juego2 = new Juego("Minecraft", "PC", 2011, "Sandbox");

            System.out.println(juego1);
            System.out.println(juego2);
        }
    }
}
