package com.zipcodewilmington.arrayutility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by leon on 3/6/18.
 */
public class ArrayUtility<E> {

    private E[] array;

    public ArrayUtility(E[] array) {
        this.array = array;
    }

    public Integer getNumberOfOccurrences(E value) {
        int counter = 0;
        for (E s : this.array) {
            if (s.equals(value)) {
                counter++;
            }
        }
        return counter;
    }

    public E[] removeValue(E valueToRemove) {
        int counter = 0;

        E[] keepThese = Arrays.copyOf(this.array, this.array.length);
        for (int i = 0; i < this.array.length; i++) {
            if (this.array[i] != valueToRemove) {
                keepThese[i - counter] = this.array[i];
            } else {
                counter++;
            }
        }
        E[] result = Arrays.copyOf(this.array, this.array.length - counter);
        for (int j = 0; j < result.length; j++) {
            result[j] = keepThese[j];
        }
        return result;
    }

    public Integer countDuplicatesInMerge(E[] arrayToMerge, E value) {
        E[] newArray = merge(arrayToMerge);
        return getNumberOfOccurrences(value);
    }

    public E getMostCommonFromMerge(E[] arrayToMerge) {
        this.array = merge(arrayToMerge);
        E current = this.array[0];
        for(int i = 0; i < this.array.length; i++){
            if(getNumberOfOccurrences(this.array[i]) > getNumberOfOccurrences(current)){
                current = this.array[i];
            }
        }
            return current;
    }

    public E[] merge(E[] arrayToMerge){
        int oldLength = this.array.length;
        E[] newArray = Arrays.copyOf(this.array, this.array.length + arrayToMerge.length);
        this.array = newArray;
        for(int i = 0; i < arrayToMerge.length; i++){
            this.array[i + oldLength] = arrayToMerge[i];
        }
        return this.array;
    }
}
