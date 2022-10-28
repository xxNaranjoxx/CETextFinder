package Servidor.Lectores;

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


    //javax.swing.JFileChooser j = new javax.swing.JFileChooser();
    //j.showOpenDialog(j);
    //String path = j.getSelectedFile().getAbsolutePath();

    /***
     * Este metodo busca la palbra en el documento txt
     * @param palabra
     * @param documento
     * @throws FileNotFoundException
     */
    public void BuscarPalabraStack(String palabra, String documento) throws FileNotFoundException {
        int val = 0;
        Scanner file = new Scanner(new File(documento));

        while (file.hasNextLine()) {
            String line = file.nextLine();
            if (line.indexOf(palabra) != -1) {
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
    public void agregarPalabrasArbolTXT() throws FileNotFoundException {
        //Declare File object
        File file = new File("/home/javatpoint/Desktop/ABHISHEK/AngularJS/Index/abc.txt");
        //Initialize the scanner
        Scanner scan = new Scanner(file);
        // iterate through the file line by line
        while(scan.hasNextLine()){
            //Print the contents of a file by line
            System.out.println(scan.next());
        }
        scan.close();
    }//agregarPalabrasArbolTXT

    /***
     * Este metodo carga las palabras del arbol
     */
    public void cargarPalabrasArbol() {
       /* Path archivo = Paths.get("C:/ruta...");

        try (Stream<String> lines = Files.lines(archivo)){
            var map = lines.collect(toMap(String::hashCode, e -> e));
            var arbol = new TreeMap<>(map);//este es el arbol binario
        }
        catch (Exception e){
            e.printStackTrace();
        }*/
    }//

}//fin clase
