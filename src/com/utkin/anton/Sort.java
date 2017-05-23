package com.utkin.anton;

public class Sort {

    private static Object mTmpArray[] = null;

/*-------------------------------------------------------------------------------------
       Heap Sort implementation
       Allows to sort array with O(N log N) complexity
--------------------------------------------------------------------------------------*/
    public static <T extends Comparable> void heapSort(T array[]) {
        MinHeap<T> heap = MinHeap.build(array);
        System.arraycopy( heap.sort(), 0, array, 0, array.length);
    }

/*-------------------------------------------------------------------------------------
       Merge Sort implementation
       Allows to sort array with O(N log N) complexity
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

/*-------------------------------------------------------------------------------------
       Quick Sort implementation
       Allows to sort array with average complexity O(N log N)
--------------------------------------------------------------------------------------*/
    public static <T extends Comparable> void quickSort(T array[]){
        if(array == null || array.length == 0) return;
        random(array);
        quickSortImpl(array, 1, array.length);
    }

    private static <T extends Comparable> void random(T array[]){
        for(int i = 1; i <= array.length; ++i) {
            int random = (int)(i + Math.random() * (array.length - i + 1));
            swap(array, i, random);
        }
    }

    private static <T extends Comparable> void quickSortImpl(T array[], int start, int end){
        if(start >= end) return;
        int n = partition(array, start, end);
        quickSortImpl(array, start, n - 1);
        quickSortImpl(array, n + 1, end);
    }

    private static <T extends Comparable> int partition(T array[], int start, int end){
        int i = start - 1;
        for(int j = start; j < end; ++j){
            if(array[j - 1].compareTo(array[end - 1]) == -1){
                ++i;
                swap(array, i, j);
            }
        }
        swap(array, i + 1, end);
        return i + 1;
    }

    private static <T extends Comparable> void swap(T array[], int i, int j){
        T tmp = array[i - 1];
        array[i - 1] = array[j - 1];
        array[j - 1] = tmp;
    }
}
