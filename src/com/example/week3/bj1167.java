package com.example.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

/*
2021.07.31(토)
[백준] 트리의 지름
https://www.acmicpc.net/problem/1167
*/

public class bj1167 {

    static int V, max = 0;
    static ArrayList<Line>[] map;
    static boolean[] visited;
    static int maxNode;

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
        V = Integer.parseInt(br.readLine());
        visited = new boolean[V+1];
        map = new ArrayList[V+1];
        for (int i = 1; i<=V; i++){
            map[i] = new ArrayList<>();
        }
        for(int i = 0; i<V; i++){
            String[] input = br.readLine().split(" ");
            int point = Integer.parseInt(input[0]);
            for (int j = 1; j<input.length-1; j+=2){
                int a = Integer.parseInt(input[j]);
                int b = Integer.parseInt(input[j+1]);
                map[point].add(new Line(a, b));
            }
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
