package Servidor.Lectores;

import Servidor.Arboles.Binario.ArbolBinario;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;


public class LectorPDF {


    private String fechaPDF;
    ArbolBinario arbolBinarioPDF = new ArbolBinario();

    private int contadorPalabrasPDF = 50;

    public LectorPDF() {
        this.contadorPalabrasPDF = 0;
    }//Constructor

    /***
     * Esta funcion indexa todos los documentos de tipo PDF
     * @param palabra se le pasa pr parametro la palabra que se desea buscar en el documento
     * @param documento se le pasa por parametro el documento que se quiere bucar
     * @throws IOException
     */
    public void indexarPDF(String palabra, String documento) throws IOException {
        String texto = "";

        File file = new File(documento);

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

        fechaPDF = dia + mes + annio + hora + minuto + segundo;
        System.out.println(fechaPDF);

        PdfReader reader = new PdfReader(String.valueOf(file));

        int pages = reader.getNumberOfPages();

        for (int i = 1; i <= reader.getNumberOfPages(); i++) {
            texto = texto + PdfTextExtractor.getTextFromPage(reader,i);

        }

        Scanner in = new Scanner(texto);

        while (in.hasNext()) {
            arbolBinarioPDF.insertar(in.next());
            this.contadorPalabrasPDF ++;
        }
        System.out.println(this.contadorPalabrasPDF);
        arbolBinarioPDF.existe(palabra);
        in.close();


    }//agregarPalabraArbol

    /***
     * Setters y getters para poder utilizarlos
     * @return
     */
    public String getFechaPDF() {
        return fechaPDF;
    }

    public void setFechaPDF(String fechaPDF) {
        this.fechaPDF = fechaPDF;
    }

    public int getContadorPalabrasPDF() {
        return contadorPalabrasPDF;
    }

    public void setContadorPalabrasPDF(int contadorPalabrasPDF) {
        this.contadorPalabrasPDF = contadorPalabrasPDF;
    }
}//fin clase
