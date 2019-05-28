package com.foxminded.anagrams;

import android.text.TextUtils;

import java.util.ArrayList;
import java.util.List;

public class StringProcessor {
    public String getAnagram(String userInput) {
        String anagram;
        try {
            String[] words = userInput.split("\\s");
            List<String> invertedWords = new ArrayList<String>();
            for (String stringFromArray : words) {
                invertedWords.add(getInversionResult(stringFromArray));
            }
            anagram = TextUtils.join(" ", invertedWords);
        } catch (NullPointerException e) {
            return "got non-existent string";
        }
        return anagram;
    }

    private String getInversionResult(String word) {
        final int lengthString = word.length();
        char[] resultAsChars = new char[lengthString];
        String reversedOnlyLetters = reverseSeparatedLetters(word);
        int position = 0;
        for (int i = 0; i < lengthString; i++) {
            if (!Character.isLetter(word.charAt(i))) {
                resultAsChars[i] = word.charAt(i);
            } else {
                resultAsChars[i] = reversedOnlyLetters.charAt(position);
                position++;
            }
        }
        return new String(resultAsChars);
    }

    private String reverseSeparatedLetters(String word) {
        String separatedLetters = leaveLetters(word);
        StringBuilder stringBuilder = new StringBuilder(separatedLetters);
        return stringBuilder.reverse().toString();
    }

    private String leaveLetters(String stringUser) {
        String[] letters = stringUser.split("[^a-zA-Zа-яА-Я]");
        return TextUtils.join("", letters);
    }

}
