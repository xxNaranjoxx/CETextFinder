package Servidor.Arboles;

public class NodoArbol {
        private String dato;
        private NodoArbol izquierda, derecha;

        public NodoArbol(String dato) {
            this.dato = dato;
            this.izquierda = this.derecha = null;
        }


        public String getDato() {
            return dato;
        }

        public NodoArbol getIzquierda() {
            return izquierda;
        }

        public void setIzquierda(NodoArbol izquierda) {
            this.izquierda = izquierda;
        }

        public NodoArbol getDerecha() {
            return derecha;
        }

        public void setDerecha(NodoArbol derecha) {
            this.derecha = derecha;
        }

        public void imprimirDato() {
            System.out.println(this.getDato());
        }


}//fin clase NodoArbol
