package Servidor;

import Servidor.Lectores.LectorDOCX;
import Servidor.Lectores.LectorPDF;
import Servidor.Lectores.LectorTXT;
import Servidor.Ordenamiento.BubbleSort;
import Servidor.Ordenamiento.QuickSort;
import Servidor.Ordenamiento.RadixSort;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class Servidor {
    LectorPDF lectorPDF = new LectorPDF();
    LectorTXT lectorTXT = new LectorTXT();
    LectorDOCX lectorDOCX = new LectorDOCX();
    RadixSort radixSort = new RadixSort();
    BubbleSort bubbleSort = new BubbleSort();

    /**
     * Este metodo hace la indización de los documentos
     * @throws FileNotFoundException
     */
    public void buscarPalabras(String palabra, String documento1, String documento2, String documento3) throws IOException, InvalidFormatException {
        lectorTXT.indexarTXT(palabra,documento1);
        lectorPDF.indexarPDF(palabra,documento2);
        lectorDOCX.indexarDOCX(palabra, documento3);
    }//bucarPalabra


    /***
     * Este metodo reune todas las cantidades de palabras de los documentos para ordenarlas
     */
    public void ordenamientoCantidadPalabras() {
        //TODO Hacer el ordenamiento de los archivos
        lectorPDF.getContadorPalabrasPDF();
        lectorDOCX.getContadorPalabrasDOCX();
        lectorTXT.getCantidadPalabrasTXT();

        System.out.println(lectorTXT.getCantidadPalabrasTXT());

        int[] tamanos = new int[]{lectorPDF.getContadorPalabrasPDF(),lectorDOCX.getContadorPalabrasDOCX(),lectorTXT.getCantidadPalabrasTXT()};
        radixSort.radixSort(tamanos);
        radixSort.printArray(tamanos);

    }//ordenamiento

    /***
     * Este metodo obtiene todos los ordenamientos por fehcas y los ordena
     */
    public void ordenamientoPorFecha(){
        lectorPDF.getFechaPDF();
        lectorDOCX.getFechaDOCX();
        lectorTXT.getFechaTXT();

        String[] fechas = new String[]{lectorPDF.getFechaPDF(), lectorDOCX.getFechaDOCX(), lectorTXT.getFechaTXT()};
        int n = fechas.length;
        bubbleSort.sortStrings(fechas,n);
        for (int i = 0; i < n; i++) {
            JOptionPane.showMessageDialog(null, "Documento " + (i + 1) + " es " + fechas[i]);
        }
    }//ordenamientoPorFecha
    private void resultados() {
        //TODO mostrasr los resultados de la busqueda


    }//ordenamiento
}//fin clase servidor
