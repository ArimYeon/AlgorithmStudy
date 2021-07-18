package com.example.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
2021.07.18(일)
[백준] 최대공약수와 최소공배수
https://www.acmicpc.net/problem/2609
 */

public class bj2609 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int a = Integer.parseInt(input[0]);
        int b = Integer.parseInt(input[1]);
        System.out.print(gcd(a, b));
        System.out.println();
        System.out.print(a*b / gcd(a, b));
    }

    public static int gcd(int a, int b){
        return b!=0 ? gcd(b, a%b) : a;
    }
}
