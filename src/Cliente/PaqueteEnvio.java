package Cliente;

import java.io.Serializable;

public class PaqueteEnvio implements Serializable {
    private String mensajeTexto;
    private int banderillaBoton;

    private String[] docs;
    private int banderillaDocumentoEnvio;

    /***
     * Esta es el paquete que se va a enviar al servidor
     * @return
     */

    public String getMensajeTexto() {
        return mensajeTexto;
    }

    public void setMensajeTexto(String mensajeTexto) {
        this.mensajeTexto = mensajeTexto;
    }

    public int getBanderillaBoton() {
        return banderillaBoton;
    }

    public void setBanderillaBoton(int banderillaBoton) {
        this.banderillaBoton = banderillaBoton;
    }

    public int getBanderillaDocumentoEnvio() {
        return banderillaDocumentoEnvio;
    }

    public void setBanderillaDocumentoEnvio(int banderillaDocumentoEnvio) {
        this.banderillaDocumentoEnvio = banderillaDocumentoEnvio;
    }

    public String[] getDocs() {
        return docs;
    }

    public void setDocs(String[] docs) {
        this.docs = docs;
    }
}//fin clase
