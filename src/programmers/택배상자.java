package programmers;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/131704
 * queue와 stack 이용하여 비교.
 */
public class 택배상자 {


    public int solution(int[] order) {
        int answer = 0;
        int length = order.length;
        Queue<Integer> queue = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();

        for (int i = 1; i <= length; i++) {
            queue.add(i);
        }

        int orderIndex = 0;
        while (orderIndex < length) {
            boolean isCheck = false;
            int nowOrder = order[orderIndex];
            if (!queue.isEmpty() && queue.peek() == nowOrder) {
                queue.poll();
                orderIndex++;
                answer++;
                isCheck = true;
            } else if (!stack.isEmpty() && stack.peek() == nowOrder) {
                stack.pop();
                orderIndex++;
                answer++;
                isCheck = true;
            } else {
                if (!queue.isEmpty()) {
                    stack.add(queue.poll());
                    isCheck = true;
                }
            }


            if (!isCheck) {
                break;
            }
        }

        return answer;
    }


    public static void main(String[] args) {
        택배상자 a = new 택배상자();
        int[] order1 = {4,3,1,2,5};
        int[] order2 = {5,4,3,2,1};
        System.out.println(a.solution(order2));

    }

}
