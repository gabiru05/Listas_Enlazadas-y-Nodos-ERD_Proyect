
public class Lista_Enlazada {
   public Crear_Nodo cima;

   public Lista_Enlazada() {
      cima = null;
   }

   // a. Crear nodos
   public class Crear_Nodo {
      int dato;
      Crear_Nodo next_dato;

      Crear_Nodo(int d) {
         dato = d;
         next_dato = null;
      }
   }

   // c. Inserción de nodos
   public void insert(int dato) {
      Crear_Nodo newCrear_Nodo = new Crear_Nodo(dato);
      newCrear_Nodo.next_dato = cima;
      cima = newCrear_Nodo;
   }

   // b. Recorrido y búsqueda
   public boolean search(int key) {
      Crear_Nodo current = cima;
      while (current != null) {
         if (current.dato == key) {
            return true;
         }
         current = current.next_dato;
      }
      return false;
   }

   // d. Impresión de la lista
   public void printList() {
      Crear_Nodo current = cima;
      while (current != null) {
         System.out.print(current.dato + " ");
         current = current.next_dato;
      }
      System.out.println();
   }

}
