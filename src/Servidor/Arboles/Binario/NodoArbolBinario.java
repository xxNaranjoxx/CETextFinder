package Servidor.Arboles.Binario;

public class NodoArbolBinario {
    private String dato;
    private NodoArbolBinario izquierda, derecha;

    public NodoArbolBinario(String dato) {
        this.dato = dato;
        this.izquierda = this.derecha = null;
    }


    public String getDato() {
        return dato;
    }

    public NodoArbolBinario getIzquierda() {
        return izquierda;
    }

    public void setIzquierda(NodoArbolBinario izquierda) {
        this.izquierda = izquierda;
    }

    public NodoArbolBinario getDerecha() {
        return derecha;
    }

    public void setDerecha(NodoArbolBinario derecha) {
        this.derecha = derecha;
    }

    public void imprimirDato() {
        System.out.println(this.getDato());
    }
}//fin clase NodoArbol
