package roku;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class wordLadder {
    public static void main(String[] args) {

        String[] strs=new String []{"bat","bag","sag","dag","dot"};

        List<String> words = new ArrayList<>(List.of(strs));


        System.out.println(ladderLength("dag","sag",words));

    }
    public static int ladderLength(String beginWord, String endWord, List<String> wordList){
        Set<String> wordSet = new HashSet<>(wordList);
        if(!wordSet.contains(endWord)) return 0;
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        int level = 1;
        while(!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                if(word.equals(endWord)){ return level;}
                char[] chars = word.toCharArray();
                for (int j = 0; j < chars.length; j++) {
                    char ch = chars[j];
                    for(char c = 'a'; c <= 'z'; c++){
                        chars[j] = c;
                        String newWord = new String(chars);
                        if(wordSet.contains(newWord)){
                            queue.add(newWord);
                            wordSet.remove(newWord);
                        }
                    }
                    chars[j] = ch;
                }

            }
            level++;
        }

        return 0;
    }

}
