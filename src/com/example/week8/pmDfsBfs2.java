package com.example.week8;

/*
2021.09.3(금)
[프로그래머스] 네트워크
https://programmers.co.kr/learn/courses/30/lessons/43162
*/

public class pmDfsBfs2 {

    public static void main(String[] args){
        int node = 3;
        int[][] computers = {{1,1,0}, {1,1,0}, {0,0,1}};
        System.out.println(solution(node, computers));
    }

    static boolean[] visit;

    public static void dfs(int node, int[][] computers){
        visit[node] = true;
        for (int i = 0; i<computers.length; i++){
            if (!visit[i] && computers[node][i]==1)
                dfs(i, computers);
        }
    }

    public static int solution(int n, int[][] computers) {
        int answer = 0;
        visit = new boolean[n];
        for (int i = 0; i<n; i++){
            if (!visit[i]){
                dfs(i, computers);
                answer++;
            }
        }
        return answer;
    }
}
