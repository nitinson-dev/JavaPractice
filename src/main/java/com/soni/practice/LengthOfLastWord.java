package com.soni.practice;

import java.util.Arrays;

public class LengthOfLastWord {

    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("   fly me   to   the moon  "));
    }

    public static int lengthOfLastWord(String s) {
        String[] str = s.split(" ");

        Arrays.asList(str).stream().forEach(System.out::println);

        return str[str.length - 1].length();
    }
}
