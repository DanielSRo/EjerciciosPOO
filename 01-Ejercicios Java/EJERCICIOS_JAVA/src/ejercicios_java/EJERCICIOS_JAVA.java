package ejercicios_java;

import ejercicios_java.ejerciciosFunciones.Ejercicios_De_Funciones;
import ejercicios_java.ejerciciosArray.Ejercicios_De_Array;
import javax.swing.JOptionPane;

public class EJERCICIOS_JAVA {

    static String[] tipoEjercicio = {"Ejercicios de Funciones", "Ejercicios de Array"};

    public static void main(String[] args) {

//        Ejercicios_De_Funciones objFunciones = new Ejercicios_De_Funciones();
//        objFunciones.llamarEjercicio();

        Ejercicios_De_Array objArray = new Ejercicios_De_Array();
        objArray.llamarEjercicio();

//        String ejercicio = (String) JOptionPane.showInputDialog(null, "Seleccione el tipo de ejercicios que desea ver", "Tipo de Ejercicios", JOptionPane.QUESTION_MESSAGE, null, tipoEjercicio, tipoEjercicio[0]);
//
//        if (ejercicio != null) {
//
//            switch (ejercicio) {
//                case "Ejercicios de Funciones" -> {
//                    Ejercicios_De_Funciones objFunciones = new Ejercicios_De_Funciones();
//                    objFunciones.llamarEjercicio();
//                }
//                case "Ejercicios de Array" -> {
//                    Ejercicios_De_Array objArray = new Ejercicios_De_Array();
//                    objArray.llamarEjercicio();
//                }
//                default ->
//                    throw new AssertionError();
//            }
//        }
    }
}
