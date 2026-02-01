package org.example.Study.Tree;

public class InsertNodeBSt {

    public static Node intesetANodeInBST(int value, Node root){
        if(root == null) return  new Node(value);

        Node curr = root;

        while(true){
            if(value <= curr.value){
                if(curr.leftNode != null) curr = curr.leftNode;
                else{
                    curr.leftNode = new Node(value);
                    break;
                }
            }else{
                if(curr.rightNode != null) curr = curr.rightNode;
                else{
                    curr.rightNode = new Node(value);
                    break;
                }

            }
        }
        return root;
    }

    public static Node createABst(Node root, int val){
        if(root == null) return new Node(val);

        if(val<=root.value){
            root.leftNode = createABst(root,val);
        }else{
            root.rightNode = createABst(root,val);
        }
        return root;
    }

    public static Node searchInBST(Node root, int val){
        if(root == null) return null;

        if(root.value == val ) return root;


        if(val < root.value)return searchInBST(root.leftNode,val);
        else return searchInBST(root.rightNode,val);
    }

    int count = 0;
    public  Node kthSmallest(Node root, int k){
        if(root == null) return null;

        Node left = kthSmallest(root.leftNode,k);
        if(left != null) return left;
        count = count+1;
        if(count == k) return root;
        return kthSmallest(root.rightNode,k);
    }
}
