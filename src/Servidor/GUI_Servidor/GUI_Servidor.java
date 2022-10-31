package Servidor.GUI_Servidor;

import Cliente.PaqueteEnvio;
import Servidor.Lectores.LectorDOCX;
import Servidor.Lectores.LectorPDF;
import Servidor.Lectores.LectorTXT;
import Servidor.Servidor;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class GUI_Servidor extends JFrame implements Runnable {


    private JTextArea areaTexto;

    Servidor servidor1 = new Servidor();


    public GUI_Servidor() {
        setBounds(850, 200, 280, 350);

        JPanel milamina = new JPanel();

        milamina.setLayout(new BorderLayout());

        areaTexto = new JTextArea();

        milamina.add(areaTexto, BorderLayout.CENTER);

        add(milamina);

        setVisible(true);

        Thread miHilo = new Thread(this);
        miHilo.start();


    }//constructor

    @Override
    public void run() {

        try {
            ServerSocket servidor = new ServerSocket(9991);

            int banderilla,documentoEnvio;
            String mensajeTexto, documento,documento1,documento2,documento3;

            PaqueteEnvio paqueteRecibido;

            while (true){
                Socket miSocket = servidor.accept();

                ObjectInputStream paqueteDatos = new ObjectInputStream(miSocket.getInputStream());

                paqueteRecibido = (PaqueteEnvio) paqueteDatos.readObject();

                banderilla = paqueteRecibido.getBanderillaBoton();

                mensajeTexto = paqueteRecibido.getMensajeTexto();

                documentoEnvio = paqueteRecibido.getBanderillaDocumentoEnvio();

                if (banderilla == 1){
                    //TXT
                    if(documentoEnvio == 0){

                        documento = "src\\Servidor\\Archivos\\prueba.txt";
                        areaTexto.append(documento + "\n" + mensajeTexto);
                        LectorTXT lectorTXT = new LectorTXT();
                        lectorTXT.indexarTXT(documento);
                        //lectorTXT.buscarPalabraTXT(mensajeTexto, documento);

                    //PDF
                    } else if (documentoEnvio == 1) {

                        documento = "src\\Servidor\\Archivos\\pdf.pdf";
                        areaTexto.append(documento + "\n" + mensajeTexto);
                        LectorPDF lectorPDF = new LectorPDF();
                        lectorPDF.indexarPDF(documento);

                    //DOCX
                    }else if (documentoEnvio == 2){
                        documento = "src\\Servidor\\Archivos\\word.docx";
                        areaTexto.append(documento);
                        LectorDOCX lectorDOCX = new LectorDOCX();
                        lectorDOCX.indexarDOCX(documento);
                    }else {
                        JOptionPane.showMessageDialog(null, "No se encontro el documento");
                    }



                } else if (banderilla == 2) {
                    System.out.println("ordenNombrebtn");
                }else if (banderilla == 3) {
                    System.out.println("ordenFechabtn");
                }else if (banderilla == 4) {
                    System.out.println("ordenCantidadPalabrasBtn");
                }else if (banderilla == 5) {
                    System.out.println("eliminarDocBtn");
                }else if (banderilla == 6) {
                    documento1 = "src\\Servidor\\Archivos\\prueba.txt";
                    documento2 = "src\\Servidor\\Archivos\\pdf.pdf";
                    documento3 = "src\\Servidor\\Archivos\\word.docx";
                    servidor1.indexarDocs(documento1,documento2,documento3);
                    System.out.println("indizarBtn");
                }



                miSocket.close();
            }

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InvalidFormatException e) {
            throw new RuntimeException(e);
        }


    }//run

}//fin clase GUI_Servidor
