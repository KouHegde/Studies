package org.example.Study.Tree;

public class Node {
    public int value;

    public void setLeftNode(Node leftNode) {
        this.leftNode = leftNode;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setRightNode(Node rightNode) {
        rightNode = rightNode;
    }

    public Node leftNode;
    public Node rightNode;

    public Node getLeftNode() {
        return leftNode;
    }

    public int getValue() {
        return value;
    }

    public Node getRightNode() {
        return rightNode;
    }
    public Node(int value) {
        this.value = value;
    }
}
