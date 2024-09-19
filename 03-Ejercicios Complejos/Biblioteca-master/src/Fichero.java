import java.io .*;
import java.nio.file .*;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.Instant;

public class Fichero {
    public static void crearDirectorio(String ruta) {
        File directorio = new File(ruta);
        if (!directorio.exists()) {
            directorio.mkdirs();
        }
    }

    public static void copiarArchivo(String origen, String destino) throws IOException {
        Files.copy(Paths.get(origen), Paths.get(destino), StandardCopyOption.REPLACE_EXISTING);
    }

    public static void eliminarArchivo(String ruta) {
        File archivo = new File(ruta);
        if (archivo.exists()) {
            archivo.delete();
        }
    }

    public static void limpiarArchivosAntiguos(String directorio, int diasAntiguedad) {
        LocalDate fechaLimite = LocalDate.now().minusDays(diasAntiguedad);
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
}
