package org.example.Study.Tree;

import com.sun.source.tree.BreakTree;

public class SumOfNodeWithEvenValuedGP {
    int ans = 0;
    public int sumEvenGrandparent(Node root) {
        int ans  = check(root);
        return ans;
    }

    public int check(Node root){
        if(root == null){
            return 0;
        }

        if(root.value %2 ==0){
            if(root.leftNode != null){
                if(root.leftNode.leftNode != null){
                    ans +=  root.leftNode.leftNode.value;
                }
                if(root.leftNode.rightNode != null){
                    ans +=  root.leftNode.rightNode.value;
                }
            }
            if(root.rightNode != null){
                if(root.rightNode.leftNode != null){
                    ans +=  root.rightNode.leftNode.value;
                }
                if(root.rightNode.rightNode != null){
                    ans +=  root.rightNode.rightNode.value;
                }
            }
        }
        check(root.leftNode);
        check(root.rightNode);
        return ans;
    }
}
