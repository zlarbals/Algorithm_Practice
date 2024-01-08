package programmers;

import java.util.Arrays;

/**
 * DP 문제
 * 점화식 작성
 * d[0][i] = (d[][i-n] 최솟값)+1
 * d[1][i] = (d[][i/2] 최솟값)+1
 * d[2][i] = (d[][i/3] 최솟값)+1
 * https://school.programmers.co.kr/learn/courses/30/lessons/154538
 */
public class 숫자변환하기 {

    public int solution(int x, int y, int n) {
        int answer = 0;
        int[][] d = new int[3][1000001];

        //처음에 d 배열값을 최대값으로 초기화하지 않고 구현하여, 구현에 대한 고민 시간이 길어짐.
        //최대값으로 초기화 작업 생각 이후 구현에 편의성 높아짐.
        for(int i=0;i<3;i++){
            Arrays.fill(d[i],Integer.MAX_VALUE);
            d[i][x]=0;
        }

        //점화식 생성
        for(int i=x;i<=y;i++){
            int temp1 = i+n;
            int temp2 = i*2;
            int temp3 = i*3;

            int minimumValue = getMinValue(d,i);
            if(minimumValue != Integer.MAX_VALUE){
                if(temp1 <= y) {
                    d[0][temp1] = minimumValue + 1;
                }
                if(temp2 <= y) {
                    d[1][temp2] = minimumValue + 1;
                }
                if(temp3 <= y) {
                    d[2][temp3] = minimumValue + 1;
                }
            }
        }

        answer = getMinValue(d,y);
        if(answer == Integer.MAX_VALUE){
            return -1;
        }
        return answer;
    }

    private int getMinValue(int[][] d, int i) {
        return Math.min(d[0][i], Math.min(d[1][i],d[2][i]));
    }

    public static void main(String[] args) {
        숫자변환하기 a = new 숫자변환하기();
        System.out.println(a.solution(1,1000000,1));
    }

}
