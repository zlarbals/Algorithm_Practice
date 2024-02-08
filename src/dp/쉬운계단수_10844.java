package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/10844
 * d[K][N] = N번째 자리에 숫자 K가 올 때 계단 수 갯수
 * d[0][N] = d[1][N-1]
 * d[k][N] = d[k-1][N-1] + d[k+1][N-1] ,   1<= k <= 8
 * d[9][N] = d[8][N-1]
 */
public class 쉬운계단수_10844 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int DIVIDER = 1000000000;
        int N = Integer.parseInt(br.readLine());

        int[][] d = new int[10][N+1];
        for(int i=1;i<10;i++){
            d[i][1] = 1;
        }
        for(int i=2;i<=N;i++){
            for(int j=0;j<10;j++){
                if(j==0){
                    d[j][i] = d[j+1][i-1];
                }else if(j==9){
                    d[j][i] = d[j-1][i-1];
                }else {
                    d[j][i] = (d[j - 1][i - 1] + d[j + 1][i - 1])%DIVIDER;
                }
            }
        }

        int result = 0;
        for(int i=0;i<10;i++){
            result += d[i][N];
            result %= DIVIDER;
        }

        System.out.println(result);
    }

}
