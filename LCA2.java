package org.example.Study.Tree;

public class LCA2 {

    public Node executor(Node root, Node p, Node q) {
        Found found = new Found();
        Node res = LCA(root, p, q, found);
        return (found.p && found.q) ? res : null;
    }

    public Node LCA(Node root, Node p, Node q, Found found) {
        if (root == null) return null;

        Node left = LCA(root.leftNode, p, q, found);
        Node right = LCA(root.rightNode, p, q, found);

        if (root == p) {
            found.p = true;
            return root;
        }
        if (root == q) {
            found.q = true;
            return root;
        }

        if (left != null && right != null) return root;
        return left != null ? left : right;
    }

    class Found {
        boolean p;
        boolean q;
    }
}
