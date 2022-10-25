package Servidor.Lectores;

import javax.swing.*;
import java.io.*;

public class LectorTXT {
    File f;
    FileReader lectorArchivo;

    public String leer(String nombre){
        try{
            f = new File(nombre);
            lectorArchivo = new FileReader(f);
            BufferedReader br = new BufferedReader(lectorArchivo);
            String hola="";
            String aux = "";

            while(true){
                aux= br.readLine();
                if (aux != null)
                    hola=hola+aux+"\n";
                else
                    break;

            }//while true
            br.close();
            lectorArchivo.close();
            return hola;

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;

    }//leer

    public String leerGraficp(){
        System.out.println("hola");
        File f;
        javax.swing.JFileChooser j = new javax.swing.JFileChooser();
        j.showOpenDialog(j);
        String path = j.getSelectedFile().getAbsolutePath();
        String lectura = "";
        f = new File(path);
        System.out.println("estoy antes del try");
        try {
            System.out.println("estoy dentro del while");
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String aux;
            while ((aux = br.readLine()) != null)
                lectura = lectura + aux + "\n";

        }catch(IOException e){}
        return lectura;
    }
}//fin clase
