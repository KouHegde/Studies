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


    public static void main(String[] args){
        String beginWord = "hit", endWord = "cog";
        List<String> wordList = List.of("hot","dot","dog","lot","log","cog");
        worldLadder2(beginWord,endWord,wordList);

    }

    public static List<List<String>> worldLadder2(String beginWord, String endWord, List<String> wordList){

        Set<String> overAll = new HashSet<>();
        Set<String> eachLevel = new HashSet<>();

        List<String> initial = new ArrayList<>();

        initial.add(beginWord);

        Queue<List<String>> queue= new LinkedList<>();
        queue.add(initial);

        List<List<String>> result = new ArrayList<>();

        boolean found = false;

        while(!queue.isEmpty() && !found){
            int size = queue.size();
            eachLevel.clear();

            for(int i= 0; i < size; i++){
                List<String> path = queue.poll();
                assert path != null;
                String lastWord = path.getLast();

                char[] chars = lastWord.toCharArray();

                for(int j = 0 ; j < chars.length; j++){
                    char original = chars[j];

                    for(char ch = 'a'; ch<='z'; ch++) {
                        chars[j] = ch;
                        String newWord = new String(chars);

                        if (wordList.contains(newWord) && !overAll.contains(newWord)) {

                            eachLevel.add(newWord);
                            List<String> newPath = new ArrayList<>(path);
                            newPath.add(newWord);
                            if (newWord.equals(endWord)) {
                                result.add(new ArrayList<>(newPath));
                                found = true;
                            } else {
                                queue.add(newPath);
                            }
                        }

                    }
                    chars[j] = original;
                }
            }
            overAll.addAll(eachLevel);

        }
        return result;

    }



}
