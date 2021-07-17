package com.example.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
2021.07.17(토)
[백준] 가장 큰 증가 부분 수열
https://www.acmicpc.net/problem/11055
 */

public class bj11055 {
    static int N, max = 0;
    static int[] num, sum;

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        num = new int[1000];
        sum = new int[1000];
        for (int i = 0; i < N; i++){
            num[i] = sum[i] = Integer.parseInt(input[i]);
            for (int j = 0; j < i; j++){
                if (num[j] < num[i]){
                    sum[i] = Math.max(sum[j]+num[i], sum[i]);
                }
            }
            max = Math.max(max, sum[i]);
        }
        System.out.println(max);
    }
}
