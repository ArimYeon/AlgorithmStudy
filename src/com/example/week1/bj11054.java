package com.example.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
2021.07.17(토)
[백준] 가장 긴 바이토닉 부분 수열
https://www.acmicpc.net/problem/11054
 */

public class bj11054 {

    static int N, max = 0;
    static int[] num, dp1, dp2;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        num = new int[N];
        dp1 = new int[1000];
        dp2 = new int[1000];
        for (int i = 0; i<N; i++){
            num[i] = Integer.parseInt(st.nextToken());
            dp1[i] = 1;
            for (int j = 0; j < i; j++){
                if (num[j] < num[i]){
                    dp1[i] = Math.max(dp1[j]+1, dp1[i]);
                }
            }
        }
        for (int i = N-1; i >= 0; i--){
            dp2[i] = 1;
            for (int j = i; j < N; j++){
                if (num[i] > num[j]){
                    dp2[i] = Math.max(dp2[j]+1, dp2[i]);
                }
            }
            max = Math.max(max, dp1[i]+dp2[i]-1);
        }
        System.out.println(max);
    }
}
