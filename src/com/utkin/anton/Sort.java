package com.utkin.anton;

public class Sort {

    private static Object mTmpArray[] = null;

/*-------------------------------------------------------------------------------------
       Merge Sort implementation
       Allows to sort array with O(log N) complexity
--------------------------------------------------------------------------------------*/
    public static <T extends Comparable> void mergeSort(T array[]){
        if(array == null || array.length == 0) return;
        mTmpArray = new Object[array.length];
        mergeSortImpl(array, 1, array.length);
    }

    private static <T extends Comparable> void mergeSortImpl(T array[], int start, int end){
        if(start == end) return;
        mergeSortImpl(array, start, (start + end) / 2);
        mergeSortImpl(array, (start + end) / 2 + 1, end);
        merge(array, start, end);
    }

    private static <T extends Comparable> void merge(T array[], int start, int end){
        int i = start;
        int j = (start + end) / 2 + 1;
        int pos = start;
        while(i < (start + end) / 2 + 1 && j <= end){
            if(((T)array[i - 1]).compareTo(array[j - 1]) == -1){
                mTmpArray[pos - 1] = array[i - 1];
                ++i;
            }else{
                mTmpArray[pos - 1] = array[j - 1];
                ++j;
            }
            ++pos;
        }
        while(i < (start + end) / 2 + 1){
            mTmpArray[pos - 1] = array[i - 1];
            ++i;
            ++pos;
        }
        while(j <= end){
            mTmpArray[pos - 1] = array[j - 1];
            ++j;
            ++pos;
        }
        System.arraycopy(mTmpArray, start - 1, array, start - 1, end - start + 1);
    }
}