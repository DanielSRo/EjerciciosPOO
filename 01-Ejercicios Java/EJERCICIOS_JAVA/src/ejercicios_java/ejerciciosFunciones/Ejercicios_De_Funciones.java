package ejercicios_java.ejerciciosFunciones;

import javax.swing.JOptionPane;

public class Ejercicios_De_Funciones {

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
        String[] ejercicios = new String[20];
        for (int i = 0; i < ejercicios.length; i++) {
            ejercicios[i] = "Ejercicio #" + (i + 1);
        }

        String seleccion = (String) JOptionPane.showInputDialog(null, "Seleccione el ejercicio a probar", "Lista de ejercicios", JOptionPane.QUESTION_MESSAGE, null, ejercicios, ejercicios[0]);

        // *** *** *** *** EJERCICIOS DE FUNCIONES *** *** *** ***//
        if (seleccion != null) {
            switch (seleccion) {
                case ("Ejercicio #1") -> {
                    //*** *** Ejercicio #01 *** ***//
                    mensaje("""
                            La empresa GlobalTech necesita un programa en Java para calcular
                            el salario anual y la deducci\u00f3n de retenci\u00f3n en la fuente de un empleado.
                            El programa debe incluir una funci\u00f3n que reciba el salario mensual de un
                            empleado y el porcentaje de retenci\u00f3n en la fuente, y devuelva el salario
                            anual total y el monto de la deducci\u00f3n de retenci\u00f3n en la fuente.""");
                    
                    float salario = Float.parseFloat(m("Digite el valor del salario mensual"));
                    float retencion = Float.parseFloat(m("Digite elvalor del porcentaje de retención"));

                    ejercicioUno(salario, retencion);
                }
                case ("Ejercicio #2") -> {
                    //*** *** Ejercicio #02 *** ***//
                    mensaje("""
                            La tienda SuperMart necesita un programa en Java para determinar el nivel
                            de stock de productos, con una funci\u00f3n que recibe las cantidades de varios
                            productos y el nivel m\u00ednimo requerido de stock, y determina si es necesario
                            realizar un pedido para cada producto.""");
                    
                    int numProductos = Integer.parseInt(m("Digite el numero de productos:"));
                    ejercicioDos(numProductos);
                }
                case ("Ejercicio #3") -> {
                    // *** *** Ejercicio #03 *** ***//
                    mensaje("""
                            Una f\u00e1brica necesita un programa en Java para calcular el costo total de
                            producci\u00f3n, con una funci\u00f3n que recibe los costos de materiales, mano de
                            obra y gastos generales, y devuelve el costo total de producci\u00f3n.""");
                    
                    double[] ejercicio3 = new double[3];
                    ejercicio3[0] = Double.parseDouble(m("Ingrese el costo por materiales"));
                    ejercicio3[1] = Double.parseDouble(m("Ingrese el costo por mano de obra "));
                    ejercicio3[2] = Double.parseDouble(m("Ingrese el costo por gastos generales"));

                    ejercicioTres(ejercicio3);
                }
                case ("Ejercicio #4") -> {
                    //*** *** Ejercicio #04 *** ***//
                    mensaje("");
                    
                    int num = Integer.parseInt(m("Ingrese el numero de departamentos"));
                    ejercicioCuatro(num);
                }
                case ("Ejercicio #5") -> {
                    //*** *** Ejercicio #05 *** ***//
                    mensaje("""
                            Una empresa de tecnolog\u00eda necesita un programa en Java para calcular la
                            depreciaci\u00f3n anual de un activo, con una funci\u00f3n que recibe el valor inicial,
                            el valor residual y la vida \u00fatil de un activo, y devuelve la depreciaci\u00f3n
                            anual utilizando el m\u00e9todo de l\u00ednea recta.""");
                    
                    double[] ejercicio5 = new double[3];
                    ejercicio5[0] = Double.parseDouble(m("Ingrese el valor original del producto:"));
                    ejercicio5[1] = Double.parseDouble(m("Ingrese el valor residual del producto:"));
                    ejercicio5[2] = Double.parseDouble(m("Ingrese la vida util del producto en años:"));

                    ejercicioCinco(ejercicio5);
                }
                case ("Ejercicio #6") -> {
                    //*** *** Ejercicio #06 *** ***//
                    mensaje("""
                            Un asesor financiero necesita un programa en Java para calcular la rentabilidad de
                            una inversi\u00f3n, con una funci\u00f3n que recibe el capital inicial, la tasa de inter\u00e9s anual
                            y el n\u00famero de a\u00f1os, y devuelve el valor futuro de la inversi\u00f3n utilizando inter\u00e9s
                            compuesto.""");
                    
                    double[] ejercicio6 = new double[3];
                    ejercicio6[0] = Double.parseDouble(m("Ingrese el valor del capital inicial:"));
                    ejercicio6[1] = Double.parseDouble(m("Ingrese el valor del porsentaje de rentabilidad anual:"));
                    ejercicio6[2] = Double.parseDouble(m("Ingrese el tiempo en años en el que desea hacer la inversion:"));

                    ejercicioSeis(ejercicio6);
                }
                case ("Ejercicio #7") -> {
                    //*** *** Ejercicio #07 *** ***//
                    mensaje("""
                            La empresa WorkHours Inc. necesita un programa en Java para generar un informe de horas 
                            extras trabajadas por empleados, con una función que recibe los nombres de empleados y las 
                            horas extras trabajadas por cada uno, y genera un informe detallado de las horas extras.""");
                    
                    int empleados = Integer.parseInt(m("Numero de empleados a evaluar:"));
                    ejercicioSiete(empleados);
                }
                case ("Ejercicio #8") -> {
                    //*** *** Ejercicio #08 *** ***//
                    mensaje("""
                            Una constructora necesita un programa en Java para calcular el costo de un proyecto de 
                            construcción, con una función que recibe los costos de materiales, mano de obra y equipos, y
                            devuelve el costo total del proyecto.""");
                    
                    double[] ejercicio8 = new double[3];

                    ejercicio8[0] = Double.parseDouble(m("Ingrese el costo por materiales."));
                    ejercicio8[1] = Double.parseDouble(m("Ingrese el costo por mano de obra."));
                    ejercicio8[2] = Double.parseDouble(m("Ingrese el costo por equipos."));

                    ejercicio8cho(ejercicio8);
                }
                case ("Ejercicio #9") -> {
                    //*** *** Ejercicio #09 *** ***//
                    mensaje("""
                            Una empresa de manufactura necesita un programa en Java para calcular la nómina semanal 
                            de los empleados, con una función que recibe las horas trabajadas y el salario por hora de 
                            varios empleados, y devuelve la nómina total de la semana.""");
                    
                    int num = Integer.parseInt(m("Numero de empleados a evaluar:"));
                    ejercicioNueve(num);
                }
                case ("Ejercicio #10") -> {
                    //*** *** Ejercicio #10 *** ***//
                    mensaje("""
                            Una empresa de mensajería necesita un programa en Java para calcular el tiempo estimado
                            de entrega de un paquete, con una función que recibe la distancia y la velocidad promedio
                            del vehículo de entrega, y devuelve el tiempo estimado de entrega.""");
                    
                    double distancia = Double.parseDouble(m("Ingrese la distancia en Km"));
                    double velocidad = Double.parseDouble(m("Ingrese la velocidad promedio en Km/h"));

                    ejercicioDies(distancia, velocidad);
                }
                case ("Ejercicio #11") -> {
                    //*** *** Ejercicio #11 *** ***//
                    mensaje("""
                            Una empresa de transporte necesita un programa en Java para calcular el consumo de
                            combustible de una flota de vehículos, con una función que recibe la distancia recorrida y
                            el combustible consumido por varios vehículos, y devuelve el consumo promedio de
                            combustible de la flota.""");
                    
                    double distancia = Double.parseDouble(m("Ingrese la distancia en Km"));
                    int carabana = Integer.parseInt(m("Ingrese el numero de vehiculos \nque conformaban la carabana"));
                    double velocidad = Double.parseDouble(m("Ingrese el consumo total en galones"));

                    ejercicioOnce(distancia, carabana, velocidad);
                }
                case ("Ejercicio #12") -> {
                    //*** *** Ejercicio #12 *** ***//
                    mensaje("""
                            Una liga deportiva necesita un programa en Java para determinar el equipo con más puntos
                            en una liga, con una función que recibe los puntos de varios equipos y determina cuál tiene
                            la mayor cantidad de puntos.""");
                    
                    int num = Integer.parseInt(m("Cuantos equipos participaron"));
                    ejercicioDoce(num);
                }
                case ("Ejercicio #13") -> {
                    //*** *** Ejercicio #13 *** ***//
                    mensaje("""
                            Una universidad necesita un programa en Java para calcular el rendimiento académico de
                            un estudiante, con una función que recibe las calificaciones de un estudiante en varias
                            asignaturas y devuelve su promedio.""");
                    
                    int num = Integer.parseInt(m("Ingrese el numero de notas que va a evaluar"));
                    ejercicioDoceMasUno(num);
                }
                case ("Ejercicio #14") -> {
                    //*** *** Ejercicio #14 *** ***//
                    mensaje("""
                            Una tienda en línea necesita un programa en Java para determinar el mejor producto
                            basado en las opiniones de los clientes, con una función que recibe las calificaciones de
                            varios productos y determina cuál tiene la mejor calificación promedio.""");
                    
                    int num = Integer.parseInt(m("Cuantos productos desea calificar"));
                    ejercicioCatorse(num);
                }
                case ("Ejercicio #15") -> {
                    //*** *** Ejercicio #15 *** ***//
                    mensaje("""
                            Un fabricante de electrodomésticos necesita un programa en Java para calcular la
                            eficiencia energética de un electrodoméstico, con una función que recibe el consumo
                            de energía y el rendimiento de varios electrodomésticos, y devuelve la eficiencia
                            energética de cada uno.""");
                    
                    int electrodomesticos = Integer.parseInt(m("Ingrese el numero de electrodomestico a evaluar"));
                    ejercicioQuinse(electrodomesticos);
                }
                case ("Ejercicio #16") -> {
                    //*** *** Ejercicio #16 *** ***//
                    mensaje("""
                            Una empresa de organización de eventos necesita un programa en Java para calcular
                            el costo de un evento corporativo, con una función que recibe los costos de alquiler,
                            catering, entretenimiento y otros gastos, y devuelve el costo total del evento.""");
                    
                    double[] ejercicio16 = new double[4];
                    ejercicio16[0] = Double.parseDouble(m("Costo de alquiler: "));
                    ejercicio16[1] = Double.parseDouble(m("Costo de catering: "));
                    ejercicio16[2] = Double.parseDouble(m("Costo de entretenimiento: "));
                    ejercicio16[3] = Double.parseDouble(m("Costo de otros casos: "));

                    ejercicioDieciseis(ejercicio16);
                }
                case ("Ejercicio #17") -> {
                    //*** *** Ejercicio #17 *** ***//
                    mensaje("""
                            Un centro de atención al cliente necesita un programa en Java para determinar el nivel
                            de satisfacción del cliente, con una función que recibe las puntuaciones de satisfacción
                            de varios clientes y devuelve el promedio de satisfacción.""");
                    
                    int num = Integer.parseInt(m("Ingrese el numero de encuestas"));
                    ejercicioDiecisiete(num);
                }
                case ("Ejercicio #18") -> {
                    //*** *** Ejercicio #18 *** ***//
                    mensaje("""
                            Un departamento de ventas necesita un programa en Java para calcular el porcentaje
                            de cumplimiento de metas, con una función que recibe la cantidad de metas cumplidas
                            y el total de metas establecidas, y devuelve el porcentaje de cumplimiento.""");
                    
                    int metas = Integer.parseInt(m("Ingrese el numero de metas"));
                    int cumplidas = Integer.parseInt(m("Metas cumplidas"));

                    ejercicioDieci8cho(metas, cumplidas);
                }
                case ("Ejercicio #19") -> {
                    //*** *** Ejercicio #19 *** ***//
                    mensaje("""
                            Un centro de distribución necesita un programa en Java para determinar la capacidad
                            restante de almacenamiento, con una función que recibe la capacidad total del almacén
                            y la cantidad de espacio ocupado, y devuelve la capacidad restante.""");
                    
                    double capasidad = Double.parseDouble(m("Ingrese la capasidad del almaven"));
                    double usado = Double.parseDouble(m("Ingrese el espacio utilizado"));

                    ejercicioDieciNueve(capasidad, usado);
                }
                case ("Ejercicio #20") -> {
                    //*** *** Ejercicio #20 *** ***//
                    mensaje("""
                            Una empresa de taxis necesita un programa en Java para calcular el costo por 
                            kilómetro de un servicio de taxi, con una función que recibe la distancia recorrida y la 
                            tarifa total, y devuelve el costo por kilómetro del viaje.""");
                    
                    double x = Double.parseDouble(m("Ingrese la distancia recorrida."));
                    double tarifa = Double.parseDouble(m("Costo total del servicio."));

                    ejercicioVeinte(x, tarifa);
                }
                default ->
                    throw new AssertionError();
            }
        }
    }

    // *** *** *** *** *** *** METODOS (OPERACIONES) *** *** *** *** *** *** //
    //
    public static double[] crearLista(int limite, String texto) {
        double[] lista = new double[limite];
        for (int i = 0; i < limite; i++) {
            lista[i] = Double.parseDouble(m(texto + (i + 1)));
        }
        return lista;
    }

    public static double sumas(double[] lista) {
        double suma = 0;
        for (double item : lista) {
            suma += item;
        }
        return suma;
    }

    public static String[] elementoMay(double[] lista) {
        double mayor = lista[0];
        int i = 0;
        for (double item : lista) {
            mayor = (item > mayor) ? item : mayor;
            i++;
        }
        return new String[]{String.valueOf(mayor), String.valueOf(i)};
    }

    // *** *** *** *** *** *** METODOS (EJERCICIOS)*** *** *** *** *** *** //
    //
    //Ejercicio #1
    public void ejercicioUno(float salario, float retencion) {

        float anual = salario * 12;
        float retencionA = (salario * (retencion / 100)) * 12;

        mensaje("El salario mensual es de: $" + anual + "\nLa Retencion en el año es de: $" + retencionA);
    }

    //Ejercicio #2
    public void ejercicioDos(int num) {
        int stock = Integer.parseInt(m("Ingrese la cantidad minima de Stock:"));
        double[] lista = crearLista(num, "Ingrese la cantidad disponible del producto #");
        String mensaje = "";

        int i = 0;
        for (double item : lista) {
            mensaje += (item > stock)
                    ? "El producto #" + (i + 1) + " No requiere pedido. \n"
                    : "El producto #" + (i + 1) + " Requiere que se haga un pedido. \n";
            i++;
        }
        mensaje(mensaje);
    }

    //Ejercicio #3
    public void ejercicioTres(double[] lista) {
        double cosTotal = sumas(lista);
        mensaje("El costo total de produción es de: $" + String.format("%.2f", cosTotal));
    }

    //Ejercicio #4
    public void ejercicioCuatro(int num) {
        double[] lista = crearLista(num, "Ingrese la ganancia trimestral del departamento #");
        String[] mayor = elementoMay(lista);

        mensaje("La ganancia trimestras mas alta la tubo \nEl departamento #" + mayor[1] + " con un valor: $" + mayor[0]);
    }

    //Ejercicio #5
    public void ejercicioCinco(double[] lista) {
        double depresion = (lista[0] - lista[1]) / lista[2];

        mensaje("La deprecion anual de este producto \nes de: $" + String.format("%.2f", depresion) + " anual");
    }

    //Ejercicio #6
    public void ejercicioSeis(double[] lista) {
        double capitalInicial = lista[0];
        double porsentaje = lista[1];
        double ahno = lista[2];

        double tasaInteres = (porsentaje / 100);
        double valorFuturo = capitalInicial * Math.pow(1 + (tasaInteres / 1), (1 * ahno));

        mensaje("El valor futuro de la inversion es de: $" + String.format("%.2f", valorFuturo));
    }

    //Ejercicio #7
    public void ejercicioSiete(int num) {
        String texto = "";
        double extras;

        for (int i = 0; i < num; i++) {
            String nombre = m("Ingrese el nombre del empleado #" + (i + 1));
            int horas = Integer.parseInt(m("Numero de horas de " + nombre));

            extras = (horas > 48) ? horas - 48 : 0;
            texto += "Trabajador: " + nombre + " // Horas: " + horas + " // Horas Extras: " + String.format("%.0f", extras) + "\n";
        }
        mensaje(texto);
    }

    //Ejercicio #8
    public void ejercicio8cho(double[] lista) {
        double cosTotal = sumas(lista);
        mensaje("El costo total de produción es de: $" + String.format("%.2f", cosTotal));
    }

    //Ejercicio #9
    public void ejercicioNueve(int num) {
        double[] horas = crearLista(num, "Ingrese el numero de horas semanales \nPara el trabajador #:");
        double[] valHora = crearLista(num, "Ingrese el valor por hora \nPara el trabajador #:");
        String lista = "";

        for (int i = 0; i < num; i++) {
            double salario = horas[i] * valHora[i];
            lista += ("Empleado #" + (i + 1) + " // Horas: " + horas[i] + " // Salario: " + String.format("%.3f", salario) + "\n");
        }
        mensaje(lista);
    }

    //Ejercicio #10
    public void ejercicioDies(double x, double v) {
        double t = x / v;
        mensaje("El tiempo promedio de espera es: " + String.format("%.1f", t) + " horas.");
    }

    //Ejercicio #11
    public void ejercicioOnce(double x, int vehiculos, double combustible) {
        double consumo = (combustible / vehiculos) / x;

        mensaje("El consumo promedio por vehiculo \nes de alrededor de :" + String.format("%.2f", consumo) + "galones");
    }

    //Ejercicio #12
    public void ejercicioDoce(int num) {
        double[] lista = crearLista(num, "Ingrese los puntos del equipo #");
        String[] mayor = elementoMay(lista);

        mensaje("El mayor puntaje lo presenta \nEl equipo #" + mayor[1] + " con:" + mayor[0] + "puntos.");
    }

    //Ejercicio #13
    public void ejercicioDoceMasUno(int num) {
        double[] lista = crearLista(num, "Ingrese el valor de la nota #");
        double suma = sumas(lista);

        double promedio = suma / num;

        mensaje("El Promedio de otas es de :" + String.format("%.1f", promedio));
    }

    //Ejercicio #14
    public void ejercicioCatorse(int num) {

        double[] lista = crearLista(num, "Da una calificacion al producto #");
        String[] mayor = elementoMay(lista);

        mensaje("El articulo con mejor calificacion es el #" + mayor[1] + " \ncon una puntiacion de: " + mayor[0]);
    }

    //Ejercicio #15
    public void ejercicioQuinse(int num) {
        double kWh = Double.parseDouble(m("Ingrese el consumo total en kWh"));
        double[] lista = crearLista(num, "Ingrese el rendimiento del producto #");

        String tabla = "";
        int i = 0;
        for (double item : lista) {
            double eficiencia = (item / kWh) * 100;
            tabla += "El producto #" + (i + 1) + " tiene una eficiencia energetica de: " + String.format("%.2f", eficiencia) + "%\n";
            i++;
        }
        mensaje(tabla);
    }

    //Ejercicio #16
    public void ejercicioDieciseis(double[] gastos) {
        double valTotal = sumas(gastos);

        mensaje("El eventoc corporativo tiene un valor \nde: " + String.format("%.3f", valTotal));
    }

    //Ejercicio #17
    public void ejercicioDiecisiete(int num) {
        double[] lista = crearLista(num, "Del 1 al 10, como califica el servico \nSiendo 1 'muy malo' y 10 'muy bueno'.\nEncuesta #");
        double promedio = sumas(lista) / num;

        mensaje("El valor promedio del servicio es de: " + String.format("%.0f", promedio));
    }

    //Ejercicio #18
    public void ejercicioDieci8cho(int metas, int cumplidas) {
        double porcentaje = (cumplidas * 100) / metas;

        mensaje("El porcentaje de metas cumplidas es de: " + String.format("%.0f", porcentaje) + "%");
    }

    //Ejercicio #19
    public void ejercicioDieciNueve(double espacio, double ocupado) {
        double disponible = espacio - ocupado;

        mensaje("El espacio disponible es de: " + String.format("%.2f", disponible));
    }

    //Ejercicio #20
    public void ejercicioVeinte(double x, double presio) {
        double km = presio / x;

        mensaje("El valor por km recorrido es de: $" + String.format("%.3f", km));
    }
}
