package Servidor.Lectores;

import java.io.*;

public class LectorTXT {
    File f;
    FileReader lectorArchivo;
    String resultado;
    private  int lineasTotales;
    String lineaLeida;
    private  int totalCoincidencias;

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

}//fin clase
