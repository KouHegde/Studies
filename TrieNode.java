package org.example.Study.Trie;

public class TrieNode {
    TrieNode[] link   = new TrieNode[26];
    boolean end = false;

    public boolean contains(Character ch){
        return link[ch-'a'] != null;
    }

    public void put(Character ch, TrieNode node){
        link[ch - 'a'] = node;
    }

    public TrieNode get(Character ch){
        return link[ch-'a'];
    }

    public void setEnd(){
        end = true;
    }

}
