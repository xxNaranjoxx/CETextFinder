package Cliente.GUI_Cliente;

import Cliente.Documentos;
import Cliente.PaqueteEnvio;
import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class GUI_Cliente extends JFrame {

    public JPanel panelReproductor;
    private String banderilla;
    private Vector docs = new Vector();
    DefaultListModel dl = new DefaultListModel();
    JList jListDocs = new JList();

    /**
     * Este es el metodo constructor de la interfz grafica del cliente
     */
    public GUI_Cliente() {
        setBounds(100, 150, 750, 450);
        setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("CETexFinder");

        colocarPanel();
        colocarComponentes();
        leerDatos();

    }//constructor

    /**
     * Esta funcion se encarga de colocar el panel
     */
    private void colocarPanel() {
        panelReproductor = new JPanel();
        panelReproductor.setLayout(null);
        this.getContentPane().add(panelReproductor);

    }//colocarPanel

    /***
     * Esta funcion se encarga de colocar todos los componentes como botones, labels...
     */
    private void colocarComponentes() {
        //JTextArea
        JTextArea campo1 = new JTextArea();
        JScrollPane scrollPaneTA = new JScrollPane(campo1);
        scrollPaneTA.setBounds(420, 5, 300, 300);
        panelReproductor.add(scrollPaneTA);

        //Label
        JLabel nombreCancion = new JLabel("Orden por:");
        nombreCancion.setBounds(10, 340, 100, 30);
        panelReproductor.add(nombreCancion);

        JLabel biblioteca = new JLabel("Biblioteca:");
        biblioteca.setBounds(10, 10, 100, 30);
        panelReproductor.add(biblioteca);

        //JButton
        JButton buscarBtn = new JButton("Buscar");
        buscarBtn.setBounds(530, 315, 80, 30);
        panelReproductor.add(buscarBtn);

        JButton ordenNombrebtn = new JButton("Nombre");
        ordenNombrebtn.setBounds(10, 370, 80, 30);
        panelReproductor.add(ordenNombrebtn);

        JButton ordenFechabtn = new JButton("Fecha");
        ordenFechabtn.setBounds(100, 370, 80, 30);
        panelReproductor.add(ordenFechabtn);

        JButton ordenCantidadPalabrasBtn = new JButton("Cantidad de palabras");
        ordenCantidadPalabrasBtn.setBounds(190, 370, 155, 30);
        panelReproductor.add(ordenCantidadPalabrasBtn);

        JButton eliminarDocBtn = new JButton("Eliminar");
        eliminarDocBtn.setBounds(130, 40, 80, 30);
        panelReproductor.add(eliminarDocBtn);

        JButton anadirDocBtn = new JButton("Añadir");
        anadirDocBtn.setBounds(130, 80, 80, 30);
        panelReproductor.add(anadirDocBtn);


        //Jlist
        String prueba = "Prueba.txt";
        String pdf = "Pdf.pdf";
        String word = "Word.docx";

        String docs[] = {prueba, pdf, word};
        JList jListDocs = new JList(docs);
        JScrollPane scrollPaneJL = new JScrollPane(jListDocs);
        scrollPaneJL.setBounds(20, 40, 100, 120);
        panelReproductor.add(scrollPaneJL);

        /***
         * A partir de aquí se crean los action listener en donde
         * se van a crear los sokets para enviar informacion al servidor
         */
        //Inicio ActionListeners
        ActionListener buscarBtnListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Socket miSocket = new Socket(InetAddress.getLocalHost(), 9991);

                    PaqueteEnvio datos = new PaqueteEnvio();

                    datos.setMensajeTexto(campo1.getText());

                    datos.setBanderillaBoton(1);

                    datos.setBanderillaDocumentoEnvio((jListDocs.getSelectedIndex()));

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
                } catch (IOException e1) {
                    System.out.println(e1.getMessage());
                }

            }//actionPerformed
        };
        buscarBtn.addActionListener(buscarBtnListener);

        ActionListener ordenNombrebtnListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Socket miSocket = new Socket(InetAddress.getLocalHost(), 9991);

                    PaqueteEnvio datos = new PaqueteEnvio();

                    datos.setDocs(docs);

                    datos.setBanderillaBoton(2);

                    ObjectOutputStream paqueteDatos = new ObjectOutputStream(miSocket.getOutputStream());

                    paqueteDatos.writeObject(datos);

                    miSocket.close();


                } catch (UnknownHostException e1) {
                    e1.printStackTrace();
                } catch (IOException e1) {
                    System.out.println(e1.getMessage());
                }

            }//actionPerformed
        };
        ordenNombrebtn.addActionListener(ordenNombrebtnListener);

        ActionListener ordenFechabtnListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Socket miSocket = new Socket(InetAddress.getLocalHost(), 9991);

                    PaqueteEnvio datos = new PaqueteEnvio();

                    datos.setMensajeTexto(campo1.getText());

                    datos.setBanderillaBoton(3);

                    ObjectOutputStream paqueteDatos = new ObjectOutputStream(miSocket.getOutputStream());

                    paqueteDatos.writeObject(datos);

                    miSocket.close();


                } catch (UnknownHostException e1) {
                    e1.printStackTrace();
                } catch (IOException e1) {
                    System.out.println(e1.getMessage());
                }

            }//actionPerformed
        };
        ordenFechabtn.addActionListener(ordenFechabtnListener);
        ActionListener ordenCantidadPalabrasBtnListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Socket miSocket = new Socket(InetAddress.getLocalHost(), 9991);

                    PaqueteEnvio datos = new PaqueteEnvio();

                    datos.setMensajeTexto(campo1.getText());

                    datos.setBanderillaBoton(4);

                    ObjectOutputStream paqueteDatos = new ObjectOutputStream(miSocket.getOutputStream());

                    paqueteDatos.writeObject(datos);

                    miSocket.close();


                } catch (UnknownHostException e1) {
                    e1.printStackTrace();
                } catch (IOException e1) {
                    System.out.println(e1.getMessage());
                }

            }//actionPerformed
        };
        ordenCantidadPalabrasBtn.addActionListener(ordenCantidadPalabrasBtnListener);

        ActionListener eliminarDocBtnListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Socket miSocket = new Socket(InetAddress.getLocalHost(), 9991);

                    PaqueteEnvio datos = new PaqueteEnvio();

                    datos.setMensajeTexto(campo1.getText());

                    datos.setBanderillaBoton(5);

                    ObjectOutputStream paqueteDatos = new ObjectOutputStream(miSocket.getOutputStream());

                    paqueteDatos.writeObject(datos);

                    miSocket.close();


                } catch (UnknownHostException e1) {
                    e1.printStackTrace();
                } catch (IOException e1) {
                    System.out.println(e1.getMessage());
                }

            }//actionPerformed
        };
        eliminarDocBtn.addActionListener(eliminarDocBtnListener);

        ActionListener anadirDocBtnListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                obtenerRuta();




                /*guardamos el path del fichero en la variable ruta
                String ruta = jFileChooser.getSelectedFile().getAbsolutePath();
                //creamos un objeto File asociado al fichero seleccionado
                File f = new File(ruta);
                System.out.println(docs);*/


            }//actionPerformed
        };
        anadirDocBtn.addActionListener(anadirDocBtnListener);

    }//colocarBotones

    /***
     * Con esta funcion se va a obtener el path del archivo que el cliente seleccione
     */
    public void obtenerRuta() {
        JFileChooser jFileChooser = new JFileChooser();
        int userChoise = jFileChooser.showOpenDialog(jFileChooser);
        String ruta = jFileChooser.getSelectedFile().getAbsolutePath();
        if (userChoise == jFileChooser.APPROVE_OPTION) {
            File selectedFile = jFileChooser.getSelectedFile();
            escribirCSV(new Documentos(ruta));

        } else if (userChoise == JFileChooser.CANCEL_OPTION) {
            JOptionPane.showMessageDialog(null, "No file selected");
        }

        docs.add(ruta);
        //add(String.valueOf(docs));


    }

    /***
     * Esta funcion va a añadir a la lista el archivo que selecciona
     * @param name
     */
    private void add(String name) {
        jListDocs.setModel(dl);
        //dl.addElement(name);

    }

    /***
     * Este metodo va a escribir en el CSV todos los documentos que el usuario quiera ingresar
     * @param docs se le pasa por parametro el archivo donde se va a escribir
     */
    public void escribirCSV(Documentos docs) {
        //NodoUsuarios nodoUsuarios = new NodoUsuarios();
        String salidaArchivo = "Documentos.csv";
        boolean existe = new File(salidaArchivo).exists();

        if (existe) {
            File archivoUsuarios = new File(salidaArchivo);
            try {
                CsvWriter salidaCSV = new CsvWriter(new FileWriter(salidaArchivo, true), ',');

                salidaCSV.write(docs.getRuta());


                salidaCSV.endRecord();


                salidaCSV.close();
            } catch (IOException e) {
                e.printStackTrace();

            }//try-catch
            //archivoUsuarios.delete();

        } else {
            try {
                CsvWriter salidaCSV = new CsvWriter(new FileWriter(salidaArchivo, true), '$');
                salidaCSV.write("Ruta");

                salidaCSV.endRecord();

                salidaCSV.write(docs.getRuta());


                salidaCSV.endRecord();


                salidaCSV.close();
            } catch (IOException e) {
                e.printStackTrace();

            }//try-catch
        }


    }//escribirCSV

    /***
     * Este metodo se va a encargar de leer el archivo CSV
     * @return la lista de documentos
     */
    public List<Documentos> leerDatos() {

        List<Documentos> documentos = new ArrayList<>();
        try {
            CsvReader leerDocumentos = new CsvReader("Documentos.csv");
            leerDocumentos.readHeaders();

            while (leerDocumentos.readRecord()) {
                String ruta = leerDocumentos.get(0);


                documentos.add(new Documentos(ruta));


            }//while
            leerDocumentos.close();
            String auxiliar = "";
            for (Documentos docs : documentos) {
                auxiliar = docs.getRuta();


            }//for
            System.out.println(auxiliar);
            jListDocs.setModel(dl);
            dl.addElement(auxiliar);
            System.out.println(dl);


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();

        }//try-catch
        return documentos;
    }//ImportarDatos

}//fin clase GUI_Cliente
