package programmers;

import java.util.HashSet;
import java.util.Set;

/**
 * 프로그래머스 - 연속 부분 수열 합의 개수
 * https://school.programmers.co.kr/learn/courses/30/lessons/131701
 */
public class 연속부분수열합의개수 {

    public int solution(int[] elements) {
        int answer = 0;
        int length = elements.length;

        Set<Integer> set = new HashSet<>();
        for(int i=0;i<length;i++){
            int sum=0;
            for( int j=0;j<length;j++){
                sum+=elements[(i+j)%length];
                set.add(sum);
            }
        }

        answer = set.size();
        return answer;
    }
}
