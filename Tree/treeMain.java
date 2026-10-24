package org.example.Study.Tree;

public class treeMain {

    public static void main(String[] args){
        Tree tree = new Tree();
        tree.insert(8);
        tree.insert(7);
        tree.insert(12);
        tree.insert(15);
        tree.insert(2);
        tree.insert(5);

        tree.inOrder();

    }
}
