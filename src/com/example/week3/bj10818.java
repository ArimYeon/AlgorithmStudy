package com.example.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*
2021.08.01(일)
[백준] 스택
https://www.acmicpc.net/problem/10818
*/

public class bj10818 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Stack s = new Stack();
        while (N-- != 0){
            String[] input = br.readLine().split(" ");
            switch (input[0]){
                case "push":
                    s.push(Integer.parseInt(input[1]));
                    break;
                case "pop":
                    if (s.empty()) System.out.println("-1");
                    else System.out.println(s.pop());
                    break;
                case "size":
                    System.out.println(s.size());
                    break;
                case "empty":
                    if (s.empty()) System.out.println("1");
                    else System.out.println("0");
                    break;
                case "top":
                    if (s.empty()) System.out.println("-1");
                    else System.out.println(s.peek());
                    break;
            }
        }
    }
}
