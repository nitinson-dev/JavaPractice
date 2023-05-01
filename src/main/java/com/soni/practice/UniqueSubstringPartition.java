package com.soni.practice;

import java.util.HashSet;
import java.util.Set;

public class UniqueSubstringPartition {
    public static int uniqueSubstringPartition(String s) {
        int result = 0;
        int n = s.length();

        for (int i = 0; i < n; i++) {

            Set<Character> set = new HashSet<>();
            set.add(s.charAt(i));
            int j = i+1;
            while(j < n){
                if (set.contains(s.charAt(j))) {
                    result++;
                    i = j-1;
                    break;
                }
                set.add(s.charAt(j));
                j++;
            }
            if(j == n){
                result++;
                break;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        //String s = "codingisfun";
        String s = "111222333";
        System.out.println(uniqueSubstringPartition(s)); // Output: 7
    }
}
