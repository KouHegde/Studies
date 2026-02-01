package org.example.Study.LeetCode;

import java.util.*;

public class WordLadder {

    class Pair{
        String first;
        int second;

        public Pair(String first, Integer second){
            this.first = first;
            this.second = second;
        }
    }

    public int wordLadder(String startWord, String targetWord, List<String> wordList){
        if(startWord == targetWord) return 0;

        Queue<Pair> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        for(String word: wordList){
            visited.add(word);
        }
        q.add(new Pair(startWord,1));
        visited.remove(startWord);

        while(!q.isEmpty()){
            Pair curr = q.poll();
            String word = curr.first;
            int step = curr.second;

            if(word == targetWord) return step;

            for(int i = 0; i<word.length() ; i++ ){
                for(char ch = 'a'; ch<'z'; ch++ ){
                    char[] replacedCharArray = word.toCharArray();
                    replacedCharArray[i] = ch;
                    String newString = new String(replacedCharArray);

                    if(visited.contains(newString)){
                        visited.remove(newString);
                        q.add(new Pair(newString,1+step));

                    }
                }
            }

        }
        return 0;
    }



    class Detail {
         int step;
         String word;
         public Detail(int step, String word){
             this.word  = word;
             this.step = step;
         }
    }


    public int wordLadder1(String startWord, String targetWord, List<String> wordList){
        Queue<Detail> q = new LinkedList<>();
        Set<String> set = new HashSet<>();

        for(String word : wordList){
            set.add(word);
        }
        q.add(new Detail(1,startWord));
        set.remove(startWord);
        while(!q.isEmpty()){
            Detail curr = q.poll();
            String currWord = curr.word;
            int step = curr.step;

            if (currWord == targetWord) return step;

            for(int i  = 0 ; i < currWord.length(); i++){
                for(char c = 'a' ; c<='z'; c++){
                    char[] chars = currWord.toCharArray();
                    chars[i] = c;
                    String newWord = new String(chars);

                    if(set.contains(newWord)){
                        q.add(new Detail(step+1, newWord));
                        set.remove(newWord);
                    }
                }
            }
        }
        return -1;

    }


}
