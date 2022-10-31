package Servidor.Lectores;

import Servidor.Arboles.Binario.ArbolBinario;

import javax.swing.*;
import java.io.*;
import java.util.Scanner;

public class LectorTXT {
    File f;
    FileReader lectorArchivo;
    String resultado;
    private int lineasTotales;
    String lineaLeida;
    private int totalCoincidencias;
    private String extiste;
    ArbolBinario arbolBinario = new ArbolBinario();

    //javax.swing.JFileChooser j = new javax.swing.JFileChooser();
    //j.showOpenDialog(j);
    //String path = j.getSelectedFile().getAbsolutePath();

    /**
     * Estafunción va a encargarse de contra todas la plabras de los documentos TXT
     * @param documento
     * @throws FileNotFoundException
     */
    public void contarPalabrasTXT(String documento) throws FileNotFoundException {
        File file = new File(documento);

        Scanner scan = new Scanner(file);

        int contadorPalabras = 0;

        while(scan.hasNext()){
            scan.next();
            contadorPalabras = contadorPalabras + 1;
        }

        System.out.println(contadorPalabras);
    }//contarPalabras

    /***
     * Este metodo busca la palbra en el documento txt
     * @param palabra se la pasa por parametro la palabra a buscar
     * @param documento se le pasa por parametro el documento seleccionado
     * @throws FileNotFoundException
     */
    public void buscarPalabraTXT(String palabra, String documento) throws FileNotFoundException {
        int val = 0;
        Scanner file = new Scanner(new File(documento));

        while (file.hasNextLine()) {
            String line = file.nextLine();
            if (line.contains(palabra)) {
                JOptionPane.showMessageDialog(null, "Esa palabra si está en el documento");
                val = 1;
                break;

            } else {
                val = 0;
                continue;
            }
        }
        if (val == 0) {
            JOptionPane.showMessageDialog(null, "Esa palabra no está en el documento");
        }

    }//BuscarPalabraStack

    /***
     * Este metodo agrega las palabras del documento txt al arbol
     * @throws FileNotFoundException
     */
    public void indexarTXT(String documento) throws FileNotFoundException {
        //Declare File object
        File file = new File(documento);
        //Initialize the scanner
        Scanner scan = new Scanner(file);
        // iterate through the file line by line
        while(scan.hasNext()){
            //Print the contents of a file by line
            //System.out.println(scan.next());

            arbolBinario.insertar(scan.next());
        }
        System.out.println("INDEXAR TXT");
        arbolBinario.inorden();
        System.out.println("INDEXAR TXT");
        scan.close();
    }//agregarPalabrasArbolTXT


}//fin clase
