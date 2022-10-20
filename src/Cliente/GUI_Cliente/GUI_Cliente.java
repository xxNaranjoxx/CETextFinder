package Cliente.GUI_Cliente;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class GUI_Cliente extends JFrame {

    public JPanel panelReproductor;

    public GUI_Cliente(){
        this.setSize(750,450);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setTitle("Reproductor");

        colocarPanel();
        colocarComponentes();

    }//constructor

    private void colocarPanel(){
        panelReproductor = new JPanel();
        panelReproductor.setLayout(null);
        this.getContentPane().add(panelReproductor);

    }//colocarPanel

    private void colocarComponentes(){
        //JTextArea
        JTextArea campo1 = new JTextArea();
        JScrollPane scrollPaneTA=new JScrollPane(campo1);
        scrollPaneTA.setBounds(420,5,300,300);
        panelReproductor.add(scrollPaneTA);

        //Label
        JLabel nombreCancion = new JLabel("Orden por:");
        nombreCancion.setBounds(10,340,100,30);
        panelReproductor.add(nombreCancion);

        JLabel biblioteca = new JLabel("Biblioteca:");
        biblioteca.setBounds(10,10,100,30);
        panelReproductor.add(biblioteca);

        //JButton
        JButton ordenNombre = new JButton("Nombre");
        ordenNombre.setBounds(10,370,80,30);
        panelReproductor.add(ordenNombre);

        JButton ordenFecha = new JButton("Fecha");
        ordenFecha.setBounds(100,370,80,30);
        panelReproductor.add(ordenFecha);

        JButton ordenCantidadPalabra = new JButton("Cantidad de palabras");
        ordenCantidadPalabra.setBounds(190,370,155,30);
        panelReproductor.add(ordenCantidadPalabra);

        JButton buscarBtn = new JButton("Buscar");
        buscarBtn.setBounds(530,315,80,30);
        panelReproductor.add(buscarBtn);

        JButton eliminarDoc = new JButton("Eliminar");
        eliminarDoc.setBounds(130,40,80,30);
        panelReproductor.add(eliminarDoc);

        JButton anadirDoc = new JButton("Añadir");
        anadirDoc.setBounds(130,80,80,30);
        panelReproductor.add(anadirDoc);

        JButton indizar = new JButton("Indizar");
        indizar.setBounds(130,120,80,30);
        panelReproductor.add(indizar);

        //Jlist
        String week[]= { "Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"};
        JList b= new JList(week);
        JScrollPane scrollPaneJL=new JScrollPane(b);
        scrollPaneJL.setBounds(20,40,100,120);
        panelReproductor.add(scrollPaneJL);


        //Inicio ActionListeners
        ActionListener pauseBListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Socket miSocket = new Socket(InetAddress.getLocalHost(),9999);

                    DataOutputStream flujoSalida = new DataOutputStream(miSocket.getOutputStream());

                    flujoSalida.writeUTF(campo1.getText());

                    flujoSalida.close();


                } catch (UnknownHostException e1) {
                    e1.printStackTrace();
                }catch (IOException e1) {
                    System.out.println(e1.getMessage());
                }

            }//actionPerformed
        };
        buscarBtn.addActionListener(pauseBListener);

    }//colocarBotones

}//fin clase GUI_Cliente
