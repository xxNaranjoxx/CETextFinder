package Cliente.GUI_Cliente;

import Cliente.PaqueteEnvio;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class GUI_Cliente extends JFrame {

    public JPanel panelReproductor;
    private String banderilla;
    private JList jListDocs;

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
        JButton buscarBtn = new JButton("Buscar");
        buscarBtn.setBounds(530,315,80,30);
        panelReproductor.add(buscarBtn);

        JButton ordenNombrebtn = new JButton("Nombre");
        ordenNombrebtn.setBounds(10,370,80,30);
        panelReproductor.add(ordenNombrebtn);

        JButton ordenFechabtn = new JButton("Fecha");
        ordenFechabtn.setBounds(100,370,80,30);
        panelReproductor.add(ordenFechabtn);

        JButton ordenCantidadPalabrasBtn = new JButton("Cantidad de palabras");
        ordenCantidadPalabrasBtn.setBounds(190,370,155,30);
        panelReproductor.add(ordenCantidadPalabrasBtn);

        JButton eliminarDocBtn = new JButton("Eliminar");
        eliminarDocBtn.setBounds(130,40,80,30);
        panelReproductor.add(eliminarDocBtn);

        JButton anadirDocBtn = new JButton("Añadir");
        anadirDocBtn.setBounds(130,80,80,30);
        panelReproductor.add(anadirDocBtn);

        JButton indizarBtn = new JButton("Indizar");
        indizarBtn.setBounds(130,120,80,30);
        panelReproductor.add(indizarBtn);

        //Jlist
        String prueba = "Prueba.text";
        String pdf = "Pdf.pdf";
        String word = "Word.docx";

        String docs[]= {prueba,pdf,word};
        JList jListDocs = new JList(docs);
        JScrollPane scrollPaneJL=new JScrollPane(jListDocs);
        scrollPaneJL.setBounds(20,40,100,120);
        panelReproductor.add(scrollPaneJL);




        //Inicio ActionListeners
        ActionListener buscarBtnListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Socket miSocket = new Socket(InetAddress.getLocalHost(),9999);

                    PaqueteEnvio datos = new PaqueteEnvio();

                    datos.setMensajeTexto(campo1.getText());

                    datos.setBanderilla(1);

                    datos.setDocumentoEnvio((jListDocs.getSelectedIndex()));

                    ObjectOutputStream paqueteDatos = new ObjectOutputStream(miSocket.getOutputStream());

                    paqueteDatos.writeObject(datos);

                    miSocket.close();


                    /*DataOutputStream flujoSalida = new DataOutputStream(miSocket.getOutputStream());
                    banderilla="1";

                    flujoSalida.writeUTF(campo1.getText());
                    flujoSalida.writeUTF(banderilla);



                    flujoSalida.close();*/


                } catch (UnknownHostException e1) {
                    e1.printStackTrace();
                }catch (IOException e1) {
                    System.out.println(e1.getMessage());
                }

            }//actionPerformed
        };
        buscarBtn.addActionListener(buscarBtnListener);

        ActionListener ordenNombrebtnListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Socket miSocket = new Socket(InetAddress.getLocalHost(),9999);

                    PaqueteEnvio datos = new PaqueteEnvio();

                    datos.setBanderilla(2);

                    ObjectOutputStream paqueteDatos = new ObjectOutputStream(miSocket.getOutputStream());

                    paqueteDatos.writeObject(datos);

                    miSocket.close();


                } catch (UnknownHostException e1) {
                    e1.printStackTrace();
                }catch (IOException e1) {
                    System.out.println(e1.getMessage());
                }

            }//actionPerformed
        };
        ordenNombrebtn.addActionListener(ordenNombrebtnListener);

        ActionListener ordenFechabtnListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Socket miSocket = new Socket(InetAddress.getLocalHost(),9999);

                    PaqueteEnvio datos = new PaqueteEnvio();

                    datos.setMensajeTexto(campo1.getText());

                    datos.setBanderilla(3);

                    ObjectOutputStream paqueteDatos = new ObjectOutputStream(miSocket.getOutputStream());

                    paqueteDatos.writeObject(datos);

                    miSocket.close();


                } catch (UnknownHostException e1) {
                    e1.printStackTrace();
                }catch (IOException e1) {
                    System.out.println(e1.getMessage());
                }

            }//actionPerformed
        };
        ordenFechabtn.addActionListener(ordenFechabtnListener);
        ActionListener ordenCantidadPalabrasBtnListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Socket miSocket = new Socket(InetAddress.getLocalHost(),9999);

                    PaqueteEnvio datos = new PaqueteEnvio();

                    datos.setMensajeTexto(campo1.getText());

                    datos.setBanderilla(4);

                    ObjectOutputStream paqueteDatos = new ObjectOutputStream(miSocket.getOutputStream());

                    paqueteDatos.writeObject(datos);

                    miSocket.close();


                } catch (UnknownHostException e1) {
                    e1.printStackTrace();
                }catch (IOException e1) {
                    System.out.println(e1.getMessage());
                }

            }//actionPerformed
        };
        ordenCantidadPalabrasBtn.addActionListener(ordenCantidadPalabrasBtnListener);

        ActionListener eliminarDocBtnListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Socket miSocket = new Socket(InetAddress.getLocalHost(),9999);

                    PaqueteEnvio datos = new PaqueteEnvio();

                    datos.setMensajeTexto(campo1.getText());

                    datos.setBanderilla(5);

                    ObjectOutputStream paqueteDatos = new ObjectOutputStream(miSocket.getOutputStream());

                    paqueteDatos.writeObject(datos);

                    miSocket.close();


                } catch (UnknownHostException e1) {
                    e1.printStackTrace();
                }catch (IOException e1) {
                    System.out.println(e1.getMessage());
                }

            }//actionPerformed
        };
        eliminarDocBtn.addActionListener(eliminarDocBtnListener);

        ActionListener anadirDocBtnListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarDatos();




                /*guardamos el path del fichero en la variable ruta
                String ruta = jFileChooser.getSelectedFile().getAbsolutePath();
                //creamos un objeto File asociado al fichero seleccionado
                File f = new File(ruta);
                System.out.println(docs);*/





            }//actionPerformed
        };
        anadirDocBtn.addActionListener(anadirDocBtnListener);

        ActionListener indizarBtnListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Socket miSocket = new Socket(InetAddress.getLocalHost(),9999);

                    PaqueteEnvio datos = new PaqueteEnvio();

                    datos.setMensajeTexto(campo1.getText());

                    datos.setBanderilla(6);

                    ObjectOutputStream paqueteDatos = new ObjectOutputStream(miSocket.getOutputStream());

                    paqueteDatos.writeObject(datos);

                    miSocket.close();


                } catch (UnknownHostException e1) {
                    e1.printStackTrace();
                }catch (IOException e1) {
                    System.out.println(e1.getMessage());
                }

            }//actionPerformed
        };
        indizarBtn.addActionListener(indizarBtnListener);


    }//colocarBotones


    public DefaultListModel agregarDatos(){
        JFileChooser jFileChooser = new JFileChooser();
        int userChoise = jFileChooser.showOpenDialog(jFileChooser);
        DefaultListModel modelo = (DefaultListModel) jListDocs.getModel();

        if (userChoise == jFileChooser.APPROVE_OPTION){
            File selectedFile = jFileChooser.getSelectedFile();
            JOptionPane.showMessageDialog(null, selectedFile.getPath());

            modelo.addElement(selectedFile.getPath());

        } else if (userChoise == JFileChooser.CANCEL_OPTION) {
            JOptionPane.showMessageDialog(null, "No file selected");
        }

        return modelo;
    }


}//fin clase GUI_Cliente
