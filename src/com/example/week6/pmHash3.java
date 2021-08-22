package com.example.week6;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/*
2021.08.21(토)
[프로그래머스] 위장
https://programmers.co.kr/learn/courses/30/lessons/42578
*/

public class pmHash3 {
    public static void main(String[] args) throws IOException {
        String[][] c = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
        solution(c);
    }

    public static int solution(String[][] clothes){
        int answer = 1;
        Map<String, Integer> hash = new HashMap<>();
        for (String[] items : clothes){
            hash.put(items[1], hash.getOrDefault(items[1], 0) + 1);
        }
        for (Map.Entry<String, Integer> e : hash.entrySet()){
            answer *= (e.getValue() + 1);
        }
        answer -= 1;
        return answer;
    }
}
