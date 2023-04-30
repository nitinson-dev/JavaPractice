package com.soni.practice;

public class BinaryTreePractice {

    public static void main (String[] args) {

        BinaryTree bt = new BinaryTree();
        bt.add(7);
        bt.add(1);
        bt.add(9);
        bt.add(17);
        bt.add(4);
        bt.add(5);
        bt.add(36);

        bt.print();

    }

    private static class Node{

        int value;
        Node left;
        Node right;

        Node(int value){

            this.value = value;
            left = null;
            right = null;
        }

    }

    private static class BinaryTree{

        Node root;

        public void add(int value){
            root = addToNode(root, value);
        }

        private Node addToNode(Node root, int value){
            if(root == null){
                return new Node(value);
            }

            if(value < root.value){
                root.left = addToNode(root.left, value);
            } else if(value > root.value){
                root.right = addToNode(root.right, value);
            } else{
                return root;
            }
            return root;
        }

        public void print(){
            printNode(root);
        }

        private void printNode(Node node){

            if(node != null){
                printNode(node.left);
                System.out.print(" "+ node.value);
                printNode(node.right);
            }

        }

    }
}
