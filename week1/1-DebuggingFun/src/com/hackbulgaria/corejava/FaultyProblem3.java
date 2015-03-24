package com.hackbulgaria.corejava;

public class FaultyProblem3 {
    
    public String reverseEveryWordInString(String sentence){
        String[] words = sentence.split(" ");
        for (String word: words){
            sentence = sentence.replaceFirst(word.toString(), reverse(word).toString());
            
        }
        return sentence;
    }

    private CharSequence reverse(String word) {
        return Utils.reverseMe(word);
    }
}
