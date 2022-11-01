package Servidor.Arboles.AVL;

public class ArbolAVL {

    NodoArbolAVL root;

    /***
     * Esta duncion va a dar como resultado la altura del nodo
     * @param N
     * @return
     */
    int height(NodoArbolAVL N) {
        if (N == null)
            return 0;

        return N.height;
    }

    /**
     * Esta funcion va a dar como resultado el nodo maximo de dos nodos
     * @param a Nodo 1 a comparar
     * @param b Nodo 2 a comparar
     * @return
     */
    int max(int a, int b) {
        return (a > b) ? a : b;
    }

    // A utility function to right rotate subtree rooted with y
    // See the diagram given above.
    NodoArbolAVL rightRotate(NodoArbolAVL y) {
        NodoArbolAVL x = y.left;
        NodoArbolAVL T2 = x.right;

        // Perform rotation
        x.right = y;
        y.left = T2;

        // Update heights
        y.height = max(height(y.left), height(y.right)) + 1;
        x.height = max(height(x.left), height(x.right)) + 1;

        // Return new root
        return x;
    }

    /***
     * Esta funcion va a dar como resultado una rotacion a la iquierda con respecto a x nodo
     * @param x nodo
     * @return
     */
    // A utility function to left rotate subtree rooted with x
    // See the diagram given above.
    NodoArbolAVL leftRotate(NodoArbolAVL x) {
        NodoArbolAVL y = x.right;
        NodoArbolAVL T2 = y.left;

        // Perform rotation
        y.left = x;
        x.right = T2;

        //  Update heights
        x.height = max(height(x.left), height(x.right)) + 1;
        y.height = max(height(y.left), height(y.right)) + 1;

        // Return new root
        return y;
    }

    /***
     * Esta funcion devuelve el balance del nodo que se solicita
     * @param N nodo
     * @return
     */
    // Get Balance factor of node N
    int getBalance(NodoArbolAVL N) {
        if (N == null)
            return 0;

        return height(N.left) - height(N.right);
    }

    /***
     * Esta funcion inserta
     * @param node
     * @param key
     * @return
     */
    NodoArbolAVL insert(NodoArbolAVL node, int key) {

        /* 1.  Perform the normal BST insertion */
        if (node == null)
            return (new NodoArbolAVL(key));

        if (key < node.key)
            node.left = insert(node.left, key);
        else if (key > node.key)
            node.right = insert(node.right, key);
        else // Duplicate keys not allowed
            return node;

        /* 2. Update height of this ancestor node */
        node.height = 1 + max(height(node.left),
                height(node.right));

        /* 3. Get the balance factor of this ancestor
              node to check whether this node became
              unbalanced */
        int balance = getBalance(node);

        // If this node becomes unbalanced, then there
        // are 4 cases Left, Left Case
        if (balance > 1 && key < node.left.key)
            return rightRotate(node);

        // Right, Right Case
        if (balance < -1 && key > node.right.key)
            return leftRotate(node);

        // Left Right Case
        if (balance > 1 && key > node.left.key) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // Right Left Case
        if (balance < -1 && key < node.right.key) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        /* return the (unchanged) node pointer */
        return node;
    }

    /***
     * Esta funcion devuelve el arbol de forma "preorden"
     * @param node
     */
    // A utility function to print preorder traversal
    // of the tree.
    // The function also prints height of every node
    void preOrder(NodoArbolAVL node) {
        if (node != null) {
            System.out.print(node.key + " ");
            preOrder(node.left);
            preOrder(node.right);
        }

    }
}
