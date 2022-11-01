package Servidor.Lectores;

import Servidor.Arboles.Binario.ArbolBinario;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class LectorDOCX  {

    ArbolBinario arbolBinarioDOCX = new ArbolBinario();
    private int contadorPalabrasDOCX = 1000;
    private String fechaDOCX;

    /***
     * Este metodo va a indexar todos los documentos de tipo docx
     * @param palabra esta es la palabra a buscar
     * @param documento este es el documento que se va a buscar
     * @throws IOException
     * @throws InvalidFormatException
     */
    public void indexarDOCX(String palabra,String documento) throws IOException, InvalidFormatException {

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

        fechaDOCX = dia + mes + annio + hora + minuto + segundo;
        System.out.println(fechaDOCX);

        // load DOCX file
        FileInputStream fis = new FileInputStream(file);
        // open file
        XWPFDocument xwpfDocument = new XWPFDocument(OPCPackage.open(fis));
        // read text
        XWPFWordExtractor ext = new XWPFWordExtractor(xwpfDocument);

        Scanner scanner = new Scanner(ext.getText());

        while (scanner.hasNext()){
            //System.out.println(scanner.next());
            arbolBinarioDOCX.insertar(scanner.next());
            contadorPalabrasDOCX ++;
        }
        System.out.println(contadorPalabrasDOCX);
        arbolBinarioDOCX.existe(palabra);
        scanner.close();
    }//indexarDOCX

    public int getContadorPalabrasDOCX() {
        return contadorPalabrasDOCX;
    }

    public void setContadorPalabrasDOCX(int contadorPalabrasDOCX) {
        this.contadorPalabrasDOCX = contadorPalabrasDOCX;
    }

    public String getFechaDOCX() {
        return fechaDOCX;
    }

    public void setFechaDOCX(String fechaDOCX) {
        this.fechaDOCX = fechaDOCX;
    }
}//fin clase LectorDOCX