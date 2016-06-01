package com.komdas.asd.bst;

public class BinarySearchTree {

    class Node {
        int id;
        Object data;
        Node left, right;

        Node(int id, Object data) {
            this.id = id;
            this.data = data;
        }
    }

    Node root = null;

    // TODO : method untuk tambah data.
    public void insert(int id, Object data) {
        Node newest = new Node(id, data);

        if (root == null) {
            root = newest;
        } else {
            insert(root, newest);
        }
    }

    private void insert(Node subroot, Node newest) {
        if (newest.id < subroot.id) {
            if (subroot.left == null) subroot.left = newest;
            else insert(subroot.left, newest);
        } else {
            if (subroot.right == null) subroot.right = newest;
            else insert(subroot.right, newest);
        }
    }


    public void print() {
        preorder(root);
    }

    private void preorder(Node subroot) {
        if (subroot != null) {
            System.out.println(subroot.id);
            preorder(subroot.left);
            preorder(subroot.right);
        }
    }


    public static void main(String[] args) {
        BinarySearchTree b = new BinarySearchTree();
        b.insert(89,89);
        b.insert(60,60);
        b.insert(91,91);
        b.insert(57,57);
        b.insert(63,63);
        b.insert(100,100);
        b.insert(10,10);
        b.print();
    }

}
