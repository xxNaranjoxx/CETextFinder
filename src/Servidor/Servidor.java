package Servidor;

import Servidor.Lectores.LectorDOCX;
import Servidor.Lectores.LectorPDF;
import Servidor.Lectores.LectorTXT;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Servidor {
    LectorPDF lectorPDF = new LectorPDF();
    LectorTXT lectorTXT = new LectorTXT();
    LectorDOCX lectorDOCX = new LectorDOCX();

    /**
     * Este metodo hace la indización de los documentos
     * @throws FileNotFoundException
     */
    public void indexarDocs(String documento1,String documento2,String documento3) throws IOException, InvalidFormatException {
        //TODO Hacer la indizacion
        lectorTXT.indexarTXT(documento1);
        lectorPDF.indexarPDF(documento2);
        lectorDOCX.indexarDOCX(documento3);
    }//bucarPalabra


    private void ordenamiento() {
        //TODO Hacer el ordenamiento de los archivos


    }//ordenamiento

    private void resultados() {
        //TODO mostrasr los resultados de la busqueda


    }//ordenamiento
}//fin clase servidor
