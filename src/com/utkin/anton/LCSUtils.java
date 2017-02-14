package com.utkin.anton;

import java.util.ArrayList;
import java.util.List;

/*-------------------------------------------------------------------------------------
       LCSUtils - Utils for calculation Longest Common Subsequence
       For example if seqA = A, B, C, D, E and seqB = Y, B, G, D, Z; LCS = B, D
       Utility class supports two different algorithms of calculation: recursive
       and iterative, both with O(N * M) complexity, where N - length of
       first sequence, M - length of second sequence.
--------------------------------------------------------------------------------------*/
public class LCSUtils {

    enum AlgoType{
        Recursive,
        Iterative
    }

    private static AlgoType mType = AlgoType.Recursive;

    public static void switchAlgoType(AlgoType type) {
        mType = type;
    }

    //Interface for calculating LCS
    public static List<Character> clculateLCS(List<Character> sequenceA, List<Character> sequenceB)
    {
        List<Character> result = new ArrayList<>();
        calcLSC(sequenceA.toArray(new Character[0]), sequenceB.toArray(new Character[0]), result);
        return result;
    }

    //Implementation
    private static void calcLSC(Character X[], Character Y[], List<Character> result) {
        int c[] [] = new int[X.length + 1] [Y.length + 1];
        for (int a = 0; a < X.length + 1; ++a){
            for (int b = 0; b < Y.length + 1; ++ b) {
                if(a == 0 || b == 0){
                    c[a][b] = 0;
                }
                else {
                    c[a][b] = Integer.MIN_VALUE;
                }
            }
        }
        if(mType == AlgoType.Recursive) {
            LCSRecursive(X, X.length, Y, Y.length, c);
        }else if(mType == AlgoType.Iterative) {
            LCSIterative(X, X.length, Y, Y.length, c);
        }
        build(X, X.length, Y, Y.length, c, result);
    }

    /*-------------------------------------------------------------------------------------
       Longest Common Subsequence recursive implementation
       Complexity: O(N * M),
       where N - length of first sequence
       where M - length of second sequence
    --------------------------------------------------------------------------------------*/
    private static int LCSRecursive(Character[] X, int i, Character Y[], int j, int c[][]) {
        if(c[i][j] == Integer.MIN_VALUE) {
            if (X[i - 1].equals(Y[j - 1])) {
                c[i][j] = 1 + LCSRecursive(X, i - 1, Y, j - 1, c);
            } else {
                c[i][j] = Math.max(LCSRecursive(X, i - 1, Y, j, c), LCSRecursive(X, i, Y, j - 1, c));
            }
        }
        return c[i][j];
    }

    /*-------------------------------------------------------------------------------------
       Longest Common Subsequence iterative implementation
       Complexity: O(N * M),
       where N - length of first sequence
       where M - length of second sequence
    --------------------------------------------------------------------------------------*/
    private static void LCSIterative(Character[] X, int i, Character Y[], int j, int c[][]) {
        for(int a = 1; a <= i; ++a) {
            for(int b = 1; b <= j; ++b){
              if(X[a - 1] == Y[b - 1]) {
                  c[a][b] = 1 + c[a - 1][b - 1];
              }
                else {
                  c[a][b] = Math.max(c[a - 1][b], c[a][b - 1]);
              }
            }
        }
    }

    /*-------------------------------------------------------------------------------------
       Longest Common Subsequence helper method for building result from matrix
       Complexity: O(N + M),
       where N - length of first sequence
       where M - length of second sequence
    --------------------------------------------------------------------------------------*/
    private static void build(Character X[], int i, Character Y[], int j, int c[][], List<Character> result) {
        if(i == 0 || j == 0) {
            return;
        }
        else if (X[i - 1] == Y[j - 1]) {
            build(X, i - 1, Y, j - 1, c, result);
            result.add(X[i - 1]);
        }
        else if (c[i - 1][j] >= c[i][j -1]) {
            build(X, i - 1, Y, j, c, result);
        }
        else {
            build(X, i, Y, j - 1, c, result);
        }
    }
}
