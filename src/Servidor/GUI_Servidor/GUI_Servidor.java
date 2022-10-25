package Servidor.GUI_Servidor;

import Cliente.PaqueteEnvio;
import Servidor.Lectores.LectorTXT;

import javax.swing.*;
import java.awt.*;
import java.io.DataInputStream;
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

            int banderilla;
            String mensajeTexto;

            PaqueteEnvio paqueteRecibido;

            while (true){
                Socket miSocket = servidor.accept();

                ObjectInputStream paqueteDatos = new ObjectInputStream(miSocket.getInputStream());

                paqueteRecibido = (PaqueteEnvio) paqueteDatos.readObject();

                banderilla = paqueteRecibido.getBanderilla();

                mensajeTexto = paqueteRecibido.getMensajeTexto();

                if (banderilla == 1){
                    System.out.println("antes");
                    LectorTXT txt= new LectorTXT();
                    String l = txt.leerGraficp();
                    System.out.println(l);
                } else if (banderilla == 2) {
                    System.out.println("ordenNombrebtn");
                }else if (banderilla == 3) {
                    System.out.println("ordenFechabtn");
                }else if (banderilla == 4) {
                    System.out.println("ordenCantidadPalabrasBtn");
                }else if (banderilla == 5) {
                    System.out.println("eliminarDocBtn");
                }else if (banderilla == 6) {
                    System.out.println("anadirDocBtn");
                }else if (banderilla == 7) {
                    System.out.println("indizarBtn");
                }



                miSocket.close();
            }

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }


    }//run

}//fin clase GUI_Servidor
