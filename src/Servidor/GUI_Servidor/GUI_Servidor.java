package Servidor.GUI_Servidor;

import javax.swing.*;
import java.awt.*;
import java.io.DataInputStream;
import java.io.IOException;
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

            while (true){
                Socket miSocket = servidor.accept();

                DataInputStream flujoEntrada = new DataInputStream(miSocket.getInputStream());

                String mensajeTexto = flujoEntrada.readUTF();


                areaTexto.append(mensajeTexto + "\n");

                miSocket.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }//run

}//fin clase GUI_Servidor
