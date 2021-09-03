package com.example.week8;

/*
2021.09.3(금)
[프로그래머스] 타겟 넘버
https://programmers.co.kr/learn/courses/30/lessons/43165
*/

public class pmDfsBfs1 {

    public static void main(String[] args){
        int[] numbers = {1, 1, 1, 1, 1};
        int target = 3;
        System.out.println(solution(numbers, target));
    }

    public static int dfs(int[] numbers, int target, int index, int sum){
        if (index == numbers.length)
            return (sum == target) ? 1 : 0;
        return dfs(numbers, target, index+1, sum+numbers[index])
                + dfs(numbers, target, index+1, sum-numbers[index]);
    }

    public static int solution(int[] numbers, int target) {
        int answer = 0;
        answer = dfs(numbers, target, 0, 0);
        return answer;
    }
}
