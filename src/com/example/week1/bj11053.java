package com.example.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
2021.07.18(일)
[백준] 가장 긴 증가하는 부분 수열
https://www.acmicpc.net/problem/11053
 */

public class bj11053 {

    static int[] dp, nums;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int A = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        dp = new int[A];
        nums = new int[A];
        int max = 0;
        for (int i = 0; i<A; i++){
            nums[i] = Integer.parseInt(input[i]);
            dp[i] = 1;
            for (int j = 0; j < i; j++){
                if (nums[j]<nums[i]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        System.out.print(max);
    }
}
