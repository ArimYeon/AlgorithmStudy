package com.example.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
2021.07.18(일)
[백준] 반복수열
https://www.acmicpc.net/problem/2331
 */

public class bj2331 {

    static int A, P;
    static int[] visited;

    public static void dfs(int num){
        visited[num]++;
        if(visited[num] == 3)
            return;
        int next = 0;
        while(num!=0){
            next += Math.pow(num%10, P);
            num /= 10;
        }
        dfs(next);
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        A = Integer.parseInt(input[0]);
        P = Integer.parseInt(input[1]);
        visited = new int[300001];
        dfs(A);
        int result = 0;
        for(int i = 0 ; i<300001; i++){
            if(visited[i] == 1) result++;
        }
        System.out.print(result);
    }
}
