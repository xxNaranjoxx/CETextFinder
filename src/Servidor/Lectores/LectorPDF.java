package Servidor.Lectores;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.pdf.PDFParser;
import org.apache.tika.sax.BodyContentHandler;

import org.xml.sax.SAXException;

import java.util.Scanner;

import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;


public class LectorPDF {
    BodyContentHandler handler = new BodyContentHandler(-1);
    Metadata metadata = new Metadata();
    ParseContext parseContext = new ParseContext();
    FileInputStream inputStream;
    PDFParser pdfParser = new PDFParser();

    public LectorPDF() {
    }//Constructor

    /***
     * Este metodo parsea los documentos pdf
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
     * Este metodo agrega todas las palabras de lo documentos pdf en el arbol binario
     * @throws IOException
     */
    public void agregarpalbraArbol() throws IOException {
        String tipofichero = "pdf"; // solo tomaremos ficheros con esta extension

        String ruta = "D:\\Algoritmos\\next\\src\\Archivos\\";
        String documento = "pdf.pdf";//
        String fichero = ruta + documento;
        System.out.println("Fichero a analizar =" + documento);
        int numero = documento.length() - 3; //calcula donde empieza la extension del fichero

        // System.out.println(«numero=»+numero);
        String sub = documento.substring(numero); //calcula la extension del fichero

        //abrimos el PDF
        PdfReader reader = new PdfReader(fichero);

        int pages = reader.getNumberOfPages();
        System.out.println("Este PDF tiene " + pages + " paginas.");

        //empezamos la coversion a pdf
        String page = PdfTextExtractor.getTextFromPage(reader, 1); ////<———————————————–aqui da errror
        System.out.println("Contenido del documento de la pagina " + pages);
        System.out.println("\n\n" + page + "\n\n");

        /////////////////////////////////////////////////////////////////////
        //     solo procesaremos los ficheros con la extrension pdf        //
        ////////////////////////////////////////////////////////////////////

        //para procesar el texto lo copiamos a una cadena
        String nombreFichero = page; //Fichero;


        Scanner in = new Scanner(nombreFichero);

        while (in.hasNext()) //leemos toda la cadena
        {
            System.out.println(in.next());

        } //while
        in.close();
    }//agregarpalbraArbol

    public String getDocumentText() {
        return handler.toString();
    }//getDocumentText



    public Map<String, String> getMetadata() {
        String[] metadatanames = metadata.names();
        Map<String, String> metamap = new HashMap<>();
        for (String name : metadatanames) {
            metamap.put(name, metadata.get(name));
        }
        return metamap;
    }//getMetadata


}//fin clase
