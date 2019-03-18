package com.zipcodewilmington.arrayutility;

import java.util.Arrays;
/**
 * Created by leon on 3/6/18.
 */
public class ArrayUtility <T>{

        T[] array;

        public ArrayUtility(T[] array) {
            this.array = array;
        }

        public Integer countDuplicatesInMerge(T[] arraysToMerge, T valueToEvaluate) {
            array = mergeArrays(arraysToMerge);
            return getNumberOfOccurrences(valueToEvaluate);
        }

        public T getMostCommonFromMerge(T[] arrayToMerge) {
            T[] mergedArray = mergeArrays(arrayToMerge);
            int max = 0;
            for(int i = 1; i <  mergedArray.length; i++){
                if (countDuplicatesInMerge(arrayToMerge, mergedArray[i]) >
                        (countDuplicatesInMerge(arrayToMerge, mergedArray[max]))){
                    max = i;
                }
            }
            return mergedArray[max];
        }

        public Integer getNumberOfOccurrences(T object) {

            Integer count = 0;
            for (T element : array) {
                if (element == object) {

                    count++;
                }
            }
            return count;
        }

        public T[] removeValue(T object) {
            Integer j = 0;
            T[] result = Arrays.copyOf(array,array.length - getNumberOfOccurrences(object));
            for (int i = 0; i < array.length; i++) {
                if(array[i] != object){
                    result[j] = array[i];
                    j++;
                }
            }
            return result;
        }

        public T[] mergeArrays(T[] arrayToMerge) {
            T[] result = Arrays.copyOf(array, array.length + arrayToMerge.length);
            for (int i = 0; i < array.length ; i++) {
                result[i] = array[i];
            }
            for (int i = array.length, j = 0; i < result.length; i++, j++) {
                result[i] = arrayToMerge[j];
            }
            return result;
        }
    }


