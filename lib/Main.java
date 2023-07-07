public class Main {
    public static void main(String[] args) {
        Lista_Enlazada list = new Lista_Enlazada();

        // c. Inserción de nodos
        list.insert(1);
        list.insert(2);
        list.insert(3);

        // d. Impresión de la lista
        list.printList();

        // b. Recorrido y búsqueda
        System.out.println(list.search(2));
        System.out.println(list.search(4));
    }
}
