package com.example.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/*
2021.08.01(일)
[백준] 큐
https://www.acmicpc.net/problem/10845
*/

public class bj10845 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Queue<Integer> q = new LinkedList<>();
        int last = 0;
        while (N-- != 0){
            String[] input = br.readLine().split(" ");
            switch (input[0]) {
                case "push":
                    last = Integer.parseInt(input[1]);
                    q.offer(last);
                    break;
                case "pop":
                    if (q.isEmpty()) System.out.println("-1");
                    else System.out.println(q.poll());
                    break;
                case "size":
                    System.out.println(q.size());
                    break;
                case "empty":
                    if (q.isEmpty()) System.out.println("1");
                    else System.out.println("0");
                    break;
                case "front":
                    if (q.isEmpty()) System.out.println("-1");
                    else System.out.println(q.peek());
                    break;
                case "back":
                    if (q.isEmpty()) System.out.println("-1");
                    else System.out.println(last);
                    break;
            }
        }
    }
}
