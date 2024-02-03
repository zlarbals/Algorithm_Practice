package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/1904
 *
 * dp 연습
 * d[N] = d[N-1] + d[N-2]
 */
public class _01타일_1904 {

    public static void main(String[] args) throws IOException {
        final int DIVIDE_NUMBER = 15746;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] d = new int[N+1];

        d[0] = 1;
        d[1] = 1;
        for(int i=2;i<=N;i++){
            int temp = d[i-1] + d[i-2];
            d[i] = temp % DIVIDE_NUMBER;
        }

        System.out.println(d[N]);
    }

}
