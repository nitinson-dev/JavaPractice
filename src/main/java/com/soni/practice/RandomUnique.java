package com.soni.practice;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class RandomUnique {

    private final int maxValue;
    private Integer[] arrayOfIntegers;



    public RandomUnique(int maxValue) {

        this.maxValue = maxValue;
        arrayOfIntegers = new Integer[maxValue];

    }



    public int getNext() {

        Optional<Integer> returnedInteger = Arrays.stream(arrayOfIntegers).findAny();
        List<Integer> integerList = null;
        if (returnedInteger.isPresent()){
            for(int i=0; i<arrayOfIntegers.length - 1; i++){
                if(arrayOfIntegers[i] != returnedInteger.get()){
                    integerList.add(arrayOfIntegers[i]);
                }
            }
            arrayOfIntegers = (Integer[]) integerList.toArray();

            return returnedInteger.get();
        }
        return -1;



        // it should return a random unique value [0..maxValue-1] in a non-deterministic way

        // so we can't use any Java tools to predict the next value at any time.

        // Unique means it never repeats. If all walues are issued, it should return -1.

    }

}