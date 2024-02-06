package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/2579
 * d[0][n] = 계단 한개 밟았을 때, n번째 최댓 값
 * d[1][n] = 계단 연속 두개 밝았을 때, n번째 최댓 값
 * d[0][n] = max(d[0][n-1],d[1][n-2]) + value[n]
 * d[1][n] = d[0][n-1] + value[n]
 */
public class 계단오르기_2579 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] values = new int[N];
        for(int i=0;i<N;i++){
            values[i] = Integer.parseInt(br.readLine());
        }

        int[][] d = new int[2][N];
        d[0][0] = values[0];
        d[1][0] = values[0];
        for(int i=1;i<N;i++){
            if(i==1){
                d[0][i] = values[i];
            }else {
                d[0][i] = Math.max(d[0][i - 2], d[1][i - 2]) + values[i];
            }
            d[1][i] = d[0][i-1] + values[i];
        }

        System.out.println(Math.max(d[0][N-1],d[1][N-1]));
    }

}
