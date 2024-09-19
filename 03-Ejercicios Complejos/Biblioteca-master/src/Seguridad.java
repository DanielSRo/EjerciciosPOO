import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Seguridad {
        public static String hashContrasena(String contrasena) {
            try {
                MessageDigest md = MessageDigest.getInstance("SHA-256");
                byte[] hash = md.digest(contrasena.getBytes());
                StringBuilder sb = new StringBuilder();
                for (byte b : hash) {
                    sb.append(String.format("%02x", b));
                }
                return sb.toString();
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException("Error al hashear la contraseña", e);
            }
        }

        public static boolean verificarContrasena(String contrasena, String hash) {
            return hashContrasena(contrasena).equals(hash);
        }
    }


