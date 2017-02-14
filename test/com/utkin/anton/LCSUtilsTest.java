package com.utkin.anton;


import org.junit.Test;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class LCSUtilsTest {

    void checkTestCase(List<Character> listA, List<Character> listB, List<Character> expectedResult){
        LCSUtils.switchAlgoType(LCSUtils.AlgoType.Recursive);
        assertEquals(expectedResult, LCSUtils.clculateLCS(listA, listB));

        LCSUtils.switchAlgoType(LCSUtils.AlgoType.Iterative);
        assertEquals(expectedResult, LCSUtils.clculateLCS(listA, listB));
    }

    @Test
    public void testA() {
        List<Character> listA = Arrays.asList('A');
        List<Character> listB = Arrays.asList('A');
        checkTestCase(listA, listB, Arrays.asList('A'));
    }

    @Test
    public void testB() {
        List<Character> listA = Arrays.asList('A');
        List<Character> listB = Arrays.asList('B');
        checkTestCase(listA, listB, Collections.EMPTY_LIST);
    }

    @Test
    public void testC() {
        List<Character> listA = Arrays.asList('A', 'A');
        List<Character> listB = Arrays.asList('A', 'A');
        checkTestCase(listA, listB, Arrays.asList('A', 'A'));
    }

    @Test
    public void testD() {
        List<Character> listA = Arrays.asList('A', 'A');
        List<Character> listB = Arrays.asList('B', 'B');
        checkTestCase(listA, listB, Collections.EMPTY_LIST);
    }

    @Test
    public void testE() {
        List<Character> listA = Arrays.asList('A', 'A');
        List<Character> listB = Arrays.asList('A', 'B');
        checkTestCase(listA, listB, Arrays.asList('A'));
    }

    @Test
    public void testF() {
        List<Character> listA = Arrays.asList('A', 'A');
        List<Character> listB = Arrays.asList('B', 'A');
        checkTestCase(listA, listB, Arrays.asList('A'));
    }

    @Test
    public void testG() {
        List<Character> listA = Arrays.asList('A', 'B');
        List<Character> listB = Arrays.asList('A', 'A');
        checkTestCase(listA, listB, Arrays.asList('A'));
    }

    @Test
    public void testH() {
        List<Character> listA = Arrays.asList('A', 'B');
        List<Character> listB = Arrays.asList('B', 'B');
        checkTestCase(listA, listB, Arrays.asList('B'));
    }

    @Test
    public void testI() {
        List<Character> listA = Arrays.asList('A', 'B');
        List<Character> listB = Arrays.asList('A', 'B');
        checkTestCase(listA, listB, Arrays.asList('A', 'B'));
    }

    @Test
    public void testJ() {
        List<Character> listA = Arrays.asList('A', 'B');
        List<Character> listB = Arrays.asList('B', 'A');
        checkTestCase(listA, listB, Arrays.asList('A'));
    }

    @Test
    public void testK() {
        List<Character> listA = Arrays.asList('A');
        List<Character> listB = Arrays.asList('A', 'A');
        checkTestCase(listA, listB, Arrays.asList('A'));
    }

    @Test
    public void testL() {
        List<Character> listA = Arrays.asList('A');
        List<Character> listB = Arrays.asList('B', 'B');
        checkTestCase(listA, listB, Collections.EMPTY_LIST);
    }

    @Test
    public void testM() {
        List<Character> listA = Arrays.asList('A');
        List<Character> listB = Arrays.asList('A', 'B');
        checkTestCase(listA, listB, Arrays.asList('A'));
    }

    @Test
    public void testN() {
        List<Character> listA = Arrays.asList('A');
        List<Character> listB = Arrays.asList('B', 'A');
        checkTestCase(listA, listB, Arrays.asList('A'));
    }

    @Test
    public void testO() {
        List<Character> listA = Arrays.asList('A', 'A');
        List<Character> listB = Arrays.asList('A');
        checkTestCase(listA, listB, Arrays.asList('A'));
    }

    @Test
    public void testP() {
        List<Character> listA = Arrays.asList('B', 'B');
        List<Character> listB = Arrays.asList('A');
        checkTestCase(listA, listB, Collections.EMPTY_LIST);
    }

    @Test
    public void testQ() {
        List<Character> listA = Arrays.asList('A', 'B');
        List<Character> listB = Arrays.asList('A');
        checkTestCase(listA, listB, Arrays.asList('A'));
    }

    @Test
    public void testR() {
        List<Character> listA = Arrays.asList('B', 'A');
        List<Character> listB = Arrays.asList('A');
        checkTestCase(listA, listB, Arrays.asList('A'));
    }

    @Test
    public void testS() {
        List<Character> listA = Arrays.asList('1', '2', '3', '4', '5');
        List<Character> listB = Arrays.asList('0', '7', '2', '0', '3', '0', '5', '0');
        checkTestCase(listA, listB, Arrays.asList('2', '3', '5'));
    }

    @Test
    public void testT() {
        List<Character> listA = Arrays.asList('A', 'B', 'C', 'D', 'E');
        List<Character> listB = Arrays.asList('Z', 'A', 'Z', 'B', 'Z', 'C', 'Y');
        checkTestCase(listA, listB, Arrays.asList('A', 'B', 'C'));
    }
}
