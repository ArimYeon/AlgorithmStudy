package com.example.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class bj2667 {
    static int[][] map;
    static boolean[][] visit;
    static ArrayList<Integer> countList = new ArrayList<>();
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int n, cnt;

    public static void dfs(int i, int j){
        visit[i][j] = true;
        for (int a = 0; a < 4; a++){
            int x = i + dx[a];
            int y = j + dy[a];
            if (0<=x && x<=n && 0<=y && y<=n){
                if (map[x][y] == 1 && !visit[x][y]){
                    cnt++;
                    dfs(x, y);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n+1][n+1];
        visit = new boolean[n+1][n+1];

        for (int i = 0; i < n; i++){
            String input = br.readLine();
            for (int j = 0; j < n; j++)
                map[i][j] = input.charAt(j) - '0';
        }
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n ; j++){
                if (map[i][j] == 1 && !visit[i][j]) {
                    cnt = 1;
                    dfs(i, j);
                    countList.add(cnt);
                }
            }
        }
        System.out.println(countList.size());
        Collections.sort(countList);
        for (int i: countList)
            System.out.println(i);
    }
}
