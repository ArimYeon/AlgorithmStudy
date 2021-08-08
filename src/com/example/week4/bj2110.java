package com.example.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
2021.08.07(토)
[백준] 공유기 설치
https://www.acmicpc.net/problem/2110
*/

public class bj2110 {

    static int N, C;
    static int[] homes;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        C = Integer.parseInt(input[1]);
        homes = new int[N];
        for (int i = 0; i<N; i++){
            homes[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(homes);
        int left = 1;
        int right = homes[N - 1] - homes[0];
        int d = 0;
        int ans = 0;
        while (left <= right){
            int mid = (left + right)/2;
            int start = homes[0];
            int cnt = 1;
            for (int i = 1; i<N; i++){
                d = homes[i] - start;
                if (mid <= d){
                    cnt++;
                    start = homes[i];
                }
            }
            if (cnt >= C){
                ans = mid;
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        System.out.print(ans);
    }
}
