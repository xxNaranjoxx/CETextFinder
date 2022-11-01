package Servidor.Lectores;

import Servidor.Arboles.Binario.ArbolBinario;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class LectorTXT {
    private String fechaTXT;
    int cantidadPalabrasTXT;
    ArbolBinario arbolBinarioTXT = new ArbolBinario();

    //javax.swing.JFileChooser j = new javax.swing.JFileChooser();
    //j.showOpenDialog(j);
    //String path = j.getSelectedFile().getAbsolutePath();


    /***
     * Este metodo indexa todos los documentos de tipo TXT
     * @param palabra se le pasa por parametro la palabra que se desea buscar
     * @param documento se le pasa por parametro el documento
     * @throws FileNotFoundException
     */
    public void indexarTXT(String palabra,String documento) throws FileNotFoundException {
        //Declare File object
        File file = new File(documento);

        //obtener la fecha de modificacion
        long ms = file.lastModified();

        Date date = new Date(ms);
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);

        String dia = Integer.toString(calendar.get(Calendar.DATE));
        String mes = Integer.toString(calendar.get(Calendar.MONTH));
        String annio = Integer.toString(calendar.get(Calendar.YEAR));
        String hora = Integer.toString(calendar.get(Calendar.HOUR_OF_DAY));
        String minuto = Integer.toString(calendar.get(Calendar.MINUTE));
        String segundo = Integer.toString(calendar.get(Calendar.SECOND));

        fechaTXT = dia + mes + annio + hora + minuto + segundo;

        System.out.println(fechaTXT);

        //Initialize the scanner
        Scanner scan = new Scanner(file);
        // iterate through the file line by line
        while(scan.hasNext()){
            arbolBinarioTXT.insertar(scan.next());
            cantidadPalabrasTXT ++;

        }
        scan.close();
        System.out.println(cantidadPalabrasTXT);
        arbolBinarioTXT.existe(palabra);
    }//agregarPalabrasArbolTXT


    /***
     * Setters y getters para poder utilizarlos
     * @return
     */
    public String getFechaTXT() {
        return fechaTXT;
    }

    public void setFechaTXT(String fechaTXT) {
        this.fechaTXT = fechaTXT;
    }

    public int getCantidadPalabrasTXT() {
        return cantidadPalabrasTXT;
    }

    public void setCantidadPalabrasTXT(int cantidadPalabrasTXT) {
        this.cantidadPalabrasTXT = cantidadPalabrasTXT;
    }
}//fin clase
