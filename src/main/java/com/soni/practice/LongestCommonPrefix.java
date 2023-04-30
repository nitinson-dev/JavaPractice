package com.soni.practice;

import java.util.Arrays;

public class LongestCommonPrefix {

    public static void main(String[] args) {

        System.out.println(longestCommonPrefix(new String[]{"flower", "flow", "flight"}));

    }

    public static String longestCommonPrefix(String[] strs) {

        Arrays.sort(strs);

        String firstString = strs[0];
        String lastString = strs[strs.length - 1];

        int index = 0;

        while(index < firstString.length() && index < lastString.length()){
            if(firstString.charAt(index) == lastString.charAt(index)){
                index++;
            } else{
                break;
            }
        }

        return firstString.substring(0, index);
    }
}
