package ejepapeleria;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class EjePapeleria {

    // *** *** *** *** *** *** LISTAS *** *** *** *** *** *** //
    //*** *** Articulos *** ***//
    static String[] articulos = {"Lapices", "Cuadernos", "Borradores", "Reglas", "Juego1", "Juego2"};

    //*** *** Meses *** ***//
    static String[] meses = {"Ene", "Feb", "Mar", "Abr", "May", "Jun", "Jul", "Ago", "Sep", "Oct", "Nov", "Dic"};

    //*** *** Precios *** ***//
    static int[] preciosDefecto = {1000, 2300, 1200, 2700, 15500, 20300};

    static int[][] ventaAnual = {
        {1, 15, 0}, {2, 23, 0}, {3, 36, 0}, {4, 27, 0}, {5, 12, 0}, {6, 26, 0}, {7, 23, 0}, {8, 31, 0}, {9, 21, 0}, {10, 23, 0}, {11, 35, 0}, {12, 40, 0}, //lapices
        {1, 15, 1}, {2, 23, 1}, {3, 36, 1}, {4, 27, 1}, {5, 12, 1}, {6, 26, 1}, {7, 23, 1}, {8, 31, 1}, {9, 21, 1}, {10, 23, 1}, {11, 35, 1}, {12, 40, 1}, //cuaderno
        {1, 15, 2}, {2, 23, 2}, {3, 36, 2}, {4, 27, 2}, {5, 12, 2}, {6, 26, 2}, {7, 23, 2}, {8, 31, 2}, {9, 21, 2}, {10, 23, 2}, {11, 35, 2}, {12, 40, 2}, //Borradores
        {1, 15, 3}, {2, 23, 3}, {3, 36, 3}, {4, 27, 3}, {5, 12, 3}, {6, 26, 3}, {7, 23, 3}, {8, 31, 3}, {9, 21, 3}, {10, 23, 3}, {11, 35, 3}, {12, 40, 3}, //Reglas
        {1, 15, 4}, {2, 23, 4}, {3, 36, 4}, {4, 27, 4}, {5, 12, 4}, {6, 26, 4}, {7, 23, 4}, {8, 31, 4}, {9, 21, 4}, {10, 23, 4}, {11, 35, 4}, {12, 40, 4}, //juego1
        {1, 15, 5}, {2, 23, 5}, {3, 36, 5}, {4, 27, 5}, {5, 12, 5}, {6, 26, 5}, {7, 23, 5}, {8, 31, 5}, {9, 21, 5}, {10, 23, 5}, {11, 35, 5}, {12, 40, 5}};//juego2

    // *** *** *** *** *** *** METODOS *** *** *** *** *** *** //
    //*** *** Principal *** ***//
    public static void main(String[] args) {
        String[] servicios = {"Ventas por articulos por mes", "Venta general por mes", "Ventas anual de cada uno de los articulos", "Venta anual"};
        boolean consulta = true;

        while (consulta) {
            String seleccion = (String) JOptionPane.showInputDialog(null, "Bienbenido a nuestra papeleria y control de ventas\nSeleccione el tipo de consulta", "Servicios", JOptionPane.QUESTION_MESSAGE, null, servicios, servicios[0]);

            switch (seleccion) {
                case ("Ventas por articulos por mes") -> {
                    MtdArticuloPorMes();
                    consulta = MtdContinuar();
                }
                case ("Venta general por mes") -> {
                    MtdVentaMensual();
                    consulta = MtdContinuar();
                }
                case ("Ventas anual de cada uno de los articulos") -> {
                    MtdVentaAnualArt();
                    consulta = MtdContinuar();
                }
                case ("Venta anual") -> {
                    MtdVentaAnual();
                    consulta = MtdContinuar();
                }
                default ->
                    throw new AssertionError();
            }
        }
    }

    //*** *** Venta de articulos por mes *** ***//
    public static void MtdArticuloPorMes() {
        StringBuilder texto = new StringBuilder();
        int mes = MtdMes();
        int[] valores = MtdConsultarPrecios();

        texto.append("Para el mes de ").append(meses[mes - 1]).append(" se tiene el siguinete registro:\n");
        for (int[] ventaAnual1 : ventaAnual) {
            if (ventaAnual1[0] == (mes)) {
                texto.append("\n").
                        append(articulos[ventaAnual1[2]]).append(" :\n").
                        append("Articulos vendidos: ").append(ventaAnual1[1]).append(" // Recaudado: $").append(ventaAnual1[1] * valores[ventaAnual1[2]]).append("\n");
            }
        }
        JOptionPane.showMessageDialog(null, texto);
    }

    //*** *** Venta mensual *** ***//
    public static void MtdVentaMensual() {
        StringBuilder texto = new StringBuilder();
        int recaudacion = 0;
        int mes = MtdMes();
        int[] valores = MtdConsultarPrecios();

        for (int[] ventaAnual1 : ventaAnual) {
            if (ventaAnual1[0] == (mes)) {
                recaudacion += ventaAnual1[1] * valores[ventaAnual1[2]];
            }
        }
        texto.append("Para el mes de ").append(meses[mes - 1]).append(" se tiene el siguinete registro:\n")
                .append("\nRecaudado: $").append(recaudacion);

        JOptionPane.showMessageDialog(null, texto);
    }

    //*** *** Venta anual de Articulos *** ***//
    public static void MtdVentaAnualArt() {
        StringBuilder texto = new StringBuilder();
        int i = 0;
        int valorAnual = 0;
        for (int j = 0; j < articulos.length; j++) {
            texto.append("\n").append(articulos[j]).append(" :\n");
            for (int[] mes : ventaAnual) {
                if (mes[2] == i) {
                    valorAnual += mes[1] * preciosDefecto[i];
                }
            }
            i++;
            texto.append("Recaudado anual: $").append(valorAnual)
                    .append("\n");
            valorAnual = 0;
        }
        JOptionPane.showMessageDialog(null, texto);
    }

    //*** *** Venta Anual *** ***//
    public static void MtdVentaAnual() {
        StringBuilder texto = new StringBuilder();
        int recaudacion = 0;

        for (int[] ventaAnual1 : ventaAnual) {
            recaudacion += ventaAnual1[1] * preciosDefecto[ventaAnual1[2]];
        }
        texto.append("La recaudaion anual de la papeleria es de:").append("\n")
                .append("\n")
                .append("Recaudacion Anual : $").append(recaudacion).append("\n");

        JOptionPane.showMessageDialog(null, texto);
    }

    // *** *** *** *** *** *** METODOS (REURILIZABLES) *** *** *** *** *** *** //
    //*** *** Definir precios precio *** ***//
    private static int[] MtdConsultarPrecios() {
        int[] precios = new int[6];
        String opcion = JOptionPane.showInputDialog("""
                       Desea ingresar los precioas de cada articulo o prefiere dejara 
                       los precios por defecto? (SI / NO)""");

        if (opcion.toLowerCase().equals("si") || opcion.toLowerCase().equals("s")) {
            for (int i = 0; i < 4; i++) {
                int precio = Integer.parseInt(JOptionPane.showInputDialog("Ingrese para los " + articulos[i]));
                precios[i] = precio;
            }
            precios[4] = (precios[0] * 2) + (precios[1] * 3) + (precios[2]) + (precios[3] * 2);
            precios[5] = (precios[0] * 6) + (precios[1] * 4) + (precios[2] * 2) + (precios[3]);
            return precios;
        } else {
            return preciosDefecto;
        }
    }

    //*** *** Consultar # del mes *** ***//
    private static int MtdMes() {
        String mes = (String) JOptionPane.showInputDialog(null, "Seleccione el mes que desea consultar", "meses", JOptionPane.QUESTION_MESSAGE, null, meses, meses[0]);
        for (int i = 0; i < meses.length; i++) {
            if (meses[i].equals(mes)) {
                return i + 1;
            }
        }
        return 112;
    }

    //*** *** Continuar con las operaciones *** ***//
    private static boolean MtdContinuar() {
        String seleccion = JOptionPane.showInputDialog("Desea realizar otro servico? (SI / NO)");
        String respuesta = seleccion.toLowerCase();

        return respuesta.equals("si") || respuesta.equals("s");
    }
}
