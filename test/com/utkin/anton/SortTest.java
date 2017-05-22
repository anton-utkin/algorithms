package com.utkin.anton;

import org.junit.Test;
import java.util.Arrays;

import static org.junit.Assert.assertTrue;


public class SortTest {

    void checkTestCase(Integer[] array, Integer[] expectedResult){
        Integer[] arrayCopy = new Integer[array.length];
        System.arraycopy(array, 0, arrayCopy, 0, array.length);
        Sort.mergeSort(array);
        assertTrue(null, Arrays.equals(array, expectedResult));
        Sort.quickSort(arrayCopy);
        assertTrue(null, Arrays.equals(arrayCopy, expectedResult));
    }

    @Test
    public void testA() {
        Integer[] array = {};
        Integer[] sortedArray = {};
        checkTestCase(array, sortedArray);
    }

    @Test
    public void testB() {
        Integer[] array = {1};
        Integer[] sortedArray = {1};
        checkTestCase(array, sortedArray);
    }

    @Test
    public void testC() {
        Integer[] array = {1, 2};
        Integer[] sortedArray = {1, 2};
        checkTestCase(array, sortedArray);
    }

    @Test
    public void testD() {
        Integer[] array = {2, 1};
        Integer[] sortedArray = {1, 2};
        checkTestCase(array, sortedArray);
    }

    @Test
    public void testE() {
        Integer[] array = {1, 2, 3};
        Integer[] sortedArray = {1, 2, 3};
        checkTestCase(array, sortedArray);
    }

    @Test
    public void testF() {
        Integer[] array = {1, 3, 2};
        Integer[] sortedArray = {1, 2, 3};
        checkTestCase(array, sortedArray);
    }

    @Test
    public void testG() {
        Integer[] array = {2, 1, 3};
        Integer[] sortedArray = {1, 2, 3};
        checkTestCase(array, sortedArray);
    }

    @Test
    public void testH() {
        Integer[] array = {2, 3, 1};
        Integer[] sortedArray = {1, 2, 3};
        checkTestCase(array, sortedArray);
    }

    @Test
    public void testI() {
        Integer[] array = {3, 1, 2};
        Integer[] sortedArray = {1, 2, 3};
        checkTestCase(array, sortedArray);
    }

    @Test
    public void testJ() {
        Integer[] array = {3, 2, 1};
        Integer[] sortedArray = {1, 2, 3};
        checkTestCase(array, sortedArray);
    }

    @Test
    public void testK() {
        Integer[] array = {1, 3, 2, 6, 5, 9, 7, 8, 0, 4};
        Integer[] sortedArray = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        checkTestCase(array, sortedArray);
    }
}
