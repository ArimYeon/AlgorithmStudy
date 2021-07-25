package com.example.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class bj2109 {
    static PriorityQueue<University> pq;
    static boolean[] check;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        pq = new PriorityQueue<>();
        int maxDay = 0, sum = 0;
        for (int i = 0; i<n; i++){
            String[] input = br.readLine().split(" ");
            int p = Integer.parseInt(input[0]);
            int d = Integer.parseInt(input[1]);
            maxDay = Math.max(maxDay, d);
            pq.add(new University(p, d));
        }
        check = new boolean[maxDay+1];
        while (!pq.isEmpty()){
            University u = pq.poll();
            for (int i = u.d; i>0; i--){
                if (!check[i]){
                    check[i] = true;
                    sum += u.p;
                    break;
                }
            }
        }
        System.out.print(sum);
    }

    static class University implements Comparable<University>{
        int p, d;
        public University(int p, int d){
            this.p = p;
            this.d = d;
        }
        public int compareTo(University u){
            if (this.p < u.p) return 1;
            else if (this.p > u.p) return -1;
            else return 0;
        }
    }
}
