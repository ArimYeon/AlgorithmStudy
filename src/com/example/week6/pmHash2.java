package com.example.week6;

import java.io.IOException;

/*
2021.08.21(토)
[프로그래머스] 전화번호 목록
https://programmers.co.kr/learn/courses/30/lessons/42577
*/

public class pmHash2 {
    public static void main(String[] args) throws IOException {
        String[] p = {"119", "97674223", "1195524421"};
        solution(p);
    }

    public static boolean solution(String[] phone_book){
        boolean answer = true;
        for (int i = 0; i<phone_book.length-1; i++){
            for (int j = i+1; j<phone_book.length; j++){
                if (phone_book[i].indexOf(phone_book[j]) == 0)
                    return false;
                if (phone_book[j].indexOf(phone_book[i]) == 0)
                    return false;
            }
        }
        return answer;
    }
}
