package com.example.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

/*
2021.08.01(일)
[백준] 트리의 지름
https://www.acmicpc.net/problem/1967
*/

public class bj1967 {

    static int N, max = 0;
    static ArrayList<Line>[] map;
    static boolean[] visited;
    static int maxNode = 1;

    public static void dfs(int n, int len){
        visited[n] = true;
        for (Line line : map[n]){
            if (!visited[line.node]){
                dfs(line.node, len + line.len);
            }
        }
        if (max < len){
            max = len;
            maxNode = n;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        visited = new boolean[N+1];
        map = new ArrayList[N+1];
        for (int i = 1; i<=N; i++){
            map[i] = new ArrayList<>();
        }
        for (int i = 0; i<N-1; i++){
            String[] input = br.readLine().split(" ");
            int p = Integer.parseInt(input[0]);
            int c = Integer.parseInt(input[1]);
            int dist = Integer.parseInt(input[2]);
            map[p].add(new Line(c, dist));
            map[c].add(new Line(p, dist));
        }
        dfs(1, 0);
        Arrays.fill(visited, false);
        max = 0;
        dfs(maxNode, 0);
        System.out.println(max);
    }

    public static class Line{
        int node;
        int len;
        public Line(int n, int l){
            node = n;
            len = l;
        }
    }
}
