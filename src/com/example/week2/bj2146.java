package com.example.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class bj2146 {
    private static int[][] map;
    private static int[][] groupMap;
    private static int[][] distMap;
    private static int[] dx = {0, 0, 1, -1};
    private static int[] dy = {1, -1, 0, 0};

    private static class Dot{
        int x, y;
        Dot(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        groupMap = new int[n][n];
        distMap = new int[n][n];
        for (int i = 0; i < n; i++){
            String[] inputS = br.readLine().split(" ");
            for (int j = 0; j < n; j++)
                map[i][j] = Integer.parseInt(inputS[j]);
        }
        setGroupMap(n);
        setDistMap(n);
        int ans = findShort(n);
        System.out.println(ans);
    }

    private static void setGroupMap(int n){
        int cnt = 0;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if (map[i][j] == 1 && groupMap[i][j] == 0){
                    Queue<Dot> tmpQ = new LinkedList<>();
                    tmpQ.add(new Dot(i, j));
                    groupMap[i][j] = ++cnt;
                    while (!tmpQ.isEmpty()){
                        Dot d = tmpQ.poll();
                        int x = d.x, y = d.y;
                        for (int a = 0; a < 4; a++){
                            int nx = x + dx[a];
                            int ny = y + dy[a];
                            if ((0<=nx&&nx<n) && (0<=ny&&ny<n)){
                                if (map[nx][ny] == 1 && groupMap[nx][ny] == 0){
                                    groupMap[nx][ny] = cnt;
                                    tmpQ.add(new Dot(nx, ny));
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private static void setDistMap(int n){
        Queue<Dot> q = new LinkedList<>();
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if (map[i][j] == 1) {
                    distMap[i][j] = 0;
                    q.add(new Dot(i, j));
                }else   distMap[i][j] = -1;
            }
        }

        while (!q.isEmpty()){
            Dot d = q.poll();
            int x = d.x, y = d.y;
            for (int a = 0; a < 4; a++){
                int nx = x + dx[a];
                int ny = y + dy[a];
                if ((0<=nx&&nx<n) && (0<=ny&&ny<n)){
                    if (distMap[nx][ny] == -1){
                        distMap[nx][ny] = distMap[x][y] + 1;
                        groupMap[nx][ny] = groupMap[x][y];
                        q.add(new Dot(nx, ny));
                    }
                }
            }
        }
    }

    private static int findShort(int n){
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                for (int a = 0; a < 4; a++){
                    int nx = i + dx[a];
                    int ny = j + dy[a];
                    if ((0<=nx&&nx<n) && (0<=ny&&ny<n)) {
                        if (groupMap[i][j] != groupMap[nx][ny])
                            ans = Math.min(ans, distMap[i][j]+distMap[nx][ny]);
                    }
                }
            }
        }
        return ans;
    }
}
