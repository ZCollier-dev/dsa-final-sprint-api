package org.example.rest.node;

public class Node {
    private Double value;
    private Node left;
    private Node right;

    public Node(){
        value = null;
        left = null;
        right = null;
    }

    public Double getValue(){
        return value;
    }
    public void setValue(Double value){
        this.value = value;
    }

    public Node getLeft(){
        return left;
    }
    public void setLeft(Node left){
        this.left = left;
    }

    public Node getRight(){
        return right;
    }
    public void setRight(Node right){
        this.right = right;
    }
}
