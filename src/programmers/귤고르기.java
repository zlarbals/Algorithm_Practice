package programmers;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/138476
 */
public class 귤고르기 {

    public int solution(int k, int[] tangerine) {
        final int NUMBER = 10000001;
        int answer = 0;
        int length = tangerine.length;
        int[] count = new int[NUMBER];

        //귤의 크기에 따른 귤의 갯수 설정
        for(int i=0;i<length;i++){
            count[tangerine[i]]++;
        }

        //내림차순 정렬으로 큰수부터 나옴.
        //귤의 갯수가 내림차순정렬된 이후부터는 귤의 크기는 의미없음.
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=1;i<NUMBER;i++){
            if(count[i] != 0){
                pq.add(count[i]);
            }
        }

        int sum=0;
        //갯수가 높은것부터 귤을 상자에 담으면 종류의 최솟값 확인 가능.
        while (!pq.isEmpty()){
            sum+=pq.poll();
            answer++;

            if(sum>=k){
                break;
            }
        }

        return answer;
    }

}
