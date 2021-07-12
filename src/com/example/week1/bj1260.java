package com.example.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
2021.07.11(일)
[백준] DFS와 BFS
https://www.acmicpc.net/problem/1260
 */

public class bj1260 {
    static int N;
    static boolean[][] map;
    static boolean[] visited;

    public static void dfs(int v){
        visited[v] = true;
        System.out.print(v + " ");
        for (int i = 1; i <= N; i++){
            if (map[v][i] && !visited[i]) dfs(i);
        }
    }

    public static void bfs(int v){
        Queue<Integer> q = new LinkedList<>();
        q.offer(v);
        visited[v] = true;
        while(!q.isEmpty()){
            int temp = q.poll();
            System.out.print(temp + " ");
            for (int i = 1; i <= N; i++){
                if (map[temp][i] && !visited[i]){
                    visited[i] = true;
                    q.offer(i);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int V = Integer.parseInt(input[2]);
        map = new boolean[N+1][N+1];
        visited = new boolean[N+1];
        for (int i = 0; i < M; i++){
            String[] line = br.readLine().split(" ");
            int a = Integer.parseInt(line[0]);
            int b = Integer.parseInt(line[1]);
            map[a][b] = map[b][a] = true;
        }
        dfs(V);
        System.out.println();
        Arrays.fill(visited, false);
        bfs(V);
    }
}