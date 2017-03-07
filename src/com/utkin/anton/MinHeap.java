package com.utkin.anton;

public class MinHeap<T extends Comparable> {

    private static int INITIAL_ARRAY_SIZE = 1;

    private Object[] array = new Object[INITIAL_ARRAY_SIZE];
    private int size = 0;

    private void resize(){
        Object[] tmp = array;
        array = new Object[2 * array.length];
        System.arraycopy( tmp, 0, array, 0, tmp.length );
    }

    private void siftUp(int pos){
        if(pos - 1 == 0) return;
        int parent = pos / 2;
        if(((T) array[pos - 1]).compareTo((T)array[parent - 1]) == -1){
            Object tmp = array[parent - 1];
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
            minPos = ((T)array[left - 1]).compareTo(array[right - 1]) == -1 ? left : right;
        }

        if(((T) array[pos - 1]).compareTo(array[minPos - 1]) == 1) {
            Object tmp = array[pos - 1];
            array[pos - 1] = array[minPos - 1];
            array[minPos - 1] = tmp;
            siftDown(minPos);
        }
    }

    public static <T extends Comparable> MinHeap<T> build(T[] array){
        MinHeap<T> heap = new MinHeap<T>();
        heap.array = new Object[array.length];
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
        if(((T)newValue).compareTo(array[pos - 1]) >= 0) return;
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
}
