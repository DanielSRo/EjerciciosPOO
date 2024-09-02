import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Biblioteca {
    private Map<String, Usuario> usuarios;
    private Map<String, Libro> libros;
    private List<Prestamo> prestamos;

    public Biblioteca() {
        usuarios = new HashMap<>();
        libros = new HashMap<>();
        prestamos = new ArrayList<>();
        cargarDatos();
    }

    private void cargarDatos() {
        cargarUsuarios();
        cargarLibros();
        cargarPrestamos();
    }

    private void cargarUsuarios() {
        try (BufferedReader reader = new BufferedReader(new FileReader("usuarios.csv"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                Usuario usuario = new Usuario(parts[0], parts[1], parts[2], parts[3], parts[4]);
                usuarios.put(usuario.getIdentificacion(), usuario);
            }
        } catch (IOException e) {
            System.out.println("Error al cargar usuarios: " + e.getMessage());
        }
    }

    private void cargarLibros() {
        try (BufferedReader reader = new BufferedReader(new FileReader("catalogo.csv"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                Libro libro = new Libro(parts[0], parts[1], parts[2], parts[3], Integer.parseInt(parts[4]));
                libros.put(libro.getIsbn(), libro);
            }
        } catch (IOException e) {
            System.out.println("Error al cargar libros: " + e.getMessage());
        }
    }

    private void cargarPrestamos() {
        try (BufferedReader reader = new BufferedReader(new FileReader("prestamos.csv"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                Libro libro = libros.get(parts[0]);
                Usuario usuario = usuarios.get(parts[1]);
                LocalDate fechaInicio = LocalDate.parse(parts[2]);
                Prestamo prestamo = new Prestamo(libro, usuario, fechaInicio);
                prestamo.setFechaDevolucion(LocalDate.parse(parts[3]));
                prestamo.setEstado(parts[4]);
                prestamos.add(prestamo);
            }
        } catch (IOException e) {
            System.out.println("Error al cargar préstamos: " + e.getMessage());
        }
    }

    public void guardarDatos() {
        guardarUsuarios();
        guardarLibros();
        guardarPrestamos();
    }

    private void guardarUsuarios() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("usuarios.csv"))) {
            for (Usuario usuario : usuarios.values()) {
                writer.println(String.format("%s,%s,%s,%s,%s",
                        usuario.getNombre(),
                        usuario.getIdentificacion(),
                        usuario.getTipoUsuario(),
                        usuario.getCorreoElectronico(),
                        usuario.getContrasenaHash()));
            }
        } catch (IOException e) {
            System.out.println("Error al guardar usuarios: " + e.getMessage());
        }
    }

    private void guardarLibros() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("catalogo.csv"))) {
            for (Libro libro : libros.values()) {
                writer.println(String.format("%s,%s,%s,%s,%d,%d",
                        libro.getTitulo(),
                        libro.getAutor(),
                        libro.getIsbn(),
                        libro.getGenero(),
                        libro.getNumCopias(),
                        libro.getDisponibilidad()));
            }
        } catch (IOException e) {
            System.out.println("Error al guardar libros: " + e.getMessage());
        }
    }

    private void guardarPrestamos() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("prestamos.csv"))) {
            for (Prestamo prestamo : prestamos) {
                writer.println(String.format("%s,%s,%s,%s,%s",
                        prestamo.getLibro().getIsbn(),
                        prestamo.getUsuario().getIdentificacion(),
                        prestamo.getFechaInicio(),
                        prestamo.getFechaDevolucion(),
                        prestamo.getEstado()));
            }
        } catch (IOException e) {
            System.out.println("Error al guardar préstamos: " + e.getMessage());
        }
    }

    public void registrarUsuario(String nombre, String identificacion, String tipoUsuario, String correoElectronico, String contrasena) {
        if (usuarios.containsKey(identificacion)) {
            throw new IllegalArgumentException("Ya existe un usuario con esa identificación.");
        }
        Usuario nuevoUsuario = new Usuario(nombre, identificacion, tipoUsuario, correoElectronico, contrasena);
        usuarios.put(identificacion, nuevoUsuario);
        guardarUsuarios();
        registrarLog("usuarios_log.csv", "Usuario registrado: " + identificacion);
    }

    public void modificarUsuario(String identificacion, Map<String, String> cambios) {
        Usuario usuario = usuarios.get(identificacion);
        if (usuario == null) {
            throw new IllegalArgumentException("Usuario no encontrado.");
        }
        for (Map.Entry<String, String> entry : cambios.entrySet()) {
            switch (entry.getKey()) {
                case "nombre":
                    usuario.setNombre(entry.getValue());
                    break;
                case "tipoUsuario":
                    usuario.setTipoUsuario(entry.getValue());
                    break;
                case "correoElectronico":
                    usuario.setCorreoElectronico(entry.getValue());
                    break;
            }
        }
        guardarUsuarios();
        registrarLog("usuarios_log.csv", "Usuario modificado: " + identificacion);
    }

    public void eliminarUsuario(String identificacion) {
        if (!usuarios.containsKey(identificacion)) {
            throw new IllegalArgumentException("Usuario no encontrado.");
        }
        usuarios.remove(identificacion);
        guardarUsuarios();
        registrarLog("usuarios_log.csv", "Usuario eliminado: " + identificacion);
    }

    public void agregarLibro(String titulo, String autor, String isbn, String genero, int numCopias) {
        if (libros.containsKey(isbn)) {
            throw new IllegalArgumentException("Ya existe un libro con ese ISBN.");
        }
        Libro nuevoLibro = new Libro(titulo, autor, isbn, genero, numCopias);
        libros.put(isbn, nuevoLibro);
        guardarLibros();
        registrarLog("catalogo_log.csv", "Libro agregado: " + isbn);
    }

    public void modificarLibro(String isbn, Map<String, String> cambios) {
        Libro libro = libros.get(isbn);
        if (libro == null) {
            throw new IllegalArgumentException("Libro no encontrado.");
        }
        for (Map.Entry<String, String> entry : cambios.entrySet()) {
            switch (entry.getKey()) {
                case "titulo":
                    libro.setTitulo(entry.getValue());
                    break;
                case "autor":
                    libro.setAutor(entry.getValue());
                    break;
                case "genero":
                    libro.setGenero(entry.getValue());
                    break;
                case "numCopias":
                    int newCopias = Integer.parseInt(entry.getValue());
                    int diff = newCopias - libro.getNumCopias();
                    libro.setNumCopias(newCopias);
                    libro.setDisponibilidad(libro.getDisponibilidad() + diff);
                    break;
            }
        }
        guardarLibros();
        registrarLog("catalogo_log.csv", "Libro modificado: " + isbn);
    }

    public void eliminarLibro(String isbn) {
        if (!libros.containsKey(isbn)) {
            throw new IllegalArgumentException("Libro no encontrado.");
        }
        libros.remove(isbn);
        guardarLibros();
        registrarLog("catalogo_log.csv", "Libro eliminado: " + isbn);
    }

    public void realizarPrestamo(String isbn, String identificacionUsuario) {
        Libro libro = libros.get(isbn);
        Usuario usuario = usuarios.get(identificacionUsuario);
        if (libro == null || usuario == null) {
            throw new IllegalArgumentException("Libro o usuario no encontrado.");
        }
        if (libro.getDisponibilidad() <= 0) {
            throw new IllegalStateException("No hay copias disponibles de este libro.");
        }
        Prestamo nuevoPrestamo = new Prestamo(libro, usuario, LocalDate.now());
        prestamos.add(nuevoPrestamo);
        libro.setDisponibilidad(libro.getDisponibilidad() - 1);
        guardarPrestamos();
        guardarLibros();
        registrarLog("prestamos_log.csv", "Préstamo realizado: " + isbn + " a " + identificacionUsuario);
    }

    public void devolverLibro(String isbn, String identificacionUsuario) {
        Prestamo prestamo = prestamos.stream()
                .filter(p -> p.getLibro().getIsbn().equals(isbn) &&
                        p.getUsuario().getIdentificacion().equals(identificacionUsuario) &&
                        p.getEstado().equals("pendiente"))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Préstamo no encontrado."));
        prestamo.setEstado("devuelto");
        prestamo.getLibro().setDisponibilidad(prestamo.getLibro().getDisponibilidad() + 1);
        guardarPrestamos();
        guardarLibros();
        registrarLog("prestamos_log.csv", "Libro devuelto: " + isbn + " por " + identificacionUsuario);
    }

    public List<Map<String, Object>> generarReporte(String tipoReporte) {
        switch (tipoReporte) {
            case "libros_mas_prestados":
                return reporteLibrosMasPrestados();
            case "usuarios_mas_activos":
                return reporteUsuariosMasActivos();
            default:
                throw new IllegalArgumentException("Tipo de reporte no válido.");
        }
    }

    private List<Map<String, Object>> reporteLibrosMasPrestados() {
        Map<String, Integer> conteoPrestamos = new HashMap<>();
        for (Prestamo prestamo : prestamos) {
            String isbn = prestamo.getLibro().getIsbn();
            conteoPrestamos.put(isbn, conteoPrestamos.getOrDefault(isbn, 0) + 1);
        }
        List<Map.Entry<String, Integer>> librosOrdenados = new ArrayList<>(conteoPrestamos.entrySet());
        librosOrdenados.sort((a, b) -> b.getValue().compareTo(a.getValue()));

        List<Map<String, Object>> reporte = new ArrayList<>();
        for (int i = 0; i < Math.min(10, librosOrdenados.size()); i++) {
            Map.Entry<String, Integer> entry = librosOrdenados.get(i);
            Libro libro = libros.get(entry.getKey());
            Map<String, Object> item = new HashMap<>();
            item.put("titulo", libro.getTitulo());
            item.put("prestamos", entry.getValue());
            reporte.add(item);
        }
        return reporte;
    }

    private List<Map<String, Object>> reporteUsuariosMasActivos() {
        Map<String, Integer> conteoUsuarios = new HashMap<>();
        for (Prestamo prestamo : prestamos) {
            String idUsuario = prestamo.getUsuario().getIdentificacion();
            conteoUsuarios.put(idUsuario, conteoUsuarios.getOrDefault(idUsuario, 0) + 1);
        }
        List<Map.Entry<String, Integer>> usuariosOrdenados = new ArrayList<>(conteoUsuarios.entrySet());
        usuariosOrdenados.sort((a, b) -> b.getValue().compareTo(a.getValue()));

        List<Map<String, Object>> reporte = new ArrayList<>();
        for (int i = 0; i < Math.min(10, usuariosOrdenados.size()); i++) {
            Map.Entry<String, Integer> entry = usuariosOrdenados.get(i);
            Usuario usuario = usuarios.get(entry.getKey());
            Map<String, Object> item = new HashMap<>();
            item.put("nombre", usuario.getNombre());
            item.put("prestamos", entry.getValue());
            reporte.add(item);
        }
        return reporte;
    }

    public void exportarReporteCSV(String tipoReporte, String nombreArchivo) {
        List<Map<String, Object>> reporte = generarReporte(tipoReporte);
        try (PrintWriter writer = new PrintWriter(new FileWriter(nombreArchivo))) {

            writer.println("Nombre,Cantidad");

            for (Map<String, Object> item : reporte) {
                writer.println(item.get("nombre") + "," + item.get("prestamos"));
            }
        } catch (IOException e) {
            System.out.println("Error al exportar reporte: " + e.getMessage());
        }
    }

    private void registrarLog(String archivo, String mensaje) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(archivo, true))) {
            writer.println(LocalDate.now() + " - " + mensaje);
        } catch (IOException e) {
            System.out.println("Error al registrar log: " + e.getMessage());
        }
    }

    public void crearCopiaSeguridad() {
        String timestamp = LocalDate.now().toString().replace("-", "");
        String directorioRespaldo = "respaldos/" + timestamp;
        new File(directorioRespaldo).mkdirs();

        copiarArchivo("usuarios.csv", directorioRespaldo + "/usuarios.csv");
        copiarArchivo("catalogo.csv", directorioRespaldo + "/catalogo.csv");
        copiarArchivo("prestamos.csv", directorioRespaldo + "/prestamos.csv");

        registrarLog("auditoria.csv", "Copia de seguridad creada: " + directorioRespaldo);
    }

    private void copiarArchivo(String origen, String destino) {
        try {
            Files.copy(Paths.get(origen), Paths.get(destino), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            System.out.println("Error al copiar archivo: " + e.getMessage());
        }
    }

    public void restaurarDesdeRespaldo(String directorioRespaldo) {
        copiarArchivo(directorioRespaldo + "/usuarios.csv", "usuarios.csv");
        copiarArchivo(directorioRespaldo + "/catalogo.csv", "catalogo.csv");
        copiarArchivo(directorioRespaldo + "/prestamos.csv", "prestamos.csv");

        cargarDatos();
        registrarLog("auditoria.csv", "Sistema restaurado desde respaldo: " + directorioRespaldo);
    }

    public void limpiarLogsAntiguos(int diasAntiguedad) {
        LocalDate fechaLimite = LocalDate.now().minusDays(diasAntiguedad);
        limpiarArchivosAntiguos("logs", fechaLimite);
    }

    private void limpiarArchivosAntiguos(String directorio, LocalDate fechaLimite) {
        File dir = new File(directorio);
        File[] archivos = dir.listFiles();
        if (archivos != null) {
            for (File archivo : archivos) {
                if (archivo.isFile()) {
                    LocalDate fechaModificacion = LocalDate.ofInstant(
                            Instant.ofEpochMilli(archivo.lastModified()), ZoneId.systemDefault());
                    if (fechaModificacion.isBefore(fechaLimite)) {
                        archivo.delete();
                    }
                }
            }
        }
    }
    public static class Reporte {
        private Biblioteca biblioteca;

        public Reporte(Biblioteca biblioteca) {
            this.biblioteca = biblioteca;
        }

        public void generarReporteLibrosMasPrestados() {
            List<Map<String, Object>> reporte = biblioteca.generarReporte("libros_mas_prestados");
            System.out.println("Libros más prestados:");
            for (Map<String, Object> item : reporte) {
                System.out.println(item.get("titulo") + ": " + item.get("prestamos") + " préstamos");
            }
        }

        public void generarReporteUsuariosMasActivos() {
            List<Map<String, Object>> reporte = biblioteca.generarReporte("usuarios_mas_activos");
            System.out.println("Usuarios más activos:");
            for (Map<String, Object> item : reporte) {
                System.out.println(item.get("nombre") + ": " + item.get("prestamos") + " préstamos");
            }
        }

        public void exportarReporteCSV(String tipoReporte, String nombreArchivo) {
            biblioteca.exportarReporteCSV(tipoReporte, nombreArchivo);
            System.out.println("Reporte exportado a " + nombreArchivo);
        }
    }


}


