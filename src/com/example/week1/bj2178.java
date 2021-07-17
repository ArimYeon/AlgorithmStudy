package com.example.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
2021.07.17(토)
[백준] 미로 탐색
https://www.acmicpc.net/problem/2178
 */

public class bj2178 {

    static int N, M;
    static boolean[][] map;
    static int[][] cnt;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new boolean[N][M];
        cnt = new int[N][M];
        for (int i = 0; i < N; i++){
            String input = br.readLine();
            for (int j = 0; j < M; j++){
                int num = input.charAt(j) - '0';
                if (num == 1) map[i][j] = true;
                else map[i][j] = false;
            }
        }
        bfs();
        System.out.println(cnt[N-1][M-1]);
    }

    public static void bfs(){
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(0, 0));
        cnt[0][0] = 1;
        while(!q.isEmpty()){
            Pair p = q.poll();
            for (int i = 0; i<4; i++){
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if (0<=nx&&nx<N && 0<=ny&&ny<M){
                    if (map[nx][ny] && cnt[nx][ny] == 0){
                        q.offer(new Pair(nx, ny));
                        cnt[nx][ny] = cnt[p.x][p.y] + 1;
                    }
                }
            }
        }
    }

    static class Pair{
        int x, y;
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
