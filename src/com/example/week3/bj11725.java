package com.example.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*
2021.07.31(토)
[백준] 트리의 부모 찾기
https://www.acmicpc.net/problem/11725
*/

/*
주의!!
N 최대가 100,000라서 map을 인접행렬을 사용하면 메모리 초과가 남.
인접리스트를 사용해야 메모리 초과가 나지 않는다.
*/

public class bj11725 {
    static int N;
    static ArrayList<Integer>[] map;
    static boolean[] visited;
    static int[] parents;

    public static void dfs(int n){
        visited[n] = true;
        for (int next : map[n]){
            if (!visited[next]){
                parents[next] = n;
                dfs(next);
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new ArrayList[N+1];
        for (int i = 1; i<=N; i++){
            map[i] = new ArrayList<>();
        }
        visited = new boolean[N+1];
        parents = new int[N+1];
        for (int i = 0; i<N-1; i++){
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            map[a].add(b);
            map[b].add(a);
        }
        dfs(1);
        for (int i = 2; i<=N; i++){
            System.out.println(parents[i]);
        }
    }
}
