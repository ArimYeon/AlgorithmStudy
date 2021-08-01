package com.example.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
2021.08.01(일)
[백준] 스택
https://www.acmicpc.net/problem/14501
*/

public class bj14501 {
    static int N;
    static int[] t, p, dp;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        t = new int[N+1];
        p = new int[N+1];
        for (int i = 1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            t[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());
        }
        dp = new int[N+2];
        for (int i = N; i>0; i--){
            int nextDay = i + t[i];
            if (nextDay - 1 > N)
                dp[i] = dp[i+1];
            else{
                dp[i] = Math.max(dp[i+1], dp[nextDay]+p[i]);
            }
        }
        System.out.print(dp[1]);
    }
}
