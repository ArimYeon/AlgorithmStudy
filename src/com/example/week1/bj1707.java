package com.example.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*
2021.07.18(일)
[백준] 이분 그래프
https://www.acmicpc.net/problem/1707
 */

public class bj1707 {

    static ArrayList<Integer>[] graph;
    static int[] color;
    static String[] input;
    static boolean ans;

    public static void dfs(int n){
        for (int next : graph[n]){
            if (color[next]!=0 && color[n]==color[next]){
                ans = false;
                return;
            }
            if (color[next] == 0){
                if (color[n] == 1)  color[next] = 2;
                else color[next] = 1;
                dfs(next);
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        while (K-- > 0){
            input = br.readLine().split(" ");
            int V = Integer.parseInt(input[0]);
            int E = Integer.parseInt(input[1]);
            graph = new ArrayList[V+1];
            color = new int[V+1];
            for (int i = 1; i <= V; i++){
                graph[i] = new ArrayList<>();
            }
            for (int i = 0; i < E; i++){
                input = br.readLine().split(" ");
                int a = Integer.parseInt(input[0]);
                int b = Integer.parseInt(input[1]);
                graph[a].add(b);
                graph[b].add(a);
            }
            ans = true;
            for (int i = 1; i <= V; i++){
                if (color[i] == 0){
                    color[i] = 1;
                    dfs(i);
                }
            }
            if (ans) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
