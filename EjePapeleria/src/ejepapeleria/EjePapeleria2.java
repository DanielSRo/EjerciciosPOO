//package ejepapeleria;
//
//import java.util.Scanner;
//
//public class EjePapeleria2 {
//
//    public static void main(String[] args) {
//        //librerias Suid
//        Scanner sc = new Scanner(System.in);
//        String[] meses = {"Enero", "Feb", "Mar", "Abr", "May", "Jun", "Jul", "Ago", "Sep", "Oct", "Nov", "Dic"};
//        String[] nombresArticulos = {"Lapices", "Cuadernos", "Borradores", "Reglas"};
//
//        int[][] juegos = {
//            {2, 3, 1, 2},
//            {6, 4, 2, 1}};
//
//        int[][] ventas = new int[12][2];
//        double[][] precios = new double[4][12];
//
//        for (int mes = 0; mes < 12; mes++) {
//            System.out.println("Digite las ventas del mes de " + meses[mes] + " : ");
//            System.out.println("Promocion 1 vendidos: ");
//            ventas[mes][0] = sc.nextInt();
//
//            System.out.println("Promocion 2 vendidos: ");
//            ventas[mes][1] = sc.nextInt();
//
//            System.out.println("Digite los precios de los productos en el mes de " + meses[mes] + " : ");
//
//            for (int art = 0; art < 4; art++) {
//                System.out.println("precio por: " + nombresArticulos[art] + " : ");
//                precios[art][mes] = sc.nextDouble();
//            }
//
//        }
//        //calculo Articulos vendidos por mes, total anual
//        int[][] articulosVendidosMensuales = new int[4][12];
//        int[] articulosVendidosAnuales = new int[4];
//
//        System.out.println("\nNumero de articulos vendidos en c/mes");
//        for (int mes = 0; mes < 12; mes++) {
//            System.out.println("\nMes: " + meses[mes]);
//            for (int art = 0; art < 4; art++) {
//                articulosVendidosMensuales[art][mes] = juegos[0][art] * ventas[mes][0] + juegos[1][art] * ventas[mes][1];
//                articulosVendidosAnuales[art] += articulosVendidosMensuales[art][mes];
//                System.out.println(nombresArticulos[art] + " vendidos: " + articulosVendidosMensuales[art][mes]);
//            }
//        }
//        //cacular total de ventas por articulo/mes y total anual
//        double[][] ventasPorArticulo = new double[4][12];
//        double[] totalVentasMensuales = new double[12];
//        double[] totalVentasAnualesPorArticulo = new double[4];
//        double totalVentasAnual = 0.0;
//
//        System.out.println("\nTotal de ventas por articulo y mes: ");
//        for (int mes = 0; mes < 12; mes++) {
//            System.out.println("\nMes: " + meses[mes]);
//
//            for (int art = 0; art < 4; art++) {
//                ventasPorArticulo[art][mes] = articulosVendidosMensuales[art][mes] * precios[art][mes];
//                totalVentasMensuales[mes] += ventasPorArticulo[art][mes];
//                totalVentasAnualesPorArticulo[art] += ventasPorArticulo[art][mes];
//
//                System.out.println("Ventas de " + nombresArticulos[art] + " : $" + ventasPorArticulo[art][mes]);
//            }
//            System.out.println("Total ventas en " + meses[mes] + " : $" + totalVentasMensuales[mes]);
//            totalVentasAnual += totalVentasMensuales[mes];
//        }
//        //Mostrar el total anual e ventas por articulo y el total general anual
//        System.out.println("\nTotal anual de ventas por articulo");
//        for (int art = 0; art < 4; art++) {
//            System.out.println(nombresArticulos[art] + ": $" + totalVentasAnualesPorArticulo[art]);
//        }
//        System.out.println("\nTotal ventas anual: $" + totalVentasAnual);
//    }
//}