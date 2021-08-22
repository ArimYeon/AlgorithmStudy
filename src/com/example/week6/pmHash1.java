package com.example.week6;

/*
2021.08.21(토)
[프로그래머스] 완주하지 못한 선수
https://programmers.co.kr/learn/courses/30/lessons/42576
*/

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class pmHash1 {
    public static void main(String[] args) throws IOException{
        String[] p = {"leo", "kiki", "eden"};
        String[] c = {"eden", "kiki"};
        solution(p, c);
    }

    public static String solution(String[] participant, String[] completion){
        String answer = "";
        Map<String, Integer> hs = new HashMap<>();
        for (String p : participant){
            hs.put(p, hs.getOrDefault(p, 0) + 1);
        }
        // hash는 이미 있는 key에 새로운 value값을 넣으면 새로운 값으로 바뀐다.
        for (String c : completion){
            hs.put(c, hs.get(c) - 1);
        }
        for (Map.Entry<String, Integer> entry : hs.entrySet()){
            if (entry.getValue() != 0)
                answer = entry.getKey();
        }
        return answer;
    }
}
