package org.example.Study.LeetCode;


import java.util.*;

public class FileSystem {

    /*
    mkdir("/a/b/c")
    addContentToFile("/a/b/c/d", "hello")
    ls("/") ➜ ["a"]
    readContentFromFile("/a/b/c/d") ➜ "hello"
     */

    public class TrieNode{
         StringBuilder content;
         boolean isFile;
         Map<String, TrieNode> map;

         public TrieNode(){
             this.map = new HashMap<>();
             this.isFile = false;
             this.content = new StringBuilder();
         }
        public TrieNode(String content){
            this.map = new HashMap<>();
            this.isFile = false;
            this.content = new StringBuilder().append(content);
        }


    }



    TrieNode root = new TrieNode();

    public TrieNode makdir(String filePath) {
        if (root == null) root = new TrieNode();
        String[] path = filePath.split("/");
        TrieNode curr = root;
        for (String name : path) {
            if (name.isEmpty()) continue;
            curr.map.putIfAbsent(name, new TrieNode());
            curr = curr.map.get(name);
        }
        return root;
    }

    public void addContentToFile(String path, String newContent){
        String[] strs = path.split("/");

        TrieNode curr = root;
        for(int i = 0 ; i < strs.length; i++){
            String s = strs[i];
            if(s.isEmpty()) continue;
            curr.map.putIfAbsent(s,new TrieNode());
            curr = curr.map.get(s);
            if(i == strs.length-1){
                curr.isFile = true;
                curr.content.append(newContent);
                }
            }
        }

    public List<String> ls(String path) {
        String[] parts = path.split("/");
        TrieNode curr = root;

        for (String part : parts) {
            if (part.isEmpty()) continue;
            curr = curr.map.get(part);
        }

        List<String> result = new ArrayList<>();


        if (curr.isFile) {
            result.add(parts[parts.length - 1]);
            return result;
        }

        // If directory → return all children sorted
        result.addAll(curr.map.keySet());
        Collections.sort(result);

        return result;
    }

    public String readContentFromFile(String pathWithFileName) {
        String[] parts = pathWithFileName.split("/");
        TrieNode curr = root;

        for (String part : parts) {
            if (part.isEmpty()) continue;
            curr = curr.map.get(part);
        }

        return curr.content.toString();
    }
}


