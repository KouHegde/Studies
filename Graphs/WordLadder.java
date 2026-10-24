package org.example.Study.Graphs;

import java.util.*;

public class WordLadder {

    public class Pair{
        public Pair(int step, String word) {
            this.step = step;
            this.word = word;
        }

        String word;
        int step;
    }

    public int wordLadder(String src, String dest, List<String> wordList){
        if(wordList.size() == 0) return 0;

        Queue<Pair> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        for(String word : wordList){
            visited.add(word);
        }

        q.add(new Pair(0,src));
        visited.remove(src);

        while(!q.isEmpty()){
            Pair curr = q.poll();

            String currWord = curr.word;
            int steps = curr.step;

            if(currWord == dest) return steps;

            for(int i = 0 ; i < currWord.length(); i++){
                for(char ch = 'a'; ch<='z'; ch++){
                    char[] replaceWord = currWord.toCharArray();
                    replaceWord[i] = ch;
                    String newW = new String(replaceWord);

                    if(visited.contains(newW)){
                        visited.remove(newW);
                        q.add(new Pair(steps+1, newW));
                    }


                }
                }
            }
        return 0;

    }
}

