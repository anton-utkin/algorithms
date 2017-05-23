package com.utkin.anton;

public class MinHeap<T extends Comparable> {

    private static int INITIAL_ARRAY_SIZE = 1;

    private Comparable[] array = new Comparable[INITIAL_ARRAY_SIZE];
    private int size = 0;

    private void resize(){
        Comparable[] tmp = array;
        array = new Comparable[2 * array.length];
        System.arraycopy( tmp, 0, array, 0, tmp.length );
    }

    private void siftUp(int pos){
        if(pos - 1 == 0) return;
        int parent = pos / 2;
        if(array[pos - 1].compareTo(array[parent - 1]) == -1){
            Comparable tmp = array[parent - 1];
            array[parent - 1] = array[pos - 1];
            array[pos - 1] = tmp;
            siftUp(parent);
        }
    }

    private void siftDown(int pos){
        int left = 2 * pos;
        int right = 2 * pos + 1;
        if(left > size && right > size) return;

        int minPos;
        if(left > size){
            minPos = right;
        }else if(right > size){
            minPos = left;
        }else {
            minPos = array[left - 1].compareTo(array[right - 1]) == -1 ? left : right;
        }

        if(array[pos - 1].compareTo(array[minPos - 1]) == 1) {
            Comparable tmp = array[pos - 1];
            array[pos - 1] = array[minPos - 1];
            array[minPos - 1] = tmp;
            siftDown(minPos);
        }
    }

    private void reverse(){
        for(int i = 0; i < array.length / 2; ++i){
            Comparable tmp = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = tmp;
        }
    }

    public static <T extends Comparable> MinHeap<T> build(T[] array){
        MinHeap<T> heap = new MinHeap<T>();
        heap.array = new Comparable[array.length];
        heap.size = array.length;
        System.arraycopy( array, 0, heap.array, 0, array.length );

        for(int i = array.length / 2; i >= 0; --i){
            heap.siftDown(i + 1);
        }
        return heap;
    }

    public void add(T value){
        size++;
        if(array.length < size){
            resize();
        }
        array[size - 1] = value;

        siftUp(size);
    }

    public void decreaseKey(int pos, T newValue){
        if(pos > size || pos < 0) return;
        if(newValue.compareTo(array[pos - 1]) >= 0) return;
        array[pos - 1] = newValue;
        siftUp(pos);
    }


    public T getMin(){
        return size == 0 ? null : (T)array[0];
    }

    public T extractMin(){
        if(size == 0) return null;
        T tmp = (T)array[0];
        array[0] = array[size - 1];
        size--;
        siftDown(1);
        return tmp;
    }

    public T[] sort(){
        while(size > 1) {
            Comparable tmp = array[size - 1];
            array[size - 1] = array[0];
            array[0] = tmp;
            size--;
            siftDown(1);
        }
        reverse();
        return (T[])array;
    }
}
