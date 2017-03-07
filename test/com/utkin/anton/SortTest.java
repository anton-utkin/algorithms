package com.utkin.anton;

import org.junit.Test;
import java.util.Arrays;

import static org.junit.Assert.assertTrue;


public class SortTest {

    @Test
    public void testA() {
        Integer[] array = {};
        Sort.mergeSort(array);
        Integer[] sortedArray = {};
        assertTrue(null, Arrays.equals(sortedArray, array));
    }

    @Test
    public void testB() {
        Integer[] array = {1};
        Sort.mergeSort(array);
        Integer[] sortedArray = {1};
        assertTrue(null, Arrays.equals(sortedArray, array));
    }

    @Test
    public void testC() {
        Integer[] array = {1, 2};
        Sort.mergeSort(array);
        Integer[] sortedArray = {1, 2};
        assertTrue(null, Arrays.equals(sortedArray, array));
    }

    @Test
    public void testD() {
        Integer[] array = {2, 1};
        Sort.mergeSort(array);
        Integer[] sortedArray = {1, 2};
        assertTrue(null, Arrays.equals(sortedArray, array));
    }

    @Test
    public void testE() {
        Integer[] array = {1, 2, 3};
        Sort.mergeSort(array);
        Integer[] sortedArray = {1, 2, 3};
        assertTrue(null, Arrays.equals(sortedArray, array));
    }

    @Test
    public void testF() {
        Integer[] array = {1, 3, 2};
        Sort.mergeSort(array);
        Integer[] sortedArray = {1, 2, 3};
        assertTrue(null, Arrays.equals(sortedArray, array));
    }

    @Test
    public void testG() {
        Integer[] array = {2, 1, 3};
        Sort.mergeSort(array);
        Integer[] sortedArray = {1, 2, 3};
        assertTrue(null, Arrays.equals(sortedArray, array));
    }

    @Test
    public void testH() {
        Integer[] array = {2, 3, 1};
        Sort.mergeSort(array);
        Integer[] sortedArray = {1, 2, 3};
        assertTrue(null, Arrays.equals(sortedArray, array));
    }

    @Test
    public void testI() {
        Integer[] array = {3, 1, 2};
        Sort.mergeSort(array);
        Integer[] sortedArray = {1, 2, 3};
        assertTrue(null, Arrays.equals(sortedArray, array));
    }

    @Test
    public void testJ() {
        Integer[] array = {3, 2, 1};
        Sort.mergeSort(array);
        Integer[] sortedArray = {1, 2, 3};
        assertTrue(null, Arrays.equals(sortedArray, array));
    }

    @Test
    public void testK() {
        Integer[] array = {1, 3, 2, 6, 5, 9, 7, 8, 0, 4};
        Sort.mergeSort(array);
        Integer[] sortedArray = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        assertTrue(null, Arrays.equals(sortedArray, array));
    }
}
