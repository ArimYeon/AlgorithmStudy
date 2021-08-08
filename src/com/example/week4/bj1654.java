package com.example.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
2021.08.07(토)
[백준] 랜선 자르기
https://www.acmicpc.net/problem/1654
*/

public class bj1654 {

    static int K, N;
    static long max = Integer.MAX_VALUE, maxAns = 1;
    static int[] lines;

    public static void binarySearch(long l, long h){
        long mid = (l + h)/2;
        int cnt = 0;
        for (int i = 0; i<K; i++){
            int line = lines[i];
            if (line >= mid)
                cnt += line/mid;
        }
        if (l <= h){
            long nextMid = (l + h)/2;
            if (cnt >= N) {
                maxAns = mid;
                binarySearch(nextMid + 1, h);
            }
            else if (cnt < N)
                binarySearch(l, nextMid-1);
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        K = Integer.parseInt(input[0]);
        N = Integer.parseInt(input[1]);
        lines = new int[K];
        for (int i = 0; i<K; i++){
            lines[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, lines[i]);
        }
        binarySearch(1, max);
        System.out.print(maxAns);
    }
}
