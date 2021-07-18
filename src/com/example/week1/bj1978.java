package com.example.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj1978 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int ans = 0;
        for (int i = 0; i<N; i++){
            int n = Integer.parseInt(input[i]);
            boolean isPrime = true;
            for (int j = 2; j <= n/2; j++){
                if (n % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (n != 1 && isPrime) ans++;
        }
        System.out.print(ans);
    }
}
