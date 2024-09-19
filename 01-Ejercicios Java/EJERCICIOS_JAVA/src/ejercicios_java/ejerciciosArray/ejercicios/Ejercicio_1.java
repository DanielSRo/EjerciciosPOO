package ejercicios_java.ejerciciosArray.ejercicios;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.swing.JOptionPane;

public class Ejercicio_1 {

    // *** *** *** *** *** *** ATRIBUTOS CLASE LIBRO *** *** *** *** *** *** //
    private String titulo;
    private String autor;
    private int stock;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    // *** *** *** *** *** *** METODOS (ATAJOS)*** *** *** *** *** *** //
    private static void mensaje(String texto) {
        JOptionPane.showMessageDialog(null, texto);
    }

    private static void con(String text) {
        System.out.println(text);
    }

    private static String m(String texto) {
        return JOptionPane.showInputDialog(texto);
    }

    // *** *** *** *** *** *** DESARROLLO EJERCICIO *** *** *** *** *** *** //
    //*** *** Listas *** ***//
    List<String[]> libros = new ArrayList<>();

    String[] libro1 = {"Cien ahnos de soledad", "Gabriel Garcia Marquez", "3"};
    String[] libro2 = {"1984", "George Orwell", "5"};
    String[] libro3 = {"El amor en los tiempos del colera", "Gabriel Garcia Marquez", "2"};
    String[] libro4 = {"El principito", "Antoine de Saint-Exupery", "4"};
    String[] libro5 = {"Don Quijote de la Mancha", "Miguel de Cervantes", "1"};

    public void ejercicio_1() {
        mensaje("""
                Desarrolla un programa en Java que permita gestionar el inventario de una
                biblioteca. El programa debe:
                \u2022 Declarar e inicializar un array de libros con informaci\u00f3n b\u00e1sica (t\u00edtulo,
                autor, cantidad en stock).
                \u2022 Implementar funcionalidades para mostrar el inventario, agregar
                nuevas copias de libros, prestar libros, buscar libros y ordenar el
                inventario por t\u00edtulo.""");

        String[] servicio = {"Mostrar Inventario", "Agregar", "Prestar Libros", "Buscar Libro", "Ordenar Inventario"};
        String seleccion = (String) JOptionPane.showInputDialog(null, "Seleccione la accion que desea ejecutar", "Biblioteca de libros", JOptionPane.QUESTION_MESSAGE, null, servicio, servicio[0]);

        MtdLibros();
        switch (seleccion) {
            case ("Mostrar Inventario") -> {
                MtdInventario();
            }
            case ("Agregar") -> {
                MtdAgregar();
            }
            case ("Prestar Libros") -> {
                MtdPrestar();
            }
            case ("Buscar Libro") -> {
                MtdBuscar();
            }
            case ("Ordenar Inventario") -> {
                MtdOrdenar();
            }
            default ->
                throw new AssertionError();
        }
    }

    // *** *** *** *** *** *** METODOS  *** *** *** *** *** *** //
    private void MtdLibros() {
        libros.add(libro1);
        libros.add(libro2);
        libros.add(libro3);
        libros.add(libro4);
        libros.add(libro5);
    }

    public void MtdInventario() {
        con("*** *** *** *** *** *** INVENTARIO *** *** *** *** *** ***\n");
        for (String[] libro : libros) {
            con("Libro: " + libro[0] + "\nAutor: " + libro[1] + "\nStock: " + libro[2]);
            con("\n// *** *** *** *** *** //");
        }
        con("\n** *** *** *** *** *** *** *** *** *** *** *** *** *** *** **");
    }

    public void MtdAgregar() {
        titulo = m("Ingrese el titulo del libro:");
        autor = m("Ingrese el numbre dell autor:");
        stock = Integer.parseInt(m("Cuantas copias desea ingresar:"));

        String[] libroA = {titulo, autor, String.valueOf(stock)};
        libros.add(libroA);

        MtdInventario();
    }

    public void MtdPrestar() {
        String tituloLib = m("Ingrese el nombre del libro que desea solicitar como prestamo");

        for (String[] item : libros) {
            if (tituloLib.equals(item[0])) {
                int stockLib = Integer.parseInt(item[2]);
                if (stockLib != 0) {
                    item[2] = String.valueOf(stockLib - 1);

                    mensaje("Usted selecciono el libro"
                            + "\nTitulo: " + item[0]
                            + "\nAutor: " + item[1]
                            + "\nRestan: " + item[2] + " ejemplares.");
                }
                break;
            }
        }
        MtdInventario();
    }

    public void MtdBuscar() {
        String tituloLib = m("Ingrese el nombre del libro que desea buscar");

        for (String[] item : libros) {
            if (tituloLib.equals(item[0])) {
                mensaje("El libro solicitado concuerda con el siguiente:"
                        + "\nTitulo: " + item[0]
                        + "\nAutor: " + item[1]
                        + "\nRestan: " + item[2] + " ejemplares.");
            }
            break;
        }
    }

    public void MtdOrdenar() {
//        Collections.sort //Este método se utiliza para ordenar una lista en Java. (lista, comparador)
//                (libros, new Comparator<String[]>() { //Se crea un nuevo comparador
//
//                    public int compare //es un método que compara dos cadenas lexicográficamente
//                            (String[] libro1, String[] libro2) {
//                        return libro1[0].compareTo(libro2[0]); //Compara los títulos de dos libros y devuelve un valor entero que indica su orden.
//                    }
//                });
        Collections.sort(libros, (String[] libro6, String[] libro7) -> libro6[0].compareTo(libro7[0]));
        MtdInventario();
    }
}
