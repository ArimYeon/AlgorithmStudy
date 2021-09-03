package com.example.week8;

import java.util.*;

/*
2021.09.2(목)
[프로그래머스] 베스트앨범
https://programmers.co.kr/learn/courses/30/lessons/42579
*/

public class pmHash4 {

    public static void main (String[] args){
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};
        int[] ans = solution(genres, plays);
        for (int i = 0; i<ans.length; i++){
            System.out.print(ans[i]+" ");
        }
    }

    public static int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> cntPlays = new HashMap<>();
        Map<String, ArrayList<Music>> musicList = new HashMap<>();

        for (int i = 0; i<genres.length; i++){
            cntPlays.put(genres[i], cntPlays.getOrDefault(genres[i], 0) + plays[i]);
            if (!musicList.containsKey(genres[i])){
                musicList.put(genres[i], new ArrayList<Music>());
            }
            ArrayList<Music> list = musicList.get(genres[i]);
            list.add(new Music(i, plays[i]));
            musicList.put(genres[i], list);
        }

        // 속한 노래가 많이 재생된 장르 먼저 오도록 정렬
        List<Map.Entry<String, Integer>> entries = new ArrayList<>(cntPlays.entrySet());
        // Comparator를 이용한 내림차순 정렬
        Collections.sort(entries, new Comparator<Map.Entry<String, Integer>>(){
            public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2){
                if(e1.getValue() < e2.getValue())    return 1;
                else if(e1.getValue() > e2.getValue())   return -1;
                else return 0;
            }
        });

        ArrayList<Integer> tmpAns = new ArrayList<>();
        for (Map.Entry<String, Integer> e : entries){
            // 음악 장르 가져오기
            String maxGenres = e.getKey();
            // 음악 장르에 해당하는 음악 리스트 가져오기
            ArrayList<Music> sortMusicList = musicList.get(maxGenres);
            Collections.sort(sortMusicList);
            // 최대 2개 수록
            tmpAns.add(sortMusicList.get(0).uniqNum);
            if (sortMusicList.size() >= 2){
                tmpAns.add(sortMusicList.get(1).uniqNum);
            }
        }

        int[] answer = new int[tmpAns.size()];
        for (int i = 0; i<tmpAns.size(); i++)
            answer[i] = tmpAns.get(i);
        return answer;
    }

    public static class Music implements Comparable<Music>{
        int uniqNum;
        int plays;

        public Music(int num, int plays){
            this.uniqNum = num;
            this.plays = plays;
        }

        // 더 많이 재생된 노래를 먼저 오도록 정렬
        @Override
        public int compareTo(Music music){
            if (music.plays > this.plays) return 1;
            else if (music.plays < this.plays) return -1;
            else{
                // 재생된 횟수가 같을 때 고유 번호가 낮은 노래가 먼저 오도록 정렬
                if (music.uniqNum < this.uniqNum) return 1;
                else if (music.uniqNum > this.uniqNum) return -1;
                else return 0;
            }
        }
    }

}
