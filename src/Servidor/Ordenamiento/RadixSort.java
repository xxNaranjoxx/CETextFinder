package Servidor.Ordenamiento;

import java.io.*;
import java.util.*;

public class RadixSort {
    /***
     * Esta funcion ordena un arregl de la forma radix
     * @param arr arreglo que se desea ordenar
     */
    public void radixSort(int[] arr) {
        int digit = getMaxDigit (arr); // obtiene el número máximo de dígitos
        for (int i = 0; i < digit; i++) {
            bucketSort (arr, i); // ordena bucketSort por dígitos veces
        }//for
    }//radixSort

    /**
     * Esta funcion obtiene el digito maximo
     * @param arr pasamos por parametro el arreglo
     * @return
     */
    public int getMaxDigit(int[] arr) {
        int digit = 1; // el valor predeterminado es solo un dígito
        int base = 10; // Cada dígito adicional en decimal significa que su valor es 10 veces mayor
        for (int i : arr) {
            while (i > base) {
                digit++;
                base *= 10;
            }
        }
        return digit;
    }

    /***
     * Esta funcion va ordenando conrespecto a su numeros
     * @param arr
     * @param digit
     */
    public void bucketSort(int[] arr, int digit) {
        int base = (int) Math.pow(10, digit);
        // init buckets
        ArrayList<ArrayList<Integer>> buckets = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i <10; i ++) {// Solo hay diez números del 0 al 9, así que prepara diez cubos
            buckets.add(new ArrayList<Integer>());
        }
        // sort
        for (int i : arr) {
            int index = i / base % 10;
            buckets.get(index).add(i);
        }
        // output: copy back to arr
        int index = 0;
        for (ArrayList<Integer> bucket : buckets) {
            for (int i : bucket) {
                arr[index++] = i;
            }
        }
    }

    /***
     * Esta funcion imprime
     * @param arr se le pasa por parametro el arreglo
     */
    public void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

}

