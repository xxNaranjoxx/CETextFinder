package Cliente;

import java.io.Serializable;

public class PaqueteEnvio implements Serializable {
    private String mensajeTexto;
    private int banderillaBoton;

    private int banderillaDocumentoEnvio;

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
}//fin clase
