package com.example.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
2021.07.17(토)
[백준] 가장 긴 감소하는 부분 수열
https://www.acmicpc.net/problem/11722
*/

public class bj11722 {

    static int[] cnt, num;
    static int max;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        num = new int[1000];
        cnt = new int[1000];
        for(int i = 0; i < N; i++){
            num[i] = Integer.parseInt(input[i]);
            cnt[i] = 1;
            for (int j = 0; j < i; j++){
                if (num[j] > num[i]){
                    cnt[i] = Math.max(cnt[j]+1, cnt[i]);
                }
            }
            max = Math.max(max, cnt[i]);
        }
        System.out.println(max);
    }
}
