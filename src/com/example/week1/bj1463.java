package com.example.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
2021.07.18(일)
[백준] 1로 만들기
https://www.acmicpc.net/problem/1463
 */

public class bj1463 {

    static int[] dp;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp = new int[n+1];
        for (int i = 2; i<=n; i++){
            dp[i] = dp[i-1] + 1;
            if (i % 2 == 0)
                dp[i] = Math.min(dp[i/2]+1, dp[i]);
            if (i % 3 == 0)
                dp[i] = Math.min(dp[i/3]+1, dp[i]);
        }
        System.out.print(dp[n]);
    }
}
