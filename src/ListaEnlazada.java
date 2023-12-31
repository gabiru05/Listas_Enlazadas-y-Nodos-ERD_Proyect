

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ListaEnlazada {
    public Nodo cima;
    public int size;

    // creamos la lista con cima null
    public ListaEnlazada() {
        cima = null;
        size = 0;
    }

    // a. Creamos los nodos
    private class Nodo {
        public int valor;
        public Nodo siguiente;

        // asignamos los nodos nuevo y actualizamos el ultimo a null --nueva cima--

        public Nodo(int valor) {
            this.valor = valor;
            siguiente = null;
        }
    }

    // b. Recorrido y búsqueda del dato
    public int buscar(int valor) {
        Nodo actual = cima;
        int index = 0;
        while (actual != null) {
            if (actual.valor == valor) {
                // devolvemo la ubicacion donde fue encontrado
                return index;
            }
            actual = actual.siguiente;
            index++;
        }
        // sino se encontro
        return -1;
    }

    // c. Inserción de nodos
    public void insertar(int valor) {
        Nodo nuevoNodo = new Nodo(valor);
        // añadimos a la cima el ultimo nodo
        if (cima == null) {
            cima = nuevoNodo;
        } else {
            Nodo actual = cima;
            while (actual.siguiente != null) {
                // buscamos el ultimo nodo
                actual = actual.siguiente;
            }
            // asigamos el nodo
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

    // e. Cima o tamaño de la lista y eliminar nodo
    public int size() {
        return size;
    }

    public void eliminar(int valor) {
        // comprobamos si la lista esta vacia en caso de ser verdadero retorna
        if (cima == null) {
            return;
        }
        // en caso la cima sea igual al valor que eliminaremos borramos y continuamos
        // con el siguiente nodo como nueva cima
        if (cima.valor == valor) {
            cima = cima.siguiente;
            size--;
            return;
        }
        // sino esta en la cima lo buscamos y eliminamos remplazandolo por el siguiente
        Nodo actual = cima;
        while (actual.siguiente != null) {
            if (actual.siguiente.valor == valor) {
                actual.siguiente = actual.siguiente.siguiente;
                size--;
                return;
            }
            // como un contador pero de dato revisando hasta encontrar el ultimo ---null--
            actual = actual.siguiente;
        }
    }

    public static void main(String[] args) throws NumberFormatException, IOException {

        // declaracion de lista y otros datos utiles --leer_nombre_variable--
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

                // Imprimir informacion
                System.out.println(" ");
                System.out.println("Ingrese dato:");

                // Ingreso de dato a la lista
                dato = Integer.parseInt(leer.readLine());
                lista.insertar(dato);

                // Imprimir nueva lista
                System.out.println("");
                System.out.println("La nueva lista quedo asi:");
                lista.imprimir();

            } else if (eleccion == 2) {

                // Imprimir informacion
                System.out.println(" ");
                System.out.println("Ingrese dato:");

                // Eliminacion de dato a la lista
                dato = Integer.parseInt(leer.readLine());
                lista.eliminar(dato);

                // Imprimir nueva lista
                System.out.println("");
                System.out.println("La nueva lista quedo asi:");
                lista.imprimir();
            } else if (eleccion == 3) {

                // Imprimir informacion
                System.out.println(" ");
                System.out.println("Ingrese dato que desea buscar:");

                // obtener datos y buscarlo
                dato = Integer.parseInt(leer.readLine());
                int index = lista.buscar(dato);

                // comparar segun resultado y mostrar informacion
                if (index != -1) {
                    System.out.println("El dato: " + dato + " si esta dentro de la lista");
                    System.out.println("Posicion " + (index + 1));
                } else {
                    System.out.println("El dato: " + dato + " no se encuentra en la lista");

                }

            } else if (eleccion == 4) {

                // Imprimir Lista
                System.out.println(" ");
                System.out.println("Los datos dentro de la lista son:");
                lista.imprimir_detalles();

                // mas informacion de la lista --Cima--
                System.out.println(" ");
                System.out.println("La cima es de: " + lista.size());

            } else if (eleccion == 5) {
                // cerrar programa
                break;
            } else {
                // contra error de haber ingresado algun numero mal --solo numeros--
                System.out.println("Ingrese una opcion valida ");
            }

        }
    }
}

/*
 * 3--UTilizamos una lista con nodos para conectarse entre si
 * ademas los puntos principales estan en funciones
 * como eliminar, insertar, imprimir y recorrer el la lista
 * el programa principal o main contiene las distintas acciones del programa
 * donde va ingresando a cada funcion segun la seleccion del usuario
 * 
 */