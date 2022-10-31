package Servidor.Lectores;

import Servidor.Arboles.Binario.ArbolBinario;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class LectorDOCX  {

    ArbolBinario arbolBinario = new ArbolBinario();

    public void indexarDOCX(String documento) throws IOException, InvalidFormatException {

        // load DOCX file
        FileInputStream fis = new FileInputStream(documento);
        // open file
        XWPFDocument file = new XWPFDocument(OPCPackage.open(fis));
        // read text
        XWPFWordExtractor ext = new XWPFWordExtractor(file);

        Scanner scanner = new Scanner(ext.getText());

        while (scanner.hasNext()){
            //System.out.println(scanner.next());
            arbolBinario.insertar(scanner.next());
        }
        System.out.println("INDEXAR DOCX");
        arbolBinario.inorden();
        System.out.println("INDEXAR DOCX");
        /*if (ext.getText().contains(palabra)){
            JOptionPane.showMessageDialog(null,"Esa frase si está en el documento");
        }*/



    }//fin clase LectorDOCX
}