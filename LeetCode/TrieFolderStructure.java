package org.example.Study.LeetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TrieFolderStructure {


    static class  TrieNode{
        String name;
        Map<String,TrieNode> children;

        TrieNode (String name){
            this.name = name;
            this.children= new HashMap<>();
        }
    }

    public static void main(String[] args) {
        List<String> path = Arrays.asList("app/frontend/components","app/server", "imgs/gifs");


        TrieNode root = buildTrie(path);

        printTrie(root, 0);

    }


    public static TrieNode buildTrie(List<String> paths){
        TrieNode root = new TrieNode("");

        for(String path : paths){
            String[] multipleParts = path.split("/");      //[app,frontend,componemets]
            TrieNode current = root;

            for(String part : multipleParts){
                current.children.putIfAbsent(part, new TrieNode(part));
                current  = current.children.get(part);
            }

        }
        return root;
    }

    public static void  printTrie(TrieNode  node, int level){

        if(!node.name.equals("")){
            for(int i = 0; i < level; i++){
                System.out.print(" - ");
            }
            System.out.println(node.name);
        }
        for(TrieNode nextNodes : node.children.values()){
            printTrie(nextNodes, level+1);
        }


    }
}
