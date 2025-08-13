package org.example.rest.node;

import org.springframework.data.mongodb.core.mapping.Field;

public class Node {
    @Field("height")
    private int height;

    @Field("value")
    private Double value;

    @Field("left")
    private Node left;

    @Field("right")
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

    public Node(Node node){
        this.value = node.getValue();
        this.left = node.getLeft();
        this.right = node.getRight();
        this.height = node.getHeight();
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

    private int safeHeight(Node node){
        return (node == null) ? 0 : node.getHeight();
    }

    // height starts at max, goes to 0
    public int addNode(Double number){
        if (value == null){
            value = number;
            height = 0;
            return height;
        } else if (number < value){
            if (this.left == null){
                this.left = new Node();
                this.left.setValue(number);
                this.left.setHeight(0);
            } else { left.addNode(number); }
        } else if (number > value){
            if (this.right == null){
                this.right = new Node();
                this.right.setValue(number);
                this.right.setHeight(0);
            } else { right.addNode(number); }
        } else { return height; }

        height = 1 + Math.max(safeHeight(left), safeHeight(right));
        return height;
    }

    public int getBalance(){
        return safeHeight(left) - safeHeight(right);
    }

    private int leftLeftHeight(Node node) {
        return (node != null && node.left != null) ? node.left.getHeight() : -1;
    }

    private int leftRightHeight(Node node) {
        return (node != null && node.right != null) ? node.right.getHeight() : -1;
    }

    private int rightRightHeight(Node node) {
        return (node != null && node.right != null) ? node.right.getHeight() : -1;
    }

    private int rightLeftHeight(Node node) {
        return (node != null && node.left != null) ? node.left.getHeight() : -1;
    }


    public Node rotateRight(){
        Node leftChild = left;
        Node temp = leftChild.getRight();

        leftChild.setRight(this);
        left = temp;

        height = 1 + Math.max(safeHeight(left), safeHeight(right));
        leftChild.setHeight(1 + Math.max(safeHeight(leftChild.getLeft()), safeHeight(leftChild.getRight())));

        return leftChild;
    }
    public Node rotateLeft(){
        Node rightChild = right;
        Node temp = rightChild.getLeft();

        rightChild.setLeft(this);
        right = temp;

        height = 1 + Math.max(safeHeight(left), safeHeight(right));
        rightChild.setHeight(1 + Math.max(safeHeight(rightChild.getLeft()), safeHeight(rightChild.getRight())));

        return rightChild;
    }

    public Node addNodeBalance(Double number){
        if (value == null){
            value = number;
            height = 0;
            return this;
        } else if (number < value){
            if (left == null){
                left = new Node();
                left.setValue(number);
                left.setHeight(0);
            } else {
                left = left.addNodeBalance(number);
            }
        } else if (number > value){
            if (right == null){
                right = new Node();
                right.setValue(number);
                right.setHeight(0);
            } else {
                right = right.addNodeBalance(number);

            }
        } else { return this; }

        height = 1 + Math.max(safeHeight(left), safeHeight(right));
        int balance = getBalance();

        if (balance > 1 && left.getBalance() >= 0){
            if (leftLeftHeight(this) >= leftRightHeight(this)){
                return this.rotateRight();
            } else {
                left = left.rotateLeft();
                return this.rotateRight();
            }
        }

        if (balance < -1){
            if (rightRightHeight(this) >= rightLeftHeight(this)){
                return this.rotateLeft();
            } else {
                right = right.rotateRight();
                return this.rotateLeft();
            }
        }

        return this;
    }
}
