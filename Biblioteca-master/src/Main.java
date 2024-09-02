// Main.java
import java.util.Scanner;

public class Main {
    private static Biblioteca biblioteca;
    private static Scanner scanner;

    public static void main(String[] args) {
        biblioteca = new Biblioteca();
        scanner = new Scanner(System.in);

        while (true) {
            mostrarMenu();
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    registrarUsuario();
                    break;
                case 2:
                    agregarLibro();
                    break;
                case 3:
                    realizarPrestamo();
                    break;
                case 4:
                    devolverLibro();
                    break;
                case 5:
                    generarReporte();
                    break;
                case 6:
                    crearCopiaSeguridad();
                    break;
                case 7:
                    restaurarDesdeRespaldo();
                    break;
                case 8:
                    limpiarLogsAntiguos();
                    break;
                case 0:
                    System.out.println("Gracias por usar el Sistema de Gestión de Biblioteca.");
                    System.exit(0);
                default:
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");
            }
        }
    }

    private static void mostrarMenu() {
        System.out.println("\n--- Sistema de Gestión de Biblioteca ---");
        System.out.println("1. Registrar usuario");
        System.out.println("2. Agregar libro");
        System.out.println("3. Realizar préstamo");
        System.out.println("4. Devolver libro");
        System.out.println("5. Generar reporte");
        System.out.println("6. Crear copia de seguridad");
        System.out.println("7. Restaurar desde respaldo");
        System.out.println("8. Limpiar logs antiguos");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opción: ");
    }

    private static void registrarUsuario() {
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Identificación: ");
        String identificacion = scanner.nextLine();
        System.out.print("Tipo de usuario (lector/bibliotecario): ");
        String tipoUsuario = scanner.nextLine();
        System.out.print("Correo electrónico: ");
        String correoElectronico = scanner.nextLine();
        System.out.print("Contraseña: ");
        String contrasena = scanner.nextLine();

        try {
            biblioteca.registrarUsuario(nombre, identificacion, tipoUsuario, correoElectronico, contrasena);
            System.out.println("Usuario registrado con éxito.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error al registrar usuario: " + e.getMessage());
        }
    }

    private static void agregarLibro() {
        System.out.print("Título: ");
        String titulo = scanner.nextLine();
        System.out.print("Autor: ");
        String autor = scanner.nextLine();
        System.out.print("ISBN: ");
        String isbn = scanner.nextLine();
        System.out.print("Género: ");
        String genero = scanner.nextLine();
        System.out.print("Número de copias: ");
        int numCopias = scanner.nextInt();
        scanner.nextLine();

        try {
            biblioteca.agregarLibro(titulo, autor, isbn, genero, numCopias);
            System.out.println("Libro agregado con éxito.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error al agregar libro: " + e.getMessage());
        }
    }

    private static void realizarPrestamo() {
        System.out.print("ISBN del libro: ");
        String isbn = scanner.nextLine();
        System.out.print("Identificación del usuario: ");
        String identificacionUsuario = scanner.nextLine();

        try {
            biblioteca.realizarPrestamo(isbn, identificacionUsuario);
            System.out.println("Préstamo realizado con éxito.");
        } catch (IllegalArgumentException | IllegalStateException e) {
            System.out.println("Error al realizar préstamo: " + e.getMessage());
        }
    }

    private static void devolverLibro() {
        System.out.print("ISBN del libro: ");
        String isbn = scanner.nextLine();
        System.out.print("Identificación del usuario: ");
        String identificacionUsuario = scanner.nextLine();

        try {
            biblioteca.devolverLibro(isbn, identificacionUsuario);
            System.out.println("Libro devuelto con éxito.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error al devolver libro: " + e.getMessage());
        }
    }

    private static void generarReporte() {
        System.out.println("Tipos de reporte:");
        System.out.println("1. Libros más prestados");
        System.out.println("2. Usuarios más activos");
        System.out.print("Seleccione el tipo de reporte: ");
        int tipoReporte = scanner.nextInt();
        scanner.nextLine();

        Biblioteca.Reporte reporte = new Biblioteca.Reporte(biblioteca);
        switch (tipoReporte) {
            case 1:
                reporte.generarReporteLibrosMasPrestados();
                break;
            case 2:
                reporte.generarReporteUsuariosMasActivos();
                break;
            default:
                System.out.println("Tipo de reporte no válido.");
        }
    }

    private static void crearCopiaSeguridad() {
        biblioteca.crearCopiaSeguridad();
        System.out.println("Copia de seguridad creada con éxito.");
    }

    private static void restaurarDesdeRespaldo() {
        System.out.print("Ingrese el nombre del directorio de respaldo: ");
        String directorioRespaldo = scanner.nextLine();

        try {
            biblioteca.restaurarDesdeRespaldo(directorioRespaldo);
            System.out.println("Sistema restaurado con éxito desde el respaldo.");
        } catch (Exception e) {
            System.out.println("Error al restaurar desde respaldo: " + e.getMessage());
        }
    }

    private static void limpiarLogsAntiguos() {
        System.out.print("Ingrese el número de días de antigüedad para limpiar logs: ");
        int diasAntiguedad = scanner.nextInt();
        scanner.nextLine();

        biblioteca.limpiarLogsAntiguos(diasAntiguedad);
        System.out.println("Logs antiguos limpiados con éxito.");
    }
}