package Servidor.Lectores;

import javax.swing.*;
import java.io.*;
import java.util.Scanner;

public class LectorTXT {
    File f;
    FileReader lectorArchivo;
    String resultado;
    private  int lineasTotales;
    String lineaLeida;
    private  int totalCoincidencias;

    private String extiste;

    public String leerGraficp(){
        File f;
        javax.swing.JFileChooser j = new javax.swing.JFileChooser();
        j.showOpenDialog(j);
        String path = j.getSelectedFile().getAbsolutePath();
        String lectura = "";
        f = new File(path);
        try {
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);

            String aux;
            while ((aux = br.readLine()) != null)
                lectura = lectura + aux + "\n";

        }catch(IOException e){}
        return lectura;
    }

    public String buscarPalabra(File archivo, String palabra) {
        try {
            // SI EXISTE EL ARCHIVO
            if(archivo.exists()) {
                // ABRE LECTURA DEL ARCHIVO
                BufferedReader leerArchivo = new BufferedReader(new FileReader(archivo));
                // LINEA LEIDA
                // MIENTRAS LA LINEA LEIDA NO SEA NULL
                while((lineaLeida = leerArchivo.readLine()) != null) {
                    lineasTotales = lineasTotales + 1;
                    String[] palabras = lineaLeida.split(" ");
                    for(int i = 0 ; i < palabras.length ; i++) {
                        if(palabras[i].equalsIgnoreCase(palabra)) {
                            totalCoincidencias = totalCoincidencias + 1;
                            System.out.println(lineaLeida);
                            System.out.println("En la linea: " + lineasTotales + " se encontro la palabra a buscar: " + palabra);
                            System.out.println("");
                        }
                    }
                }

            }

            resultado = "En total se encotro la palabra: " + palabra + ", " + totalCoincidencias + " Veces en el archivo";

        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
        return resultado;
    }


    public void BuscarPalabraStack(String palabra, String documento) throws FileNotFoundException {
        JOptionPane.showMessageDialog(null,"hola");
        int val = 0;

            Scanner file = new Scanner(new File(documento));

            while(file.hasNextLine()){
                String line = file.nextLine();
                if(line.indexOf(palabra) != -1){
                    JOptionPane.showMessageDialog(null,"Esa palabra si está en el documento");
                    val = 1;
                    break;
                }else{
                    val = 0;
                    continue;
                }
            }
            if(val == 0){
                JOptionPane.showMessageDialog(null,"Esa palabra no está en el documento");
            }



    }//BuscarPalabraStack

}//fin clase
