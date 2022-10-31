package Servidor.Lectores;

import Servidor.Arboles.Binario.ArbolBinario;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;
import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.pdf.PDFParser;
import org.apache.tika.sax.BodyContentHandler;
import org.xml.sax.SAXException;

import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;


public class LectorPDF {

    BodyContentHandler handler = new BodyContentHandler(-1);
    Metadata metadata = new Metadata();
    ParseContext parseContext = new ParseContext();
    FileInputStream inputStream;
    PDFParser pdfParser = new PDFParser();
    ArbolBinario arbolBinario = new ArbolBinario();

    public LectorPDF() {
    }//Constructor

    /***
     * Este método parsea los documentos pdf
     * @param filepath
     * @return
     * @throws FileNotFoundException
     */
    public String importarPDF(String filepath) throws FileNotFoundException {
        inputStream = new FileInputStream(new File(filepath));
        try {
            pdfParser.parse(inputStream, handler, metadata, parseContext);
        } catch (TikaException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SAXException e) {
            throw new RuntimeException(e);
        }


        return handler.toString();
    }//importarPDF

    /***
     * Este método agrega todas las palabras de los documentos pdf en el arbol binario
     * @throws IOException
     */
    public void indexarPDF(String documento) throws IOException {
        String tipoFichero = "pdf"; // solo tomaremos ficheros con esta extension

        //String ruta = "D:\\Algoritmos\\next\\src\\Archivos\\";
        //String pdf = "pdf.pdf";//
        //String fichero = ruta + pdf;
        //System.out.println("Fichero a analizar =" + pdf);
        //int numero = pdf.length() - 3; //calcula donde empieza la extension del fichero

        // System.out.println(«numero=»+numero);
        //String sub = pdf.substring(numero); //calcula la extension del fichero

        //abrimos el PDF
        PdfReader reader = new PdfReader(documento);

        int pages = reader.getNumberOfPages();
        System.out.println("Este PDF tiene " + pages + " paginas.");

        //empezamos la conversion a pdf
        String page = PdfTextExtractor.getTextFromPage(reader, 1); ////<———————————————–aqui da error
        System.out.println("Contenido del pdf de la pagina " + pages);
        System.out.println("\n\n" + page + "\n\n");

        /*if (page.contains(palabra)) {
            JOptionPane.showMessageDialog(null, "Si se encontró esa frase");

        }*/

        /////////////////////////////////////////////////////////////////////
        //     solo procesaremos los ficheros con la extension pdf        //
        ////////////////////////////////////////////////////////////////////

        //para procesar el texto lo copiamos a una cadena
        String nombreFichero = page; //Fichero;

        int contadorlineas = 0;

        Scanner in = new Scanner(nombreFichero);

        //hacer arbol nuevo para incluir las lista de ocurrencias
        //
        //while
        while (in.hasNext()) {
            //System.out.println(in.next());
            arbolBinario.insertar(in.next());

        }
        System.out.println("INDEXAR PDF");
        arbolBinario.inorden();
        System.out.println("INDEXAR PDF");
        in.close();


    }//agregarPalabraArbol


}//fin clase
