package Servidor.GUI_Servidor;

import Cliente.PaqueteEnvio;
import Servidor.Lectores.LectorPDF;
import Servidor.Lectores.LectorTXT;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class GUI_Servidor extends JFrame implements Runnable {


    private JTextArea areaTexto;

    public GUI_Servidor() {
        setBounds(600, 200, 280, 350);

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
            ServerSocket servidor = new ServerSocket(9999);

            int banderilla,documentoEnvio;
            String mensajeTexto, documento;

            PaqueteEnvio paqueteRecibido;

            while (true){
                Socket miSocket = servidor.accept();

                ObjectInputStream paqueteDatos = new ObjectInputStream(miSocket.getInputStream());

                paqueteRecibido = (PaqueteEnvio) paqueteDatos.readObject();

                banderilla = paqueteRecibido.getBanderilla();

                mensajeTexto = paqueteRecibido.getMensajeTexto();

                documentoEnvio = paqueteRecibido.getDocumentoEnvio();

                if (banderilla == 1){
                    if(documentoEnvio == 0){

                        documento = "src\\Servidor\\Archivos\\prueba.txt";
                        areaTexto.append(documento + "\n" + mensajeTexto);
                        LectorTXT lectorTXT = new LectorTXT();
                        lectorTXT.BuscarPalabraStack(mensajeTexto, documento);

                    } else if (documentoEnvio == 1) {

                        documento = "src\\pdf.pdf";
                        LectorPDF lecotrPDF = new LectorPDF();
                        try {
                            areaTexto.append(lecotrPDF.importarPDF("src\\pdf.pdf"));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }else if (documentoEnvio == 2){

                        documento = "src\\word.docx";
                        areaTexto.append(documento);
                        LectorTXT lectorTXT = new LectorTXT();
                        lectorTXT.BuscarPalabraStack(mensajeTexto, documento);
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
                    System.out.println("indizarBtn");
                }



                miSocket.close();
            }

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }


    }//run

}//fin clase GUI_Servidor
