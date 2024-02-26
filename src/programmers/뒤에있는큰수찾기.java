package programmers;

import java.util.Arrays;
import java.util.Stack;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/154539
 * 자신보다 크면서 가장 가까이 있는 수를 구하는 것이므로 스택 활용.
 */
public class 뒤에있는큰수찾기 {

    public int[] solution(int[] numbers) {
        int length = numbers.length;
        int[] answer = new int[length];
        Arrays.fill(answer, -1);

        Stack<Integer> stack = new Stack<>();
        for(int i = length-1;i>=0;i--){
            while(!stack.isEmpty() && numbers[i]>=stack.peek()){
                stack.pop();
            }

            if(!stack.isEmpty()){
                answer[i] = stack.peek();
            }

            stack.push(numbers[i]);
        }

        return answer;
    }

}
