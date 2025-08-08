package org.example.rest.node;

public class Node {
    private int height;
    private Double value;
    private Node left;
    private Node right;

    public Node(){
        value = null;
        left = null;
        right = null;
        height = 0;
    }

    public Node(int height, Double value, Node left, Node right){
        this.value = value;
        this.left = left;
        this.right = right;
        this.height = height;
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

    public int getHeight(){
        return height;
    }
    public void setHeight(int height){
        this.height = height;
    }

    public void setAll(int height, Double value, Node left, Node right){
        this.value = value;
        this.height = height;
        this.left = left;
        this.right = right;
    }
    public int getBalance(){
        return left.getHeight() - right.getHeight();
    }

    // height starts at max, goes to 0
    public int addNode(Double number){
        if (value == null || value.equals(number)){
            value = number;
        } else if (number < value){
            if (this.left == null){ this.left = new Node(); }
            left.addNode(number);
            height = 1 + Math.max(left.getHeight(), right.getHeight());
        } else {
            if (this.right == null){ this.right = new Node(); }
            right.addNode(number);
            height = 1 + Math.max(left.getHeight(), right.getHeight());
        }

        return height;
    }

    public Node rotateRight(){
        Node n1 = left;
        Node n2 = n1.getRight();
        n1.setRight(new Node(height, value, left, right));
        left = n2;
        height = 1 + Math.max(left.getHeight(), right.getHeight());
        n1.setHeight(1 + Math.max(n1.getLeft().getHeight(), n1.getRight().getHeight()));
        return n1;
    }
    public Node rotateLeft(){
        Node n1 = right;
        Node n2 = n1.getLeft();
        n1.setLeft(new Node(height, value, left, right));
        right = n2;
        height = 1 + Math.max(left.getHeight(), right.getHeight());
        n1.setHeight(1 + Math.max(n1.getLeft().getHeight(), n1.getRight().getHeight()));
        return n1;
    }

    public int addNodeBalance(Double number){
        if (value == null || value.equals(number)){
            value = number;
        } else if (number < value){
            if (this.left == null){ this.left = new Node(); }
            left.addNodeBalance(number);
            height = 1 + Math.max(left.getHeight(), right.getHeight());
        } else {
            if (this.right == null){ this.right = new Node(); }
            right.addNodeBalance(number);
            height = 1 + Math.max(left.getHeight(), right.getHeight());
        }

        int balance = getBalance();
        Node balancedNode;

        if (balance > 1 && left.getBalance() >= 0){
            balancedNode = rotateRight();
            setAll(balancedNode.getHeight(), balancedNode.getValue(), balancedNode.getLeft(), balancedNode.getRight());
        } else if (balance > 1 && left.getBalance() < 0){
            left = left.rotateLeft();
            balancedNode = rotateRight();
            setAll(balancedNode.getHeight(), balancedNode.getValue(), balancedNode.getLeft(), balancedNode.getRight());
        } else if (balance < -1 && right.getBalance() <= 0){
            balancedNode = rotateLeft();
            setAll(balancedNode.getHeight(), balancedNode.getValue(), balancedNode.getLeft(), balancedNode.getRight());
        } else if (balance < -1 && left.getBalance() > 0){
            right = right.rotateRight();
            balancedNode = rotateLeft();
            setAll(balancedNode.getHeight(), balancedNode.getValue(), balancedNode.getLeft(), balancedNode.getRight());
        }

        return height;
    }
}
