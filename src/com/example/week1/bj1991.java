package com.example.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
2021.07.18(일)
[백준] 트리 순회
https://www.acmicpc.net/problem/1991
 */

public class bj1991 {

    static int N;
    static Node A[] = new Node[26];

    // 전위 순회
    static void preOrder(int node){
        System.out.print(A[node].data);
        if (A[node].left != -1) preOrder(A[node].left);
        if (A[node].right != -1) preOrder(A[node].right);
    }
    // 중위 순회
    static void inOrder(int node){
        if (A[node].left != -1) inOrder(A[node].left);
        System.out.print(A[node].data);
        if (A[node].right != -1) inOrder(A[node].right);
    }
    // 후위 순회
    static void postOrder(int node){
        if (A[node].left != -1) postOrder(A[node].left);
        if (A[node].right != -1) postOrder(A[node].right);
        System.out.print(A[node].data);
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i<N; i++){
            A[i] = new Node((char)('A'+i));
        }
        for (int i = 0; i<N; i++){
            String input = br.readLine().replaceAll(" ", "");
            char data = input.charAt(0);
            char left = input.charAt(1);
            char right = input.charAt(2);
            if(left != '.'){
                A[data - 'A'].left = left - 'A';
                A[left - 'A'].parent = data - 'A';
            }
            if (right != '.') {
                A[data - 'A'].right = right - 'A';
                A[right - 'A'].parent = data - 'A';
            }
        }
        preOrder(0);
        System.out.print("\n");
        inOrder(0);
        System.out.print("\n");
        postOrder(0);
    }

    static class Node{
        char data;
        int parent, right, left;
        Node(char data){
            this.data = data;
            this.parent = this.right = this.left = -1;
        }
    }
}
