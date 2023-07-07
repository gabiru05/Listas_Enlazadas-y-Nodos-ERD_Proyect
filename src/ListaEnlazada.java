import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ListaEnlazada {
    private Nodo cima;
    private int size;

    public ListaEnlazada() {
        cima = null;
        size = 0;
    }

    // a. Crear nodos
    private class Nodo {
        public int valor;
        public Nodo siguiente;

        public Nodo(int valor) {
            this.valor = valor;
            siguiente = null;
        }
    }

    // b. Recorrido y búsqueda
    public boolean buscar(int valor) {
        Nodo actual = cima;
        while (actual != null) {
            if (actual.valor == valor) {
                return true;

            }
            actual = actual.siguiente;
        }
        return false;
    }

    // c. Inserción de nodos
    public void insertar(int valor) {
        Nodo nuevoNodo = new Nodo(valor);
        if (cima == null) {
            cima = nuevoNodo;
        } else {
            Nodo actual = cima;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevoNodo;
        }
        size++;
    }

    // d. Impresión de la lista simple
    public void imprimir() {
        Nodo actual = cima;

        while (actual != null) {
            System.out.println(actual.valor);
            actual = actual.siguiente;

        }
        System.out.println("Ultimo elemento ^^");
        System.out.println(" ");

    }

    // Impresion de la lista con detalles
    public void imprimir_detalles() {
        Nodo actual = cima;
        int cantidad = 0;
        while (actual != null) {
            cantidad = cantidad + 1;
            if (actual != null && actual.siguiente != null) {
                System.out.println(" ");
                System.out
                        .println("dato " + cantidad + " = " + actual.valor + "     -----direccion Actual-> " + actual);
                System.out.println("direccion del Siguiente dato -> " + actual.siguiente);
            } else {
                System.out
                        .println("dato " + cantidad + " = " + actual.valor + "     -----direccion Actual-> " + actual);
                System.out.println("Siguiente --- Este es el ultimo elemento en la lista");
            }
            actual = actual.siguiente;
            System.out.println(" ");
        }

    }

    // e. Cima o tamaño de la lista
    public int size() {
        return size;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        ListaEnlazada lista = new ListaEnlazada();
        int eleccion;
        int dato;
        boolean continuar = true;

        BufferedReader leer = new BufferedReader(new InputStreamReader(System.in)); // Ya tenemos el "lector"

        while (continuar) {
            System.out.println(" ");
            System.out.println("1) Insertar dato a la lista: ");
            System.out.println("2) Eliminar dato de la lista: ");
            System.out.println("3) Buscar un dato en la lista: ");
            System.out.println("4) Imprimir la lista con detalles: ");
            System.out.println("5) Salir del programa");
            System.out.println("Ingrese Opcion: ");

            eleccion = Integer.parseInt(leer.readLine());

            if (eleccion == 1) {
                System.out.println(" ");
                System.out.println("Ingrese dato:");
                dato = Integer.parseInt(leer.readLine());
                lista.insertar(dato);

                System.out.println("");
                System.out.println("La nueva lista quedo asi:");
                lista.imprimir();

            } else if (eleccion == 2) {

            } else if (eleccion == 3) {
                System.out.println(" ");
                System.out.println("Ingrese dato que desea buscar:");
                dato = Integer.parseInt(leer.readLine());

                if (lista.buscar(dato) == true) {
                    System.out.println(" ");
                    System.out.println("El dato: " + dato + " si esta dentro de la lista");

                } else {
                    System.out.println(" ");
                    System.out.println("El dato: " + dato + " no se encuentra en la lista");
                }
            } else if (eleccion == 4) {
                System.out.println(" ");
                System.out.println("Los datos dentro de la lista son:");
                lista.imprimir_detalles();
                System.out.println(" ");
                System.out.println("La cima es de: " + lista.size());
            } else if (eleccion == 5) {
                break;
            }

            else {
                System.out.println("Ingrese una opcion valida ");
            }

        }
    }
}