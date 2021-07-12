package com.example.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
2021.07.11(일)
[백준] 연결 요소의 개수
https://www.acmicpc.net/problem/11724
 */

public class bj11724{
    static int N, M;
    static boolean map[][];
    static boolean visited[];

    public static void dfs(int s){
        visited[s] = true;
        for (int i = 1; i <= N; i++){
            if (map[s][i] && !visited[i])   dfs(i);
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        map = new boolean[N + 1][N + 1];
        visited = new boolean[N + 1];
        for (int i = 0; i < M; i++){
            String[] line = br.readLine().split(" ");
            int a = Integer.parseInt(line[0]);
            int b = Integer.parseInt(line[1]);
            map[a][b] = map[b][a] = true;
        }
        int ans = 0;
        for (int i = 1; i <= N; i++){
            if (!visited[i]){
                dfs(i);
                ans++;
            }
        }
        System.out.println(ans);
    }
}
