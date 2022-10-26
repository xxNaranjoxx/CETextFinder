package Cliente;

import java.io.Serializable;

public class PaqueteEnvio implements Serializable {
    private String mensajeTexto;
    private int banderilla;

    private int documentoEnvio;

    public String getMensajeTexto() {
        return mensajeTexto;
    }

    public void setMensajeTexto(String mensajeTexto) {
        this.mensajeTexto = mensajeTexto;
    }

    public int getBanderilla() {
        return banderilla;
    }

    public void setBanderilla(int banderilla) {
        this.banderilla = banderilla;
    }

    public int getDocumentoEnvio() {
        return documentoEnvio;
    }

    public void setDocumentoEnvio(int documentoEnvio) {
        this.documentoEnvio = documentoEnvio;
    }
}//fin clase
