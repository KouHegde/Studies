package org.example.Study.Graphs;

import java.util.*;

public class WordLadder2 {

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
