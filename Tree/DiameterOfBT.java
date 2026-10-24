package org.example.Study.Tree;

import java.util.Map;

public class DiameterOfBT {
   int diameter = 0;

   public int diameter(Node root){
       helper(root);
       return diameter;
   }

   public int helper(Node root){
       if(root == null) return 0;

       int lh = helper(root.leftNode);
       int rh = helper(root.rightNode);

       diameter = Math.max(diameter,lh+rh);

       return 1+Math.max(lh,rh);

   }
}
