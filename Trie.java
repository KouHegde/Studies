package org.example.Study.Trie;

public class Trie {
    TrieNode root;
    Trie(){
        root = new TrieNode();
    }

    void insert(String word) {
        TrieNode node = root;
        for(Character ch : word.toCharArray()){
            if(!node.contains(ch)){
                node.put(ch,new TrieNode());
            }
            node = node.get(ch);
        }
        node.setEnd();
    }

    boolean search(String word) {
       TrieNode node = root;
       for(Character ch : word.toCharArray()){
           if(!node.contains(ch)){
               return false;
           }
           node = node.get(ch);
       }
       if(node.end){
           return true;
       }
       return false;
    }

    boolean startsWith(String prefix) {
        TrieNode node = root;
        for(Character ch : prefix.toCharArray()){
            if(!node.contains(ch)){
                return false;
            }
            node = node.get(ch);
        }
       return true;
    }
}
