package Servidor.Arboles.AVL;

public class NodoArbolAVL {
    int key, height;
    NodoArbolAVL left, right;

    NodoArbolAVL(int d) {
        key = d;
        height = 1;
    }//constructor

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public NodoArbolAVL getLeft() {
        return left;
    }

    public void setLeft(NodoArbolAVL left) {
        this.left = left;
    }

    public NodoArbolAVL getRight() {
        return right;
    }

    public void setRight(NodoArbolAVL right) {
        this.right = right;
    }
}//fin clase
