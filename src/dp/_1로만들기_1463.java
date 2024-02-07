package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/1463
 * bottom-up
 * d[i] = min(d[i/3], d[i/2], d[i-1]) + 1
 */
public class _1로만들기_1463 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] d = new int[N+1];
        for(int i=2;i<=N;i++){
            int value = d[i-1]+1;

            if(i%3 == 0){
                value = Math.min(value, d[i/3]+1);
            }

            if(i%2 == 0){
                value = Math.min(value, d[i/2]+1);
            }

            d[i] = value;
        }

        System.out.println(d[N]);

    }

}
