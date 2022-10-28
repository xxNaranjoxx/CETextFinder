package Servidor.Lectores;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.util.HashMap;
import java.util.Map;


import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.pdf.PDFParser;
import org.apache.tika.sax.BodyContentHandler;

import org.xml.sax.SAXException;



public class LecotrPDF {
    BodyContentHandler handler = new BodyContentHandler(-1);
    Metadata metadata = new Metadata();
    ParseContext parseContext = new ParseContext();
    FileInputStream  inputStream;
    PDFParser pdfParser = new PDFParser();

    public LecotrPDF() {
    }//Constructor


    public String importarPDF(String filepath) throws FileNotFoundException {
        inputStream = new FileInputStream(new File(filepath));
        try{
            pdfParser.parse(inputStream,handler,metadata,parseContext);
        } catch (TikaException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SAXException e) {
            throw new RuntimeException(e);
        }


        return handler.toString();
    }//importarPDF

    public String getDocumentText(){
        return handler.toString();
    }//getDocumentText


    public Map<String,String> getMetadata(){
        String[] metadatanames = metadata.names();
        Map<String,String> metamap = new HashMap<>();
        for (String name: metadatanames){
            metamap.put(name,metadata.get(name));
        }
        return metamap;
    }
}
