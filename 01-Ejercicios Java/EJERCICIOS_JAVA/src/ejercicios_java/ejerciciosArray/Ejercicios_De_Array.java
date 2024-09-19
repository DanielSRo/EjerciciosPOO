package ejercicios_java.ejerciciosArray;

import ejercicios_java.ejerciciosArray.ejercicios.Ejercicio_1;
import javax.swing.JOptionPane;

public class Ejercicios_De_Array {

    // *** *** *** *** *** *** METODOS (ATAJOS)*** *** *** *** *** *** //
    //
    private static void mensaje(String texto) {
        JOptionPane.showMessageDialog(null, texto);
    }

    private static String m(String texto) {
        return JOptionPane.showInputDialog(texto);
    }

    // *** *** *** *** *** *** METODO (INVOCAR EJERCICIO)*** *** *** *** *** *** //
    //
    public void llamarEjercicio() {
        //*** *** Lista de ejercicios *** ***//
        String[] ejercicios = new String[2];
        for (int i = 0; i < ejercicios.length; i++) {
            ejercicios[i] = "Ejercicio #" + (i + 1);
        }

        String seleccion = (String) JOptionPane.showInputDialog(null, "Seleccione el ejercicio a probar", "Lista de ejercicios", JOptionPane.QUESTION_MESSAGE, null, ejercicios, ejercicios[0]);

        // *** *** *** *** EJERCICIOS DE ARRAY *** *** *** ***//
        if (seleccion != null) {
            switch (seleccion) {
                case ("Ejercicio #1") -> {
                    //*** *** Ejercicio #01 *** ***//
                    Ejercicio_1 eje1 = new Ejercicio_1();
                    eje1.ejercicio_1();
                }
                case ("Ejercicio #2") -> {
                    //*** *** Ejercicio #01 *** ***//

                }
                case ("Ejercicio #3") -> {
                    // *** *** Ejercicio #03 *** ***//

                }
                case ("Ejercicio #4") -> {
                    //*** *** Ejercicio #04 *** ***//

                }
                case ("Ejercicio #5") -> {
                    //*** *** Ejercicio #05 *** ***//

                }
                case ("Ejercicio #6") -> {
                    //*** *** Ejercicio #06 *** ***//

                }
                case ("Ejercicio #7") -> {
                    //*** *** Ejercicio #07 *** ***//

                }
                case ("Ejercicio #8") -> {
                    //*** *** Ejercicio #08 *** ***//

                }
                case ("Ejercicio #9") -> {
                    //*** *** Ejercicio #09 *** ***//

                }
                case ("Ejercicio #10") -> {
                    //*** *** Ejercicio #10 *** ***//

                }
                case ("Ejercicio #11") -> {
                    //*** *** Ejercicio #11 *** ***//

                }
                case ("Ejercicio #12") -> {
                    //*** *** Ejercicio #12 *** ***//

                }
                case ("Ejercicio #13") -> {
                    //*** *** Ejercicio #13 *** ***//

                }
                case ("Ejercicio #14") -> {
                    //*** *** Ejercicio #14 *** ***//

                }
                default ->
                    throw new AssertionError();
            }
        }
    }
}
