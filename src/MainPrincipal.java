import Cliente.GUI_Cliente.GUI_Cliente;
import Servidor.GUI_Servidor.GUI_Servidor;

import javax.swing.*;

public class MainPrincipal {

    public static void main(String[] args) {
        GUI_Servidor gui_servidor = new GUI_Servidor();
        gui_servidor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GUI_Cliente gui_cliente = new GUI_Cliente();
        gui_cliente.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }

}
