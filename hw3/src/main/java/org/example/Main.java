package org.example;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        System.out.println(reverseWords("hello world"));
        System.out.println(reverseWord("hello world", "worl"));
        System.out.println(reverseSubstring("hello world", 3, 7));
    }

    public static String reverseWords(String src) {
        String[] words = src.split(" ");
        StringBuilder reversedText = new StringBuilder();
        for (String word : words) {
            StringBuilder reversedWord = new StringBuilder(word);
            reversedText.append(reversedWord.reverse()).append(" ");
        }
        return reversedText.toString().trim();
    }

    public static String reverseWord(String src, String target) {
        if (!src.contains(target)) {
            System.out.println("The text does not contain this word.");
            return src;
        } else {
            StringBuilder reversedTarget = new StringBuilder(target).reverse();
            return src.replace(target, reversedTarget.toString());
        }
    }

    public static String reverseSubstring(String src, int startIndex, int endIndex) {
        String[] words = src.split(" ");
        StringBuilder reversedSubstring = new StringBuilder();
        for (String word : words) {
            int length = word.length();
            if (endIndex >= length) {
                String piece = word.substring(startIndex);
                StringBuilder reversedPiece = new StringBuilder(piece).reverse();
                reversedSubstring.append(word.replace(piece, reversedPiece.toString())).append(" ");
                startIndex = 0;
                endIndex -= length;
            } else {
                String piece = word.substring(startIndex, endIndex);
                StringBuilder reversedPiece = new StringBuilder(piece).reverse();
                reversedSubstring.append(word.replace(piece, reversedPiece.toString()));
                startIndex = 0;
                endIndex -= length;
            }
        }
        return reversedSubstring.toString().trim();
    }
}
