package Servidor.Ordenamiento;

public class BubbleSort {
    static int MAX = 100;

    /***
     * Esta funcion ordena un array de forma bubble
     * @param arr el arreglo que se desea ordenar
     * @param n el tamaño de ese arreglo
     */
    public void sortStrings(String[] arr, int n) {
        String temp;

        // Sorting strings using bubble sort
        for (int j = 0; j < n - 1; j++) {
            for (int i = j + 1; i < n; i++) {
                if (arr[j].compareTo(arr[i]) > 0) {
                    temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
    }


}

