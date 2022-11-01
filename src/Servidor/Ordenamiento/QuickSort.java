package Servidor.Ordenamiento;

public class QuickSort {
    /* This function takes last element as pivot,
       places the pivot element at its correct
       position in sorted array, and places all
       smaller (smaller than pivot) to left of
       pivot and all greater elements to right
       of pivot */

    /***
     * Esta funcion hace la particion del arreglo
     * @param arreglo arreglo que se desea ordenar
     * @param izquierda
     * @param derecha
     * @return
     */
    public int particion(String arreglo[], int izquierda, int derecha) {
        // Elegimos el pivote, es el primero
        String pivote = arreglo[izquierda];
        // Ciclo infinito
        while (true) {
            // Mientras cada elemento desde la izquierda esté en orden (sea menor que el
            // pivote) continúa avanzando el índice
            while (arreglo[izquierda].compareTo(pivote) < 0) {
                izquierda++;
            }
            // Mientras cada elemento desde la derecha esté en orden (sea mayor que el
            // pivote) continúa disminuyendo el índice
            while (arreglo[derecha].compareTo(pivote) > 0) {
                derecha--;
            }

            if (izquierda >= derecha) {
                // Indicar "en dónde nos quedamos" para poder dividir el arreglo de nuevo
                // y ordenar los demás elementos
                return derecha;
            } else {

                String temporal = arreglo[izquierda];
                arreglo[izquierda] = arreglo[derecha];
                arreglo[derecha] = temporal;
      /*
      Ya intercambiamos, pero seguimos avanzando los índices una vez más
      */
                izquierda++;
                derecha--;
            }
            // El while se repite hasta que izquierda >= derecha
        }
    }

    /***
     * Esta funcion es la de divide y venceras
     * @param arreglo
     * @param izquierda
     * @param derecha
     */
    public void quicksort(String arreglo[], int izquierda, int derecha) {
        if (izquierda < derecha) {
            int indiceParticion = particion(arreglo, izquierda, derecha);
            quicksort(arreglo, izquierda, indiceParticion);
            quicksort(arreglo, indiceParticion + 1, derecha);
        }
    }

    /***
     * Esta funcion va a imprimir  el arreglo
     * @param arr
     */
    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }//printArray

}//fin clase

