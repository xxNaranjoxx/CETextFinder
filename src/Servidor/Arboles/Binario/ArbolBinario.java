package Servidor.Arboles.Binario;

import javax.swing.*;

public class ArbolBinario {
    private NodoArbolBinario raiz;

    public ArbolBinario() {

    }

    /***
     * funcion recursiva para ver si un nodo existe en el arbol
     * @param busqueda
     */
    public void existe(String busqueda) {
        existe(this.raiz, busqueda);
    }

    private void existe(NodoArbolBinario n, String busqueda) {
        if (n == null) {
            JOptionPane.showMessageDialog(null, "Esa palabra no existe");
            return;
        }
        if (n.getDato().equalsIgnoreCase(busqueda)) {
            JOptionPane.showMessageDialog(null, "Esa palabra si está en el documento");
        } else if (busqueda.compareTo(n.getDato()) < 0) {
             existe(n.getIzquierda(), busqueda);
        } else {
             existe(n.getDerecha(), busqueda);
        }

    }

    /**
     * Funcion recursiva para insertar un nodo nuevo al arbol binario
     * @param dato
     */
    public void insertar(String dato) {
        if (this.raiz == null) {
            this.raiz = new NodoArbolBinario(dato);
        } else {
            this.insertar(this.raiz, dato);
        }
    }

    private void insertar(NodoArbolBinario padre, String dato) {
        if (dato.compareTo(padre.getDato()) > 0) {
            if (padre.getDerecha() == null) {
                padre.setDerecha(new NodoArbolBinario(dato));
            } else {
                this.insertar(padre.getDerecha(), dato);
            }
        } else {
            if (padre.getIzquierda() == null) {
                padre.setIzquierda(new NodoArbolBinario(dato));
            } else {
                this.insertar(padre.getIzquierda(), dato);
            }
        }
    }

    /***
     * Esta funcion da como resultado el "preorden" del arbol
     * @param n
     */
    private void preorden(NodoArbolBinario n) {
        if (n != null) {
            n.imprimirDato();
            preorden(n.getIzquierda());
            preorden(n.getDerecha());
        }
    }
    /***
     * Esta funcion da como resultado el "inorden" del arbol
     * @param n
     */
    private void inorden(NodoArbolBinario n) {
        if (n != null) {
            inorden(n.getIzquierda());
            n.imprimirDato();
            inorden(n.getDerecha());
        }
    }
    /***
     * Esta funcion da como resultado el "posorden" del arbol
     * @param n
     */
    private void postorden(NodoArbolBinario n) {
        if (n != null) {
            postorden(n.getIzquierda());
            postorden(n.getDerecha());
            n.imprimirDato();
        }
    }

    public void preorden() {
        this.preorden(this.raiz);
    }

    public void inorden() {
        this.inorden(this.raiz);
    }

    public void postorden() {
        this.postorden(this.raiz);
    }
}//fin clase
