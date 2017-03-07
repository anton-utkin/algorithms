package com.utkin.anton;


import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class MinHeapTest {

    private void checkMinimum(MinHeap<Integer> heap, Integer value){
        assertEquals(value, heap.getMin());
        assertEquals(value, heap.extractMin());
    }

    @Test
    public void testA() {
        MinHeap<Integer> heap = new MinHeap<Integer>();
        checkMinimum(heap, null);
        heap.add(1);
        checkMinimum(heap, 1);
        checkMinimum(heap, null);
    }

    @Test
    public void testB() {
        MinHeap<Integer> heap = new MinHeap<Integer>();
        heap.add(1);
        heap.add(2);
        checkMinimum(heap, 1);
        checkMinimum(heap, 2);
    }

    @Test
    public void testC() {
        MinHeap<Integer> heap = new MinHeap<Integer>();
        heap.add(2);
        heap.add(1);
        checkMinimum(heap, 1);
        checkMinimum(heap, 2);
    }

    @Test
    public void testD() {
        MinHeap<Integer> heap = new MinHeap<Integer>();
        heap.add(1);
        heap.add(2);
        heap.add(3);
        checkMinimum(heap, 1);
        checkMinimum(heap, 2);
        checkMinimum(heap, 3);
    }

    @Test
    public void testE() {
        MinHeap<Integer> heap = new MinHeap<Integer>();
        heap.add(1);
        heap.add(3);
        heap.add(2);
        checkMinimum(heap, 1);
        checkMinimum(heap, 2);
        checkMinimum(heap, 3);
    }

    @Test
    public void testF() {
        MinHeap<Integer> heap = new MinHeap<Integer>();
        heap.add(2);
        heap.add(1);
        heap.add(3);
        checkMinimum(heap, 1);
        checkMinimum(heap, 2);
        checkMinimum(heap, 3);
    }

    @Test
    public void testG() {
        MinHeap<Integer> heap = new MinHeap<Integer>();
        heap.add(2);
        heap.add(3);
        heap.add(1);
        checkMinimum(heap, 1);
        checkMinimum(heap, 2);
        checkMinimum(heap, 3);
    }

    @Test
    public void testH() {
        MinHeap<Integer> heap = new MinHeap<Integer>();
        heap.add(3);
        heap.add(1);
        heap.add(2);
        checkMinimum(heap, 1);
        checkMinimum(heap, 2);
        checkMinimum(heap, 3);
    }

    @Test
    public void testI() {
        MinHeap<Integer> heap = new MinHeap<Integer>();
        heap.add(3);
        heap.add(2);
        heap.add(1);
        checkMinimum(heap, 1);
        checkMinimum(heap, 2);
        checkMinimum(heap, 3);
    }

    @Test
    public void testJ() {
        Integer array[] = {4, 3, 5, 1, 2};
        MinHeap<Integer> heap = MinHeap.build(array);
        checkMinimum(heap, 1);
        checkMinimum(heap, 2);
        checkMinimum(heap, 3);
        checkMinimum(heap, 4);
        checkMinimum(heap, 5);
    }

    @Test
    public void testK() {
        Integer array[] = {4, 3, 1, 2};
        MinHeap<Integer> heap = MinHeap.build(array);
        checkMinimum(heap, 1);
        checkMinimum(heap, 2);
        checkMinimum(heap, 3);
        checkMinimum(heap, 4);
    }

    @Test
    public void testL() {
        Integer array[] = {};
        MinHeap<Integer> heap = MinHeap.build(array);
        checkMinimum(heap, null);
    }

    @Test
    public void testM() {
        Integer array[] = {1};
        MinHeap<Integer> heap = MinHeap.build(array);
        checkMinimum(heap, 1);
        checkMinimum(heap, null);
    }


    @Test
    public void testN() {
        Integer array[] = {1, 2, 3};
        MinHeap<Integer> heap = MinHeap.build(array);
        heap.decreaseKey(1, 0);
        heap.decreaseKey(3, 1);
        heap.decreaseKey(100, 1);
        checkMinimum(heap, 0);
        checkMinimum(heap, 1);
        checkMinimum(heap, 2);
    }

    @Test
    public void testO() {
        MinHeap<Integer> heap = new MinHeap<Integer>();
        heap.add(4);
        heap.add(3);
        heap.add(5);
        heap.add(1);
        heap.add(2);
        checkMinimum(heap, 1);
        checkMinimum(heap, 2);
        checkMinimum(heap, 3);
        checkMinimum(heap, 4);
        checkMinimum(heap, 5);
    }
}
